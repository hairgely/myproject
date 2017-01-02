package com.hairgely.timeline.newsfeed.service;

import com.hairgely.timeline.entity.Person;
import com.hairgely.timeline.entity.Post;
import com.hairgely.timeline.newsfeed.repository.NewsfeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsfeedService {

    @Autowired
    private NewsfeedRepository newsfeedRepository;

    public List<Post> findPostById(long id) {
        return newsfeedRepository.findPostById(id);
    }
}
