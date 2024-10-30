package com.comso.backend_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.comso.backend_spring.entity.BoardEntity;
import com.comso.backend_spring.entity.PostEntity;
import com.comso.backend_spring.repository.resultSet.GetPostResultSet;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Integer> {
    
    boolean existsByPostNumber(Integer postNumber);
    
    BoardEntity findByPostNumber(Integer postNumber);

    @Query(
        value = 
        "SELECT " +
        "P.post_number AS postNumber, " +
        "P.title AS title, " +
        "P.content AS content, " +
        "P.write_datetime AS writeDatetime, " +
        "P.writer_email AS writerEmail, " +
        "U.nickname AS writerNickname, " +
        "U.profile_image AS writerProfileImage " +
        "FROM post AS P " +
        "INNER JOIN user AS U " +
        "ON P.writer_email = U.email " +
        "WHERE post_number = ?1 ",
        nativeQuery = true
    )
    GetPostResultSet getPost(Integer postNumber);
}
