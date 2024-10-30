package com.comso.backend_spring.dto.request.post;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostPostRequestDto {
    
    @NotBlank
    private String title;
    @NotBlank
    private String content;
}
