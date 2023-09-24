package services;

import models.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final ICommentRepository commentRepository;

    @Autowired
    public UserService(ICommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public ICommentRepository getCommentRepository() {
        return this.commentRepository;
    }
}
