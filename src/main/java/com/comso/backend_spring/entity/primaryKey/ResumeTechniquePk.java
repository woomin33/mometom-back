package com.comso.backend_spring.entity.primaryKey;

import java.io.Serializable;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResumeTechniquePk implements Serializable{
    @Column(name = "resume_number")
    private int resumeNumber;
    @Column(name = "technique_number")
    private int techniqueNumber;
}
