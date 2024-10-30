package com.comso.backend_spring.dto.request.notice;

import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostNoticeRequestDto {
    
    @NotBlank
    private String title;
    @NotNull
    private Date endDate;
    private String employmentForm;
    private String wage;
    private String recruitNumber;
    private String career;
    private String task;
    private String condition;
    private String preference;
    private String etc;
    private List<Integer> selectedTechStack;
    private int selectedDevCategory;
}
