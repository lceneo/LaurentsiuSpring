package main;

import config.ProjectConfig;
import entities.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

import java.util.logging.Logger;

public class Main {

    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var service = context.getBean(CommentService.class);
        var comment = new Comment();
        comment.setText("Demo comment");
        comment.setAuthor("Natasha");

        var result = service.publishComment(comment);
        logger.info(result);
    }
}
