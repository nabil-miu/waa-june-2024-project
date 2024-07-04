package edu.miu.cs545.project.repository;

import edu.miu.cs545.project.model.entity.Interest;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestRepo extends GenericRepo<Interest, Long> {
}
