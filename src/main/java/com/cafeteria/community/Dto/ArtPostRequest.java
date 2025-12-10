package com.cafeteria.community.Dto;

public record ArtPostRequest(
        String title,
        String description,
        String imageUrl,
        Long userId
) {}
