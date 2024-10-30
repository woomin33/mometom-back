package com.comso.backend_spring.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.comso.backend_spring.dto.response.ResponseDto;
import com.comso.backend_spring.dto.response.category.GetCategoryListResponseDto;
import com.comso.backend_spring.dto.response.category.GetDevCategoryListResponseDto;
import com.comso.backend_spring.dto.response.category.GetSelectedCategoryListResponseDto;
import com.comso.backend_spring.dto.response.category.GetTechniqueListResponseDto;
import com.comso.backend_spring.entity.BoardCategoryEntity;
import com.comso.backend_spring.entity.CategoryEntity;
import com.comso.backend_spring.entity.DevCategoryEntity;
import com.comso.backend_spring.entity.TechniqueEntity;
import com.comso.backend_spring.repository.BoardCategoryRepository;
import com.comso.backend_spring.repository.CategoryRepository;
import com.comso.backend_spring.repository.DevCategoryRepository;
import com.comso.backend_spring.repository.TechniqueRepository;
import com.comso.backend_spring.service.CategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImplement implements CategoryService{

    private final CategoryRepository categoryRepository;
    private final BoardCategoryRepository boardCategoryRepository;
    private final DevCategoryRepository devCategoryRepository;
    private final TechniqueRepository techniqueRepository;

    @Override
    public ResponseEntity<? super GetCategoryListResponseDto> getCategory() {
        List<CategoryEntity> resultSets = new ArrayList<>();

        try {
            resultSets = categoryRepository.findByOrderByCategoryNumberAsc();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetCategoryListResponseDto.success(resultSets);
    }

    @Override
    public ResponseEntity<? super GetSelectedCategoryListResponseDto> getSelectedCategory(Integer boardNumber) {
        List<BoardCategoryEntity> resultSets = new ArrayList<>();

        try {
            resultSets = boardCategoryRepository.findByBoardNumber(boardNumber);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetSelectedCategoryListResponseDto.success(resultSets);
    }

    @Override
    public ResponseEntity<? super GetDevCategoryListResponseDto> getDevCategory() {
        List<DevCategoryEntity> resultSets = new ArrayList<>();

        try {
            resultSets = devCategoryRepository.findByOrderByCategoryNumberAsc();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetDevCategoryListResponseDto.success(resultSets);
    }

    @Override
    public ResponseEntity<? super GetTechniqueListResponseDto> getTechnique() {
        List<TechniqueEntity> resultSets = new ArrayList<>();

        try {
            resultSets = techniqueRepository.findByOrderByTechniqueNumberAsc();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetTechniqueListResponseDto.success(resultSets);
    }

    
    
}
