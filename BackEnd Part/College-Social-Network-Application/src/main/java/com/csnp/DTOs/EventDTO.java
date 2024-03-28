package com.csnp.DTOs;

import com.csnp.Models.Event;
import com.csnp.Models.Staff;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {

    private Long id;

    @NotBlank(message = "Event name is required")
    private String eventName;

    @NotNull(message = "Event date is required")
    @PastOrPresent(message = "Event date must be in the past or present")
    private LocalDateTime eventDate;

    @NotBlank(message = "Event location is required")
    private String eventLocation;

    @Positive(message = "Staff ID must be positive")
    private Long staffId; // Assuming you want to include staff ID in DTO



    // Utility method to convert DTO to Entity (if needed)
    public Event toEntity() {
        Event event = new Event();
        event.setId(this.id);
        event.setEventName(this.eventName);
        event.setEventDate(this.eventDate);
        event.setEventLocation(this.eventLocation);
        // Set staff if needed, but it's not included in this DTO
        return event;
    }
}
