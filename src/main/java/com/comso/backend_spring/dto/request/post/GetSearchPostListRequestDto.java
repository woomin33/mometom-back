package com.comso.backend_spring.dto.request.post;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GetSearchPostListRequestDto {
    
    private String searchWord;
    private String startDate;
    private String endDate;
}
