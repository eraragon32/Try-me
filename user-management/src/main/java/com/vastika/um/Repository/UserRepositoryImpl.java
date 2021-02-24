package com.vastika.um.repository;

import com.vastika.um.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveUser(User user) {

        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public void updateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public void deleteUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.load(User.class, id);
        if (user != null) {
            session.delete(user);
        }
    }

    @Override
    public User getUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    public List<User> getAllUser() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(User.class);
        return criteria.list();
    }

    @Override
    public User getUserByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User u where u.username=?1");
        query.setParameter(1, username);
        return (User) query.getSingleResult();
    }
}
