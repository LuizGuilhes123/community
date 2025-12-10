package com.cafeteria.community.Repository;


import com.cafeteria.community.Model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    boolean existsByUserIdAndArtPostId(Long userId, Long artId);

    long countByArtPostId(Long artPostId);
}
