package com.amazingJava.Real.time.social.media.sentiment.anlysis.repository;

import com.amazingJava.Real.time.social.media.sentiment.anlysis.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
}
