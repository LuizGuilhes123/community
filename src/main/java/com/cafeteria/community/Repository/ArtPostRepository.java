package com.cafeteria.community.Repository;


import com.cafeteria.community.Model.ArtPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArtPostRepository extends JpaRepository<ArtPost, Long> {

    @Query("SELECT COUNT(DISTINCT a.user.id) FROM ArtPost a")
    long countDistinctUsers();


}
