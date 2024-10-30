package com.comso.backend_spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "technique")
@Table(name = "technique")
public class TechniqueEntity {
    @Id @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int techniqueNumber;
    private String techniqueName;
}

