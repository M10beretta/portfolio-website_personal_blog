package com.mber.springcourse.repo;

import com.mber.springcourse.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}

