package com.graphqljava.tutorial.bookDetails.lib;

import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author nevinsunny
 * date 28/02/23
 * time 4:52 PM
 */
public class MongoSortCriteriaCreator {

    public static Sort buildSortCriteria(SortExpression sortExpression){
        Map<String, String> sortMap = sortExpression.getSortMap();

        List<Sort.Order> sortList = new ArrayList<>();

        for(String sortBy : sortMap.keySet()){
            Sort.Direction direction = Sort.Direction.ASC;
            if(!sortMap.get(sortBy).equals("ASC")){
                direction = Sort.Direction.DESC;
            }

            sortList.add( new Sort.Order(direction,sortBy));
        }

        return Sort.by(sortList);
    }
}
