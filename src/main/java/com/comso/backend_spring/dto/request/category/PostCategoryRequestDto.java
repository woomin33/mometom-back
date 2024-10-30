package com.comso.backend_spring.dto.request.category;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostCategoryRequestDto {
    
    @NotNull
    private List<Integer> selectedCategoryList;
}
