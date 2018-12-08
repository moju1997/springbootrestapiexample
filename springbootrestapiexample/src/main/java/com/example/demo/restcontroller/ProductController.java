package com.example.demo.restcontroller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/products")
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    /* to save product*/
    @PostMapping
    public Product createProduct(@Valid @RequestBody Product product){
        return productService.save(product);
    }

    /*get all products*/
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.findAll();
    }

    /* get product by id*/
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable (value = "id")Long productid){
        Product product=productService.findOne(productid);

        if(product==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    /* update product by id*/
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable (value = "id") Long productid ,@RequestBody @Valid Product productDetails){
        Product product=productService.findOne(productid);
        if(product==null){
            ResponseEntity.notFound().build();
        }
        product.setCategory(productDetails.getCategory());
        product.setName(productDetails.getName());

        Product updateProduct=productService.save(product);
        return ResponseEntity.ok().body(updateProduct);
    }

    /* delete product by id*/
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable (value = "id")Long productid){
        Product product=productService.findOne(productid);
        if (product==null){
            ResponseEntity.notFound().build();
        }
        productService.delete(product);
        return ResponseEntity.ok().build();
    }

}
