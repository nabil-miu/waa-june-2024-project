package edu.miu.cs545.project.service.impl;

import edu.miu.cs545.project.model.entity.ExtracurricularActivity;
import edu.miu.cs545.project.repository.ExtracurricularActivityRepo;
import edu.miu.cs545.project.service.ExtracurricularActivityService;
import org.springframework.stereotype.Service;

@Service

public class ExtracurricularActivityServiceImpl extends CrudServiceImpl<ExtracurricularActivity, Long> implements ExtracurricularActivityService {
    public ExtracurricularActivityServiceImpl(ExtracurricularActivityRepo repository) {
        super(repository);
    }
}
