package edu.miu.cs545.project.service;

import edu.miu.cs545.project.model.entity.BasicEntity;

import java.util.List;
import java.util.Optional;

public interface CrudService<T extends BasicEntity, ID> {

    List<T> getAll();

    Optional<T> getById(ID id);

    T create(T entity);

    T update(ID id, T entity);

    void delete(ID id);

    boolean existsById(ID id);

    void softDelete(ID id);
}
