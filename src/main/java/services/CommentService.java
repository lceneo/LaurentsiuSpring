package services;

import entities.Comment;
import models.ICommentNotificationProxy;
import models.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import processors.CommentProcessor;

@Service
@Lazy
@Qualifier("push")
public class CommentService {

    private final ICommentNotificationProxy commentNotificationProxy;

    private final ICommentRepository commentRepository;

    private final ApplicationContext context;


    @Autowired
    public CommentService(ICommentRepository commentRepository,
                          @Qualifier("EMAIL") ICommentNotificationProxy commentNotificationProxy,
                          ApplicationContext context) {
        this.commentNotificationProxy = commentNotificationProxy;
        this.commentRepository = commentRepository;
        this.context = context;
    }

    public void publishComment(Comment comment) {
        this.commentRepository.storeComment(comment);
        this.commentNotificationProxy.sendComment(comment);
    }

    public void sendComment(Comment c) {
        var p = this.context.getBean(CommentProcessor.class);
        p.setComment(c);
        p.processComment(c);
        p.validateComment(c);
        c = p.getComment();
    }

    public ICommentRepository getCommentRepository() {
        return this.commentRepository;
    }
}

