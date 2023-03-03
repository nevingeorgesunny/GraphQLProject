package com.graphqljava.tutorial.bookDetails.lib;

import com.intuit.graphql.filter.ast.*;
import org.springframework.data.util.Pair;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.*;

/**
 * @author nevinsunny
 * date 28/02/23
 * time 1:35 PM
 */
public class SortExpressionParser {

    private Map<String,String> sortMap = new HashMap<>();

    public Map<String,String> parseSortExpressionList(Map filterArgs) {
        return createSortMap(filterArgs);
    }

    private  Map<String,String> createSortMap(Map filterMap) {
        Set<Map.Entry> entries =  filterMap.entrySet();
        for (Map.Entry entry : entries) {



            String leftOperand = (String) entry.getKey();
            String rightOperand = "ASC";

            Object value = entry.getValue();

            while (value instanceof Map){
                Map<String,Object> valueMap = (Map) value;

                Map.Entry<String,Object> firstEntry = valueMap.entrySet().iterator().next();

                leftOperand += "."+ firstEntry.getKey();

                value = firstEntry.getValue();
            }

            if(value instanceof String){
                rightOperand = (String) value;
            }



            sortMap.put(leftOperand,rightOperand);

        }
        return sortMap;
    }

    private boolean isOperator(String key) {
        Operator operator = null;
        try {
            operator = Operator.getOperator(key);
        } catch (Exception ex) {

        }
        return operator == null ? false : true;
    }

    private Comparable convertIfDate(Comparable value) {
        if (value == null) {
            return null;
        }
        if (value instanceof LocalDate) {
            LocalDate localDate = (LocalDate) value;
            value = java.util.Date.from(localDate.atStartOfDay()
                    .atZone(ZoneId.systemDefault())
                    .toInstant());
        } else if (value instanceof LocalDateTime) {
            LocalDateTime localDateTime = (LocalDateTime) value;
            value = java.util.Date
                    .from(localDateTime.atZone(ZoneId.systemDefault())
                            .toInstant());
        } else if (value instanceof OffsetDateTime) {
            OffsetDateTime offsetDateTime = (OffsetDateTime) value;
            value = java.util.Date
                    .from(offsetDateTime.toInstant());
        }
        return value;
    }

    /**
     * Validates if the given expression is
     * instance of Binary or Compound expression.
     * @param expression
     * @return
     */
    private boolean validateExpression(Expression expression) {
        if (expression != null && (expression instanceof BinaryExpression
                || expression instanceof CompoundExpression
                || expression instanceof UnaryExpression)) {
            return true;
        }
        return false;
    }
}
