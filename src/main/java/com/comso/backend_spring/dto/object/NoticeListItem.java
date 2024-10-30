package com.comso.backend_spring.dto.object;

import java.util.ArrayList;
import java.util.List;

import com.comso.backend_spring.entity.NoticeListViewEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NoticeListItem {
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

    public NoticeListItem(NoticeListViewEntity noticeListViewEntity){
        
        this.noticeNumber = noticeListViewEntity.getNoticeNumber();
        this.title = noticeListViewEntity.getTitle();
        this.endDate = noticeListViewEntity.getEndDate();
        this.registrationDate = noticeListViewEntity.getRegistrationDate();
        this.applicantCount = noticeListViewEntity.getApplicantCount();
        this.corporationNumber = noticeListViewEntity.getCorporationNumber();
        this.devCategoryNumber = noticeListViewEntity.getDevCategoryNumber();
        this.devCategoryName = noticeListViewEntity.getDevCategoryName();
        this.corporationName = noticeListViewEntity.getCorporationName();
        this.corporationImage = noticeListViewEntity.getCorporationImage();
        this.techniques = noticeListViewEntity.getTechniques();
    }

    public static List<NoticeListItem> getList(List<NoticeListViewEntity> noticeListViewEntities){
        List<NoticeListItem> list = new ArrayList<>();
        for(NoticeListViewEntity noticeListViewEntity: noticeListViewEntities){
            NoticeListItem noticeListItem = new NoticeListItem(noticeListViewEntity);
            list.add(noticeListItem);
        }
        return list;
    }
}
