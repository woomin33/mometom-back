package com.comso.backend_spring.entity;

import java.util.Date;

import com.comso.backend_spring.dto.request.notice.PostNoticeRequestDto;

import java.time.Instant;
import java.text.SimpleDateFormat;

import jakarta.persistence.Column;
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
@Entity(name="notice")
@Table(name="notice")
public class NoticeEntity {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noticeNumber;
    private String title;
    private Date endDate;
    private String employmentForm;
    private String wage;
    private String career;
    private String recruitNumber;
    private String task;
    @Column(name = "`condition`")
    private String condition;
    private String preference;
    private String etc;
    private String registrationDate;
    private String registerEmail;
    private int corporationNumber;
    private int categoryNumber;
  

    public NoticeEntity(int corporationNumber, PostNoticeRequestDto dto, String email){

        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String registrationDate = simpleDateFormat.format(now);

        this.title = dto.getTitle();
        this.endDate = dto.getEndDate();
        this.employmentForm = dto.getEmploymentForm();
        this.wage = dto.getWage();
        this.career = dto.getCareer();
        this.recruitNumber = dto.getRecruitNumber();
        this.task = dto.getTask();
        this.condition = dto.getCondition();
        this.preference = dto.getPreference();
        this.etc = dto.getEtc();
        this.registrationDate = registrationDate;
        this.registerEmail = email;
        this.corporationNumber = corporationNumber;
        this.categoryNumber = dto.getSelectedDevCategory();
        
    }

}
