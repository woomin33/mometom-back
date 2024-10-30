package com.comso.backend_spring.entity;


import com.comso.backend_spring.entity.primaryKey.BoardCategoryPk;

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
@Entity(name="board_category")
@Table(name="board_category")
@IdClass(BoardCategoryPk.class)
public class BoardCategoryEntity {
    @Id
    private int boardNumber;
    @Id
    private int categoryNumber;
}
