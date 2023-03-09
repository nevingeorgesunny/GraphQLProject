package com.graphqljava.tutorial.bookDetails.mongo.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.parameters.P;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.sql.Date;
import java.util.List;

/**
 * @author nevinsunny
 * date 08/03/23
 * time 6:56 PM
 */
@Document(collection = "transactions")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionsDocument {
    @Basic
    @Column(name = "_id")
    private String id;
    @Basic
    @Column(name = "account_id")
    private Integer account_id;

    @Column(name = "transaction_count")
    private Integer transaction_count;

    private List<Transactions> transactions;

    public static class Transactions{
        private Integer amount;
        private String transactionCode;
        private String transaction_code;
        private String symbol;
    }
}
