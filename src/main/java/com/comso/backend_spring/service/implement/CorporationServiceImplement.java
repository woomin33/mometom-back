package com.comso.backend_spring.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.comso.backend_spring.dto.request.corporation.PostCorporationRequestDto;
import com.comso.backend_spring.dto.response.ResponseDto;
import com.comso.backend_spring.dto.response.corporation.GetCorporationResponseDto;
import com.comso.backend_spring.dto.response.corporation.GetCorporationListResponseDto;
import com.comso.backend_spring.dto.response.corporation.PostCorporationResponseDto;
import com.comso.backend_spring.entity.CorporationEntity;
import com.comso.backend_spring.entity.CorporationImageEntity;
import com.comso.backend_spring.entity.CorporationListViewEntity;
import com.comso.backend_spring.repository.CorporationImageRepository;
import com.comso.backend_spring.repository.CorporationListViewRepository;
import com.comso.backend_spring.repository.CorporationRepository;
import com.comso.backend_spring.repository.UserRespository;
import com.comso.backend_spring.repository.resultSet.GetCorporationResultSet;
import com.comso.backend_spring.service.CorporatonService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CorporationServiceImplement implements CorporatonService{
    
    private final UserRespository userRespository;
    private final CorporationRepository corporationRepository;
    private final CorporationImageRepository corporationImageRepository;
    private final CorporationListViewRepository corporationListViewRepository;


    @Override
    public ResponseEntity<? super GetCorporationResponseDto> getCorporation(Integer corporationNumber) {

        GetCorporationResultSet resultSet = null;
        List<CorporationImageEntity> corporationImageEntities = new ArrayList<>();
        
        try {
            resultSet = corporationRepository.getCorporation(corporationNumber);
            if(resultSet == null) return GetCorporationResponseDto.noExistCorporation();

            corporationImageEntities = corporationImageRepository.findByCorporationNumber(corporationNumber);
        

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetCorporationResponseDto.success(resultSet, corporationImageEntities);
    }

    @Override
    public ResponseEntity<? super GetCorporationResponseDto> getUserCorporation(String email) {
        GetCorporationResultSet resultSet = null;
        List<CorporationImageEntity> corporationImageEntities = new ArrayList<>();
        
        try {
            resultSet = corporationRepository.getUserCorporation(email);
            if(resultSet == null) return GetCorporationResponseDto.noExistCorporation();

            corporationImageEntities = corporationImageRepository.findByCorporationNumber(resultSet.getCorporationNumber());

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetCorporationResponseDto.success(resultSet, corporationImageEntities);
    }

    @Override
    public ResponseEntity<? super GetCorporationListResponseDto> getCorporationList() {
        
        List<CorporationListViewEntity> corporationListViewEntities = new ArrayList<>();

        try { 
            corporationListViewEntities = corporationListViewRepository.findAll();
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetCorporationListResponseDto.success(corporationListViewEntities);
    }

    @Override
    public ResponseEntity<? super PostCorporationResponseDto> postCorporation(PostCorporationRequestDto dto, String email) {
        
        try {
            boolean existedEmail = userRespository.existsByEmail(email);
            if(!existedEmail) return PostCorporationResponseDto.noExistUser();
            
            CorporationEntity corporationEntity = new CorporationEntity(dto, email);
            corporationRepository.save(corporationEntity);

            int corporationNumber = corporationEntity.getCorporationNumber();

            List<String> corporationImageList = dto.getCorporationImageList();
            List<CorporationImageEntity> corporationImageEntities = new ArrayList<>();

            for(String image: corporationImageList){
                CorporationImageEntity corporationImageEntity = new CorporationImageEntity(corporationNumber, image);
                corporationImageEntities.add(corporationImageEntity);

            }

            corporationImageRepository.saveAll(corporationImageEntities);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();

        }

        return PostCorporationResponseDto.success();
    }

   

    

    


}
