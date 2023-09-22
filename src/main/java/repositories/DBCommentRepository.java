package repositories;

import entities.Comment;
import models.ICommentRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DBCommentRepository implements ICommentRepository {

    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing comment: " + comment.getText());
    }
}
