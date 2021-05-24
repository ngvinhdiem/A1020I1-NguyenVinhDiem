package model.service;

import model.bean.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    List<User> selectAllUser();

    boolean deleteUser(int id) throws SQLException;

    boolean updateUser(User user) throws SQLException;

    List<User> selectByCountry(String country) throws SQLException;

    List<User> sortByName();

    User getUserById (int id);

    void insertUserStore(User user) throws SQLException;

    void addUserTransaction(User user, int[] permision);

    void insertUpdateWithoutTransaction();

    void insertUpdateUseTransaction();

}