package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.model.Tag;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment createComment(Comment comment) {
        System.out.println("GOOOOO createTag tagService");
        return commentRepository.createComment(comment);
    }

    public Comment getComment(Comment comment) {
        System.out.println("GOOOOO gettabbyname tagService");
        return commentRepository.findComment(comment);
    }
}
