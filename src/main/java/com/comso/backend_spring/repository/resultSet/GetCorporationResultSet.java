package com.comso.backend_spring.repository.resultSet;

public interface GetCorporationResultSet {
    Integer getCorporationNumber();
    String getName();
    String getIntroduction();
    String getContent();
    String getRegistrationDatetime();
    String getRegisterEmail();
    String getAddress();
    String getAddressDetail();
    Double getLatitude();
    Double getLongitude();
    String getWelfare();
    String getBusinessLicense();
    String getContactNumber();
    Byte getApproval();
}
