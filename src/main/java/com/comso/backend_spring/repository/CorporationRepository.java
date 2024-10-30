package com.comso.backend_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.comso.backend_spring.entity.CorporationEntity;
import com.comso.backend_spring.repository.resultSet.GetCorporationResultSet;

@Repository
public interface CorporationRepository extends JpaRepository<CorporationEntity, Integer>{
    
    boolean existsByCorporationNumber(Integer corporationNumber);
    
    CorporationEntity findByCorporationNumber(Integer corporationNumber);


    @Query(
        value = 
        "SELECT " +
        "C.corporation_number AS corporationNumber, " +
        "C.name AS name, " +
        "C.introduction AS introduction, " +
        "C.content AS content, " +
        "C.registration_datetime AS registrationDatetime, " +
        "C.register_email AS registerEmail, " +
        "C.address AS address, " +
        "C.address_detail AS addressDetail, " +
        "C.latitude AS latitude, " +
        "C.longitude AS longitude, " +
        "C.welfare AS welfare, " +
        "C.business_license AS businessLicense, " +
        "C.contact_number AS contactNumber, " +
        "C.approval As approval " +
        "FROM corporation AS C " +
        "WHERE corporation_number = ?1 ",
        nativeQuery = true
    )
    GetCorporationResultSet getCorporation(Integer corporationNumber);

    @Query(
        value = 
        "SELECT " +
        "C.corporation_number AS corporationNumber, " +
        "C.name AS name, " +
        "C.introduction AS introduction, " +
        "C.content AS content, " +
        "C.registration_datetime AS registrationDatetime, " +
        "C.register_email AS registerEmail, " +
        "C.address AS address, " +
        "C.address_detail AS addressDetail, " +
        "C.latitude AS latitude, " +
        "C.longitude AS longitude, " +
        "C.welfare AS welfare, " +
        "C.business_license AS businessLicense, " +
        "C.contact_number AS contactNumber, " +
        "C.approval As approval " +
        "FROM corporation AS C " +
        "WHERE register_email = ?1 ",
        nativeQuery = true
    )
    GetCorporationResultSet getUserCorporation(String email);
}
