package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.lang.reflect.Method;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class CrudController<T, ID> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final CrudService<T, ID> crudService;

    @GetMapping("/all")
    public ResponseEntity<List<T>> getAll() throws NoSuchMethodException {
        callLogger(getClass().getSimpleName(), getClass().getMethod("getAll", null));
        List<T> entities = crudService.getAll();
        return ResponseEntity.ok().body(entities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable ID id) throws NoSuchMethodException {
        callLogger(getClass().toString(), getClass().getMethod("getById", Object.class));
        Optional<T> optionalEntity = crudService.getById(id);
        return optionalEntity.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody T entity) throws NoSuchMethodException {
        callLogger(getClass().getSimpleName(), getClass().getMethod("create", null));
        crudService.create(entity);
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(getId(entity))
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable ID id, @RequestBody T entity) throws NoSuchMethodException {
        callLogger(getClass().getSimpleName(), getClass().getMethod("update", null));
        crudService.update(id, entity);
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) throws NoSuchMethodException {
        callLogger(getClass().getSimpleName(), getClass().getMethod("delete", null));
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

    private void callLogger(String className, Method method) {
        logger.debug("Logging message within class: {}, method: {}", className,
                method.getName());
    }
}
