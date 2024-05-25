package com.amazingJava.Real.time.social.media.sentiment.anlysis.repository;

import com.amazingJava.Real.time.social.media.sentiment.anlysis.model.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepo extends JpaRepository<ImageData,Integer> {
    Optional<ImageData> findByName(String fileName);
}
