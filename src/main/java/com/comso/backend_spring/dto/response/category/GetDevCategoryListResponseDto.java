package com.comso.backend_spring.dto.response.category;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.comso.backend_spring.common.ResponseCode;
import com.comso.backend_spring.common.ResponseMessage;
import com.comso.backend_spring.dto.object.DevCategoryListItem;
import com.comso.backend_spring.dto.response.ResponseDto;
import com.comso.backend_spring.entity.DevCategoryEntity;

import lombok.Getter;

@Getter
public class GetDevCategoryListResponseDto extends ResponseDto{
    private List<DevCategoryListItem> devCategoryList;

    private GetDevCategoryListResponseDto(List<DevCategoryEntity> devCategoryEntities){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.devCategoryList = DevCategoryListItem.getList(devCategoryEntities);
        
    }
    public static ResponseEntity<GetDevCategoryListResponseDto> success(List<DevCategoryEntity> devCategoryEntities){
        GetDevCategoryListResponseDto result = new GetDevCategoryListResponseDto(devCategoryEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
