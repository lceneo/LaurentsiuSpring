package main;

import config.ProjectConfig;
import entities.Comment;
import models.ICommentNotificationProxy;
import models.ICommentRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repositories.DBCommentRepository;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    }
}
