package com.comso.backend_spring.dto.object;

import java.util.ArrayList;
import java.util.List;

import com.comso.backend_spring.entity.ResumeListViewEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResumeListItem {
    private int resumeNumber;
    private String title;
    private String name;
    private String contactNumber;
    private String mail;
    private String introduce;
    private String workExperience;
    private String project;
    private String otherDetail;
    private String image;
    private String writeDatetime;
    private String writerEmail;
    private String techniques;

    public ResumeListItem(ResumeListViewEntity resumeListViewEntity){
        this.resumeNumber = resumeListViewEntity.getResumeNumber();
        this.title = resumeListViewEntity.getTitle();
        this.name = resumeListViewEntity.getName();
        this.contactNumber = resumeListViewEntity.getContactNumber();
        this.mail = resumeListViewEntity.getMail();
        this.introduce = resumeListViewEntity.getIntroduce();
        this.workExperience = resumeListViewEntity.getWorkExperience();
        this.project = resumeListViewEntity.getProject();
        this.otherDetail = resumeListViewEntity.getOtherDetail();
        this.image = resumeListViewEntity.getImage();
        this.writeDatetime = resumeListViewEntity.getWriteDatetime();
        this.writerEmail = resumeListViewEntity.getWriterEmail();
        this.techniques = resumeListViewEntity.getTechniques();
    }

    public static List<ResumeListItem> getList(List<ResumeListViewEntity> resumeListViewEntities){
        List<ResumeListItem> list = new ArrayList<>();
        for(ResumeListViewEntity resumeListViewEntity: resumeListViewEntities){
            ResumeListItem resumeListItem = new ResumeListItem(resumeListViewEntity);
            list.add(resumeListItem);
        }
        return list;
    }
}
