package com.csnp.MyServices;

import com.csnp.DTOs.StaffDTO;
import com.csnp.Models.Event;
import com.csnp.Models.Staff;
import com.csnp.Models.Student;

import java.time.LocalDateTime;
import java.util.List;

public interface StaffService  {
    List<Student> getAllStudents();
    void Register(StaffDTO staffDTO);

    Staff login(long mobileNumber, String password);

    void postEvent(Long mobileNumber, String eventName, LocalDateTime eventDate, String eventLocation);

    public List<Event> getAllEvents();
}