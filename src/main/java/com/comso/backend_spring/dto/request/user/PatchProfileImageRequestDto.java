package com.comso.backend_spring.dto.request.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatchProfileImageRequestDto {
    
    private String profileImage;
}
