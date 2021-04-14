package web;

import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.service.UserService;
import web.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
//        UserService userService = new UserServiceImpl(userDao);
//        userService.listUsers();
//        System.out.println("22");

        UserDao userDao = new UserDaoImpl();
        //userDao.listUsers();
        System.out.println(userDao.getAllUsers());
        System.out.println("33");
    }
}
