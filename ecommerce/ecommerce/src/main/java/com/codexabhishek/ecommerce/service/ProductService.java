package com.codexabhishek.ecommerce.service;

import com.codexabhishek.ecommerce.model.Product;
import com.codexabhishek.ecommerce.repo.Productrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private Productrepo productRepo;
    public List<Product>getAllProducts(){
        return productRepo.findAll();
    }
    public Product getProductById(int id){
        return productRepo.findById(id).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile image) throws IOException {
        product.setImageData(image.getBytes());
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        return productRepo.save(product);
    }
}
