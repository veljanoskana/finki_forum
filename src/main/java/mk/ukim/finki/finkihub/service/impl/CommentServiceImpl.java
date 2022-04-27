package mk.ukim.finki.finkihub.service.impl;

import mk.ukim.finki.finkihub.models.Comment;
import mk.ukim.finki.finkihub.repository.CommentRepository;
import mk.ukim.finki.finkihub.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void addComment(Comment comment) {
        this.commentRepository.save(comment);
    }
}
