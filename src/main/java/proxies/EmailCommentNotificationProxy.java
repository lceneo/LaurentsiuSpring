package proxies;

import entities.Comment;
import models.ICommentNotificationProxy;

public class EmailCommentNotificationProxy implements ICommentNotificationProxy {
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending notification for comment: "
                + comment.getText());
    }
}
