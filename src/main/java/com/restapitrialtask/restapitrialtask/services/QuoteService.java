package com.restapitrialtask.restapitrialtask.services;

import com.restapitrialtask.restapitrialtask.dto.QuoteDTO;
import com.restapitrialtask.restapitrialtask.models.QuoteModel;
import com.restapitrialtask.restapitrialtask.models.UserModel;
import com.restapitrialtask.restapitrialtask.repository.QuoteRepo;
import com.restapitrialtask.restapitrialtask.repository.UsersRepo;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class QuoteService {
    private QuoteRepo quoteRepo;
    private UsersRepo usersRepo;

    public QuoteModel addNewQuote(@NotNull QuoteDTO newQuote){
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

    public QuoteModel updateQuote(@NotNull QuoteDTO editQuote){
        Optional<QuoteModel> editedQuote = quoteRepo.findById(editQuote.getQuoteID());
        if(editedQuote.isEmpty())
            return new QuoteModel();
        else {
            Timestamp updateDate = new Timestamp(System.currentTimeMillis());
            editedQuote.get().setQuoteContent(editQuote.getQuoteContent());
            editedQuote.get().setCreatedUpdated(updateDate);
            return quoteRepo.save(editedQuote.get());
        }
    }

    public String deletingQuote(Long id){
        QuoteModel deletedQuote = quoteRepo.findQuoteById(id);
        if(deletedQuote == null)
            return "BAD_REQUEST";
        else {
            quoteRepo.deleteById(deletedQuote.getQuoteID());
            return "OK";
        }
    }

    public List<QuoteModel> showQuotes(){
        return quoteRepo.findAll();
    }

    public QuoteDTO showQuote(Long quoteID){
        QuoteModel quote = quoteRepo.findQuoteById(quoteID);
        if(quote == null)
            return new QuoteDTO();
        else {
            QuoteDTO showingQuote = new QuoteDTO(quote.getQuoteContent(),
                    quote.getUser().getId(), quote.getQuoteID(), quote.getUser().getUserName(),
                    quote.getCreatedUpdated(), quote.getVotesCount());
            return showingQuote;
        }
    }

    public QuoteDTO showRandom() {
        List<QuoteModel> allQuotes = quoteRepo.findAll();
        Random rnd = new Random();
        QuoteModel randomFromDB = allQuotes.get(rnd.nextInt(allQuotes.size()));
        QuoteDTO randomQuote = new QuoteDTO(randomFromDB.getQuoteContent(),
                randomFromDB.getUser().getId(), randomFromDB.getQuoteID(), randomFromDB.getUser().getUserName(),
                randomFromDB.getCreatedUpdated(), randomFromDB.getVotesCount());
        return randomQuote;
    }

    public List<QuoteModel> showBest(){
        Pageable topTen = PageRequest.of(0, 10);
        return quoteRepo.findBest(topTen);
    }

    public List<QuoteModel> showWorst(){
        Pageable worstTen = PageRequest.of(0, 10);
        return quoteRepo.findWorst(worstTen);
    }
}
