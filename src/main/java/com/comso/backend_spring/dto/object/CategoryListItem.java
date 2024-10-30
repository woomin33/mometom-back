package com.comso.backend_spring.dto.object;

import java.util.ArrayList;
import java.util.List;

import com.comso.backend_spring.entity.CategoryEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryListItem {
    private int categoryNumber;
    private String categoryName;

    public CategoryListItem(CategoryEntity resultSet){
        this.categoryNumber = resultSet.getCategoryNumber();
        this.categoryName = resultSet.getCategoryName();
    }

    public static List<CategoryListItem> getList(List<CategoryEntity> resultSets){
        List<CategoryListItem> list = new ArrayList<>();
        for(CategoryEntity resultSet: resultSets){
            CategoryListItem categoryListItem = new CategoryListItem(resultSet);
            list.add(categoryListItem);
        }
        return list;
    }
}
