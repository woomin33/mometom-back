package com.comso.backend_spring.dto.response.category;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.comso.backend_spring.common.ResponseCode;
import com.comso.backend_spring.common.ResponseMessage;
import com.comso.backend_spring.dto.object.SelectedCategoryListItem;
import com.comso.backend_spring.dto.response.ResponseDto;
import com.comso.backend_spring.entity.BoardCategoryEntity;

import lombok.Getter;

@Getter
public class GetSelectedCategoryListResponseDto extends ResponseDto{
    private List<SelectedCategoryListItem> selectedCategoryList;

    private GetSelectedCategoryListResponseDto(List<BoardCategoryEntity> boardCategoryEntities){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.selectedCategoryList = SelectedCategoryListItem.getList(boardCategoryEntities);
        
    }
    public static ResponseEntity<GetSelectedCategoryListResponseDto> success(List<BoardCategoryEntity> boardCategoryEntities){
        GetSelectedCategoryListResponseDto result = new GetSelectedCategoryListResponseDto(boardCategoryEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
