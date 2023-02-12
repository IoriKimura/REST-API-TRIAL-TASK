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
        //Trying to find user with this userID. If there is no user, then we send an empty UserModel
        Optional<UserModel> user = usersRepo.findById(newQuote.getUserID());
        if(user.isEmpty())
            return new QuoteModel();
        else {
            //Here we get current Date and Time of creation
            Timestamp creationDate = new Timestamp(System.currentTimeMillis());
            QuoteModel quote = new QuoteModel(newQuote.getQuoteContent(), creationDate, user.get());
            return quoteRepo.save(quote);
        }
    }
}
