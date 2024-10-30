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
public class GetPostListResponseDto extends ResponseDto {
    
    private List<PostListItem> postList;

    private GetPostListResponseDto(List<PostListViewEntity> postEntities){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.postList = PostListItem.getList(postEntities);
    }

    public static ResponseEntity<GetPostListResponseDto> success(List<PostListViewEntity> postEntities){
        GetPostListResponseDto result = new GetPostListResponseDto(postEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
