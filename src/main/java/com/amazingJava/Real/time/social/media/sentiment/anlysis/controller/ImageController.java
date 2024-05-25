package com.amazingJava.Real.time.social.media.sentiment.anlysis.controller;

import com.amazingJava.Real.time.social.media.sentiment.anlysis.model.ImageData;
import com.amazingJava.Real.time.social.media.sentiment.anlysis.service.CloudinaryImageService;
import com.amazingJava.Real.time.social.media.sentiment.anlysis.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private ImageService imageService;
    @Autowired
    private CloudinaryImageService cloudinaryImageService;


    //################# store database #############
    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
        String uploadImg = imageService.uploadImage(file);

        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImg);
    }

    @GetMapping("/{fileName}")
    public ResponseEntity<?> download(@PathVariable String fileName) throws IOException {
        byte[]imageData = imageService.downloadImage(fileName);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }

    //######################## store file system #############
    //upload an image into the file -> then save the file path into database
    @PostMapping("/fileSystem")
    public ResponseEntity<?> uploadImageFilesystem(@RequestParam("image")MultipartFile file) throws IOException {
        String uploadImg = imageService.uploadImageFileSystem(file);

        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImg);
    }
    //get the image : from db we get file path-> and then file we show the image
    @GetMapping("/fileSystem/{fileName}")
    public ResponseEntity<?> downloadFileSystem(@PathVariable String fileName) throws IOException {
        byte[]imageData = imageService.downloadImageFileSystem(fileName);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }

    //#################### Store cloudinary #############
    @PostMapping("/cloud")
    public ResponseEntity<?> uploadImageCloud(@RequestParam("image")MultipartFile file) throws IOException {
        Map data = cloudinaryImageService.upload(file);

        return new  ResponseEntity(data,HttpStatus.OK);
    }

    @GetMapping("/cloud/{fileName}")
    public ResponseEntity<?> downloadCloud(@PathVariable String fileName) throws IOException {
        byte[]imageData = cloudinaryImageService.downloadImage(fileName);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return ResponseEntity.ok().headers(headers).body(imageData);

    }

}
