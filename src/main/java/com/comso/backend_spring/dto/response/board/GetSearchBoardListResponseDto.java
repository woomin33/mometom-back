package com.comso.backend_spring.dto.response.board;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.comso.backend_spring.common.ResponseCode;
import com.comso.backend_spring.common.ResponseMessage;
import com.comso.backend_spring.dto.object.BoardListItem;
import com.comso.backend_spring.dto.response.ResponseDto;
import com.comso.backend_spring.entity.BoardListViewEntity;

import lombok.Getter;

@Getter
public class GetSearchBoardListResponseDto extends ResponseDto{
    
    private List<BoardListItem> searchList;

    private GetSearchBoardListResponseDto(List<BoardListViewEntity> boardListViewEntities){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.searchList = BoardListItem.getList(boardListViewEntities);
    }

    public static ResponseEntity<GetSearchBoardListResponseDto> success(List<BoardListViewEntity> boardListViewEntities){
        GetSearchBoardListResponseDto result = new GetSearchBoardListResponseDto(boardListViewEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
}
