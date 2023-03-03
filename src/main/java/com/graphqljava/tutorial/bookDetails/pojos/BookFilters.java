package com.graphqljava.tutorial.bookDetails.pojos;

import lombok.*;

import java.util.UUID;

/**
 * @author nevinsunny
 * date 26/02/23
 * time 11:48 AM
 */


@Setter
public class BookFilters {

    public BookFilters() {
        int x = 1;
    }

    private String id;
    private String name;
    private Integer pageCount;
    private UUID someUUID;
}
