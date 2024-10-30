package com.comso.backend_spring.service.implement;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.comso.backend_spring.dto.request.resume.PostResumeRequestDto;
import com.comso.backend_spring.dto.response.ResponseDto;
import com.comso.backend_spring.dto.response.board.PostBoardResonseDto;
import com.comso.backend_spring.dto.response.resume.GetUserResumeListResponseDto;
import com.comso.backend_spring.dto.response.resume.PostResumeResponseDto;
import com.comso.backend_spring.entity.ResumeEntity;
import com.comso.backend_spring.entity.ResumeListViewEntity;
import com.comso.backend_spring.entity.ResumeTechniqueEntity;
import com.comso.backend_spring.repository.ResumeListViewRepository;
import com.comso.backend_spring.repository.ResumeRepository;
import com.comso.backend_spring.repository.ResumeTechniqueRepository;
import com.comso.backend_spring.repository.UserRespository;
import com.comso.backend_spring.service.ResumeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ResumeServiceImplement implements ResumeService{

    private final ResumeRepository resumeRepository;
    private final UserRespository userRespository;
    private final ResumeTechniqueRepository resumeTechniqueRepository;
    private final ResumeListViewRepository resumeListViewRepository;
    

    @Override
    public ResponseEntity<? super GetUserResumeListResponseDto> getUserResumeList(String email) {
        List<ResumeListViewEntity> resumeListViewEntities = new ArrayList<>();
        
        
        try {
            boolean existedUser = userRespository.existsByEmail(email);
            if(!existedUser) return GetUserResumeListResponseDto.noExistUser();
            
            resumeListViewEntities = resumeListViewRepository.findByWriterEmailOrderByWriteDatetimeDesc(email);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetUserResumeListResponseDto.success(resumeListViewEntities);
    }
    
    @Override
    public ResponseEntity<? super PostResumeResponseDto> postResume(PostResumeRequestDto dto, String email) {
         try {
            
            boolean existedEmail = userRespository.existsByEmail(email);
            if(!existedEmail) return PostBoardResonseDto.noExistUser();

            ResumeEntity resumeEntity = new ResumeEntity(dto, email);
            resumeRepository.save(resumeEntity);

            int resumeNumber = resumeEntity.getResumeNumber();
        
            List<Integer> techStackList = dto.getSelectedTechStack();
            List<ResumeTechniqueEntity> resumeTechniqueEntities = new ArrayList<>();

            if (techStackList != null) {
                for(Integer techniqueNumber: techStackList){
                    ResumeTechniqueEntity resumeTechniqueEntity = new ResumeTechniqueEntity(resumeNumber, techniqueNumber);
                    resumeTechniqueEntities.add(resumeTechniqueEntity);
                }
            }

            resumeTechniqueRepository.saveAll(resumeTechniqueEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PostResumeResponseDto.success();
    }


    
    

    
    
}
