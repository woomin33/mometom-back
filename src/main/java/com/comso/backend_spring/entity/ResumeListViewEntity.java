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
@Entity(name = "resume_list_view")
@Table(name = "resume_list_view")
public class ResumeListViewEntity {
    @Id
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
}
