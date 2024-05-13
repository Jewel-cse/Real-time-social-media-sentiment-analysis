package com.amazingJava.Real.time.social.media.sentiment.anlysis.service;

import com.amazingJava.Real.time.social.media.sentiment.anlysis.repository.ProductRepo;
import com.amazingJava.Real.time.social.media.sentiment.anlysis.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts(){

        return productRepo.findAll();
    }

    public Product findOne(Long id){
        return productRepo.findById(id).orElse(null);
    }

    public void save(Product product){
        productRepo.save(product);
    }

    public void delete(Long id) {
        productRepo.deleteById(id);
    }

    public void update(Product product,Long id) {
        Product newPr = productRepo.findById(id).get();
        newPr.setId(id);
        newPr.setName(product.getName());
        newPr.setDescription(product.getName());
        newPr.setPrice(product.getPrice());
        productRepo.save(newPr);
    }
}
