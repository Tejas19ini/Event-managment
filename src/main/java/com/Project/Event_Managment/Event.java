package com.Project.Event_Managment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "events_held")
@Data
public class Event {

    @Id
    @Column(name = "event_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String eventName;
    private String eventType;
    private String venue;

    @Column(name = "date")
    private LocalDate date;   // ✅ add this

    @Column(name = "time")
    private LocalTime time;   // ✅ add this

    @OneToMany(mappedBy = "event")
    private List<Schedule> schedules;

    @OneToMany(mappedBy = "event")
    private List<Celebrity> celebrities;
}