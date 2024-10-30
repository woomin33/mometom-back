package com.comso.backend_spring.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.comso.backend_spring.dto.response.ResponseDto;
import com.comso.backend_spring.dto.response.search.GetPopularListResponseDto;
import com.comso.backend_spring.repository.SearchLogPostRepository;
import com.comso.backend_spring.repository.resultSet.GetPopularListResultSet;
import com.comso.backend_spring.service.SearchService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SearchServiceImplement implements SearchService{
    
    private final SearchLogPostRepository searchLogPostRepository;

    @Override
    public ResponseEntity<? super GetPopularListResponseDto> getPopularList() {

        List<GetPopularListResultSet> resultSets = new ArrayList<>();

        try {
            resultSets = searchLogPostRepository.getPopularList();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetPopularListResponseDto.success(resultSets);
    }
    
}
