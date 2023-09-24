package processors;

import entities.Comment;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentProcessor {
    private Comment comment;
    public void setComment(Comment comment) {
        this.comment = comment;
    }
    public Comment getComment() {
        return this.comment;
    }
    public void processComment(Comment comment) {
        // изменение атрибута comment
    }
    public void validateComment(Comment comment) {
        // валидация и изменение атрибута comment
    }
}