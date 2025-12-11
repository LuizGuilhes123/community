package com.cafeteria.community.Controller;


import com.cafeteria.community.Model.Event;
import com.cafeteria.community.Service.EventService;
import com.cafeteria.community.Service.MetricsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/staff")
@RequiredArgsConstructor
public class StaffController {

    private final EventService eventService;
    private final MetricsService metricsService;

    @PostMapping("/event")
    public Event createEvent(@RequestParam String title,
                             @RequestParam String description,
                             @RequestParam String date,
                             @RequestParam Long staffId) {
        LocalDateTime eventDate = LocalDateTime.parse(date);
        return eventService.createEvent(title, description, eventDate, staffId);
    }

    @GetMapping("/events")
    public List<Event> listEvents() {
        return eventService.listAllEvents();
    }

    @DeleteMapping("/event/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return "Evento deletado com sucesso";
    }

    @GetMapping("/metrics/clients-posts")
    public long clientsWithPosts() {
        return metricsService.countUniqueClientsWithPosts();
    }
}
