package com.comso.backend_spring.dto.response.search;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.comso.backend_spring.common.ResponseCode;
import com.comso.backend_spring.common.ResponseMessage;
import com.comso.backend_spring.dto.response.ResponseDto;
import com.comso.backend_spring.repository.resultSet.GetPopularListResultSet;

import lombok.Getter;

@Getter
public class GetPopularListResponseDto extends ResponseDto{
    
    private List<String> popularWordList;

    private GetPopularListResponseDto(List<GetPopularListResultSet> resultSets){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);

        List<String> popularWordList = new ArrayList<>();
        for(GetPopularListResultSet resultSet : resultSets){
            String popularWord = resultSet.getSearchWord();
            popularWordList.add(popularWord);
        }
        this.popularWordList = popularWordList;
    }

    public static ResponseEntity<GetPopularListResponseDto> success(List<GetPopularListResultSet> resultSets){
        GetPopularListResponseDto result = new GetPopularListResponseDto(resultSets);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
