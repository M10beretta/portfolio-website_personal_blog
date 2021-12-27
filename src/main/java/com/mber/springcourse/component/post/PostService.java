package com.mber.springcourse.component.post;

import java.util.Optional;

public interface PostService {

    Optional<Post> getById(long id);

    Iterable<Post> getAll();

    void save(Post post);

    void deleteById(long id);

    boolean existById(long id);
}
