package edu.miu.cs545.project.repository;

import edu.miu.cs545.project.model.entity.BasicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepo<T extends BasicEntity, ID> extends JpaRepository<T, ID> {
}
