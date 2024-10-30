package com.comso.backend_spring.dto.response.notice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.comso.backend_spring.common.ResponseCode;
import com.comso.backend_spring.common.ResponseMessage;
import com.comso.backend_spring.dto.response.ResponseDto;
import com.comso.backend_spring.entity.CorporationImageEntity;
import com.comso.backend_spring.repository.resultSet.GetNoticeResultSet;

import lombok.Getter;

@Getter
public class GetNoticeResponseDto extends ResponseDto{
    private int noticeNumber;
    private String title;
    private String employmentForm;
    private String wage;
    private String career;
    private String recruitNumber;
    private String task;
    private String condition;
    private String preference;
    private String etc;
    private String corporationName;
    private String introduction;
    private String welfare;
    private String address;
    private String addressDeatil;
    private String contactNumber;
    private String devCategoryName;
    private List<String> corporationImageList;
    private List<String> techniqueList;

    private GetNoticeResponseDto(GetNoticeResultSet resultSet, List<CorporationImageEntity> corporationImageEntities, List<String> techniques){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);

        List<String> corporationImageList = new ArrayList<>();
        for(CorporationImageEntity corporationImageEntity: corporationImageEntities){
            String corporationImage = corporationImageEntity.getImage();
            corporationImageList.add(corporationImage);
        }
        List<String> techniqueList = new ArrayList<>();
        for(String technique: techniques){
            techniqueList.add(technique);
        }
        
        this.noticeNumber = resultSet.getNoticeNumber();
        this.title = resultSet.getTitle();
        this.employmentForm = resultSet.getEmploymentForm();
        this.wage = resultSet.getWage();
        this.career = resultSet.getCareer();
        this.recruitNumber = resultSet.getRecruitNumber();
        this.task = resultSet.getTask();
        this.condition = resultSet.getCondition();
        this.preference = resultSet.getPreference();
        this.etc = resultSet.getEtc();
        this.corporationName = resultSet.getCorporationName();
        this.introduction = resultSet.getIntroduction();
        this.welfare = resultSet.getWelfare();
        this.address = resultSet.getAddress();
        this.addressDeatil = resultSet.getAddressDetail();
        this.contactNumber = resultSet.getContactNumber();
        this.devCategoryName = resultSet.getCategoryName();
        this.corporationImageList = corporationImageList;
        this.techniqueList = techniqueList;
    }

    public static ResponseEntity<GetNoticeResponseDto> success(GetNoticeResultSet resultSet, List<CorporationImageEntity> corporationImageEntities, List<String> techniques){
        GetNoticeResponseDto result = new GetNoticeResponseDto(resultSet, corporationImageEntities, techniques);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> noExistBoard(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_BOARD, ResponseMessage.NOT_EXISTED_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
    

}

