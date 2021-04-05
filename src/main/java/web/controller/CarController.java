package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.dao.CarDao;

@Controller
public class CarController {

    @Autowired
    private CarDao carDao;
//1
    @GetMapping("/cars")
    public String getCars(@RequestParam(required=false,value = "count") Integer count, Model model) {
        model.addAttribute("cars", carDao.getCars(count));
        return "cars";
    }
}