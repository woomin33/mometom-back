package com.comso.backend_spring.dto.request.corporation;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostCorporationRequestDto {
    
    @NotBlank
    private String name;
    @NotBlank
    private String introduction;
    private String content;
    @NotBlank
    private String address;
    @NotBlank
    private String addressDetail;
    @NotNull
    private double latitude;
    @NotNull
    private double longitude;
    private String welfare;
    @NotNull
    private String businessLicense;
    @NotBlank
    private String contactNumber;
    @NotNull
    private List<String> corporationImageList;
    
    
}
