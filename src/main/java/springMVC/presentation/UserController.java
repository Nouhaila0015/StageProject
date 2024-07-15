package springMVC.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import springMVC.dao.entities.User;
import springMVC.service.IService.IServiceUser;

@Controller
public class UserController {
    @Autowired
    private IServiceUser serviceUser;

    @GetMapping("/user/{username}")
    public String showUser(@PathVariable("username") String username, Model model) {
        try {
            User user = serviceUser.rechercherParId(username);
            model.addAttribute("user", user);
            return "detail";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
    }
}