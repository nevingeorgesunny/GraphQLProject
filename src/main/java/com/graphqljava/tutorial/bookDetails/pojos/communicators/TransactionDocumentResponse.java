package com.graphqljava.tutorial.bookDetails.pojos.communicators;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.graphqljava.tutorial.bookDetails.mongo.dao.AccountDocument;
import com.graphqljava.tutorial.bookDetails.mongo.dao.TransactionsDocument;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author nevinsunny
 * date 09/03/23
 * time 11:41 AM
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionDocumentResponse {
    private List<TransactionsDocument> transactions;
    private Integer pageSize;
    private Integer offset;
    private Integer totalCount;
}
