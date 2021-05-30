package model.service;
import model.bean.Service;

import java.sql.SQLException;
import java.util.List;

public interface ServiceService {

    List<Service> selectAllService();

    boolean deleteService(int id) throws SQLException;

    boolean updateService(Service service) throws SQLException;

    List<Service> selectByName(String name) throws SQLException;


    Service getServiceById (int id);

    void insertServiceStore(Service service) throws SQLException;
}
