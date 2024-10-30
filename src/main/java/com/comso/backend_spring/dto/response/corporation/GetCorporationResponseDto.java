package com.comso.backend_spring.dto.response.corporation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.comso.backend_spring.common.ResponseCode;
import com.comso.backend_spring.common.ResponseMessage;
import com.comso.backend_spring.dto.response.ResponseDto;
import com.comso.backend_spring.entity.CorporationImageEntity;
import com.comso.backend_spring.repository.resultSet.GetCorporationResultSet;

import lombok.Getter;

@Getter
public class GetCorporationResponseDto extends ResponseDto{
    private int corporationNumber;
    private String name;
    private String introduction;
    private String content;
    private String registrationDatetime;
    private String registerEmail;   
    private String address;
    private String addressDetail;
    private Double latitude;
    private Double longitude;
    private String welfare;
    private String businessLicense;
    private String contactNumber;
    private Byte approval;
    private List<String> corporationImageList;

    

    private GetCorporationResponseDto(GetCorporationResultSet resultSet, List<CorporationImageEntity> corporationImageEntities){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);

        List<String> corporationImageList = new ArrayList<>();
        for(CorporationImageEntity corporationImageEntity: corporationImageEntities){
            String corporationImage = corporationImageEntity.getImage();
            corporationImageList.add(corporationImage);
        }
        
        this.corporationNumber = resultSet.getCorporationNumber();
        this.name = resultSet.getName();
        this.introduction = resultSet.getIntroduction();
        this.content = resultSet.getContent();
        this.registrationDatetime = resultSet.getRegistrationDatetime();
        this.registerEmail = resultSet.getRegisterEmail();
        this.address = resultSet.getAddress();
        this.addressDetail = resultSet.getAddressDetail();
        this.latitude = resultSet.getLatitude();
        this.longitude = resultSet.getLongitude();
        this.welfare = resultSet.getWelfare();
        this.businessLicense = resultSet.getBusinessLicense();
        this.contactNumber = resultSet.getContactNumber();
        this.approval = resultSet.getApproval();
        this.corporationImageList = corporationImageList;
    }

    public static ResponseEntity<GetCorporationResponseDto> success(GetCorporationResultSet resultSet, List<CorporationImageEntity> corporationImageEntities){
        GetCorporationResponseDto result = new GetCorporationResponseDto(resultSet, corporationImageEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


    public static ResponseEntity<ResponseDto> noExistCorporation(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_CORPORATION, ResponseMessage.NOT_EXISTED_CORPORATION);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    

}
