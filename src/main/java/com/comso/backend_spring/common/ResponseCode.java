package com.comso.backend_spring.common;

public interface ResponseCode {
    
    // HTTP Status 200
    String SUCCESS = "SU";
    // 400
    String VALIDATION_FAILED = "VF";
    String DUPLICATE_EMAIL = "DE";
    String DUPLICATE_NICKNAME = "DN";
    String DUPLICATE_TEL_NUMBER = "DT";
    String NOT_EXISTED_BOARD = "NB";
    String NOT_EXISTED_CORPORATION = "NC";
    String NOT_EXISTED_USER = "NU";

    // 401
    String SIGN_IN_FAIL = "SF";
    String AUTHORIZATION = "AF";

    // 403
    String NO_PERMISSION = "NP";

    //500
    String DATABASE_ERROR = "DBE";



}
