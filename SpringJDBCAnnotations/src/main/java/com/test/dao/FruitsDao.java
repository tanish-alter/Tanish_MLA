package com.test.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.test.model.Fruits;
import com.test.model.FruitsMapper;

@Component
@Transactional(propagation = Propagation.REQUIRED, isolation=Isolation.SERIALIZABLE)
public class FruitsDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public FruitsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final String insert_sql =
            "insert into fruits (id ,f_name, f_price, f_quantity) values (?,?,?,?)";

    private final String update_sql =
            "update fruits set f_name = ?, f_price = ?, f_quantity = ? where id =?";

    private final String delete_sql =
            "delete from fruits where id =?";

    private final String select_sql =
            "select * from fruits";

    public boolean saveFruits(Fruits obj) {
        return jdbcTemplate.update(insert_sql,
                obj.getId(),
                obj.getName(),
                obj.getPrice(),
                obj.getQuantity()) > 0;
    }

    public boolean updateFruits(Fruits obj) {
        return jdbcTemplate.update(update_sql,
                obj.getName(),
                obj.getPrice(),
                obj.getQuantity(),
                obj.getId()) > 0;
    }

    public boolean deleteFruits(Fruits obj) {
        return jdbcTemplate.update(delete_sql, obj.getId()) > 0;
    }

    public List<Fruits> selectFruits() {
        return jdbcTemplate.query(select_sql, new FruitsMapper());
    }
}