package web;

import web.dao.CarDao;
import web.dao.CarDaoImpl;
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
        System.out.println(userDao.listUsers());
        System.out.println("44");

        CarDao carDao = new CarDaoImpl();
        System.out.println(carDao.getCars(3));

        userDao.getUserById(1);
        System.out.println("getUserById"+userDao.getUserById(1));
        userDao.getUserById(1).getName();
        System.out.println(userDao.getUserById(1).getName());
    }
}
