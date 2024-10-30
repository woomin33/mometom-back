package com.comso.backend_spring.service.implement;

import java.util.List;
import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.comso.backend_spring.dto.request.board.PatchBoardRequestDto;
import com.comso.backend_spring.dto.request.board.PostBoardRequestDto;
import com.comso.backend_spring.dto.request.board.PostCommentRequestDto;
import com.comso.backend_spring.dto.request.category.PostCategoryRequestDto;
import com.comso.backend_spring.dto.response.ResponseDto;
import com.comso.backend_spring.dto.response.board.DeleteBoardResponseDto;
import com.comso.backend_spring.dto.response.board.GetBoardResponseDto;
import com.comso.backend_spring.dto.response.board.GetCommentListResponseDto;
import com.comso.backend_spring.dto.response.board.GetFavoriteListResponseDto;
import com.comso.backend_spring.dto.response.board.GetLatestBoardListResponseDto;
import com.comso.backend_spring.dto.response.board.GetMostViewedBoardListResponseDto;
import com.comso.backend_spring.dto.response.board.GetPopularityBoardListResponseDto;
import com.comso.backend_spring.dto.response.board.GetSearchBoardListResponseDto;
import com.comso.backend_spring.dto.response.board.GetUserBoardCategoryResponseDto;
import com.comso.backend_spring.dto.response.board.GetUserBoardListResponseDto;
import com.comso.backend_spring.dto.response.board.IncreaseViewCountResponseDto;
import com.comso.backend_spring.dto.response.board.PatchBoardResponseDto;
import com.comso.backend_spring.dto.response.board.PostBoardResonseDto;
import com.comso.backend_spring.dto.response.board.PostCommentResponseDto;
import com.comso.backend_spring.dto.response.board.PutFavoriteResponseDto;
import com.comso.backend_spring.entity.BoardCategoryEntity;
import com.comso.backend_spring.entity.BoardEntity;
import com.comso.backend_spring.entity.BoardListViewEntity;
import com.comso.backend_spring.entity.CommentEntity;
import com.comso.backend_spring.entity.FavoriteEntity;
import com.comso.backend_spring.entity.ImageEntity;
import com.comso.backend_spring.entity.SearchLogEntity;
import com.comso.backend_spring.entity.VideoEntity;
import com.comso.backend_spring.repository.BoardCategoryRepository;
import com.comso.backend_spring.repository.BoardListViewRepository;
import com.comso.backend_spring.repository.BoardRepository;
import com.comso.backend_spring.repository.CommentRepository;
import com.comso.backend_spring.repository.FavoriteRepository;
import com.comso.backend_spring.repository.ImageRepository;
import com.comso.backend_spring.repository.SearchLogRepository;
import com.comso.backend_spring.repository.UserRespository;
import com.comso.backend_spring.repository.VideoRepository;
import com.comso.backend_spring.repository.resultSet.GetBoardResultSet;
import com.comso.backend_spring.repository.resultSet.GetCommentListResultSet;
import com.comso.backend_spring.repository.resultSet.GetFavoriteListResultSet;
import com.comso.backend_spring.repository.resultSet.GetUserBoardCategoryResultSet;
import com.comso.backend_spring.service.BoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImplement implements BoardService{

    private final BoardRepository boardRepository;
    private final ImageRepository imageRepository;
    private final UserRespository userRespository;
    private final VideoRepository videoRepository;
    private final CommentRepository commentRepository;
    private final FavoriteRepository favoriteRepository;
    private final BoardListViewRepository boardListViewRepository;
    private final BoardCategoryRepository boardCategoryRepository;
    private final SearchLogRepository searchLogRepository;

    @Override
    public ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber) {

        GetBoardResultSet resultSet = null;
        List<ImageEntity> imageEntities = new ArrayList<>();
        List<VideoEntity> videoEntities = new ArrayList<>();
    
        try {
            resultSet = boardRepository.getBoard(boardNumber);
            if(resultSet == null) return GetBoardResponseDto.noExistBoard();

            imageEntities = imageRepository.findByBoardNumber(boardNumber);
            videoEntities = videoRepository.findByBoardNumber(boardNumber);

            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetBoardResponseDto.success(resultSet, imageEntities, videoEntities);
    }

    @Override
    public ResponseEntity<? super GetFavoriteListResponseDto> getFavoriteList(Integer boardNumber) {
        
        List<GetFavoriteListResultSet> resultSets = new ArrayList<>();

        try {

            boolean existedBoard = boardRepository.existsByBoardNumber(boardNumber);
            if(!existedBoard) return GetFavoriteListResponseDto.noExistBoard();

            resultSets = favoriteRepository.getFavoriteList(boardNumber);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        
        return GetFavoriteListResponseDto.success(resultSets);
    }

    @Override
    public ResponseEntity<? super GetCommentListResponseDto> getCommentList(Integer boardNumber) {
        
        List<GetCommentListResultSet> resultSets = new ArrayList<>();
        try {
            
            boolean existedBoard = boardRepository.existsByBoardNumber(boardNumber);
            if(!existedBoard) return GetCommentListResponseDto.noExistBoard();

            resultSets = commentRepository.getCommentList(boardNumber);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetCommentListResponseDto.success(resultSets);
    }

    @Override
    public ResponseEntity<? super GetLatestBoardListResponseDto> getLatestBoardList(PostCategoryRequestDto dto) {

        List<Integer> selectedCategoryList = dto.getSelectedCategoryList();
        List<BoardListViewEntity> boardListViewEntities = new ArrayList<>();
        String order = "write_datetime";
        try {
            if(selectedCategoryList.isEmpty()){
                boardListViewEntities = boardListViewRepository.getBoardListView(order);
            } else{
                boardListViewEntities = boardListViewRepository.getCategoryBoardListView(selectedCategoryList, order);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetLatestBoardListResponseDto.success(boardListViewEntities);
    }

    @Override
    public ResponseEntity<? super GetPopularityBoardListResponseDto> getPopularityBoardList(PostCategoryRequestDto dto) {
        
        List<Integer> selectedCategoryList = dto.getSelectedCategoryList();
        List<BoardListViewEntity> boardListViewEntities = new ArrayList<>();
        String order = "favorite_count";

        try {
            if(selectedCategoryList.isEmpty()){
                boardListViewEntities = boardListViewRepository.getBoardListView(order);
            } else{
                boardListViewEntities = boardListViewRepository.getCategoryBoardListView(selectedCategoryList, order);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetPopularityBoardListResponseDto.success(boardListViewEntities);
    }

    @Override
    public ResponseEntity<? super GetMostViewedBoardListResponseDto> getMostViewedBoardList(PostCategoryRequestDto dto) {

        List<Integer> selectedCategoryList = dto.getSelectedCategoryList();
        List<BoardListViewEntity> boardListViewEntities = new ArrayList<>();
        String order = "view_count";
        
        try {
            if(selectedCategoryList.isEmpty()){
                boardListViewEntities = boardListViewRepository.getBoardListView(order);
            } else{
                boardListViewEntities = boardListViewRepository.getCategoryBoardListView(selectedCategoryList, order);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetMostViewedBoardListResponseDto.success(boardListViewEntities);
    }
    
    @Override
    public ResponseEntity<? super GetSearchBoardListResponseDto> getSearchBoardList(String searchWord, String preSearchWord) {

        List<BoardListViewEntity> boardListViewEntities = new ArrayList<>();

        try {
            boardListViewEntities = boardListViewRepository.findByTitleContainsOrContentContainsOrderByWriteDatetimeDesc(searchWord, searchWord);
            
            SearchLogEntity searchLogEntity = new SearchLogEntity(searchWord, preSearchWord, false);
            searchLogRepository.save(searchLogEntity);

            boolean relation = preSearchWord != null;
            if(relation){
                searchLogEntity = new SearchLogEntity(preSearchWord, searchWord, relation);
                searchLogRepository.save(searchLogEntity);
            }
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetSearchBoardListResponseDto.success(boardListViewEntities);
    }

    @Override
    public ResponseEntity<? super GetUserBoardListResponseDto> getUserBoardList(String email) {

        List<BoardListViewEntity> boardListViewEntities = new ArrayList<>();
        
        
        try {
            boolean existedUser = userRespository.existsByEmail(email);
            if(!existedUser) return GetUserBoardListResponseDto.noExistUser();
            
            boardListViewEntities = boardListViewRepository.findByWriterEmailDistinctBoardNumber(email);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetUserBoardListResponseDto.success(boardListViewEntities);
    }


    @Override
    public ResponseEntity<? super PostBoardResonseDto> postBoard(PostBoardRequestDto dto, String email) {
        
        try {
            
            boolean existedEmail = userRespository.existsByEmail(email);
            if(!existedEmail) return PostBoardResonseDto.noExistUser();

            BoardEntity boardEntity = new BoardEntity(dto, email);
            boardRepository.save(boardEntity);

            int boardNumber = boardEntity.getBoardNumber();

            List<String> boardImageList = dto.getBoardImageList();
            List<ImageEntity> imageEntities = new ArrayList<>();

            for(String image: boardImageList){
                ImageEntity imageEntity = new ImageEntity(boardNumber, image);
                imageEntities.add(imageEntity);

            }

            imageRepository.saveAll(imageEntities);

            List<String> boardVideoList = dto.getBoardVideoList();
            List<VideoEntity> videoEntities = new ArrayList<>();

            for(String video: boardVideoList){
                VideoEntity videoEntity = new VideoEntity(boardNumber, video);
                videoEntities.add(videoEntity);
            }

            videoRepository.saveAll(videoEntities);

            List<Integer> selectedCategoryList = dto.getSelectedCategoryList();
            List<BoardCategoryEntity> boardCategoryEntities = new ArrayList<>();

            if (selectedCategoryList.isEmpty()) {
                selectedCategoryList.add(1);
            }
            
            for(Integer categoryNumber: selectedCategoryList){
                BoardCategoryEntity boardCategoryEntity = new BoardCategoryEntity(boardNumber, categoryNumber);
                boardCategoryEntities.add(boardCategoryEntity);
            }

            boardCategoryRepository.saveAll(boardCategoryEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PostBoardResonseDto.success();
    }

    @Override
    public ResponseEntity<? super PostCommentResponseDto> postComment(PostCommentRequestDto dto, Integer boardNumber, String email) {
        
        try {

            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            if(boardEntity == null) return PostCommentResponseDto.noExistBoard();

            boolean existedUser = userRespository.existsByEmail(email);
            if(!existedUser) return PostCommentResponseDto.noExistUser();

            CommentEntity commentEntity = new CommentEntity(dto, boardNumber, email);
            commentRepository.save(commentEntity);

            boardEntity.increaseCommentCount();
            boardRepository.save(boardEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PostCommentResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PutFavoriteResponseDto> putFavorite(Integer boardNumber, String email) {
        try {

            boolean existedUser = userRespository.existsByEmail(email);
            if(!existedUser) return PutFavoriteResponseDto.noExistUser();

            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            if(boardEntity == null) return PutFavoriteResponseDto.noExistBoard();
            
            FavoriteEntity favoriteEntity = favoriteRepository.findByBoardNumberAndUserEmail(boardNumber, email);
            if(favoriteEntity == null){
                favoriteEntity = new FavoriteEntity(email, boardNumber);
                favoriteRepository.save(favoriteEntity);
                boardEntity.increaseFavoriteCount();
            }
            else{
                favoriteRepository.delete(favoriteEntity);
                boardEntity.decreaseFavoriteCount();
            }

            boardRepository.save(boardEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        
        return PutFavoriteResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PatchBoardResponseDto> patchBoard(PatchBoardRequestDto dto, Integer boardNumber, String email) {
        
        try {
            
            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            if(boardEntity == null) return PatchBoardResponseDto.noExistBoard();

            boolean existedUser = userRespository.existsByEmail(email);
            if(!existedUser) return PatchBoardResponseDto.noExistUser();

            String writerEmail = boardEntity.getWriterEmail();
            boolean isWriter = writerEmail.equals(email);
            if(!isWriter) return PatchBoardResponseDto.noPermission();

            boardEntity.patchBoard(dto);
            boardRepository.save(boardEntity);

            imageRepository.deleteByBoardNumber(boardNumber);
            List<String> boardImageList = dto.getBoardImageList();
            List<ImageEntity> imageEntities = new ArrayList<>();

            for(String image: boardImageList){
                ImageEntity imageEntity = new ImageEntity(boardNumber, 0, image);
                imageEntities.add(imageEntity);
            }
            imageRepository.saveAll(imageEntities);

            videoRepository.deleteByBoardNumber(boardNumber);
            List<String> boardVideoList = dto.getBoardVideoList();
            List<VideoEntity> videoEntities = new ArrayList<>();

            for(String video: boardVideoList){
                VideoEntity videoEntity = new VideoEntity(boardNumber, video);
                videoEntities.add(videoEntity);
            }
            videoRepository.saveAll(videoEntities);

            boardCategoryRepository.deleteByBoardNumber(boardNumber);
            List<Integer> selectedCategoryList = dto.getSelectedCategoryList();
            List<BoardCategoryEntity> boardCategoryEntities = new ArrayList<>();

            if (selectedCategoryList.isEmpty()) {
                selectedCategoryList.add(1);
            }
            
            for(Integer categoryNumber: selectedCategoryList){
                BoardCategoryEntity boardCategoryEntity = new BoardCategoryEntity(boardNumber, categoryNumber);
                boardCategoryEntities.add(boardCategoryEntity);
            }

            boardCategoryRepository.saveAll(boardCategoryEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PatchBoardResponseDto.success();
    }

    @Override
    public ResponseEntity<? super IncreaseViewCountResponseDto> increaseViewCount(Integer boardNumber) {
        try {
            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            if(boardEntity == null) return IncreaseViewCountResponseDto.noExistBoard();
            boardEntity.increaseViewCount();
            boardRepository.save(boardEntity);
            
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return IncreaseViewCountResponseDto.success();
    }

    @Override
    public ResponseEntity<? super DeleteBoardResponseDto> deleteBoard(Integer boardNumber, String email) {
        
        try {

            boolean existedUser = userRespository.existsByEmail(email);
            if(!existedUser) return DeleteBoardResponseDto.noExistUser();

            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            if(boardEntity == null) return DeleteBoardResponseDto.noExistBoard();

            String writerEmail = boardEntity.getWriterEmail();
            boolean isWriter = writerEmail.equals(email);
            if(!isWriter) return DeleteBoardResponseDto.noPermission();

            imageRepository.deleteByBoardNumber(boardNumber);
            videoRepository.deleteByBoardNumber(boardNumber);
            commentRepository.deleteByBoardNumber(boardNumber);
            favoriteRepository.deleteByBoardNumber(boardNumber);
            boardCategoryRepository.deleteByBoardNumber(boardNumber);

            boardRepository.delete(boardEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return DeleteBoardResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetUserBoardCategoryResponseDto> getUserBoardCategoryList(String email) {
        List<GetUserBoardCategoryResultSet> resultSets = new ArrayList<>();

        try {            
            resultSets = boardListViewRepository.getCategoryBoardCountForUser(email);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        
        return GetUserBoardCategoryResponseDto.success(resultSets);
    }

    

    

    

    

    

    

    

    

    

    

    
    
}
