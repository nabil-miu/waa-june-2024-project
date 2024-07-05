package edu.miu.cs545.project.controller;

import edu.miu.cs545.project.aop.LogExecutionTime;
import edu.miu.cs545.project.model.entity.BasicEntity;
import edu.miu.cs545.project.service.CrudService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.lang.reflect.Method;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public abstract class CrudController<T extends BasicEntity, ID> {

    private final String GET_ALL = "getAll";
    private final String GET_BY_ID = "getById";
    private final String CREATE = "create";
    private final String UPDATE = "update";
    private final String DELETE = "delete";
    private final String METHOD = "method";
    private final String CLAZZ = getClass().getSimpleName();

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private Counter counterGetAll;
    private Counter counterGetById;
    private Counter counterCreate;
    private Counter counterUpdate;
    private Counter counterDelete;

    private CrudService<T, ID> crudService;
    private MeterRegistry registry;

    public CrudController(CrudService crudService, MeterRegistry registry) {
        this.crudService = crudService;
        this.counterGetAll = registry.counter(CLAZZ, METHOD, GET_ALL);
        this.counterGetById = registry.counter(CLAZZ, METHOD, GET_BY_ID);
        this.counterCreate = registry.counter(CLAZZ, METHOD, CREATE);
        this.counterUpdate = registry.counter(CLAZZ, METHOD, UPDATE);
        this.counterDelete = registry.counter(CLAZZ, METHOD, DELETE);
    }

    @LogExecutionTime
    @GetMapping("/all")
    public ResponseEntity<List<T>> getAll() throws NoSuchMethodException {
        counterGetAll.increment();
        //callLogger(CLAZZ, getClass().getMethod(GET_ALL, null));
        List<T> entities = crudService.getAll();
        return ResponseEntity.ok().body(entities);
    }

    @LogExecutionTime
    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable ID id) throws NoSuchMethodException {
        counterGetById.increment();
        //callLogger(CLAZZ, getClass().getMethod(GET_BY_ID, Long.class));
        Optional<T> optionalEntity = crudService.getById(id);
        return optionalEntity.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @LogExecutionTime
    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody T entity) throws NoSuchMethodException {
        counterCreate.increment();
        //callLogger(CLAZZ, getClass().getMethod(CREATE, Object.class));
        crudService.create(entity);
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(getId(entity))
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @LogExecutionTime
    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable ID id, @Valid @RequestBody T entity) throws NoSuchMethodException {
        counterUpdate.increment();
        //callLogger(CLAZZ, getClass().getMethod(UPDATE, Long.class, Object.class));
        T newEntity = crudService.update(id, entity);
        return ResponseEntity.ok(newEntity);
    }

    @LogExecutionTime
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) throws NoSuchMethodException {
        counterDelete.increment();
        //callLogger(CLAZZ, getClass().getMethod(DELETE, Long.class));
        if (!crudService.existsById(id)) {
            logger.error("Not found {}", id);
            return ResponseEntity.notFound().build();
        }
        crudService.softDelete(id);
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

//    private void callLogger(String className, Method method) {
//        logger.debug("Logging message within class: {}, method: {}", className,
//                method.getName());
//    }
}
