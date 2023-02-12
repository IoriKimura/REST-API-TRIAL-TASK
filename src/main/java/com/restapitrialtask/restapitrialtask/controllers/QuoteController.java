package com.restapitrialtask.restapitrialtask.controllers;

import com.restapitrialtask.restapitrialtask.dto.QuoteDTO;
import com.restapitrialtask.restapitrialtask.models.QuoteModel;
import com.restapitrialtask.restapitrialtask.services.QuoteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("api/quote/delete/{id}")
    public String deleting(@PathVariable Long id){
        if(quoteService.deletingQuote(id).equals("OK"))
            return "You have deleted quote!";
        else
            return "Something went wrong!";
    }

    @GetMapping("api/quote")
    public List<QuoteModel> showAllQuotes(){
            return quoteService.showQuotes();
    }

    @GetMapping("api/quote/{id}")
    public QuoteDTO showOneQuote(@PathVariable Long id){
        return quoteService.showQuote(id);
    }

    @GetMapping("api/quote/random")
    public QuoteDTO randomQuote(){
        return quoteService.showRandom();
    }

    @GetMapping("api/quote/top10")
    public List<QuoteModel> bestQuotes(){
        return quoteService.showBest();
    }

    @GetMapping("api/quote/worst10")
    public List<QuoteModel> worstQuotes(){
        return quoteService.showWorst();
    }
}
