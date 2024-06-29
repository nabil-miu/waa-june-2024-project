package edu.miu.cs545.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class CrudServiceImpl<T, ID> implements CrudService<T, ID> {

    private final ListCrudRepository<T, ID> repository;

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<T> getById(ID id) {
        return repository.findById(id);
    }

    @Override
    public T create(T entity) {
        return repository.save(entity);
    }

    @Override
    public T update(ID id, T entity) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Resource not found with id: " + id);
        }
        return repository.save(entity);
    }

    @Override
    public void delete(ID id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsById(ID id) {
        return repository.existsById(id);
    }
}
