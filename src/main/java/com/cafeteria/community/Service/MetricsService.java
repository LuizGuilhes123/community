package com.cafeteria.community.Service;

import com.cafeteria.community.Repository.ArtPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MetricsService {

    private final ArtPostRepository artPostRepository;

    public long countUniqueClientsWithPosts() {
        return artPostRepository.countDistinctUsers();
    }
}
