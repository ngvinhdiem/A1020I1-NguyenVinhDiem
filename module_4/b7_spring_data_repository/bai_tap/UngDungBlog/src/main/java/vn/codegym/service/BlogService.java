package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    Blog findById(int id);

    void save(Blog blog);

    void remove(Blog blog);

    void update(Blog blog);

    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findAllByAuthorContainingOrTitleContaining(String author, String title, Pageable pageable);
}
