package edu.miu.cs545.project.service.impl;

import edu.miu.cs545.project.model.entity.ThreadPost;
import edu.miu.cs545.project.repository.ThreadPostRepository;
import edu.miu.cs545.project.service.ThreadPostService;
import org.springframework.stereotype.Service;

@Service
public class ThreadPostServiceImpl extends CrudServiceImpl<ThreadPost,Long> implements ThreadPostService {
      public ThreadPostServiceImpl(ThreadPostRepository threadPostRepository){
          super(threadPostRepository);
      }
}
