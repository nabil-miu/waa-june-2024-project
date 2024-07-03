package edu.miu.cs545.project.service.impl;

import edu.miu.cs545.project.model.entity.ThreadPost;
import edu.miu.cs545.project.repository.ThreadPostRepository;
import edu.miu.cs545.project.service.ThreadPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ThreadPostServiceImpl extends CrudServiceImpl<ThreadPost,Long> implements ThreadPostService {
      public ThreadPostServiceImpl(ThreadPostRepository threadPostRepository){
          super(threadPostRepository);
      }

      @Autowired
      private ThreadPostRepository threadPostRepository;

    @Override
    public Page<ThreadPost> findAllThread(Integer page, Integer size, String sortDirection) {
        try{
            Sort sort = Sort.by("id");
            sort = sortDirection.equalsIgnoreCase("asc") ? sort.ascending() : sort.descending();
            Pageable pageable = PageRequest.of(page,size,sort);
            return threadPostRepository.findAll(pageable);

        }catch (Exception e){
            throw  new RuntimeException("Some thing happened in the server.");
        }
    }
}
