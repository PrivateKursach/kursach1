package by.bsuir.nesenchuk.dao.impl;

import by.bsuir.nesenchuk.dao.UserDAO;
import by.bsuir.nesenchuk.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User createUser(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User getUserByEmail(String email) {
        List<User> userList = entityManager.createQuery("select u from User u where u.email = :email", User.class).setParameter("email", email).getResultList();
        return userList.isEmpty() ? null : userList.get(0);
    }
}
