package mk.ukim.finki.finkihub.web;

import mk.ukim.finki.finkihub.models.Comment;
import mk.ukim.finki.finkihub.models.Course;
import mk.ukim.finki.finkihub.models.Student;
import mk.ukim.finki.finkihub.service.CommentService;
import mk.ukim.finki.finkihub.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/comments")
public class CommentsController {
    private final CommentService commentService;
    private final CourseService courseService;

    public CommentsController(CommentService commentService, CourseService courseService) {
        this.commentService = commentService;
        this.courseService = courseService;
    }

    @PostMapping("/add")
    public String saveComment(@RequestParam Course course,
                              @RequestParam String commentBody) {
        Comment comment = new Comment(new Student(), LocalDateTime.now(), commentBody);
        this.commentService.addComment(comment);
        return "redirect:/courses/details/{id}";
    }
}
