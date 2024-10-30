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
public class GetPopularityBoardListResponseDto  extends ResponseDto{
    
    private List<BoardListItem> popularityList;

    private GetPopularityBoardListResponseDto(List<BoardListViewEntity> boardEntities){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.popularityList = BoardListItem.getList(boardEntities);
    }

    public static ResponseEntity<GetPopularityBoardListResponseDto> success(List<BoardListViewEntity> boardEntities){
        GetPopularityBoardListResponseDto result = new GetPopularityBoardListResponseDto(boardEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
