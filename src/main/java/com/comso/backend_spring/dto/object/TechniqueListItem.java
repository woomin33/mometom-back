package com.comso.backend_spring.dto.object;

import java.util.ArrayList;
import java.util.List;

import com.comso.backend_spring.entity.TechniqueEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TechniqueListItem {
    private int techniqueNumber;
    private String techniqueName;

    public TechniqueListItem(TechniqueEntity resultSet){
        this.techniqueNumber = resultSet.getTechniqueNumber();
        this.techniqueName = resultSet.getTechniqueName();
    }

    public static List<TechniqueListItem> getList(List<TechniqueEntity> resultSets){
        List<TechniqueListItem> list = new ArrayList<>();
        for(TechniqueEntity resultSet: resultSets){
            TechniqueListItem techniqueListItem = new TechniqueListItem(resultSet);
            list.add(techniqueListItem);
        }
        return list;
    }
}
