package com.comso.backend_spring.entity;

import java.util.Date;

import com.comso.backend_spring.dto.request.corporation.PostCorporationRequestDto;

import java.time.Instant;
import java.text.SimpleDateFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="corporation")
@Table(name="corporation")
public class CorporationEntity {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int corporationNumber;
    private String name;
    private String introduction;
    private String content;
    private String registrationDatetime;
    private String registerEmail;
    private String address;
    private String addressDetail;
    private double latitude;
    private double longitude;
    private String welfare;
    private String businessLicense;
    private String contactNumber;
    private Byte approval;
  

    public CorporationEntity(PostCorporationRequestDto dto, String email){

        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String registrationDatetime = simpleDateFormat.format(now);

        this.name = dto.getName();
        this.introduction = dto.getIntroduction();
        this.content = dto.getContent();
        this.registrationDatetime = registrationDatetime;
        this.registerEmail = email;
        this.address = dto.getAddress();
        this.addressDetail = dto.getAddressDetail();
        this.latitude = dto.getLatitude();
        this.longitude = dto.getLongitude();
        this.welfare = dto.getWelfare();
        this.businessLicense = dto.getBusinessLicense();
        this.contactNumber = dto.getContactNumber();
        this.approval = 0;
    }

}
