package model.service.impl;

import model.bean.MatBang;
import model.repository.MatBangRepository;
import model.repository.impl.MatBangRepositoryImpl;
import model.service.MatBangService;

import java.sql.SQLException;
import java.util.List;

public class MatBangServiceImpl implements MatBangService {
    private MatBangRepository MatBangRepository = new MatBangRepositoryImpl();

    @Override
    public List<MatBang> selectAllMatBang() {
        return MatBangRepository.selectAllMatBang();
    }

    @Override
    public boolean deleteMatBang(String id) throws SQLException {
        return MatBangRepository.deleteMatBang(id);
    }


    @Override
    public List<MatBang> selectByLoaiMatBang(String loaiMatBang) throws SQLException {
        return MatBangRepository.selectByLoaiMatBang(loaiMatBang);
    }
    @Override
    public List<MatBang> selectByTang(int tang) throws SQLException {
        return MatBangRepository.selectByTang(tang);
    }

    @Override
    public List<MatBang> selectByGiaThue(int giaThue) throws SQLException {
        return MatBangRepository.selectByGiaThue(giaThue);
    }

    @Override
    public MatBang getMatBangById(String id) {
        return MatBangRepository.getMatBangById(id);
    }

    @Override
    public void insertMatBangStore(MatBang MatBang) throws SQLException {
        MatBangRepository.insertMatBangStore(MatBang);
    }
}
