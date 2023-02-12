package com.restapitrialtask.restapitrialtask.services;

import com.restapitrialtask.restapitrialtask.models.QuoteModel;
import com.restapitrialtask.restapitrialtask.repository.QuoteRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VoteService {

    QuoteRepo quoteRepo;

    public String upvote(Long quoteID){
        QuoteModel quote = quoteRepo.findQuoteById(quoteID);
        if(quote == null)
            return "BAD_REQUEST";
        else {
            quote.setVotesCount(quote.getVotesCount() +1);
            quoteRepo.save(quote);
            return "OK";
        }
    }

    public String downVote(Long quoteID){
        QuoteModel quote = quoteRepo.findQuoteById(quoteID);
        if(quote == null)
            return "BAD_REQUEST";
        else {
            quote.setVotesCount(quote.getVotesCount() -1);
            quoteRepo.save(quote);
            return "OK";
        }
    }
}
