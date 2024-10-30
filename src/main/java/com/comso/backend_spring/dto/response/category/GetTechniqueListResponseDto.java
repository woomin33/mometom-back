package com.comso.backend_spring.dto.response.category;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.comso.backend_spring.common.ResponseCode;
import com.comso.backend_spring.common.ResponseMessage;
import com.comso.backend_spring.dto.object.TechniqueListItem;
import com.comso.backend_spring.dto.response.ResponseDto;
import com.comso.backend_spring.entity.TechniqueEntity;

import lombok.Getter;

@Getter
public class GetTechniqueListResponseDto extends ResponseDto{
    private List<TechniqueListItem> techniqueList;

    private GetTechniqueListResponseDto(List<TechniqueEntity> techniqueEntities){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.techniqueList = TechniqueListItem.getList(techniqueEntities);
        
    }
    public static ResponseEntity<GetTechniqueListResponseDto> success(List<TechniqueEntity> techniqueEntities){
        GetTechniqueListResponseDto result = new GetTechniqueListResponseDto(techniqueEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}

