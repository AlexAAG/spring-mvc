package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.model.Car;
import web.model.User;
import web.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDaoImpl implements UserDao{

    private SessionFactory sessionFactory = Util.getSessionFactory();

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
        System.out.println("Пользователь добавлен: "+user);
    }

    @Override
    public void updateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        System.out.println("Пользователь обновлен: "+user);
    }

    @Override
    public void removeUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));

        if(user != null) {
            session.delete(user);
        }
        System.out.println("Пользователь удален: "+user);
    }

    @Override
    public User getUserById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        System.out.println("Пользователь выбран: "+user);

        return user;
    }

    @Override
    //Generic. действительно будет legal во время выполнения.
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        Session session = this.sessionFactory.openSession();
        List<User> userList = session.createQuery("From User").list();
        session.beginTransaction();

        for(User user : userList) {
            System.out.println("Список пользователей: "+user);
        }

        return userList;
    }

    //del
    @Override
    public List<User> getAllUsers() {
        List<User> userList;

        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM User");
        userList = query.list();

        return userList;
    }
    //<del

    //work14-04 15:45
//    @Override
//    public List<User> listUsers() {
//
//        List<User> listCar = new ArrayList<>();
//
//        listCar.add(new User(1, "Alex1", "manager1", 111));
//
//        return listCar;
//    }
}
