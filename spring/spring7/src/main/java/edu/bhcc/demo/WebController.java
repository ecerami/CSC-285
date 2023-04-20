package edu.bhcc.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {
    private UserRepository userRepo;
    private CommentRepository commentRepo;

    /**
     * Create Budget Controller.
     */
    public WebController(UserRepository userRepo,
                         CommentRepository commentRepo) {
        this.userRepo = userRepo;
        this.commentRepo = commentRepo;
    }

    @GetMapping("/")
    public String index(Model model) {
        addUsersAndComments(model);
        return "index";
    }

    @GetMapping("/add_user")
    public String addUser(String first, String last, String userName, Model model) {
        User user = new User(first, last, userName);
        userRepo.save(user);
        model.addAttribute("toast", "New user added:  " + userName);
        addUsersAndComments(model);
        return "index";
    }

    @GetMapping("/add_comment")
    public String addComment(String userName, String comment, Model model) {
        User user = userRepo.findByUserName(userName);
        if (user != null) {
            Comment newComment = new Comment(user, comment);
            commentRepo.save(newComment);
            model.addAttribute("toast", "New comment saved.");
        } else {
            model.addAttribute("toast", "Could not find user:  " + userName);
        }
        addUsersAndComments(model);
        return "index";
    }

    @GetMapping("/delete_user")
    public String deleteUser(Long id, Model model) {
        User user = userRepo.findByUserId(id);
        if (user != null) {
            userRepo.delete(user);
            model.addAttribute("toast", "Deleted user:  " + user.getUserName());
        } else {
            model.addAttribute("toast", "Could not find user ID:  " + id);
        }
        addUsersAndComments(model);
        return "index";
    }

    @GetMapping("/delete_comment")
    public String deleteComment(Long id, Model model) {
        Comment comment = commentRepo.findByCommentId(id);
        if (comment != null) {
            commentRepo.delete(comment);
            model.addAttribute("toast", "Deleted comment");
        } else {
            model.addAttribute("toast", "Could not find comment ID:  " + id);
        }
        addUsersAndComments(model);
        return "index";
    }

    private void addUsersAndComments(Model model) {
        List<User> userList = getAllUsers();
        List<Comment> commentList = getAllComments();
        model.addAttribute("user_list", userList);
        model.addAttribute("comment_list", commentList);
    }

    private List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        for (User currentUser: userRepo.findAll()) {
            userList.add((currentUser));
        }
        return userList;
    }

    private List<Comment> getAllComments() {
        List<Comment> commentList = new ArrayList<>();
        for (Comment currentComment : commentRepo.findAll()) {
            commentList.add((currentComment));
        }
        return commentList;
    }
}