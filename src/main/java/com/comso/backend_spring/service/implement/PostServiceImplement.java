package com.comso.backend_spring.service.implement;


import java.util.ArrayList;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.comso.backend_spring.dto.request.post.GetSearchPostListRequestDto;
import com.comso.backend_spring.dto.request.post.PostPostRequestDto;
import com.comso.backend_spring.dto.response.ResponseDto;
import com.comso.backend_spring.dto.response.board.PostBoardResonseDto;
import com.comso.backend_spring.dto.response.post.GetPostListResponseDto;
import com.comso.backend_spring.dto.response.post.GetPostResponseDto;
import com.comso.backend_spring.dto.response.post.PostPostResonseDto;
import com.comso.backend_spring.dto.response.post.GetSearchPostListResponseDto;
import com.comso.backend_spring.entity.PostEntity;
import com.comso.backend_spring.entity.PostListViewEntity;
import com.comso.backend_spring.entity.SearchLogPostEntity;
import com.comso.backend_spring.repository.PostListViewRepository;
import com.comso.backend_spring.repository.PostRepository;
import com.comso.backend_spring.repository.SearchLogPostRepository;
import com.comso.backend_spring.repository.UserRespository;
import com.comso.backend_spring.repository.resultSet.GetPostResultSet;
import com.comso.backend_spring.service.PostService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostServiceImplement implements PostService{
    
    private final PostRepository postRepository;
    private final UserRespository userRespository;
    private final PostListViewRepository postListViewRepository;
    private final SearchLogPostRepository searchLogPostRepository;

    @Override
    public ResponseEntity<? super GetPostResponseDto> getPost(Integer postNumber) {

        GetPostResultSet resultSet = null;
    
        try {
            resultSet = postRepository.getPost(postNumber);
            if(resultSet == null) return GetPostResponseDto.noExistBoard();
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetPostResponseDto.success(resultSet);
    }

    @Override
    public ResponseEntity<? super PostPostResonseDto> postPost(PostPostRequestDto dto, String email) {
        try {
            
            boolean existedEmail = userRespository.existsByEmail(email);
            if(!existedEmail) return PostBoardResonseDto.noExistUser();

            PostEntity postEntity = new PostEntity(dto, email);
            postRepository.save(postEntity);            

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PostPostResonseDto.success();
    }

    @Override
    public ResponseEntity<? super GetPostListResponseDto> getPostList() {
        List<PostListViewEntity> postListViewEntities = new ArrayList<>();
        try {
            
            postListViewEntities = postListViewRepository.findAll();
            
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetPostListResponseDto.success(postListViewEntities);
    }

    @Override
    public ResponseEntity<? super GetSearchPostListResponseDto> getSearchPostList(GetSearchPostListRequestDto dto) {

        List<PostListViewEntity> postListViewEntities = new ArrayList<>();
        String searchWord = dto.getSearchWord();
        String startDate = dto.getStartDate();
        String endDate = dto.getEndDate();
        
        boolean hasSearchWord = StringUtils.hasText(searchWord);
        boolean hasStartDate = StringUtils.hasText(startDate);
        boolean hasEndDate = StringUtils.hasText(endDate);
        
        try {
            
            if (hasSearchWord) {
                if (hasStartDate && hasEndDate) {
                    postListViewEntities =  postListViewRepository.findByTitleContainsAndWriteDatetimeBetweenOrderByWriteDatetimeDesc(searchWord, startDate, endDate);
                } else if (hasStartDate) {
                    postListViewEntities =  postListViewRepository.findByTitleContainsAndWriteDatetimeGreaterThanEqualOrderByWriteDatetimeDesc(searchWord, startDate);
                } else if (hasEndDate) {
                    postListViewEntities =  postListViewRepository.findByTitleContainsAndWriteDatetimeLessThanEqualOrderByWriteDatetimeDesc(searchWord, endDate);
                } else {
                    postListViewEntities =  postListViewRepository.findByTitleContainsOrderByWriteDatetimeDesc(searchWord);
                }
            } else {
                if (hasStartDate && hasEndDate) {
                    postListViewEntities =  postListViewRepository.findByWriteDatetimeBetweenOrderByWriteDatetimeDesc(startDate, endDate);
                } else if (hasStartDate) {
                    postListViewEntities =  postListViewRepository.findByWriteDatetimeGreaterThanEqualOrderByWriteDatetimeDesc(startDate);
                    
                } else if (hasEndDate) {
                    postListViewEntities =  postListViewRepository.findByWriteDatetimeLessThanEqualOrderByWriteDatetimeDesc(endDate);
                } else {
                    postListViewEntities =  postListViewRepository.findAllByOrderByWriteDatetimeDesc();
                }
            }
            if(hasSearchWord){
                SearchLogPostEntity searchLogPostEntity = new SearchLogPostEntity(searchWord);
                searchLogPostRepository.save(searchLogPostEntity);
            }
            
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        
        return GetSearchPostListResponseDto.success(postListViewEntities);
    }
    
}
