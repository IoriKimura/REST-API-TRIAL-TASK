package com.restapitrialtask.restapitrialtask.controllers;

import com.restapitrialtask.restapitrialtask.dto.QuoteDTO;
import com.restapitrialtask.restapitrialtask.services.QuoteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class QuoteController {

    private QuoteService quoteService;

    @PostMapping("api/newQuote")
    public String addNewQuote(@RequestBody QuoteDTO newQuote) {
        if (quoteService.addNewQuote(newQuote).getQuoteID() == null)
            return "There is no account like this";
        else
            return "You have created a quote!";
    }
}
