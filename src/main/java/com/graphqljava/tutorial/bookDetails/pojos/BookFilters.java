package com.graphqljava.tutorial.bookDetails.pojos;

import lombok.*;

import java.util.UUID;

/**
 * @author nevinsunny
 * date 26/02/23
 * time 11:48 AM
 */


@Setter
@NoArgsConstructor
public class BookFilters {
    private String id;
    private String name;
    private Integer pageCount;
    private UUID someUUID;
}
