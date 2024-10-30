package com.comso.backend_spring.repository.resultSet;

public interface GetPostResultSet {
    Integer getPostNumber();
    String getTitle();
    String getContent();
    String getWriteDatetime();
    String getWriterEmail();
    String getWriterNickname();
    String getWriterProfileImage();
}
