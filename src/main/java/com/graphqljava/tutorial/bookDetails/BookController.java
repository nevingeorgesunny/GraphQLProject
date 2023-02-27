package com.graphqljava.tutorial.bookDetails;

import com.graphqljava.tutorial.bookDetails.mongo.dao.AccountDocument;
import com.graphqljava.tutorial.bookDetails.mongo.repo.AccountRepository;
import com.graphqljava.tutorial.bookDetails.pojos.BookFilters;
import com.intuit.graphql.filter.client.ExpressionFormat;
import com.intuit.graphql.filter.client.FilterExpression;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
public class BookController {

    private final AccountRepository accountRepository;

    public BookController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @QueryMapping
    public Book bookById(@Argument String id) {
        return Book.getById(id);
    }

    @QueryMapping
    public Book bookById2(@Argument String id) {
        return Book.getById(id);
    }

    @QueryMapping
    public Book bookByIdFilter(@Argument String filter,@Argument String pagination) {
        return  Book.getById("book-1");
    }

    @QueryMapping
    public Book bookByIdFilterWithObject(@Argument("filter") BookFilters filter, DataFetchingEnvironment dataFetchingEnvironment) {
//        accountRepository.findAll();

        return  Book.getById("book-1");
    }



    @QueryMapping
    public List<AccountDocument> searchAccounts(DataFetchingEnvironment dataFetchingEnvironment){

        FilterExpression.FilterExpressionBuilder builder = FilterExpression.newFilterExpressionBuilder();
        FilterExpression filterExpression = builder.args(dataFetchingEnvironment.getArguments())
                .build();
        Criteria expression = filterExpression.getExpression(ExpressionFormat.MONGO);







        return null;
    }

    @SchemaMapping
    public Author author(Book book) {
        return Author.getById(book.getAuthorId());
    }
}