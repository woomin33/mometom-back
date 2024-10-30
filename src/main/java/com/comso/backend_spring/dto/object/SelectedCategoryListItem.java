package com.comso.backend_spring.dto.object;

import java.util.ArrayList;
import java.util.List;

import com.comso.backend_spring.entity.BoardCategoryEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SelectedCategoryListItem {
    private int boardNumber;
    private int categoryNumber;

    public SelectedCategoryListItem(BoardCategoryEntity resultSet){
        this.boardNumber = resultSet.getBoardNumber();
        this.categoryNumber = resultSet.getCategoryNumber();
    }

    public static List<SelectedCategoryListItem> getList(List<BoardCategoryEntity> resultSets){
        List<SelectedCategoryListItem> list = new ArrayList<>();
        for(BoardCategoryEntity resultSet: resultSets){
            SelectedCategoryListItem selectedCategoryListItem = new SelectedCategoryListItem(resultSet);
            list.add(selectedCategoryListItem);
        }
        return list;
    }
}
