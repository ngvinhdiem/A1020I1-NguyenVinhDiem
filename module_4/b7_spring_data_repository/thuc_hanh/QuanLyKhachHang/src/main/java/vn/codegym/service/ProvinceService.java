package vn.codegym.service;

import vn.codegym.model.Province;

import java.util.List;

public interface ProvinceService {
    List<Province> findAll();

    Province findById(int id);

    void save(Province province);

    void remove(Province province);

    void update(Province province);
}