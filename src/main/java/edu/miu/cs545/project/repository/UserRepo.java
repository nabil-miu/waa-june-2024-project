package edu.miu.cs545.project.repository;

import edu.miu.cs545.project.model.entity.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface UserRepo extends ListCrudRepository<User, Long>, PagingAndSortingRepository<User,Long> {
   // List<User> findAll(Pageable page);
}
