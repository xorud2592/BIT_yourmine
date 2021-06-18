package com.example.springboot.web;

import com.example.springboot.domain.posts.Posts;
import com.example.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "post/posts-save";
    }

    // Posts Searching
    @GetMapping("/posts/search")
    public String search(String keyword, Model model) {
        List<Posts> searchList = postsService.search(keyword);
        model.addAttribute("searchList", searchList);
        return "search/posts-search";
    }

    // Moving MyPage
    @GetMapping("/myPage")
    public String moveToMyPage() { return "mypage/move-mypage"; }
}
