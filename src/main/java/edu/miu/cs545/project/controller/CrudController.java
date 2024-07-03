package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.service.CrudService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.lang.reflect.Method;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class CrudController<T, ID> {

    private final CrudService<T, ID> crudService;

    @GetMapping("/all")
    public ResponseEntity<List<T>> getAll() {
        List<T> entities = crudService.getAll();
        return ResponseEntity.ok().body(entities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable ID id) {
        Optional<T> optionalEntity = crudService.getById(id);
        return optionalEntity.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody T entity) {
        crudService.create(entity);
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(getId(entity))
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable ID id, @Valid @RequestBody T entity) {
        crudService.update(id, entity);
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        if (!crudService.existsById(id)) {
            System.out.println("Not found");
            return ResponseEntity.notFound().build();
        }
        crudService.delete(id);
        return ResponseEntity.noContent().build();
    }

    private Long getId(T entity) {
        try {
            Method getIdMethod = entity.getClass().getMethod("getId");
            return (Long) getIdMethod.invoke(entity);
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to get ID from entity", e);
        }
    }

}
