package com.graphqljava.tutorial.bookDetails.sercice;

import com.graphqljava.tutorial.bookDetails.mongo.dao.AccountDocument;
import com.graphqljava.tutorial.bookDetails.pojos.FetchAccountContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author nevinsunny
 * date 27/02/23
 * time 1:43 PM
 */
@Component
public class AccountsService {

    @Autowired
    private MongoTemplate mongoTemplate;


    public List<AccountDocument> fetchAccountWithFilter(FetchAccountContext context){


//        Query query = new Query().addCriteria(criteria);
//
//        return mongoTemplate
//                .find(query.with(PageRequest.of(0,10)), AccountDocument.class);

        return null;


    }
}
