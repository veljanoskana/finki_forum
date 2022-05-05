package mk.ukim.finki.finkihub.web;

import mk.ukim.finki.finkihub.models.Comment;
import mk.ukim.finki.finkihub.models.Student;
import mk.ukim.finki.finkihub.service.CommentService;
import mk.ukim.finki.finkihub.service.CourseService;
import mk.ukim.finki.finkihub.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/comments")
public class CommentsController {
    private final CommentService commentService;
    private final CourseService courseService;
    private final StudentService studentService;

    public CommentsController(CommentService commentService, CourseService courseService, StudentService studentService) {
        this.commentService = commentService;
        this.courseService = courseService;
        this.studentService = studentService;
    }

    @PostMapping("/add/{course}")
    public String saveComment(HttpServletRequest request,
                              @PathVariable Integer course) {
        Comment comment = new Comment(LocalDateTime.now(), request.getParameter("commentBody"));
        Student student = this.studentService.findById(Integer.parseInt(request.getRemoteUser())).get();
        comment.setAuthorName(student.getFullName());
        this.courseService.findById(course).get().getComments().add(comment);
        this.commentService.addComment(comment);
        return "redirect:/courses/details/{course}";
    }

    @GetMapping("/like/{id}/{course}")
    public String likeComment(@PathVariable Integer id,
                              @PathVariable Integer course) {
        Comment comment = this.commentService.findById(id);
        this.commentService.likeComment(comment);
        return "redirect:/courses/details/{course}";
    }

    @GetMapping("/dislike/{id}/{course}")
    public String dislikeComment(@PathVariable Integer id,
                                 @PathVariable Integer course) {
        Comment comment = this.commentService.findById(id);
        this.commentService.disLikeComment(comment);
        return "redirect:/courses/details/{course}";
    }
}
