package com.hairgely.timeline.mytimeline.service;

import com.hairgely.timeline.domain.Post;
import com.hairgely.timeline.mytimeline.repository.MyTimelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class MyTimelineService {

    @Autowired
    private MyTimelineRepository myTimelineRepository;

    public Page<Post> getAllPost(Integer page, Integer size) {
        return myTimelineRepository.findAll(new PageRequest(page, size));
    }
}
