package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService{

    UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override

    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
    @Transactional(readOnly = true)
    public User getUserById(int id){
        return userDao.getUserById(id);
    }
}
