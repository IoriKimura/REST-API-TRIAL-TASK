package com.restapitrialtask.restapitrialtask.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuoteDTO {

    private String quoteContent;
    private Long userID;
    private Long quoteID;
    private String userName;
    private Timestamp createdUpdated;
    private Integer votesCount;

}
