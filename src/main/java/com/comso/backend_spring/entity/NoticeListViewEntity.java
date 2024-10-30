package com.comso.backend_spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "notice_list_view")
@Table(name = "notice_list_view")
public class NoticeListViewEntity {
    
    @Id
    private int noticeNumber;      
    private String title;
    private String endDate;
    private String registrationDate;
    private int applicantCount;
    private int corporationNumber;
    private int devCategoryNumber;
    private String devCategoryName;
    private String corporationName;
    private String corporationImage;
    private String techniques;
}
