package com.comso.backend_spring.dto.request.resume;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostResumeRequestDto {
    
    @NotBlank
    private String title;
    @NotBlank
    private String name;
    @NotBlank
    private String contactNumber;
    @NotBlank
    private String mail;
    private String introduce;
    private String workExperience;
    private String project;
    private String otherDetail;
    private String image;
    private List<Integer> selectedTechStack;


}
