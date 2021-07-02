package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import com.example.demo.model.Blog;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository("BlogRepository")
public class BlogRepositoryImpl implements BlogRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> query = entityManager.createQuery("SELECT b from Blog as b", Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(int id) {
        return entityManager.find(Blog.class, id);
    }

    @Override
    public void save(Blog blog) {
        entityManager.persist(blog);
    }

    @Override
    public void remove(Blog blog) {
        entityManager.remove(entityManager.merge(blog));
    }

    @Override
    public void update(Blog blog) {
        entityManager.merge(blog);
    }
}
