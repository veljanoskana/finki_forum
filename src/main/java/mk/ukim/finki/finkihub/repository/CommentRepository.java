package mk.ukim.finki.finkihub.repository;

import mk.ukim.finki.finkihub.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
