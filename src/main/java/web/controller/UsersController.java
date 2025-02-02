package web.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping(value = "/users")
public class UsersController {

    UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping()
    public String usersList(Model model){
        model.addAttribute("users",userService.listUsers());
        return "users";
    }
    @GetMapping(value = "/delete")
    public String delete(@RequestParam(value = "id") int id){
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping(value = "/new")
    public String newUser(Model model){
        model.addAttribute("user",new User());
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user){
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/update")
    public String updateGet(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "/update";
    }
    @PostMapping(value = "/update")
    public String updatePost(@ModelAttribute("user") User user){
        System.out.println(user.getEmail()+ " "+ user.getId() + " "+ user.getName()+" " + user.getLastName());
        userService.update(user);
        return "redirect:/users";
    }

}
