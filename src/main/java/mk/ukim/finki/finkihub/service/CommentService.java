package mk.ukim.finki.finkihub.service;

import mk.ukim.finki.finkihub.models.Comment;

public interface CommentService {
    void addComment(Comment comment);

    Comment findById(Integer id);

    void likeComment(Comment comment);

    void disLikeComment(Comment comment);
}
