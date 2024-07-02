package edu.miu.cs545.project.repository;

import edu.miu.cs545.project.model.entity.Rsvp;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RsvpRepo extends ListCrudRepository<Rsvp, Long> {
}
