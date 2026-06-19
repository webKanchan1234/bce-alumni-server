package com.bce.event.repository;
import com.bce.event.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EventRepository
        extends JpaRepository<Event, Long> {

    List<Event> findByFeaturedTrue();
}
