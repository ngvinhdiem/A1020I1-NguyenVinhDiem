package model.service;

import model.bean.MatBang;

import java.sql.SQLException;
import java.util.List;

public interface MatBangService {
    List<MatBang> selectAllMatBang();

    boolean deleteMatBang(String id) throws SQLException;

    MatBang getMatBangById (String id);

    void insertMatBangStore(MatBang MatBang) throws SQLException;
    List<MatBang> selectByLoaiMatBang(String name) throws SQLException;
    List<MatBang> selectByTang(int tang) throws SQLException;
    List<MatBang> selectByGiaThue(int giaThue) throws SQLException;
}
