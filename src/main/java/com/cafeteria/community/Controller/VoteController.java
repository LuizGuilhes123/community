package com.cafeteria.community.Controller;


import com.cafeteria.community.Service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client/vote")
@RequiredArgsConstructor
public class VoteController {

    private final VoteService voteService;

    @PostMapping("/{userId}/{artId}")
    public String vote(@PathVariable Long userId, @PathVariable Long artId) {
        voteService.vote(userId, artId);
        return "Voto registrado com sucesso!";
    }
}
