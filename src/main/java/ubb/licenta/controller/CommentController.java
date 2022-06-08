package ubb.licenta.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ubb.licenta.entity.Comment;

import ubb.licenta.service.CommentService;


@RestController
@CrossOrigin // pt cand facem request de pe front end care ruleaza de pe alt port
@RequiredArgsConstructor
@RequestMapping(value = "/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping()
    public Integer insert(@RequestBody Comment comment) {
        Integer id = commentService.insert(comment);

        return id;
    }
}
