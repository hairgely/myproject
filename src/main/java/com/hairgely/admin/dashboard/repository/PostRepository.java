package com.hairgely.admin.dashboard.repository;


import com.hairgely.admin.dashboard.domain.PostEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<PostEntity, Long> {
	List<PostEntity> findByTitle(String title);
}
