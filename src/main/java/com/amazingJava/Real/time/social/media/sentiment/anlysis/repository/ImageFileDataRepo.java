package com.amazingJava.Real.time.social.media.sentiment.anlysis.repository;

import com.amazingJava.Real.time.social.media.sentiment.anlysis.model.ImageData;
import com.amazingJava.Real.time.social.media.sentiment.anlysis.model.ImageFileData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageFileDataRepo  extends JpaRepository<ImageFileData,Integer> {
    Optional<ImageFileData> findByName(String fileName) ;

}
