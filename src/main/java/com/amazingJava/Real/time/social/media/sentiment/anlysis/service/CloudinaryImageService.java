package com.amazingJava.Real.time.social.media.sentiment.anlysis.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface CloudinaryImageService {

    Map upload(MultipartFile file);
    byte[] downloadImage(String publicId);
}
