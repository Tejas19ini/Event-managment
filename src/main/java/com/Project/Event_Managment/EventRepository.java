package com.Project.Event_Managment;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

    //Optional<Event> findByEventId(Long eventId);
}