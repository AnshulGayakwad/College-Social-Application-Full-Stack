package com.csnp.MyServices.ServiceImpl;

import java.time.LocalDateTime;
import java.util.List;

import com.csnp.DTOs.StaffDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csnp.Enum.Status;
import com.csnp.Models.Event;
import com.csnp.Models.Staff;
import com.csnp.Models.Student;
import com.csnp.MyRepositories.EventRepository;
import com.csnp.MyRepositories.StaffRepository;
import com.csnp.MyRepositories.StudentRepository;
import com.csnp.MyServices.StaffService;



@Service
public class StaffServiceImpl  implements StaffService {

    private final StaffRepository staffRepository;

    private final StudentRepository studentRepository;

    private final EventRepository eventRepository;


    @Autowired
    public StaffServiceImpl(StaffRepository staffRepository, StudentRepository studentRepository, EventRepository eventRepository) {

        this.staffRepository = staffRepository;
        this.studentRepository = studentRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Student> getAllStudents() {

        return studentRepository.findAllByStatus(Status.APPROVED);
    }

    @Override
    public void Register(StaffDTO staffDTO) {
        if (!staffRepository.findByMobileNumber(staffDTO.getMobileNumber()).isPresent()) {

            Staff staff = new Staff();

            staff.setUsername(staffDTO.getUsername());
            staff.setMobileNumber(staffDTO.getMobileNumber());
            staff.setPassword(staffDTO.getPassword());
            staff.setRole("staff");
            staff.setStatus(Status.valueOf("PENDING"));
            staffRepository.save(staff);
            System.out.println("Registered sucesffuly waiting for approval");


        } else {
            System.out.println("Account Already Exists");
        }
    }

    @Override
    public Staff login(long mobileNumber, String password) {
        Staff staff = (Staff) staffRepository.findByMobileNumber(mobileNumber).orElseThrow(() -> new RuntimeException("no user found"));
        if(staff.getPassword().equals(password) && staff.getStatus().equals(Status.APPROVED)){
            System.out.println("Logged in Sucessfully");
        } else {
            System.out.println("Please re-enter password");
        }
        return staff;
    }


    @Override
    public void postEvent(Long mobileNumber, String eventName, LocalDateTime eventDate, String eventLocation) {
        Event event = new Event();

        Staff staff = (Staff) staffRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new RuntimeException("Staff not found"));

        if (staff.getStatus().equals(Status.APPROVED)) {
            event.setEventName(eventName);
            event.setEventDate(eventDate);
            event.setEventLocation(eventLocation);
            event.setStaff(staff);
            eventRepository.save(event);
        } else {
            throw new RuntimeException("Staff is not approved. Cannot post event.");
        }
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
}
