package com.cafeteria.community.Service;


import com.cafeteria.community.Dto.ArtPostRequest;
import com.cafeteria.community.Dto.ArtPostResponse;
import com.cafeteria.community.Model.ArtPost;
import com.cafeteria.community.Model.User;
import com.cafeteria.community.Repository.ArtPostRepository;
import com.cafeteria.community.Repository.UserRepository;
import com.cafeteria.community.Repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArtPostService {

    private final ArtPostRepository artPostRepository;
    private final UserRepository userRepository;
    private final VoteRepository voteRepository;

    public ArtPostResponse createPost(ArtPostRequest request) {
        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        ArtPost post = ArtPost.builder()
                .title(request.title())
                .description(request.description())
                .imageUrl(request.imageUrl())
                .createdAt(LocalDateTime.now())
                .user(user)
                .build();

        artPostRepository.save(post);

        return mapToResponse(post, 0);
    }

    public List<ArtPostResponse> listAll() {
        return artPostRepository.findAll().stream().map(post ->
                mapToResponse(post,
                        (int) voteRepository.countByArtPostId(post.getId())
                )
        ).toList();
    }

    private ArtPostResponse mapToResponse(ArtPost post, int votes) {
        return new ArtPostResponse(
                post.getId(),
                post.getTitle(),
                post.getDescription(),
                post.getImageUrl(),
                post.getUser().getName(),
                votes
        );
    }
}
