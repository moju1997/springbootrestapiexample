package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    /* To Save Products */
    public Product save(Product product) {
        return productRepository.save(product);
    }

    /* To search all products*/
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    /* search by id*/
    public Product findOne(Long productid){
        return productRepository.findById(productid).orElse(null);
    }

    /*To Delete Product*/
    public void delete(Product product){
        productRepository.delete(product);
    }
}
