package com.restapitrialtask.restapitrialtask.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class QuoteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long quoteID;

    @Column
    private String quoteContent;

    @Column
    private Timestamp CreatedUpdated;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private UserModel user;

    @Column
    private Integer votesCount;

    public QuoteModel(String quoteContent, Timestamp creationDate, UserModel user) {
        this.quoteContent = quoteContent;
        this.CreatedUpdated = creationDate;
        this.user = user;
        this.votesCount = 0;
    }
}
