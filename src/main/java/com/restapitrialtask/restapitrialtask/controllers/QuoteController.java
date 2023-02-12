package com.restapitrialtask.restapitrialtask.controllers;

import com.restapitrialtask.restapitrialtask.dto.QuoteDTO;
import com.restapitrialtask.restapitrialtask.services.QuoteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class QuoteController {

    private QuoteService quoteService;

    //Creation of a quote
    @PostMapping("api/quote/new")
    public String addNewQuote(@RequestBody QuoteDTO newQuote) {
        if (quoteService.addNewQuote(newQuote).getQuoteID() == null)
            return "There is no account like this";
        else
            return "You have created a quote!";
    }

    @PutMapping("api/quote/update")
    public String updating( @RequestBody QuoteDTO editQuote){
        if (quoteService.updateQuote(editQuote).getQuoteID() == null)
            return "There is no quote like this";
        else
            return "You have updated a quote!";
    }
}
