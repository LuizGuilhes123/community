package com.cafeteria.community.Service;


import com.cafeteria.community.Model.ArtPost;
import com.cafeteria.community.Model.User;
import com.cafeteria.community.Model.Vote;
import com.cafeteria.community.Repository.ArtPostRepository;
import com.cafeteria.community.Repository.UserRepository;
import com.cafeteria.community.Repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class VoteService {

    private final VoteRepository voteRepository;
    private final UserRepository userRepository;
    private final ArtPostRepository artPostRepository;

    public void vote(Long userId, Long artId) {

        if (voteRepository.existsByUserIdAndArtPostId(userId, artId)) {
            throw new RuntimeException("Você já votou nesta arte.");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        ArtPost post = artPostRepository.findById(artId)
                .orElseThrow(() -> new RuntimeException("Arte não encontrada"));

        Vote vote = Vote.builder()
                .user(user)
                .artPost(post)
                .createdAt(LocalDateTime.now())
                .build();

        voteRepository.save(vote);
    }
}
