package edu.miu.cs545.project.repository;

import edu.miu.cs545.project.model.entity.ExtracurricularActivity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtracurricularActivityRepo extends ListCrudRepository<ExtracurricularActivity, Long> {
}
