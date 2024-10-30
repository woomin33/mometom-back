package com.comso.backend_spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "location_list_view")
@Table(name = "location_list_view")
public class LocationListViewEntity {
    @Id
    private int locationNumber;
    private String name;
    private String introduction;
    private double latitude;
    private double longitude;
    private String mainImage;
    private int categoryNumber;
}




    
    

