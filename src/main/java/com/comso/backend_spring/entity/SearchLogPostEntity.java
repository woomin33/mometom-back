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
@Entity(name = "search_log_post")
@Table(name="search_log_post")
public class SearchLogPostEntity {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int squence;
    private String searchWord;
    
    public SearchLogPostEntity(String searchWord){
        this.searchWord = searchWord;
    }
}
