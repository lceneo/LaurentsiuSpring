package services;

import entities.Comment;
import models.ICommentNotificationProxy;
import models.ICommentRepository;

public class CommentService {

    private final ICommentNotificationProxy commentNotificationProxy;

    private final ICommentRepository commentRepository;

    public CommentService(ICommentRepository commentRepository, ICommentNotificationProxy commentNotificationProxy) {
        this.commentNotificationProxy = commentNotificationProxy;
        this.commentRepository = commentRepository;
    }

    public void publishComment(Comment comment) {
        this.commentRepository.storeComment(comment);
        this.commentNotificationProxy.sendComment(comment);
    }
}
