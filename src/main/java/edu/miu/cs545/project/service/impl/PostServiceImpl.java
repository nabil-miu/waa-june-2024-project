package edu.miu.cs545.project.service.impl;

import edu.miu.cs545.project.model.entity.Post;
import edu.miu.cs545.project.model.entity.ThreadPost;
import edu.miu.cs545.project.repository.PostRepository;
import edu.miu.cs545.project.repository.ThreadPostRepository;
import edu.miu.cs545.project.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Transactional
@Service
public class PostServiceImpl extends CrudServiceImpl<Post, Long> implements PostService {
    public PostServiceImpl(PostRepository postRepository) {
        super( postRepository);
    }

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ThreadPostRepository threadPostRepository;

    @Override
    public Post create(Post post) {
        //very first post
        if (post.getParentPost() != null && post.getParentPost().getId() == null) {
            // Ensure that the associated ThreadPost is saved
            if (post.getThreadPost() != null && post.getThreadPost().getId() == null) {
                ThreadPost newThread = threadPostRepository.save(post.getThreadPost());
                post.setThreadPost(newThread);
            }
            post.setParentPost(null);
        }
        return postRepository.save(post);
    }


    @Override
    public Page<Post> findParentPostByThread(Long id, Integer page, Integer size, String sortDirection) {
        try{
            Sort sort = Sort.by("id");
            sort = sortDirection.equalsIgnoreCase("asc") ? sort.ascending() : sort.descending();
            Pageable pageable = PageRequest.of(page,size,sort);
            Optional<ThreadPost> threadPostOpt = threadPostRepository.findById(id);
            if(threadPostOpt.isPresent())
                return postRepository.findByThreadPostAndParentPostIsNull(threadPostOpt.get(),pageable);

        }catch (Exception e){
        throw  new RuntimeException("Some thing happened in the server.");
    }

        return null;
    }

    @Override
    public Page<Post> findChildPostByParentPost(Long id, Integer page, Integer size, String sortDirection) {
        try{
            Sort sort = Sort.by("id");
            sort = sortDirection.equalsIgnoreCase("asc") ? sort.ascending() : sort.descending();
            Pageable pageable = PageRequest.of(page,size,sort);
            Optional<Post> postOpt = postRepository.findById(id);
            if(postOpt.isPresent())
                return postRepository.findByParentPost(postOpt.get(),pageable);

        }catch (Exception e){
            throw  new RuntimeException("Some thing happened in the server.");
        }

        return null;
    }

}
