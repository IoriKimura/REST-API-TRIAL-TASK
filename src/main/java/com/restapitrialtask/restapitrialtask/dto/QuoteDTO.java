package com.restapitrialtask.restapitrialtask.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class QuoteDTO {

    private String quoteContent;
    private Long userID;
    private Long quoteID;
    private String userName;
    private Timestamp createdUpdated;
    private Long votesCount;
}
