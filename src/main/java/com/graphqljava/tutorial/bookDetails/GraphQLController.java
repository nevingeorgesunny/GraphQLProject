package com.graphqljava.tutorial.bookDetails;

import com.graphqljava.tutorial.bookDetails.mongo.dao.AccountDocument;
import com.graphqljava.tutorial.bookDetails.pojos.BookFilters;
import com.graphqljava.tutorial.bookDetails.pojos.MongoGraphQLFetchContext;
import com.graphqljava.tutorial.bookDetails.pojos.OffsetLimitPageable;
import com.graphqljava.tutorial.bookDetails.pojos.Pagination;
import graphql.schema.DataFetchingEnvironment;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;

@Controller
public class GraphQLController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @QueryMapping
    public String helloWorld() {
        return "helloWorld";
    }

    @QueryMapping
    public List<Book> getAllBooks() {
        return Arrays.asList(
                new Book("book-1", "Harry Potter and the Philosopher's Stone", 223, new Author("author-1", "Joanne", "Rowling")),
                new Book("book-2", "Moby Dick", 635, new Author("author-2", "Herman", "Melville")),
                new Book("book-3", "Interview with the vampire", 371, new Author("author-3", "Anne", "Rice"))
        );
    }

    @QueryMapping
    public Book bookById(@Argument String id) {
        return Book.getById(id);
    }

    @QueryMapping
    public Book bookByIdValidations(@Argument String id) {
        return Book.getById(id);
    }


    @QueryMapping
    public List<Book> bookByFilters(@Argument BookFilters filters) {
        return List.of(Book.getById("book-1"));
    }

    @QueryMapping
    public List<Book> bookByFiltersWithEnvVariable(DataFetchingEnvironment dataFetchingEnvironment) {
        return List.of(Book.getById("book-1"));
    }


    @QueryMapping
    @PreAuthorize("hasRole('SALES_DASHBOARD')")
    public List<AccountDocument> searchAccounts(DataFetchingEnvironment dataFetchingEnvironment) {
        MongoGraphQLFetchContext fetchContext = MongoGraphQLFetchContext.build(dataFetchingEnvironment);

        Query query = new Query().addCriteria(fetchContext.getCriteria()).with(fetchContext.getSort());
        return mongoTemplate
                .find(query.with(getPageRequest(fetchContext.getPagination())), AccountDocument.class);

    }


    @NotNull
    private OffsetLimitPageable getPageRequest(Pagination pagination) {
        if (pagination != null && pagination.getOffset() != null && pagination.getPageSize() != null) {
            return new OffsetLimitPageable(pagination.getOffset(), pagination.getPageSize());
        } else {
            return new OffsetLimitPageable(0, 10000);
        }

    }
}