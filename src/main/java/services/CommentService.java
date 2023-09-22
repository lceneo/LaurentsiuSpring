package services;

import entities.Comment;
import models.ICommentNotificationProxy;
import models.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Qualifier("push")
public class CommentService {

    private final ICommentNotificationProxy commentNotificationProxy;

    private final ICommentRepository commentRepository;

    @Autowired
    public CommentService(ICommentRepository commentRepository,
                          @Qualifier("EMAIL") ICommentNotificationProxy commentNotificationProxy) {
        System.out.println("CommentService initialised");
        this.commentNotificationProxy = commentNotificationProxy;
        this.commentRepository = commentRepository;
    }

    public void publishComment(Comment comment) {
        this.commentRepository.storeComment(comment);
        this.commentNotificationProxy.sendComment(comment);
    }
}
