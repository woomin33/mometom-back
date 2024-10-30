package com.comso.backend_spring.entity;

import com.comso.backend_spring.entity.primaryKey.NoticeTechniquePk;

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
@Entity(name="notice_technique")
@Table(name="notice_technique")
@IdClass(NoticeTechniquePk.class)
public class NoticeTechniqueEntity {
    @Id
    private int noticeNumber;
    @Id
    private int techniqueNumber;
}
