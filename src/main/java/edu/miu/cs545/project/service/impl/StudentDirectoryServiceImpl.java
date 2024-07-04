package edu.miu.cs545.project.service.impl;

import edu.miu.cs545.project.model.entity.StudentDirectory;
import edu.miu.cs545.project.repository.StudentDirectoryRepo;
import edu.miu.cs545.project.service.StudentDirectoryService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentDirectoryServiceImpl extends CrudServiceImpl<StudentDirectory, Long> implements StudentDirectoryService {
    private final StudentDirectoryRepo repository;
    @PersistenceContext
    private EntityManager em;

    public StudentDirectoryServiceImpl(StudentDirectoryRepo repository) {
        super(repository);
        this.repository = repository;
    }

    public List<StudentDirectory> findByAcademicYearAndMajorAndOtherFilters(LocalDate academicYear, String major, String otherFilter) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<StudentDirectory> cq = cb.createQuery(StudentDirectory.class);

        Root<StudentDirectory> studentDirectory = cq.from(StudentDirectory.class);
        List<Predicate> predicates = new ArrayList<>();

        if (academicYear != null) {
            predicates.add(cb.equal(studentDirectory.get("academicYear"), academicYear));
        }
        if (major != null && !major.isEmpty()) {
            predicates.add(cb.equal(cb.lower(studentDirectory.get("major")), major.toLowerCase()));
        }
        if (otherFilter != null && !otherFilter.isEmpty()) {
            predicates.add(cb.like(cb.lower(studentDirectory.get("contactInformation")), "%" + otherFilter.toLowerCase() + "%"));
        }

        cq.where(predicates.toArray(new Predicate[0]));

        TypedQuery<StudentDirectory> query = em.createQuery(cq);
        return query.getResultList();
    }
    public Page<StudentDirectory> getStudentDirectoryByPage(int pageNumber, int pageSize) {
        PageRequest request = PageRequest.of(pageNumber,pageSize);
        Page<StudentDirectory> pages =  repository.findAll(request);
        return pages;
    }
}
