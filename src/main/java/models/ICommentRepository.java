package models;

import entities.Comment;

public interface ICommentRepository {

    void storeComment(Comment comment);
}
