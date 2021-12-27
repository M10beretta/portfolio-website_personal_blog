package com.mber.springcourse.controller;

import com.mber.springcourse.component.post.Post;
import com.mber.springcourse.component.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostService service;

    @GetMapping("/post/{id}")
    public String onPostView(@PathVariable(value = "id") long id, Model model) {
        if (service.existById(id)) {
            Post post = service.getById(id).stream().findFirst().orElseThrow();
            model.addAttribute("post", post);
            return "post_view";
        }
        return "redirect:/posts";
    }


    @PostMapping("/post/add")
    public String addPost(@RequestParam String title,
                          @RequestParam String anons,
                          @RequestParam String text) {
        service.save(Post.builder().title(title).anons(anons).text(text).build());
        return "redirect:/posts";
    }


    @PostMapping("/post/{id}/edit")
    public String editPost(@PathVariable(value = "id") long id,
                           @RequestParam String title,
                           @RequestParam String anons,
                           @RequestParam String text) {
        Post post = service.getById(id).orElseThrow();
        post.setTitle(title);
        post.setAnons(anons);
        post.setText(text);
        service.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/post/{id}/remove")
    public String removePost(@PathVariable(value = "id") long id) {
        service.deleteById(id);
        return "redirect:/posts";
    }
}
