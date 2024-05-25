package com.amazingJava.Real.time.social.media.sentiment.anlysis.service;

import com.amazingJava.Real.time.social.media.sentiment.anlysis.Util.ImageUtil;
import com.amazingJava.Real.time.social.media.sentiment.anlysis.model.ImageData;
import com.amazingJava.Real.time.social.media.sentiment.anlysis.model.ImageFileData;
import com.amazingJava.Real.time.social.media.sentiment.anlysis.repository.ImageFileDataRepo;
import com.amazingJava.Real.time.social.media.sentiment.anlysis.repository.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
public class ImageService {
    @Autowired
    private ImageRepo imageRepo;

    @Autowired
    private ImageFileDataRepo imageFileDataRepo;
    private final String FOLDER_PATH = "E:\\Jewel\\Image\\";

    //store images into direct database with compression

    public String uploadImage(MultipartFile file) throws IOException {
        try {
            byte[] imageData = file.getBytes(); // Get bytes directly from MultipartFile
            ImageData imageToSave = imageRepo.save(ImageData.builder()
                    .name(file.getOriginalFilename())
                    .type(file.getContentType())
                    .imageData(ImageUtil.compressImage(file.getBytes()))
                    .build()) ;
            if(imageData != null)
                return "Image uploaded successfully!"+file.getOriginalFilename(); // Or relevant success message
        } catch (IOException e) {
            // Handle IOException appropriately (e.g., log error, return error message)
            return "Error uploading image: " + e.getMessage();
        }
        return null;
    }
    public byte[] downloadImage(String fileName){
        Optional<ImageData> dbimageData =  imageRepo.findByName(fileName);
        byte[] image = ImageUtil.decompressImage(dbimageData.get().getImageData());
        return image;
    }


    //@@@@@ store image into file system and add the path into database
    public String uploadImageFileSystem(MultipartFile file) throws IOException {
        try {
           String filePath = FOLDER_PATH+ file.getOriginalFilename();
            ImageFileData imageFileData = imageFileDataRepo.save(ImageFileData.builder()
                    .name(file.getOriginalFilename())
                    .type(file.getContentType())
                    .filePath(filePath).build());
            file.transferTo(new File(filePath));
            if(imageFileData != null)
                return "Image uploaded successfully at - "+filePath; // Or relevant success message
        } catch (IOException e) {
            // Handle IOException appropriately (e.g., log error, return error message)
            return "Error uploading image: " + e.getMessage();
        }
        return null;
    }


    public byte[] downloadImageFileSystem(String fileName) throws IOException {
        Optional<ImageFileData> fileData =  imageFileDataRepo.findByName(fileName);
        String filePath = fileData.get().getFilePath();
        byte[] image = Files.readAllBytes(new File(filePath).toPath());
        return image;
    }
}
