package com.amazingJava.Real.time.social.media.sentiment.anlysis.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImageFileData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String name;
    private String type;
    private String filePath;

}

