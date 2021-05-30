package model.service;

import model.bean.Service;
import model.repository.ServiceRepository;
import model.repository.ServiceRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class ServiceServiceImpl implements ServiceService {
    private ServiceRepository ServiceRepository = new ServiceRepositoryImpl();

    @Override
    public List<Service> selectAllService() {
        return ServiceRepository.selectAllService();
    }

    @Override
    public boolean deleteService(int id) throws SQLException {
        return ServiceRepository.deleteService(id);
    }

    @Override
    public boolean updateService(Service Service) throws SQLException {
        return ServiceRepository.updateService(Service);
    }

    @Override
    public List<Service> selectByName(String name) throws SQLException {
        return ServiceRepository.selectByName(name);
    }


    @Override
    public Service getServiceById(int id) {
        return ServiceRepository.getServiceById(id);
    }

    @Override
    public void insertServiceStore(Service Service) throws SQLException {
        ServiceRepository.insertServiceStore(Service);
    }
}
