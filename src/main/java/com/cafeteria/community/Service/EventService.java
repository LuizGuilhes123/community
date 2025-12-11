package com.cafeteria.community.Service;


import com.cafeteria.community.Model.Event;
import com.cafeteria.community.Model.User;
import com.cafeteria.community.Repository.EventRepository;
import com.cafeteria.community.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public Event createEvent(String title, String description, LocalDateTime eventDate, Long staffId) {
        User staff = userRepository.findById(staffId)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        Event event = Event.builder()
                .title(title)
                .description(description)
                .eventDate(eventDate)
                .createdBy(staff)
                .createdAt(LocalDateTime.now())
                .build();

        return eventRepository.save(event);
    }

    public List<Event> listAllEvents() {
        return eventRepository.findAll();
    }

    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }
}
