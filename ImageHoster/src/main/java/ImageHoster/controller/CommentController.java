package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Controller
public class CommentController {
    @Autowired
    private ImageService imageService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/image/{imageId}/{imageTitle}/comments", method = RequestMethod.POST)
    /* Add comment to comment repo */
    public String addImageComment(@PathVariable("imageId") Integer id, @PathVariable("imageTitle") String title, @RequestParam("comment") String comment, Model model, HttpSession session) throws IOException {
        Image image = imageService.getImage(id);
        User user = (User) session.getAttribute("loggeduser");
        Comment newComment = new Comment();

        newComment.setCreatedDate(LocalDate.now());
        newComment.setUser(user);
        newComment.setImage(image);
        newComment.setText(comment);
        commentService.createComment(newComment);
        image.setComments(commentService.getCommentsById(id));

        return "redirect:/images/{imageId}/{imageTitle}";
    }
}
