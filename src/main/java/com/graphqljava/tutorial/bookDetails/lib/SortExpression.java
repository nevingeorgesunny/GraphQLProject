package com.graphqljava.tutorial.bookDetails.lib;

import com.intuit.graphql.filter.ast.Expression;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author nevinsunny
 * date 28/02/23
 * time 1:08 PM
 */
@Setter
@Getter

public class SortExpression {


    public SortExpression() {
        int x = 1;
    }

    public static final String SORT_ARGS = "sort";

    private Map<String, String> sortMap;

    public SortExpression(Map<String, String> sortMap) {
        this.sortMap = sortMap;
    }

    public static SortExpression build(Map args) {
        SortExpressionParser sortExpressionParser = new SortExpressionParser();
        Map<String, String> sortMap = new HashMap<>();
        if (args != null) {
            Object filter = args.get(SORT_ARGS);
            if (filter != null) {
                sortMap = sortExpressionParser.parseSortExpressionList((Map) filter);
            }
        }

        return new SortExpression(sortMap);
    }

}
