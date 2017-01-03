package com.hairgely.timeline.newsfeed.service;

import com.hairgely.timeline.entity.Person;
import com.hairgely.timeline.newsfeed.repository.NewsfeedDslRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsfeedService {

    @Autowired
    private NewsfeedDslRepository newsfeedRepository;

    public List<Person> findNewsfeedById(long id) {
        return newsfeedRepository.findNewsfeedById(id);
    }
}
