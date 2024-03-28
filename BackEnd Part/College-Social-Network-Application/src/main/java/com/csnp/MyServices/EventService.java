package com.csnp.MyServices;

import com.csnp.Models.Event;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

public interface EventService {
    List<Event> getAllEvents();

    void createEvent(String username, String location, LocalDateTime date, String eventName, Event event);

    void deleteEvent(Long id);
}