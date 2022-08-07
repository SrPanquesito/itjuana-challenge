package com.itjuana.challenge.dao;

import com.itjuana.challenge.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getAll() {
        String query = "FROM User";
        return entityManager.createQuery(query).getResultList();
    };

    @Override
    public void create(User user) {
        entityManager.merge(user);
    };

    @Override
    public void update(User user) {
        User existingUser = entityManager.find(User.class, user.getId());
        existingUser.setFirstname(user.getFirstname());
        existingUser.setLastname(user.getLastname());
        existingUser.setEmail(user.getEmail());
    };

    @Override
    public void remove(Integer id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    };
}
