package com.graphqljava.tutorial.bookDetails.mongo.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;


/**
 * @author nevinsunny
 * date 27/02/23
 * time 1:22 PM
 */
@Document(collection = "accounts")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDocument {
    @Id
    private String id;
    private Integer account_id;
    private Integer limit;
    private List<String> products;
    private String someString;
    private UUID someUUID;
    private List<SampleUserTestCaseSubmissions> sampleUserTestCaseSubmissions;
    private Nevin nevin;


    @Getter
    @Setter
    @ToString
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class SampleUserTestCaseSubmissions{
        private UUID testCaseId;
        private String stdin;
        private Innerobj innerobj;



        @Getter
        @Setter
        @ToString
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        @JsonIgnoreProperties(ignoreUnknown = true)
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private static class Innerobj{

            private Innermostobj innermostobj;

            @Getter
            @Setter
            @ToString
            @Builder
            @NoArgsConstructor
            @AllArgsConstructor
            @JsonIgnoreProperties(ignoreUnknown = true)
            @JsonInclude(JsonInclude.Include.NON_NULL)
            private static class Innermostobj{
                private String theQuick;
            }
        }
    }

    @Getter
    @Setter
    @ToString
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private static class Nevin{
        private Integer sunny;
    }
}
