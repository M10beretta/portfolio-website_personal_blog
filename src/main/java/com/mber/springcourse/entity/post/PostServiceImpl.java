package com.mber.springcourse.entity.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{
    private final PostRepository repository;

    @Override
    public Optional<Post> getById(long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Post> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(Post post) {
        repository.save(post);
    }

    @Override
    public boolean notExistById(long id) {
        return !repository.existsById(id);
    }

}
