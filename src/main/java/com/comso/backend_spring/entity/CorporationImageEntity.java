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
@Entity(name = "corporation_image")
@Table(name = "corporation_image")
public class CorporationImageEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sequence;
    private int corporationNumber;
    
    private String image;

    public CorporationImageEntity(int corporationNumber, String image){
        this.corporationNumber = corporationNumber;
        
        this.image = image;
    }
}
