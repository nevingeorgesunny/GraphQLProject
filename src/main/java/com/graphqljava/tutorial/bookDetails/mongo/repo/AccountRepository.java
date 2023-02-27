package com.graphqljava.tutorial.bookDetails.mongo.repo;

import com.graphqljava.tutorial.bookDetails.mongo.dao.AccountDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author nevinsunny
 * date 27/02/23
 * time 1:25 PM
 */
public interface AccountRepository extends MongoRepository<AccountDocument, String> {
}
