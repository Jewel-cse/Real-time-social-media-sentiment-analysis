package com.amazingJava.Real.time.social.media.sentiment.anlysis.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.UUID;

@Service
public class CloudinaryImageServiceImp implements CloudinaryImageService {

    @Autowired
    private Cloudinary cloudinary;

    private final String FOLDER = "Animal/";
    @Override
    public Map upload(MultipartFile file) {
        try
        {
            String public_id = FOLDER+file.getOriginalFilename().toString();
            System.out.println("public_id : "+public_id);
           Map data= this.cloudinary.uploader().upload(file.getBytes(),Map.of("public_id",public_id));
           return data;
        }
        catch (Exception e){
            throw new RuntimeException("Image uploading failed");
        }
    }

    @Override
    public byte[] downloadImage(String filename) {
        String publicId = FOLDER + filename;
        System.out.println("Public Id : "+publicId);
        try {
            //String imageUrl = cloudinary.url().secure(true).generate(publicId);
            //String imageUrl = cloudinary.url().secure(true).resourceType("image").generate(publicId);
            Map resourceDetails = cloudinary.api().resource(publicId, ObjectUtils.emptyMap());
            String version = resourceDetails.get("version").toString();
            String imageUrl = cloudinary.url().version(Integer.parseInt(version)).secure(true).resourceType("image").generate(publicId)+".jpg";

            System.out.println("Generated Image URL: " + imageUrl);
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.connect();

            if (connection.getResponseCode() != 200) {
                throw new RuntimeException("Failed to download image, HTTP response code: " + connection.getResponseCode());
            }

            try (InputStream inputStream = connection.getInputStream();
                 ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                return outputStream.toByteArray();
            }
        } catch (Exception e) {
            throw new RuntimeException("Image downloading failed", e);
        }
    }
}
