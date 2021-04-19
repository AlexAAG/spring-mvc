package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.CarService;
import web.service.UserService;

@Controller
@RequestMapping("/users")       //подпапка всех контроллеров класса
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //выводим всех юзеров
    @GetMapping()               //пустой, тк подпапка всех контроллеров и есть лист юзеров
    public String listUsers(Model model) {      //Model используется, тк передается на представление
        model.addAttribute("users", userService.listUsers());
        return "users";
    }

    //получаем одного юзера
    @GetMapping("/{id}")        //подставляется переменная id
    public String show(@PathVariable("id") int id, Model model) {   //достаем из URI значение id
        model.addAttribute("user", userService.getUserById(id));
        return "show";
    }

    //создаем нового юзера через форму
    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User()); //юзеру передаются пустые поля, которые мы заполняем POST
        return "new";
    }

    @PostMapping()
    //получить данные из формы + создать нового человека + добавить в бд
    public String createUser(@ModelAttribute("user") User user) {   //сюда попадают данные из формы
        userService.addUser(user);
        return "redirect:/users";           //перейдем на users
    }

    //редактирование юзера
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));    //чтобы в полях уже были значения
        return "edit";
    }

    //update
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    //delete без отдельной страницы
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.removeUser(id);
        return "redirect:/users";
    }
}
