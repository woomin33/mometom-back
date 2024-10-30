package com.comso.backend_spring.dto.response.post;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.comso.backend_spring.common.ResponseCode;
import com.comso.backend_spring.common.ResponseMessage;
import com.comso.backend_spring.dto.object.PostListItem;
import com.comso.backend_spring.dto.response.ResponseDto;
import com.comso.backend_spring.entity.PostListViewEntity;

import lombok.Getter;

@Getter
public class GetSearchPostListResponseDto extends ResponseDto{
    
    private List<PostListItem> searchList;

    private GetSearchPostListResponseDto(List<PostListViewEntity> postListViewEntities){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.searchList = PostListItem.getList(postListViewEntities);
    }

    public static ResponseEntity<GetSearchPostListResponseDto> success(List<PostListViewEntity> postListViewEntities){
        GetSearchPostListResponseDto result = new GetSearchPostListResponseDto(postListViewEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
}
