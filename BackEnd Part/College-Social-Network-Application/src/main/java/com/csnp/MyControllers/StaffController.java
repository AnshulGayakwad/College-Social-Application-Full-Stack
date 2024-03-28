package com.csnp.MyControllers;

import com.csnp.DTOs.EventDTO;
import com.csnp.DTOs.StaffDTO;
import com.csnp.Exception.InvalidCredentialsException;
import com.csnp.Models.Event;
import com.csnp.Models.Staff;
import com.csnp.Models.Student;
import com.csnp.MyServices.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/staff")
public class StaffController {
      
    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return staffService.getAllStudents();
    }

    @PostMapping("/register")
    public void register(@RequestBody StaffDTO staffDTO) {
        staffService.Register(staffDTO);
    }

    @GetMapping("/login/{mobileNumber}/{password}")
    public ResponseEntity<?> login(@PathVariable long mobileNumber, @PathVariable String password) {
        try {
            Staff staff = staffService.login(mobileNumber, password);
            return ResponseEntity.ok(staff);
        } catch (InvalidCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @PostMapping("/post-event/{mobileNumber}/{eventName}/{eventDate}/{eventLocation}")
    public void postEvent(@PathVariable Long mobileNumber,
                          @PathVariable String eventName,
                          @PathVariable LocalDateTime eventDate,
                          @PathVariable String eventLocation) {
//        LocalDateTime formattedEventDate = LocalDateTime.parse(eventDate); // Assuming eventDate is in ISO-8601 format
        staffService.postEvent(mobileNumber, eventName, eventDate, eventLocation);
    }
    @GetMapping("/getAllEvents")
    public ResponseEntity<List<EventDTO>> getAllEvents() {
        List<Event> events = staffService.getAllEvents();
        List<EventDTO> eventDTOs = events.stream()
                .map(event -> new EventDTO(
                        event.getId(),
                        event.getEventName(),
                        event.getEventDate(),
                        event.getEventLocation(),
                        event.getStaff() != null ? event.getStaff().getId() : null
                ))
                .collect(Collectors.toList());
        return new ResponseEntity<>(eventDTOs, HttpStatus.OK);
    }

}
