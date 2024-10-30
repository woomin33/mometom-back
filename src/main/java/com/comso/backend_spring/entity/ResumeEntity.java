package com.comso.backend_spring.entity;


import com.comso.backend_spring.dto.request.resume.PostResumeRequestDto;

import java.util.Date;
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
@Entity(name="resume")
@Table(name="resume")
public class ResumeEntity {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String writerEmail;
    private String writeDatetime;
    
    public ResumeEntity(PostResumeRequestDto dto, String email){

        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String writeDatetime = simpleDateFormat.format(now);

        this.title = dto.getTitle();
        this.name = dto.getName();
        this.contactNumber = dto.getContactNumber();
        this.mail = dto.getMail();
        this.introduce = dto.getIntroduce();
        this.workExperience = dto.getWorkExperience();
        this.project = dto.getProject();
        this.otherDetail = dto.getOtherDetail();
        this.image = dto.getImage();
        this.writerEmail = email;
        this.writeDatetime = writeDatetime;
    }

    
}
