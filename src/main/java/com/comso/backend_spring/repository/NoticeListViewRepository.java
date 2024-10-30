package com.comso.backend_spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.comso.backend_spring.entity.NoticeListViewEntity;

@Repository
public interface NoticeListViewRepository extends JpaRepository<NoticeListViewEntity, Integer> {
    
    List<NoticeListViewEntity> findByDevCategoryNumber(Integer devCategoryNumber);
    List<NoticeListViewEntity> findTop5ByRegistrationDateGreaterThanOrderByApplicantCountDescRegistrationDateDesc(String registrationDate);

    @Query(
        value = 
        "SELECT * FROM notice_list_view " +
        "WHERE dev_category_name = ?2 AND notice_number <> ?1 " +
        "ORDER BY RAND() " +
        "LIMIT 5 ",
        nativeQuery = true
    )
    List<NoticeListViewEntity> findRandomNoticesByCategoryExcludingNotice(Integer noticeNumber, String devCategoryName);
}
