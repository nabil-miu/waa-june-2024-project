package edu.miu.cs545.project.repository;

import edu.miu.cs545.project.model.entity.Event;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepo extends GenericRepo<Event, Long> {
}
