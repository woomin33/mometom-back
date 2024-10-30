package com.comso.backend_spring.dto.object;

import java.util.ArrayList;
import java.util.List;

import com.comso.backend_spring.entity.PostListViewEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostListItem {
    private int postNumber;
    private String title;
    private String content;
    private int commentCount;
    private int viewCount;
    private String writeDatetime;
    private String writeEmail;
    private String writerNickname;
    private String writerProfileImage;

    public PostListItem(PostListViewEntity postListViewEntity){
        this.postNumber = postListViewEntity.getPostNumber();
        this.title = postListViewEntity.getTitle();
        this.content = postListViewEntity.getContent();
        this.commentCount = postListViewEntity.getCommentCount();
        this.viewCount = postListViewEntity.getViewCount();
        this.writeDatetime = postListViewEntity.getWriteDatetime();
        this.writeEmail = postListViewEntity.getWriterEmail();
        this.writerNickname = postListViewEntity.getWriterNickname();
        this.writerProfileImage = postListViewEntity.getWriterProfileImage();
    }

    public static List<PostListItem> getList(List<PostListViewEntity> postListViewEntities){
        List<PostListItem> list = new ArrayList<>();
        for(PostListViewEntity postListViewEntity: postListViewEntities){
            PostListItem postListItem = new PostListItem(postListViewEntity);
            list.add(postListItem);
        }
        return list;
    }
}
