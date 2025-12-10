package com.cafeteria.community.Controller;


import com.cafeteria.community.Dto.ArtPostRequest;
import com.cafeteria.community.Dto.ArtPostResponse;
import com.cafeteria.community.Service.ArtPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client/art")
@RequiredArgsConstructor
public class ArtPostController {

    private final ArtPostService artPostService;

    @PostMapping
    public ArtPostResponse create(@RequestBody ArtPostRequest request) {
        return artPostService.createPost(request);
    }

    @GetMapping
    public List<ArtPostResponse> list() {
        return artPostService.listAll();
    }
}
