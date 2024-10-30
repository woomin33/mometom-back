package com.comso.backend_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.comso.backend_spring.entity.NoticeEntity;
import com.comso.backend_spring.repository.resultSet.GetNoticeResultSet;


@Repository
public interface NoticeRepository extends JpaRepository<NoticeEntity, Integer> {
    
    boolean existsByNoticeNumber(Integer noticeNumber);
    
    NoticeEntity findByNoticeNumber(Integer noticeNumber);

    @Query(
        value = 
        "SELECT " +
        "N.notice_number AS noticeNumber, " +
        "N.title AS title, " +
        "N.employment_form AS employmentForm, " +
        "N.wage AS wage, " +
        "N.career AS career, " +
        "N.recruit_number AS recruitNumber, " +
        "N.task AS task, " +
        "N.condition AS `condition`, " +
        "N.preference AS preference, " +
        "N.etc AS etc, " +
        "N.corporation_number AS corporationNumber, " +
        "C.name AS corporationName, " +
        "C.introduction AS introduction, " +
        "C.welfare AS welfare, " +
        "C.address AS address, " +
        "C.address_detail AS addressDetail, " +
        "C.contact_number AS contactNumber, " +
        "D.category_name AS categoryName " +
        "FROM notice AS N " +
        "INNER JOIN corporation AS C " +
        "ON N.corporation_number = C.corporation_number " +
        "INNER JOIN dev_category AS D ON N.category_number = D.category_number " +
        "WHERE N.notice_number = ?1 ",
        nativeQuery = true
    )
    GetNoticeResultSet getNotice(Integer noticeNumber);

}
