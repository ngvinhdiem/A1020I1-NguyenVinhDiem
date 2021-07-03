package vn.codegym.service;

import vn.codegym.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById(int id);

    void save(Category category);

    void remove(Category category);

    void update(Category category);
}
