package com.restapitrialtask.restapitrialtask.services;

import com.restapitrialtask.restapitrialtask.dto.QuoteDTO;
import com.restapitrialtask.restapitrialtask.models.QuoteModel;
import com.restapitrialtask.restapitrialtask.models.UserModel;
import com.restapitrialtask.restapitrialtask.repository.QuoteRepo;
import com.restapitrialtask.restapitrialtask.repository.UsersRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
@AllArgsConstructor
public class QuoteService {
    private QuoteRepo quoteRepo;
    private UsersRepo usersRepo;

    public QuoteModel addNewQuote(QuoteDTO newQuote){
        Optional<UserModel> user = usersRepo.findById(newQuote.getUserID());
        if(user.isEmpty())
            return new QuoteModel();
        else {
            Timestamp creationDate = new Timestamp(System.currentTimeMillis());
            QuoteModel quote = new QuoteModel(newQuote.getQuoteContent(), creationDate, user.get());
            return quoteRepo.save(quote);
        }
    }
}
