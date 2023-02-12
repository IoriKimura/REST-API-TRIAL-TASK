package com.restapitrialtask.restapitrialtask.controllers;

import com.restapitrialtask.restapitrialtask.dto.QuoteDTO;
import com.restapitrialtask.restapitrialtask.services.VoteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class VoteController {

    private VoteService voteService;

    @PutMapping("api/upvote/{id}")
    public String upvote(@PathVariable Long id){
        if(voteService.upvote(id) == null)
            return "Wrong quote ID";
        else
            return "Post has been upvoted!";
    }

    @PutMapping("api/downvote/{id}")
    public String downVote(@PathVariable Long id){
        if(voteService.downVote(id) == null)
            return "Wrong quote ID";
        else
            return "Post has been downvoted!";
    }
}
