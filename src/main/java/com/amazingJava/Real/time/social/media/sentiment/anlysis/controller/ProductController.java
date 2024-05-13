package com.amazingJava.Real.time.social.media.sentiment.anlysis.controller;

import com.amazingJava.Real.time.social.media.sentiment.anlysis.model.Product;
import com.amazingJava.Real.time.social.media.sentiment.anlysis.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    //private final Logger logger = LoggerFactory.getLogger(ProductController.class);
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        log.debug("hit into database");
        return productService.getAllProducts();
    }

    @Cacheable(value = "products", key = "#id",sync = true)
    @GetMapping("/products/{id}")
    public Product getOne(@PathVariable Long id) {
        log.debug("hit into database");
        return productService.findOne(id);
    }

    @PostMapping("/products")
    public void save(@RequestBody Product product) {

        productService.save(product);
    }

    @CacheEvict(value = "products", key = "#product.id")
    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable Long id) {
        log.debug("hit into database");
        productService.delete(id);
    }

    @CacheEvict(value = "products", key = "#id")
    @PutMapping("/products/{id}")
    public void update(@RequestBody Product product, @PathVariable Long id) {
        log.debug("hit into database");
        productService.update(product, id);
    }
}
