package com.comso.backend_spring.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    
    String upload(MultipartFile file);
    Resource getImage(String imageName);
    Resource getVideo(String videoName);

}
