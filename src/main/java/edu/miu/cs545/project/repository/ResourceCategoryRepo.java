package edu.miu.cs545.project.repository;

import edu.miu.cs545.project.model.entity.ResourceCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceCategoryRepo extends GenericRepo<ResourceCategory, Long> {

    List<ResourceCategory> findByParentIsNull();

}
