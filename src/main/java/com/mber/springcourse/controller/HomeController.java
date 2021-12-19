package com.mber.springcourse.controller;

import com.mber.springcourse.entity.post.Post;
import com.mber.springcourse.entity.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final PostService postService;

    @GetMapping("/")
    public String onHomePage(Model model) {
        model.addAttribute("title", "Home page");
        return "home";
    }

    @GetMapping("/blog/add")
    public String onBlogAddPage(Model model) {
        return "blog_add";
    }


    @GetMapping("/blog/{id}")
    public String onBlogDetailsPage(@PathVariable(value = "id") long id, Model model) {
        if (postService.notExistById(id)) {
            Optional<Post> post = postService.getById(id);
            ArrayList<Post> res = new ArrayList<>();
            post.ifPresent(res::add);
            model.addAttribute("post", res);
            return "redirect:/blog";
        }
        return "blog-details";
    }


    @GetMapping("/blog/{id}/edit")
    public String onBlogEditPage(@PathVariable(value = "id") long id, Model model) {
        if (postService.notExistById(id)) {
            Optional<Post> post = postService.getById(id);
            ArrayList<Post> res = new ArrayList<>();
            post.ifPresent(res::add);
            model.addAttribute("post", res);
            return "redirect:/blog";
        }
        return "blog-edit";
    }



}


