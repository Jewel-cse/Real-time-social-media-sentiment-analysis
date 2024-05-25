package com.amazingJava.Real.time.social.media.sentiment.anlysis.controller;

import com.amazingJava.Real.time.social.media.sentiment.anlysis.model.ImageData;
import com.amazingJava.Real.time.social.media.sentiment.anlysis.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private ImageService imageService;

    //upload an image into the file -> then save the file path into database
    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
        String uploadImg = imageService.uploadImage(file);

        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImg);
    }


    //get the image : from db we get file path-> and then file we show the image
    @GetMapping("/{fileName}")
    public ResponseEntity<?> download(@PathVariable String fileName) throws IOException {
        byte[]imageDate = imageService.downloadImage(fileName);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageDate);
    }
}
