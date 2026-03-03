package com.test.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.test.entity.Role;
import com.test.entity.User;
import com.test.repository.RolesRepository;
import com.test.service.UserService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired private UserService userService;
    @Autowired
    private RolesRepository roleRepo;

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("allRoles", userService.findAllRoles());
        model.addAttribute("mode", "New");
        return "user-form";
    }


    @GetMapping("/edit/{id}")//Positioning Important
    public String editUser(@PathVariable Integer id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("allRoles", userService.findAllRoles());
        model.addAttribute("mode", "Edit");

        // Pass selected role IDs for checkbox display
        Set<Integer> selectedRoleIds = user.getRoles().stream()
            .map(Role::getId)
            .collect(Collectors.toSet());
        model.addAttribute("selectedRoleIds", selectedRoleIds);
        return "user-form";
    }

    @PostMapping("/save")
    public String saveUser(@Valid @ModelAttribute("user") User user,
                          BindingResult result,
                          @RequestParam(value = "roles", required = false) List<Integer> roleIds,
                          Model model) {
        if (result.hasErrors()) {
            model.addAttribute("allRoles", userService.findAllRoles());
            model.addAttribute("mode", user.getId() != null ? "Edit" : "New");
            return "user-form";
        }


        // Handle roles (unchanged)
        if (roleIds != null && !roleIds.isEmpty()) {
            List<Role> roles = roleRepo.findAllById(roleIds);
            user.setRoles(new HashSet<>(roles));
        }

        // Service handles password encoding automatically
        userService.save(user);
        return "redirect:/users/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.deleteById(id);
        return "redirect:/users";
    }


    @GetMapping("/list")  // Maps to /users
    public String listUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users-list";  // Returns users-list.html
    }
}