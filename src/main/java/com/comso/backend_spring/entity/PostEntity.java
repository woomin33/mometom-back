package com.comso.backend_spring.entity;

import com.comso.backend_spring.dto.request.post.PostPostRequestDto;
import com.comso.backend_spring.dto.request.board.PatchBoardRequestDto;

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
@Entity(name="post")
@Table(name="post")
public class PostEntity {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postNumber;
    private String title;
    private String content;
    private String writeDatetime;
    private int commentCount;
    private int viewCount;
    private String writerEmail;
    
    public PostEntity(PostPostRequestDto dto, String email){

        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String writeDatetime = simpleDateFormat.format(now);

        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.writeDatetime = writeDatetime;
        this.commentCount = 0;
        this.viewCount = 0;
        this.writerEmail = email;
    }

    public void increaseViewCount(){
        this.viewCount++;
    }


    public void increaseCommentCount(){
        this.commentCount++;
    }
    
    public void patchBoard(PatchBoardRequestDto dto){
        this.title = dto.getTitle();
        this.content = dto.getContent();
    }
}
