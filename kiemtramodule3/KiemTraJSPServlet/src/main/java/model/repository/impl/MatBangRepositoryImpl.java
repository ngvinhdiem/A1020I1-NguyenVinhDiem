package model.repository.impl;

import model.bean.MatBang;
import model.repository.BaseRepository;
import model.repository.MatBangRepository;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MatBangRepositoryImpl implements MatBangRepository {
    private BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL_MAT_BANG = "select * from mat_bang";
    private static final String DELETE_MAT_BANG_SQL = "delete from mat_bang where ma_mat_bang = ?;";
    private static final String SELECT_MAT_BANG_BY_LOAI_MAT_BANG = "select * from mat_bang where loai_mat_bang = ?;";
    private static final String SELECT_MAT_BANG_BY_TANG = "select * from mat_bang where tang = ?;";
    private static final String SELECT_MAT_BANG_BY_GIA_THUE = "select * from mat_bang where gia_tien = ?;";


    @Override
    public List<MatBang> selectAllMatBang() {
        List<MatBang> matBangList = new ArrayList<>();
        try{
            Statement statement = this.baseRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_MAT_BANG);

            MatBang matBang = null;
            while (resultSet.next()){
                matBang = new MatBang();
                matBang.setMaMatBang(resultSet.getString("ma_mat_bang"));
                matBang.setTrangThai(resultSet.getString("trang_thai"));
                matBang.setDienTich(resultSet.getInt("dien_tich"));
                matBang.setTang(resultSet.getInt("tang"));
                matBang.setLoaiMatBang(resultSet.getString("loai_mat_bang"));
                matBang.setGiaTien(resultSet.getInt("gia_tien"));

                Date ngayBatDau = resultSet.getDate("ngay_bat_dau");
                Date ngayKetThuc = resultSet.getDate("ngay_ket_thuc");
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                matBang.setNgayBatDau(df.format(ngayBatDau));
                matBang.setNgayKetThuc(df.format(ngayKetThuc));
                matBangList.add(matBang);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return matBangList;
    }

    @Override
    public boolean deleteMatBang(String id) throws SQLException {
        boolean rowDeleted = false;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(DELETE_MAT_BANG_SQL);
            preparedStatement.setString(1, id);

            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDeleted;
    }



    @Override
    public List<MatBang> selectByTang(int tang) throws SQLException {
        List<MatBang> matBangList = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement(SELECT_MAT_BANG_BY_TANG);
            preparedStatement.setInt(1, tang);
            ResultSet resultSet = preparedStatement.executeQuery(SELECT_MAT_BANG_BY_TANG);

            MatBang matBang = null;
            while (resultSet.next()){
                matBang = new MatBang();
                matBang.setMaMatBang(resultSet.getString("ma_mat_bang"));
                matBang.setTrangThai(resultSet.getString("trang_thai"));
                matBang.setDienTich(resultSet.getInt("dien_tich"));
                matBang.setTang(resultSet.getInt("tang"));
                matBang.setLoaiMatBang(resultSet.getString("loai_mat_bang"));
                matBang.setGiaTien(resultSet.getInt("gia_tien"));
                Date ngayBatDau = resultSet.getDate("ngay_bat_dau");
                Date ngayKetThuc = resultSet.getDate("ngay_ket_thuc");
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                matBang.setNgayBatDau(df.format(ngayBatDau));
                matBang.setNgayKetThuc(df.format(ngayKetThuc));
                matBangList.add(matBang);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return matBangList;
    }

    @Override
    public List<MatBang> selectByGiaThue(int giaThue) throws SQLException {
        List<MatBang> matBangList = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement(SELECT_MAT_BANG_BY_GIA_THUE);
            preparedStatement.setInt(1, giaThue);
            ResultSet resultSet = preparedStatement.executeQuery(SELECT_MAT_BANG_BY_GIA_THUE);

            MatBang matBang = null;
            while (resultSet.next()){
                matBang = new MatBang();
                matBang.setMaMatBang(resultSet.getString("ma_mat_bang"));
                matBang.setTrangThai(resultSet.getString("trang_thai"));
                matBang.setDienTich(resultSet.getInt("dien_tich"));
                matBang.setTang(resultSet.getInt("tang"));
                matBang.setLoaiMatBang(resultSet.getString("loai_mat_bang"));
                matBang.setGiaTien(resultSet.getInt("gia_tien"));
                Date ngayBatDau = resultSet.getDate("ngay_bat_dau");
                Date ngayKetThuc = resultSet.getDate("ngay_ket_thuc");
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                matBang.setNgayBatDau(df.format(ngayBatDau));
                matBang.setNgayKetThuc(df.format(ngayKetThuc));
                matBangList.add(matBang);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return matBangList;
    }

    @Override
    public List<MatBang> selectByLoaiMatBang(String loaiMatBang) {
        List<MatBang> matBangList = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement(SELECT_MAT_BANG_BY_LOAI_MAT_BANG);
            preparedStatement.setString(1, loaiMatBang);
            ResultSet resultSet = preparedStatement.executeQuery(SELECT_MAT_BANG_BY_LOAI_MAT_BANG);

            MatBang matBang = null;
            while (resultSet.next()){
                matBang = new MatBang();
                matBang.setMaMatBang(resultSet.getString("ma_mat_bang"));
                matBang.setTrangThai(resultSet.getString("trang_thai"));
                matBang.setDienTich(resultSet.getInt("dien_tich"));
                matBang.setTang(resultSet.getInt("tang"));
                matBang.setLoaiMatBang(resultSet.getString("loai_mat_bang"));
                matBang.setGiaTien(resultSet.getInt("gia_tien"));
                Date ngayBatDau = resultSet.getDate("ngay_bat_dau");
                Date ngayKetThuc = resultSet.getDate("ngay_ket_thuc");
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                matBang.setNgayBatDau(df.format(ngayBatDau));
                matBang.setNgayKetThuc(df.format(ngayKetThuc));
                matBangList.add(matBang);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return matBangList;
    }


    @Override
    public MatBang getMatBangById(String id) {
        MatBang matBang = null;
        try {
            CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call get_mat_bang_by_id(?)");
            callableStatement.setString(1,id);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                matBang = new MatBang();
                matBang.setMaMatBang(resultSet.getString("ma_mat_bang"));
                matBang.setTrangThai(resultSet.getString("trang_thai"));
                matBang.setDienTich(resultSet.getInt("dien_tich"));
                matBang.setTang(resultSet.getInt("tang"));
                matBang.setLoaiMatBang(resultSet.getString("loai_mat_bang"));
                matBang.setGiaTien(resultSet.getInt("gia_tien"));
                Date ngayBatDau = resultSet.getDate("ngay_bat_dau");
                Date ngayKetThuc = resultSet.getDate("ngay_ket_thuc");
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                matBang.setNgayBatDau(df.format(ngayBatDau));
                matBang.setNgayKetThuc(df.format(ngayKetThuc));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return matBang;
    }

    @Override
    public void insertMatBangStore(MatBang matBang) throws SQLException {
        CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call insert_mat_bang(?,?,?,?,?,?,?,?)");
        callableStatement.setString(1, matBang.getMaMatBang());
        callableStatement.setString(2, matBang.getTrangThai());
        callableStatement.setInt(3, matBang.getDienTich());
        callableStatement.setInt(4, matBang.getTang());
        callableStatement.setString(5, matBang.getLoaiMatBang());
        callableStatement.setInt(6, matBang.getGiaTien());
        callableStatement.setDate(7, Date.valueOf(matBang.getNgayBatDau()));
        callableStatement.setDate(8, Date.valueOf(matBang.getNgayKetThuc()));
        callableStatement.executeUpdate();
    }



    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
