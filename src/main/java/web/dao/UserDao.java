package web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import web.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    void addUser(User user);

    void updateUser(User user);

    void removeUser(int id);

    User getUserById(int id);

    List<User> listUsers();

}
