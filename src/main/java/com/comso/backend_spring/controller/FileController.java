package com.comso.backend_spring.controller;

import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.comso.backend_spring.service.FileService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping("/upload")
    public String upload(
        @RequestParam("file") MultipartFile file
    ){
        String url = fileService.upload(file);
        return url;
    }

    @GetMapping(value="{imageName}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public Resource getImage(
        @PathVariable("imageName") String imageNameString
    ){
        Resource resource = fileService.getImage(imageNameString);
        return resource;
    }

    @GetMapping(value="{videoName}", produces = {MediaType.APPLICATION_OCTET_STREAM_VALUE})
    public Resource getVideo(
        @PathVariable("videoName") String videoNameString
    ){
        Resource resource = fileService.getVideo(videoNameString);
        return resource;
    }
    
    
}
