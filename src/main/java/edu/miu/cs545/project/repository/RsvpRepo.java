package edu.miu.cs545.project.repository;

import edu.miu.cs545.project.model.entity.Event;
import edu.miu.cs545.project.model.entity.Rsvp;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RsvpRepo extends ListCrudRepository<Rsvp, Long> {

    List<Rsvp> getRsvpsByEvent(Event event);

}
