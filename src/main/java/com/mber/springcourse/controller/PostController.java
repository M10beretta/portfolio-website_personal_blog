package com.mber.springcourse.controller;

import com.mber.springcourse.entity.post.Post;
import com.mber.springcourse.entity.post.PostRepository;
import com.mber.springcourse.entity.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostRepository repository;
    private final PostService service;

    @GetMapping("/blog")
    public String getAll(Model model) {
        model.addAttribute("posts", service.getAll());
        return "blog-main";
    }


    @PostMapping("/blog/add")
    public String add(@RequestParam String title,
                      @RequestParam String anons,
                      @RequestParam String text) {
        service.save(new Post(title, anons, text));
        return "redirect:/blog";
    }

    private boolean checkId(@PathVariable("id") long id, Model model) {
        if (!repository.existsById(id)) return true;

        return false;
    }


    @PostMapping("/blog/{id}/edit")
    public String blogPostUpdate(@PathVariable(value = "id") long id,
                                 @RequestParam String title,
                                 @RequestParam String anons,
                                 @RequestParam String full_text) {
        Post post = repository.findById(id).orElseThrow();
        post.setTitle(title);
        post.setAnons(anons);
        post.setText(full_text);
        repository.save(post);
        return "redirect:/blog";
    }

    @PostMapping("/blog/{id}/remove")
    public String blogPostRemove(@PathVariable(value = "id") long id) {
        Post post = repository.findById(id).orElseThrow();
        repository.delete(post);
        return "redirect:/blog";
    }
}
