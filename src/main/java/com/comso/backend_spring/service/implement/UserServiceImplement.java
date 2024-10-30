package com.comso.backend_spring.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.comso.backend_spring.dto.request.user.PatchProfileImageRequestDto;
import com.comso.backend_spring.dto.request.user.PatchUserRequestDto;
import com.comso.backend_spring.dto.response.ResponseDto;
import com.comso.backend_spring.dto.response.user.GetSignInUserResponseDto;
import com.comso.backend_spring.dto.response.user.GetUserResponseDto;
import com.comso.backend_spring.dto.response.user.PatchProfileImageResponseDto;
import com.comso.backend_spring.dto.response.user.PatchUserResponseDto;
import com.comso.backend_spring.entity.UserEntity;
import com.comso.backend_spring.repository.UserRespository;
import com.comso.backend_spring.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService{
    
    private final UserRespository userRespository;

    @Override
    public ResponseEntity<? super GetUserResponseDto> getUser(String email) {
        
        UserEntity userEntity = null;

        try {

            userEntity = userRespository.findByEmail(email);
            if(userEntity == null) return GetUserResponseDto.noExistUser();
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetUserResponseDto.success(userEntity);
    }

    @Override
    public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email) {

        UserEntity userEntity = null;

        try {

            userEntity = userRespository.findByEmail(email);
            if (userEntity == null) return GetSignInUserResponseDto.notExistUser();
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetSignInUserResponseDto.success(userEntity);
    }

    @Override
    public ResponseEntity<? super PatchUserResponseDto> patchUser(PatchUserRequestDto dto, String email) {

        try {
            
            UserEntity userEntity = userRespository.findByEmail(email);
            if(userEntity == null) return PatchUserResponseDto.noExistUser();

            String nickname = dto.getNickname();
            boolean existedUser = userRespository.existsByNickname(nickname);
            if(existedUser) return PatchUserResponseDto.duplicateUser();

            userEntity.setNickname(nickname);
            userRespository.save(userEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PatchUserResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PatchProfileImageResponseDto> patchProfileImage(PatchProfileImageRequestDto dto, String email) {
        try {
            
            UserEntity userEntity = userRespository.findByEmail(email);
            if(userEntity == null) return PatchProfileImageResponseDto.noExistUser();

            String profileImage = dto.getProfileImage();
            userEntity.setProfileImage(profileImage);
            userRespository.save(userEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PatchProfileImageResponseDto.success();
    }

    
    
}
