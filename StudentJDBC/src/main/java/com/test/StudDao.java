package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudDao {

    private static final String URL = "jdbc:mysql://localhost:3306/mlafeb";
    private static final String USER = "root";
    private static final String PASS = "root@39";

    
    public static Connection getCon() {

        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }

    
    public void saveEmployee(Student emp) {

        String sql = "INSERT INTO student(id, name, School, city) VALUES (?, ?, ?, ?)";

        try (Connection con = getCon();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, emp.getUSN());
            pst.setString(2, emp.getName());
            pst.setString(3, emp.getSch());
            pst.setString(4, emp.getCity());

            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
    public List<Student> getAllStudents() {

        List<Student> empList = new ArrayList<>();

        String sql = "SELECT * FROM student";

        try (Connection con = getCon();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {

                Student stud = new Student();

                stud.setUSN(rs.getInt("USN"));
                stud.setName(rs.getString("name"));
                stud.setSch(rs.getString("school"));
                stud.setCity(rs.getString("city"));

                empList.add(stud);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return empList;
    }
    
    public void updateEmployee(Student emp) {
    	
    	try {
    		String sql = "update student set name=?, school=?, city=?, where USN=?";
    		PreparedStatement pst = StudDao.getCon().prepareStatement(sql);
    		
    		
            pst.setString(1, emp.getName());
            pst.setString(2, emp.getSch());
            pst.setString(3, emp.getCity());
            pst.setInt(4, emp.getUSN());
            
            pst.execute();
    	}
    	
    	catch(Exception e){
    		
    		e.printStackTrace();
    		
    	}
    }
    
    
    public void deleteEmployee(Student emp) {
    	
    	try {
    		String sql = "delete from table student where USN=?";
    		PreparedStatement pst = StudDao.getCon().prepareStatement(sql);
    	
            pst.setInt(1, emp.getUSN());
            
            pst.execute();
    	}
    	
    	catch(Exception e){
    		
    		e.printStackTrace();
    		
    	}
    	
    }

}

