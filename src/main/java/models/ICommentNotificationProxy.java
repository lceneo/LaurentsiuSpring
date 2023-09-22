package models;

import entities.Comment;

public interface ICommentNotificationProxy {
    void sendComment(Comment comment);
}
