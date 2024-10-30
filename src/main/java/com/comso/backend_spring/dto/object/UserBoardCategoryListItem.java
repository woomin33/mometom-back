package com.comso.backend_spring.dto.object;

import java.util.ArrayList;
import java.util.List;

import com.comso.backend_spring.repository.resultSet.GetUserBoardCategoryResultSet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserBoardCategoryListItem {
    private String categoryName;
    private int categoryCount;
    

    public UserBoardCategoryListItem(GetUserBoardCategoryResultSet resultSet){
        this.categoryName = resultSet.getCategoryName();
        this.categoryCount = resultSet.getCategoryCount();
        
    }

    public static List<UserBoardCategoryListItem> getList(List<GetUserBoardCategoryResultSet> resultSets){
        List<UserBoardCategoryListItem> list = new ArrayList<>();
        for(GetUserBoardCategoryResultSet resultSet: resultSets){
            UserBoardCategoryListItem userBoardCategoryItem = new UserBoardCategoryListItem(resultSet);
            list.add(userBoardCategoryItem);
        }
        return list;
    }
}
