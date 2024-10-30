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
@Entity(name = "corporation_list_view")
@Table(name = "corporation_list_view")
public class CorporationListViewEntity {
    
    @Id
    private int corporationNumber;      
    private String name;
    private String introduction;
    private String address;
    private String addressDetail;
    private double latitude;
    private double longitude;
    private int noticeNumber;
    private int categoryNumber;
    private String firstImage;
    private String endDate;
    private int approval;
}
