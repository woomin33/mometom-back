package com.comso.backend_spring.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.comso.backend_spring.dto.request.notice.PostNoticeRequestDto;
import com.comso.backend_spring.dto.response.ResponseDto;
import com.comso.backend_spring.dto.response.notice.GetNoticeListResponseDto;
import com.comso.backend_spring.dto.response.notice.GetNoticeResponseDto;
import com.comso.backend_spring.dto.response.notice.GetTop5NoticeListResponseDto;
import com.comso.backend_spring.dto.response.corporation.PostCorporationResponseDto;
import com.comso.backend_spring.dto.response.notice.PostNoticeResponseDto;
import com.comso.backend_spring.entity.CorporationImageEntity;
import com.comso.backend_spring.entity.NoticeEntity;
import com.comso.backend_spring.entity.NoticeListViewEntity;
import com.comso.backend_spring.entity.NoticeTechniqueEntity;
import com.comso.backend_spring.repository.CorporationImageRepository;
import com.comso.backend_spring.repository.NoticeListViewRepository;
import com.comso.backend_spring.repository.NoticeRepository;
import com.comso.backend_spring.repository.NoticeTechniqueRepository;
import com.comso.backend_spring.repository.UserRespository;
import com.comso.backend_spring.repository.resultSet.GetNoticeResultSet;
import com.comso.backend_spring.service.NoticeService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class NoticeServiceImplement implements NoticeService{
    
    private final NoticeRepository noticeRepository;
    private final NoticeListViewRepository noticeListViewRepository;
    private final NoticeTechniqueRepository noticeTechniqueRepository;
    private final UserRespository userRespository;
    
    private final CorporationImageRepository corporationImageRepository;

    @Override
    public ResponseEntity<? super GetNoticeResponseDto> getNotice(Integer noticeNumber) {
        GetNoticeResultSet resultSet = null;
        List<CorporationImageEntity> corporationImageEntities = new ArrayList<>();
        List<String> techniques = new ArrayList<>();
    
        try {
            resultSet = noticeRepository.getNotice(noticeNumber);
            if(resultSet == null) return GetNoticeResponseDto.noExistBoard();

            Integer corporationNumber = resultSet.getCorporationNumber();
            corporationImageEntities = corporationImageRepository.findByCorporationNumber(corporationNumber);
            techniques = noticeTechniqueRepository.findTechniqueNamesByNoticeNumber(noticeNumber);
            

            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetNoticeResponseDto.success(resultSet, corporationImageEntities, techniques);

    }

    @Override
    public ResponseEntity<? super GetNoticeListResponseDto> getNoticeList(Integer devCategoryNumber) {
        List<NoticeListViewEntity> noticeListViewEntities = new ArrayList<>();
        try {
            if (devCategoryNumber == null) return ResponseDto.databaseError();
            if (devCategoryNumber == 0) {
                noticeListViewEntities = noticeListViewRepository.findAll();
            } else {
                noticeListViewEntities = noticeListViewRepository.findByDevCategoryNumber(devCategoryNumber);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetNoticeListResponseDto.success(noticeListViewEntities);
    }

    @Override
    public ResponseEntity<? super GetNoticeListResponseDto> getDevNoticeList(Integer noticeNumber, String devCategoryName) {
        List<NoticeListViewEntity> noticeListViewEntities = new ArrayList<>();
        try {
            noticeListViewEntities = noticeListViewRepository.findRandomNoticesByCategoryExcludingNotice(noticeNumber, devCategoryName);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        
        return GetNoticeListResponseDto.success(noticeListViewEntities);
    }

    @Override
    public ResponseEntity<? super PostNoticeResponseDto> postNotice(Integer corporationNumber, PostNoticeRequestDto dto,
            String email) {
        try {
            boolean existedEmail = userRespository.existsByEmail(email);
            if(!existedEmail) return PostCorporationResponseDto.noExistUser();
                    
            NoticeEntity noticeEntity = new NoticeEntity(corporationNumber, dto, email);
            noticeRepository.save(noticeEntity);

            int noticeNumber = noticeEntity.getNoticeNumber();
        
            List<Integer> techStackList = dto.getSelectedTechStack();
            List<NoticeTechniqueEntity> noticeTechniqueEntities = new ArrayList<>();

            if (techStackList != null) {
                for(Integer techniqueNumber: techStackList){
                    NoticeTechniqueEntity noticeTechniqueEntity = new NoticeTechniqueEntity(noticeNumber, techniqueNumber);
                    noticeTechniqueEntities.add(noticeTechniqueEntity);
                }
            }

            noticeTechniqueRepository.saveAll(noticeTechniqueEntities);
                    
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        
        }
        
        return PostNoticeResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetTop5NoticeListResponseDto> getTop5NoticeList() {

        List<NoticeListViewEntity> noticeListViewEntities = new ArrayList<>();
        try {
            Date beforeWeek = Date.from(Instant.now().minus(7, ChronoUnit.DAYS));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String sevenDaysAgo = simpleDateFormat.format(beforeWeek);
            noticeListViewEntities = noticeListViewRepository.findTop5ByRegistrationDateGreaterThanOrderByApplicantCountDescRegistrationDateDesc(sevenDaysAgo);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetTop5NoticeListResponseDto.success(noticeListViewEntities);


    }

    

    



    
}