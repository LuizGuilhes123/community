package com.cafeteria.community.Dto;

public record ArtPostResponse(
        Long id,
        String title,
        String description,
        String imageUrl,
        String authorName,
        int votes
) {}
