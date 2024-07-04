package edu.miu.cs545.project.repository;

import edu.miu.cs545.project.model.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends GenericRepo<User, Long> {
}
