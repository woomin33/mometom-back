package com.comso.backend_spring.entity;

import com.comso.backend_spring.entity.primaryKey.ResumeTechniquePk;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="resume_technique")
@Table(name="resume_technique")
@IdClass(ResumeTechniquePk.class)
public class ResumeTechniqueEntity {
    @Id
    private int resumeNumber;
    @Id
    private int techniqueNumber;
}
