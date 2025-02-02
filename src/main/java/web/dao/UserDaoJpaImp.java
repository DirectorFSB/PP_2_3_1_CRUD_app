package web.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import web.model.User;

import java.util.List;

@Repository
public class UserDaoJpaImp implements UserDao{


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override

    public List<User> listUsers() {
        return entityManager.createQuery("select u from User u ",User.class).getResultList();
    }

    @Override
    public void update(User user) {
        String query = "update User u set name = :name , lastName = :lastname , email = :email where id = :id";
        entityManager.createQuery(query).setParameter("name" , user.getName()).setParameter("lastname",user.getLastName()).setParameter("email",user.getEmail()).setParameter("id",user.getId()).executeUpdate();
    }

    @Override
    public void delete(int id) {
        String query = "delete from User where id = :id";
        entityManager.createQuery(query).setParameter("id",id).executeUpdate();
    }
    @Override
    public User getUserById(int id){
        return (User) entityManager.createQuery("select u from User u where id = :id").setParameter("id" ,id).getSingleResult();
    }
}
