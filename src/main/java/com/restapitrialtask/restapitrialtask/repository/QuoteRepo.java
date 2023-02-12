package com.restapitrialtask.restapitrialtask.repository;

import com.restapitrialtask.restapitrialtask.models.QuoteModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuoteRepo extends JpaRepository<QuoteModel, Long> {
    @Query("SELECT quote FROM QuoteModel quote WHERE quote.quoteID = :quoteID")
    QuoteModel findQuoteById(Long quoteID);

    @Query("FROM QuoteModel ORDER BY votesCount desc")
    List<QuoteModel> findBest(Pageable pageable);

    @Query("FROM QuoteModel ORDER BY votesCount asc")
    List<QuoteModel> findWorst(Pageable pageable);

}
