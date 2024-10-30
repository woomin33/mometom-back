package com.comso.backend_spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comso.backend_spring.dto.request.board.PatchBoardRequestDto;
import com.comso.backend_spring.dto.request.board.PostBoardRequestDto;
import com.comso.backend_spring.dto.request.board.PostCommentRequestDto;
import com.comso.backend_spring.dto.request.category.PostCategoryRequestDto;
import com.comso.backend_spring.service.BoardService;
import com.comso.backend_spring.dto.response.board.DeleteBoardResponseDto;
import com.comso.backend_spring.dto.response.board.GetBoardResponseDto;
import com.comso.backend_spring.dto.response.board.GetCommentListResponseDto;
import com.comso.backend_spring.dto.response.board.GetFavoriteListResponseDto;
import com.comso.backend_spring.dto.response.board.GetLatestBoardListResponseDto;
import com.comso.backend_spring.dto.response.board.GetPopularityBoardListResponseDto;
import com.comso.backend_spring.dto.response.board.GetMostViewedBoardListResponseDto;
import com.comso.backend_spring.dto.response.board.GetUserBoardListResponseDto;
import com.comso.backend_spring.dto.response.board.GetSearchBoardListResponseDto;
import com.comso.backend_spring.dto.response.board.GetUserBoardCategoryResponseDto;
import com.comso.backend_spring.dto.response.board.IncreaseViewCountResponseDto;
import com.comso.backend_spring.dto.response.board.PatchBoardResponseDto;
import com.comso.backend_spring.dto.response.board.PostBoardResonseDto;
import com.comso.backend_spring.dto.response.board.PostCommentResponseDto;
import com.comso.backend_spring.dto.response.board.PutFavoriteResponseDto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
public class BoardController {
    
    private final BoardService boardService;

    @GetMapping("/{boardNumber}")
    public ResponseEntity<? super GetBoardResponseDto> getBoard(
        @PathVariable("boardNumber") Integer boardNumber
    ){
        ResponseEntity<? super GetBoardResponseDto> response = boardService.getBoard(boardNumber);
        return response;
    }

    @GetMapping("/{boardNumber}/favorite-list")
    public ResponseEntity<? super GetFavoriteListResponseDto> getFavoriteList(
        @PathVariable("boardNumber") Integer boardNumber
    ){
        ResponseEntity<? super GetFavoriteListResponseDto> response = boardService.getFavoriteList(boardNumber);
        return response;
    }

    @GetMapping("/{boardNumber}/comment-list")
    public ResponseEntity<? super GetCommentListResponseDto>getCommentList(
        @PathVariable("boardNumber") Integer boardNumber
    ){
        ResponseEntity<? super GetCommentListResponseDto> response = boardService.getCommentList(boardNumber);
        return response;
    }

    @GetMapping("/{boardNumber}/increase-view-count")
    public ResponseEntity<? super IncreaseViewCountResponseDto> increseViewCount(
        @PathVariable("boardNumber") Integer boardNumber
    ){
        ResponseEntity<? super IncreaseViewCountResponseDto> response = boardService.increaseViewCount(boardNumber);
        return response;
    }

    @GetMapping("/user-board-category/{email}")
    public ResponseEntity<? super GetUserBoardCategoryResponseDto> increseViewCount(
        @PathVariable("email") String email
    ){
        ResponseEntity<? super GetUserBoardCategoryResponseDto> response = boardService.getUserBoardCategoryList(email);
        return response;
    }


    @PostMapping("/latest-list")
    public ResponseEntity<? super GetLatestBoardListResponseDto> getLatestBoardList(
        @RequestBody @Valid PostCategoryRequestDto requestBody
    ){
        ResponseEntity<? super GetLatestBoardListResponseDto> response = boardService.getLatestBoardList(requestBody);
        return response;
    }

    @PostMapping("/popularity-list")
    public ResponseEntity<? super GetPopularityBoardListResponseDto> getPopularityBoardList(
        @RequestBody @Valid PostCategoryRequestDto requestBody
    ){
        ResponseEntity<? super GetPopularityBoardListResponseDto> response = boardService.getPopularityBoardList(requestBody);
        return response;
    }

    @PostMapping("/mostviewed-list")
    public ResponseEntity<? super GetMostViewedBoardListResponseDto> getMostViewedBoardList(
        @RequestBody @Valid PostCategoryRequestDto requestBody
    ){
        ResponseEntity<? super GetMostViewedBoardListResponseDto> response = boardService.getMostViewedBoardList(requestBody);
        return response;
    }

    @GetMapping("/user-board-list/{email}")
    public ResponseEntity<? super GetUserBoardListResponseDto> getUserBoardList(
        @PathVariable("email") String email
    ){
        ResponseEntity<? super GetUserBoardListResponseDto> response = boardService.getUserBoardList(email);
        
        return response;
    }

    @GetMapping(value = {"/search-list/{searchWord}", "/search-list/{searchWord}/{preSearchWord}"})
    public ResponseEntity<? super GetSearchBoardListResponseDto> getSearchBoardList(
        @PathVariable("searchWord") String searchWord,
        @PathVariable(value = "preSearchWord", required = false) String preSearchWord
    ){
        ResponseEntity<? super GetSearchBoardListResponseDto> response = boardService.getSearchBoardList(searchWord, preSearchWord);
        return response;
    }

    
    
    @PostMapping("")
    public ResponseEntity<? super PostBoardResonseDto> postBoard(
        @RequestBody @Valid PostBoardRequestDto requestBody,
        @AuthenticationPrincipal String email
    ){
        ResponseEntity<? super PostBoardResonseDto> response = boardService.postBoard(requestBody, email);
        return response;
    }

    @PostMapping("/{boardNumber}/comment")
    public ResponseEntity<? super PostCommentResponseDto> postComment(
        @RequestBody @Valid PostCommentRequestDto requestBody,
        @PathVariable("boardNumber") Integer boardNumber,
        @AuthenticationPrincipal String email
    ){
        ResponseEntity<? super PostCommentResponseDto> response = boardService.postComment(requestBody, boardNumber, email);
        return response;
    }

    @PutMapping("/{boardNumber}/favorite")
    public ResponseEntity<? super PutFavoriteResponseDto> putFavorite(
        @PathVariable("boardNumber") Integer boardNumber,
        @AuthenticationPrincipal String email
    ){
        ResponseEntity<? super PutFavoriteResponseDto> response= boardService.putFavorite(boardNumber, email);
        return response;
    }

    @PatchMapping("/{boardNumber}")
    public ResponseEntity<? super PatchBoardResponseDto> patchBoard(
        @RequestBody @Valid PatchBoardRequestDto requestBody,
        @PathVariable("boardNumber") Integer boardNumber,
        @AuthenticationPrincipal String email
    ){
        ResponseEntity<? super PatchBoardResponseDto> response = boardService.patchBoard(requestBody, boardNumber, email);
        return response;
    }
    
    @DeleteMapping("/{boardNumber}")
    public ResponseEntity<? super DeleteBoardResponseDto> deleteBoard(
        @PathVariable("boardNumber") Integer boardNumber,
        @AuthenticationPrincipal String email
    ){
        ResponseEntity<? super DeleteBoardResponseDto> response = boardService.deleteBoard(boardNumber, email);
        return response;
    }
    
}
