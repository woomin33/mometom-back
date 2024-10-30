package com.comso.backend_spring.service;

import org.springframework.http.ResponseEntity;

import com.comso.backend_spring.dto.request.board.PatchBoardRequestDto;
import com.comso.backend_spring.dto.request.board.PostBoardRequestDto;
import com.comso.backend_spring.dto.request.board.PostCommentRequestDto;
import com.comso.backend_spring.dto.request.category.PostCategoryRequestDto;
import com.comso.backend_spring.dto.response.board.DeleteBoardResponseDto;
import com.comso.backend_spring.dto.response.board.GetBoardResponseDto;
import com.comso.backend_spring.dto.response.board.GetCommentListResponseDto;
import com.comso.backend_spring.dto.response.board.GetFavoriteListResponseDto;
import com.comso.backend_spring.dto.response.board.GetLatestBoardListResponseDto;
import com.comso.backend_spring.dto.response.board.GetPopularityBoardListResponseDto;
import com.comso.backend_spring.dto.response.board.GetMostViewedBoardListResponseDto;
import com.comso.backend_spring.dto.response.board.GetUserBoardListResponseDto;
import com.comso.backend_spring.dto.response.board.GetSearchBoardListResponseDto;
import com.comso.backend_spring.dto.response.board.IncreaseViewCountResponseDto;
import com.comso.backend_spring.dto.response.board.PatchBoardResponseDto;
import com.comso.backend_spring.dto.response.board.PostBoardResonseDto;
import com.comso.backend_spring.dto.response.board.PostCommentResponseDto;
import com.comso.backend_spring.dto.response.board.PutFavoriteResponseDto;
import com.comso.backend_spring.dto.response.board.GetUserBoardCategoryResponseDto;



public interface BoardService {
    ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber);
    ResponseEntity<? super GetFavoriteListResponseDto> getFavoriteList(Integer boardNumber);
    ResponseEntity<? super GetCommentListResponseDto> getCommentList(Integer boardNumber);
    ResponseEntity<? super GetLatestBoardListResponseDto> getLatestBoardList(PostCategoryRequestDto dto);
    ResponseEntity<? super GetPopularityBoardListResponseDto> getPopularityBoardList(PostCategoryRequestDto dto);
    ResponseEntity<? super GetMostViewedBoardListResponseDto> getMostViewedBoardList(PostCategoryRequestDto dto);
    ResponseEntity<? super GetUserBoardListResponseDto> getUserBoardList(String email);
    ResponseEntity<? super GetSearchBoardListResponseDto> getSearchBoardList(String searchWord, String preSearchWord);
    ResponseEntity<? super GetUserBoardCategoryResponseDto> getUserBoardCategoryList(String email);


    ResponseEntity<? super PostBoardResonseDto> postBoard(PostBoardRequestDto dto, String email);
    ResponseEntity<? super PostCommentResponseDto> postComment(PostCommentRequestDto dto, Integer boardNumber, String email);

    ResponseEntity<? super PutFavoriteResponseDto> putFavorite(Integer boardNumber, String email);
    ResponseEntity<? super PatchBoardResponseDto> patchBoard(PatchBoardRequestDto dto, Integer boardNumber, String email);

    ResponseEntity<? super IncreaseViewCountResponseDto> increaseViewCount(Integer boardNumber);

    ResponseEntity<? super DeleteBoardResponseDto> deleteBoard(Integer boardNumber, String email);
}
