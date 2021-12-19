package com.mber.springcourse.entity.post;

import java.util.Optional;

public interface PostService {

    Iterable<Post> getAll();

    Optional<Post> getById(long id);

    void save(Post post);

    boolean notExistById(long id);
}
