package com.graphqljava.tutorial.bookDetails.sercice;

import com.graphqljava.tutorial.bookDetails.mongo.dao.AccountDocument;
import com.graphqljava.tutorial.bookDetails.pojos.FetchAccountContext;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author nevinsunny
 * date 27/02/23
 * time 1:43 PM
 */
@Component
public class AccountsService {


    public List<AccountDocument> fetchAccountWithFilter(FetchAccountContext context){
        return null;
    }
}
