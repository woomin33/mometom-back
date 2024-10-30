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
@Entity(name = "post_list_view")
@Table(name = "post_list_view")
public class PostListViewEntity {
    
    @Id
    private int postNumber;      
    private String title;
    private String content;
    private int viewCount;
    private int commentCount;
    private String writeDatetime;
    private String writerEmail;
    private String writerNickname;
    private String writerProfileImage;
}
