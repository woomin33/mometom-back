package com.comso.backend_spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.comso.backend_spring.dto.response.category.GetCategoryListResponseDto;
import com.comso.backend_spring.dto.response.category.GetSelectedCategoryListResponseDto;
import com.comso.backend_spring.dto.response.category.GetDevCategoryListResponseDto;
import com.comso.backend_spring.dto.response.category.GetTechniqueListResponseDto;
import com.comso.backend_spring.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/blog")
    public ResponseEntity<? super GetCategoryListResponseDto> getCategoryList(

    ){
        ResponseEntity<? super GetCategoryListResponseDto> response = categoryService.getCategory();
        return response;
    }
    @GetMapping("/{boardNumber}/selected-category")
    public ResponseEntity<? super GetSelectedCategoryListResponseDto> getSelectedCategoryList(
        @PathVariable("boardNumber") Integer boardNumber
    ){
        ResponseEntity<? super GetSelectedCategoryListResponseDto> response = categoryService.getSelectedCategory(boardNumber);
        return response;
    }
    @GetMapping("/employ")
    public ResponseEntity<? super GetDevCategoryListResponseDto> getDevCategoryList(

    ){
        ResponseEntity<? super GetDevCategoryListResponseDto> response = categoryService.getDevCategory();
        return response;
    }
    @GetMapping("/notice")
    public ResponseEntity<? super GetTechniqueListResponseDto> getTechniqueList(

    ){
        ResponseEntity<? super GetTechniqueListResponseDto> response = categoryService.getTechnique();
        return response;
    }

}
