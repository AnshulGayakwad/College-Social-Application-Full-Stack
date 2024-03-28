//package com.csnp.MyServices.ServiceImpl;
//
//import com.csnp.Enum.Status;
//import com.csnp.Models.Event;
//import com.csnp.Models.Staff;
//import com.csnp.MyRepositories.EventRepository;
//import com.csnp.MyRepositories.StaffRepository;
//import com.csnp.MyServices.EventService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Service
//public class EventServiceImpl implements EventService {
//
//    private final EventRepository eventRepository;
//
//    private final StaffRepository staffRepository;
//    @Autowired
//    public EventServiceImpl(EventRepository eventRepository, StaffRepository staffRepository) {
//        this.eventRepository = eventRepository;
//        this.staffRepository = staffRepository;
//    }
//
//
//    @Override
//    public List<Event> getAllEvents() {
//        List<Event> events=eventRepository.findByStatus(Status.APPROVED);
//        return events;
//    }
//
//    @Override
//    public void createEvent(String username, String location, LocalDateTime date, String eventName, Event event) {
//        Staff staff = new Staff();
//        staff = (Staff) staffRepository.findByName(username).orElseThrow(() -> new RuntimeException("Staff Not Found"));
//        event.setStaff(staff);
//        event.setEventLocation(location);
//        event.setEventName(eventName);
//        event.setEventDate(date);
//        eventRepository.save(event);
//    }
//
//    @Override
//    public void deleteEvent(Long id) {
//        eventRepository.deleteById(id);
//    }
//}