package com.comso.backend_spring.dto.response.category;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.comso.backend_spring.common.ResponseCode;
import com.comso.backend_spring.common.ResponseMessage;
import com.comso.backend_spring.dto.object.CategoryListItem;
import com.comso.backend_spring.dto.response.ResponseDto;
import com.comso.backend_spring.entity.CategoryEntity;

import lombok.Getter;

@Getter
public class GetCategoryListResponseDto extends ResponseDto{
    private List<CategoryListItem> categoryList;

    private GetCategoryListResponseDto(List<CategoryEntity> categoryEntities){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.categoryList = CategoryListItem.getList(categoryEntities);
        
    }
    public static ResponseEntity<GetCategoryListResponseDto> success(List<CategoryEntity> categoryEntities){
        GetCategoryListResponseDto result = new GetCategoryListResponseDto(categoryEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
