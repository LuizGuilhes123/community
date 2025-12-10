package com.cafeteria.community.Repository;


import com.cafeteria.community.Model.ArtPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtPostRepository extends JpaRepository<ArtPost, Long> {
}
