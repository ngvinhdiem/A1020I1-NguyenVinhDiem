package model.repository;

import model.bean.Customer;
import model.bean.Service;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepositoryImpl implements ServiceRepository{
    private BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL_SERVICE = "select * from service";
    private static final String DELETE_SERVICE_SQL = "delete from service where service_id = ?;";
    private static final String SELECT_SERVICE_BY_NAME = "select * from service where service_name = ?;";
    
    
    
  public List<Service> selectAllService(){
      List<Service> serviceList = new ArrayList<>();
      try{
          Statement statement = this.baseRepository.getConnection().createStatement();
          ResultSet resultSet = statement.executeQuery(SELECT_ALL_SERVICE);

          Service service = null;
          while (resultSet.next()){
              service = new Service();
              service.setServiceId(resultSet.getInt("service_id"));
              service.setServiceName(resultSet.getString("service_name"));
              service.setServiceArea(resultSet.getInt("service_area"));
              service.setServiceCost(resultSet.getDouble("service_cost"));
              service.setServiceMaxPeople(resultSet.getInt("service_max_people"));
              service.setRentTypeId(resultSet.getInt("rent_type_id"));
              service.setServiceTypeId(resultSet.getInt("service_type_id"));
              service.setStandardRoom(resultSet.getString("standard_room"));
              service.setDescriptionOtherConvenience(resultSet.getString("description_other_convenience"));
              service.setPoolArea(resultSet.getDouble("pool_area"));
              service.setNumberOfFloors(resultSet.getInt("number_of_floors"));
              serviceList.add(service);
          }
      } catch (SQLException throwables) {
          throwables.printStackTrace();
      }
      return serviceList;
  };

    public boolean deleteService(int id) throws SQLException {
        boolean rowDeleted = false;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(DELETE_SERVICE_SQL);
            preparedStatement.setInt(1, id);

            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDeleted;
    };

    public  boolean updateService(Service service) throws SQLException{
        boolean rowUpdated = false;
        try {

            CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call update_service(?,?,?,?,?,?,?,?,?,?,?)");
            callableStatement.setInt(1, service.getServiceId());
            callableStatement.setString(2, service.getServiceName());
            callableStatement.setInt(3, service.getServiceArea());
            callableStatement.setDouble(4,service.getServiceCost());
            callableStatement.setInt(5,service.getServiceMaxPeople());
            callableStatement.setInt(6,service.getRentTypeId());
            callableStatement.setInt(7,service.getServiceTypeId());
            callableStatement.setString(8, service.getStandardRoom());
            callableStatement.setString(9, service.getDescriptionOtherConvenience());
            callableStatement.setDouble(10,service.getPoolArea());
            callableStatement.setInt(11,service.getNumberOfFloors());
            callableStatement.executeUpdate();
            rowUpdated = callableStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdated;
    };

    public  List<Service> selectByName(String name) throws SQLException{
        List<Service> serviceList = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(SELECT_SERVICE_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery(SELECT_SERVICE_BY_NAME);

            Service service = null;
            while (resultSet.next()){
                service = new Service();
                service.setServiceId(resultSet.getInt("service_id"));
                service.setServiceName(resultSet.getString("service_name"));
                service.setServiceArea(resultSet.getInt("service_area"));
                service.setServiceCost(resultSet.getDouble("service_cost"));
                service.setServiceMaxPeople(resultSet.getInt("service_max_people"));
                service.setRentTypeId(resultSet.getInt("rent_type_id"));
                service.setServiceTypeId(resultSet.getInt("service_type_id"));
                service.setStandardRoom(resultSet.getString("standard_room"));
                service.setDescriptionOtherConvenience(resultSet.getString("description_other_convenience"));
                service.setPoolArea(resultSet.getDouble("pool_area"));
                service.setNumberOfFloors(resultSet.getInt("number_of_floors"));
                serviceList.add(service);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return serviceList;
    };


    public  Service getServiceById (int id){
        Service service = null;
        try {
            CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call get_service_by_id(?)");
            callableStatement.setInt(1,id);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                service = new Service();
                service.setServiceId(resultSet.getInt("service_id"));
                service.setServiceName(resultSet.getString("service_name"));
                service.setServiceArea(resultSet.getInt("service_area"));
                service.setServiceCost(resultSet.getDouble("service_cost"));
                service.setServiceMaxPeople(resultSet.getInt("service_max_people"));
                service.setRentTypeId(resultSet.getInt("rent_type_id"));
                service.setServiceTypeId(resultSet.getInt("service_type_id"));
                service.setStandardRoom(resultSet.getString("standard_room"));
                service.setDescriptionOtherConvenience(resultSet.getString("description_other_convenience"));
                service.setPoolArea(resultSet.getDouble("pool_area"));
                service.setNumberOfFloors(resultSet.getInt("number_of_floors"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return service;
    };

    public  void insertServiceStore(Service service) throws SQLException {
        CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call insert_service(?,?,?,?,?,?,?,?,?,?,?)");
        callableStatement.setInt(1, service.getServiceId());
        callableStatement.setString(2, service.getServiceName());
        callableStatement.setInt(3, service.getServiceArea());
        callableStatement.setDouble(4,service.getServiceCost());
        callableStatement.setInt(5,service.getServiceMaxPeople());
        callableStatement.setInt(6,service.getRentTypeId());
        callableStatement.setInt(7,service.getServiceTypeId());
        callableStatement.setString(8,service.getStandardRoom());
        callableStatement.setString(9,service.getDescriptionOtherConvenience());
        callableStatement.setDouble(10,service.getPoolArea());
        callableStatement.setInt(11,service.getNumberOfFloors());
        callableStatement.executeUpdate();
    };
}
