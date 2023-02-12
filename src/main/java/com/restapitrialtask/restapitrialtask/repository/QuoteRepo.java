package com.restapitrialtask.restapitrialtask.repository;

import com.restapitrialtask.restapitrialtask.models.QuoteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuoteRepo extends JpaRepository<QuoteModel, Long> {
    @Query("SELECT quote FROM QuoteModel quote WHERE quote.quoteID = :quoteID")
    QuoteModel findQuoteById(Long quoteID);

}
