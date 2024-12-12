package com.codexabhishek.ecommerce.controllers;

import com.codexabhishek.ecommerce.model.Product;
import com.codexabhishek.ecommerce.repo.Productrepo;
import com.codexabhishek.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class Productcontroller {

    @Autowired
    private ProductService productService;


    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.ACCEPTED);
    }
    @GetMapping("product/{id}")
    public ResponseEntity<Product>getProductbyId(@PathVariable int id){
        Product product = productService.getProductById(id);
        if(product!=null){
            return new ResponseEntity<>(product,HttpStatus.OK);
        }
        else{
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/product")
    public ResponseEntity<?>addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile){

        Product savedProduct = null;
        try{
            savedProduct = productService.addProduct(product,imageFile);
            return new ResponseEntity<>(savedProduct,HttpStatus.CREATED);
        }
        catch (IOException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
//        return new ResponseEntity<>(savedProduct,HttpStatus.CREATED);
    }
    @GetMapping("/product/{id}/image")
    public ResponseEntity<byte[]> getImage(@PathVariable int productid){
        Product savingData = productService.getProductById(productid);
        return new ResponseEntity<>(savingData.getImageData(),HttpStatus.OK);
    }
}
