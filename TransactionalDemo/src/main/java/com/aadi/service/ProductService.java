package com.aadi.service;

import com.aadi.DTO.Product;
import com.aadi.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;
    @Transactional
    public void saveProductInfo(){

        for(int i=1; i<10;i++){
            Product product = new Product();
            product.setId(i);
            product.setName("Product"+ i);
            productRepo.saveProduct(product);
        }
    }
}
