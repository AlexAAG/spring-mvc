//package web.dao;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
//import org.springframework.stereotype.Component;
//import web.model.User;
//import web.util.Util;
//
//import java.util.List;
//
//@Component
//public class UserDaoImpl2 implements UserDao{
//
//    private SessionFactory sessionFactory = Util.getSessionFactory();
//
//    //15-04 14:49
////    public void setSessionFactory(SessionFactory sessionFactory) {
////        this.sessionFactory = sessionFactory;
////    }
//
//    @Override
//    public List<User> listUsers() {
//        List<User> userList;
//
//        Session session = sessionFactory.openSession();
//        Query query = session.createQuery("FROM User");
//        userList = query.list();
//
//        return userList;
//    }
//
//    @Override
//    public void addUser(User user) {
//        Session session = this.sessionFactory.getCurrentSession();
//
//        session.beginTransaction();
//
//        session.persist(user);
//        System.out.println("Пользователь добавлен: "+user);
//
//        session.getTransaction().commit();
//        session.close();
//    }
//
//    @Override
//    public void updateUser(User user) {
//        Session session = this.sessionFactory.getCurrentSession();
//
//        session.beginTransaction();
//
//        session.update(user);
//        System.out.println("Пользователь обновлен: "+user);
//
//        session.getTransaction().commit();
//        session.close();
//    }
//
//    @Override
//    public void removeUser(int id) {
//        Session session = this.sessionFactory.getCurrentSession();
//
//        session.beginTransaction();
//
//        User user = (User) session.load(User.class, new Integer(id));
//
//        if(user != null) {
//            session.delete(user);
//        }
//        System.out.println("Пользователь удален: "+user);
//
//        session.getTransaction().commit();
//        session.close();
//    }
//
//    @Override
//    public User getUserById(int id) {
//        Session session = this.sessionFactory.getCurrentSession();
//
//        session.beginTransaction();
//
//        User user = (User) session.load(User.class, new Integer(id));
//        System.out.println("Пользователь выбран: "+user);
//
//        session.getTransaction().commit();
//        session.close();
//
//        return user;
//    }
//
//    //15-04
////    @Override
////    //Generic. действительно будет legal во время выполнения.
////    @SuppressWarnings("unchecked")
////    public List<User> listUsers() {
////        Session session = this.sessionFactory.openSession();
////        List<User> userList = session.createQuery("From User").list();
////        session.beginTransaction();
////
////        for(User user : userList) {
////            System.out.println("Список пользователей: "+user);
////        }
////
////        return userList;
////    }
//
//    //del
//    @Override
//    public List<User> getAllUsers() {
//        List<User> userList;
//
//        Session session = sessionFactory.openSession();
//        Query query = session.createQuery("FROM User");
//        userList = query.list();
//
//        return userList;
//    }
//    //<del
//
//    //work14-04 15:45
////    @Override
////    public List<User> listUsers() {
////
////        List<User> listCar = new ArrayList<>();
////
////        listCar.add(new User(1, "Alex1", "manager1", 111));
////
////        return listCar;
////    }
//}
