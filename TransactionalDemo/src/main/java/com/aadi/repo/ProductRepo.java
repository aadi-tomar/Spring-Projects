package com.aadi.repo;

import com.aadi.DTO.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveProduct(Product product){
        String sql = "Insert into productDetail VALUES (?,?)";
        Object[] args = {product.getId(), product.getName()};
        jdbcTemplate.update(sql, args );
        System.out.println("Product inserted");
    }
}
