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
public class BoardCategoryPk implements Serializable{
    @Column(name = "board_number")
    private int boardNumber;
    @Column(name = "category_number")
    private int categoryNumber;
}
