package repositories;

import entities.Comment;
import models.ICommentRepository;

public class DBCommentRepository implements ICommentRepository {

    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing comment: " + comment.getText());
    }
}
