package com.amazingJava.Real.time.social.media.sentiment.anlysis.config;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Value("${API_KEY}")
    private String api_key;

    @Value("${CLOUD_NAME}")
    private String cloud_name;

    @Value("${API_SECRET}")
    private String api_secret;

    @Bean
    public Cloudinary getCloudinary(){
        Map config = new HashMap();
        config.put("cloud_name",cloud_name);
        config.put("api_key",api_key);
        config.put("api_secret",api_secret);
        config.put("secure",true);
        config.put("use_filename", true);
        config.put("unique_filename", false);
        config.put("overwrite", true);

        return new Cloudinary(config);
    }
}
