package com.hairgely.timeline.newsfeed.repository;


import com.hairgely.timeline.entity.Person;
import com.hairgely.timeline.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Map;

public interface NewsfeedDslRepository {
    public List<Person> findNewsfeedById(long id);

}