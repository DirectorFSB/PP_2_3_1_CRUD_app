package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    void add(User user);

    List<User> listUsers();

    void update(User user);

    void delete(int id);

    User getUserById(int id);
}
