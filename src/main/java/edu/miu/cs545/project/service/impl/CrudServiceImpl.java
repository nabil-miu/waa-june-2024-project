package edu.miu.cs545.project.service.impl;

import edu.miu.cs545.project.model.entity.BasicEntity;
import edu.miu.cs545.project.repository.GenericRepo;
import edu.miu.cs545.project.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public abstract class CrudServiceImpl<T extends BasicEntity, ID> implements CrudService<T, ID> {

    private final GenericRepo<T, ID> repository;

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

    @Transactional
    @Override
    public void softDelete(ID id) {
        Optional<T> optionalT = repository.findById(id);
        if (optionalT.isPresent()) {
            T resource = optionalT.get();
            resource.softDelete();
            repository.save(resource);
        } else {
            throw new RuntimeException("AcademicResource not found with id: " + id);
        }
    }
}
