package com.comso.backend_spring.dto.object;

import java.util.ArrayList;
import java.util.List;

import com.comso.backend_spring.entity.DevCategoryEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DevCategoryListItem {
    private int categoryNumber;
    private String categoryName;

    public DevCategoryListItem(DevCategoryEntity resultSet){
        this.categoryNumber = resultSet.getCategoryNumber();
        this.categoryName = resultSet.getCategoryName();
    }

    public static List<DevCategoryListItem> getList(List<DevCategoryEntity> resultSets){
        List<DevCategoryListItem> list = new ArrayList<>();
        for(DevCategoryEntity resultSet: resultSets){
            DevCategoryListItem categoryListItem = new DevCategoryListItem(resultSet);
            list.add(categoryListItem);
        }
        return list;
    }
}
