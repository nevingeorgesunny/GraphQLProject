package com.graphqljava.tutorial.bookDetails.pojos;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author nevinsunny
 * date 27/02/23
 * time 4:59 PM
 */

@Getter
@Setter
@Builder
public class Pagination {

    private Integer offset;
    private Integer pageSize;
}
