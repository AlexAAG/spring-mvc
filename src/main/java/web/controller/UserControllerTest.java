//package web.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import web.model.User;
//import web.service.UserService;
//
//@Controller
//public class UserControllerTest {
//
//    private UserService userService;
//
//    @Autowired(required = true)
//    @Qualifier(value = "userService")
//    public void UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping(value = "users")       //страница users
//    public String listUsers(Model model) {
//        model.addAttribute("user", new User());         //обращаемся в html к user, чтобы получить new User();
//        model.addAttribute("listUsers", this.userService.listUsers());
//
//        return "users";       //папка web
//    }
//
////    @GetMapping("/users")
////    public String getCars(@RequestParam(required=false,value = "count") Integer count, Model model) {
////        model.addAttribute("cars", userService.getUserById(count));
////        return "cars";
////    }
//}
