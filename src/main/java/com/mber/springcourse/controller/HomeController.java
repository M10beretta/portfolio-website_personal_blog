package com.mber.springcourse.controller;

import com.mber.springcourse.component.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final PostService service;

    @GetMapping("/")
    public String onHome() {
        return "home";
    }

    @GetMapping("/posts")
    public String onPostAll(Model model) {
        model.addAttribute("posts", service.getAll());
        return "post_all";
    }

    @GetMapping("/post/add")
    public String onPostAdd() {
        return "post_add";
    }
//
//
//    @GetMapping("/blog/{id}")
//    public String onBlogDetailsPage(@PathVariable(value = "id") long id, Model model) {
//        if (service.notExistById(id)) {
//            Optional<Post> post = service.getById(id);
//            ArrayList<Post> res = new ArrayList<>();
//            post.ifPresent(res::add);
//            model.addAttribute("post", res);
//            return "redirect:/blog";
//        }
//        return "blog-details";
//    }
//
//
//    @GetMapping("/blog/{id}/edit")
//    public String onBlogEditPage(@PathVariable(value = "id") long id, Model model) {
//        if (service.notExistById(id)) {
//            Optional<Post> post = service.getById(id);
//            ArrayList<Post> res = new ArrayList<>();
//            post.ifPresent(res::add);
//            model.addAttribute("post", res);
//            return "redirect:/blog";
//        }
//        return "blog-edit";
//    }



}


