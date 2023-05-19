package com.geekster.Instagram.controller;

import com.geekster.Instagram.model.InstagramComment;
import com.geekster.Instagram.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping()
    String addComment(@RequestBody InstagramComment comment)
    {
        return commentService.addComment(comment);
    }
}
