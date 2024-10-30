package com.comso.backend_spring.dto.object;

import java.util.ArrayList;
import java.util.List;

import com.comso.backend_spring.entity.CorporationListViewEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CorporationListItem {
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

    public CorporationListItem(CorporationListViewEntity corporationListViewEntity){
        this.corporationNumber = corporationListViewEntity.getCorporationNumber();
        this.name = corporationListViewEntity.getName();
        this.introduction = corporationListViewEntity.getIntroduction();
        this.address = corporationListViewEntity.getAddress();
        this.addressDetail = corporationListViewEntity.getAddressDetail();
        this.latitude = corporationListViewEntity.getLatitude();
        this.longitude = corporationListViewEntity.getLongitude();
        this.noticeNumber = corporationListViewEntity.getNoticeNumber();
        this.categoryNumber = corporationListViewEntity.getCategoryNumber();
        this.firstImage = corporationListViewEntity.getFirstImage();
        this.endDate = corporationListViewEntity.getEndDate();
        this.approval = corporationListViewEntity.getApproval();

    }

    public static List<CorporationListItem> getList(List<CorporationListViewEntity> corporationListViewEntities){
        List<CorporationListItem> list = new ArrayList<>();
        for(CorporationListViewEntity corporationListViewEntity: corporationListViewEntities){
            CorporationListItem corporationListItem = new CorporationListItem(corporationListViewEntity);
            list.add(corporationListItem);
        }
        return list;
    }
}
