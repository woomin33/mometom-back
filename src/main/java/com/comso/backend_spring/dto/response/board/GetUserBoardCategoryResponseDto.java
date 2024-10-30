package com.comso.backend_spring.dto.response.board;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.comso.backend_spring.common.ResponseCode;
import com.comso.backend_spring.common.ResponseMessage;
import com.comso.backend_spring.dto.object.UserBoardCategoryListItem;
import com.comso.backend_spring.dto.response.ResponseDto;
import com.comso.backend_spring.repository.resultSet.GetUserBoardCategoryResultSet;

import lombok.Getter;

@Getter
public class GetUserBoardCategoryResponseDto extends ResponseDto{
    private List<UserBoardCategoryListItem> userBoardCategoryList;

    private GetUserBoardCategoryResponseDto(List<GetUserBoardCategoryResultSet> resultSets){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.userBoardCategoryList = UserBoardCategoryListItem.getList(resultSets);
    }

    public static ResponseEntity<GetUserBoardCategoryResponseDto> success(List<GetUserBoardCategoryResultSet> resultSets){
        GetUserBoardCategoryResponseDto result = new GetUserBoardCategoryResponseDto(resultSets);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> noExistBoard(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_BOARD, ResponseMessage.NOT_EXISTED_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
