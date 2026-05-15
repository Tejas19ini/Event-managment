package com.Project.Event_Managment;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    Optional<Registration> findByUser_UserIdAndEvent_EventId(Long userId, Long eventId);

    List<Registration> findByUser_UserId(Long userId); 

}