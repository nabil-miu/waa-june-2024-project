package edu.miu.cs545.project.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, ID> {
    List<T> getAll();

    Optional<T> getById(ID id);

    T create(T entity);

    T update(ID id, T entity);

    void delete(ID id);

    boolean existsById(ID id);
}
