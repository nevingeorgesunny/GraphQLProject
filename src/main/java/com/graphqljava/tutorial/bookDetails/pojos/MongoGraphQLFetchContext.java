package com.graphqljava.tutorial.bookDetails.pojos;

import com.graphqljava.tutorial.bookDetails.lib.MongoSortCriteriaCreator;
import com.graphqljava.tutorial.bookDetails.lib.SortExpression;
import com.intuit.graphql.filter.client.ExpressionFormat;
import com.intuit.graphql.filter.client.FilterExpression;
import graphql.schema.DataFetchingEnvironment;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.Map;

/**
 * @author nevinsunny
 * date 01/03/23
 * time 3:29 PM
 */
@Builder
@Getter
public class MongoGraphQLFetchContext {

    private Criteria criteria;
    private Sort sort;
    private Pagination pagination;

    public static MongoGraphQLFetchContext build(DataFetchingEnvironment dataFetchingEnvironment){

        //Build the criteria
        FilterExpression.FilterExpressionBuilder builder = FilterExpression.newFilterExpressionBuilder();
        FilterExpression filterExpression = builder.args(dataFetchingEnvironment.getArguments())
                .build();
        Criteria criteria = filterExpression.getExpression(ExpressionFormat.MONGO);

        //build the sort
        SortExpression sortExpression =  SortExpression.build(dataFetchingEnvironment.getArguments());
        Sort sort = MongoSortCriteriaCreator.buildSortCriteria(sortExpression);


        //build the Pagination
        Map<String,Integer> paginationMap = (Map<String, Integer>) dataFetchingEnvironment.getArguments().get("pagination");
        Pagination pagination = Pagination.builder()
                .offset(paginationMap.get("offset"))
                .pageSize(paginationMap.get("pageSize"))
                .build();


        return MongoGraphQLFetchContext.builder()
                .criteria(criteria)
                .sort(sort)
                .pagination(pagination)
                .build();
    }
}
