package org.project.repository.implementations;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.project.model.User;
import org.project.repository.UserRepository;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private final EntityManagerFactory entityManagerFactory;

     public UserRepositoryImpl(EntityManagerFactory entityManagerFactory) {
         this.entityManagerFactory = entityManagerFactory;
     }

    @Override
    public User fetchById(Long ID) {
         try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
             return entityManager.find(User.class, ID);
         }
    }

    @Override
    public List<User> fetchAll() {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            return entityManager.createQuery("FROM User", User.class)
                    .getResultList();
        }
    }

    @Override
    public User save(User entity) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
            return entity;
        }
    }

    @Override
    public User update(User entity) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
            return entity;
        }
    }

    @Override
    public User delete(User entity) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.detach(entity);
            entityManager.getTransaction().commit();
            return entity;
        }
    }
}
