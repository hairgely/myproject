package com.hairgely.timeline.post.service;

import com.hairgely.timeline.domain.Post;
import com.hairgely.timeline.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService{

    @Autowired
    private PostRepository postRepository;

    public Post save(Post post) {
        return postRepository.save(post);
    }
}
