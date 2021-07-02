package com.example.demo.repository;

import com.example.demo.model.Blog;

import java.util.List;

public interface BlogRepository {
    List<Blog> findAll();

    Blog findById(int id);

    void save(Blog blog);

    void remove(Blog blog);

    void update(Blog blog);
}