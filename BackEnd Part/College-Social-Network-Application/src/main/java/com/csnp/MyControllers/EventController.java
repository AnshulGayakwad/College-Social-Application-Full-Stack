//package com.csnp.MyControllers;
//
//import com.csnp.Models.Event;
//import com.csnp.MyServices.EventService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/events")
//public class EventController {
//
//    private final EventService eventService;
//
//    @Autowired
//    public EventController(EventService eventService) {
//        this.eventService = eventService;
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Event>> getAllEvents() {
//        List<Event> events = eventService.getAllEvents();
//        return ResponseEntity.ok(events);
//    }
//}
