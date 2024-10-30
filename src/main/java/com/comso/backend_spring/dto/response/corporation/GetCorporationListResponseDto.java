package com.comso.backend_spring.dto.response.corporation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.comso.backend_spring.common.ResponseCode;
import com.comso.backend_spring.common.ResponseMessage;
import com.comso.backend_spring.dto.object.CorporationListItem;
import com.comso.backend_spring.dto.response.ResponseDto;
import com.comso.backend_spring.entity.CorporationListViewEntity;

import lombok.Getter;

@Getter
public class GetCorporationListResponseDto extends ResponseDto{
    
    private List<CorporationListItem> corporationList;

    private GetCorporationListResponseDto(List<CorporationListViewEntity> corporationEntities){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.corporationList = CorporationListItem.getList(corporationEntities);
    }

    public static ResponseEntity<GetCorporationListResponseDto> success(List<CorporationListViewEntity> corporationEntities){
        GetCorporationListResponseDto result = new GetCorporationListResponseDto(corporationEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
