package model.repository.impl;

import model.bean.Contract;
import model.repository.BaseRepository;
import model.repository.ContractRepository;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ContractRepositoryImpl implements ContractRepository {
    private BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL_CONTRACT = "select * from contract";
    private static final String DELETE_CONTRACT_SQL = "delete from contract where contract_id = ?;";

    @Override
    public List<Contract> selectAllContract() {
        List<Contract> contractList = new ArrayList<>();
        try{
            Statement statement = this.baseRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_CONTRACT);

            Contract contract = null;
            while (resultSet.next()){
                contract = new Contract();
                contract.setContractId(resultSet.getInt("contract_id"));
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String startDate = df.format(resultSet.getDate("contract_start_date"));
                String endDate = df.format(resultSet.getDate("contract_end_date"));
                contract.setContractStartDate(startDate);
                contract.setContractEndDate(endDate);
                contract.setContractDeposit(resultSet.getDouble("contract_deposit"));
                contract.setContractTotalMoney(resultSet.getDouble("contract_total_money"));
                contract.setEmployeeId(resultSet.getInt("employee_id"));
                contract.setCustomerId(resultSet.getInt("customer_id"));
                contract.setServiceId(resultSet.getInt("service_id"));
                contractList.add(contract);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contractList;
    }

    @Override
    public boolean deleteContract(int id) throws SQLException {
        boolean rowDeleted = false;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(DELETE_CONTRACT_SQL);
            preparedStatement.setInt(1, id);

            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDeleted;
    }


    @Override
    public boolean updateContract(Contract contract) throws SQLException {
        boolean rowUpdated = false;
        try {

            CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call update_contract(?,?,?,?,?,?,?,?,?)");
            callableStatement.setInt(1, contract.getContractId());
            callableStatement.setDate(2, Date.valueOf(contract.getContractStartDate()));
            callableStatement.setDate(3, Date.valueOf(contract.getContractEndDate()));
            callableStatement.setDouble(4, contract.getContractDeposit());
            callableStatement.setDouble(5, contract.getContractTotalMoney());
            callableStatement.setInt(6, contract.getEmployeeId());
            callableStatement.setInt(7, contract.getCustomerId());
            callableStatement.setInt(8, contract.getServiceId());
            callableStatement.executeUpdate();

            rowUpdated = callableStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdated;
    }


    @Override
    public Contract getContractById(int id) {
        Contract contract = null;
        try {
            CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call get_contract_by_id(?)");
            callableStatement.setInt(1,id);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                contract = new Contract();
                contract.setContractId(resultSet.getInt("contract_id"));
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String startDate = df.format(resultSet.getDate("contract_start_date"));
                String endDate = df.format(resultSet.getDate("contract_end_date"));
                contract.setContractStartDate(startDate);
                contract.setContractEndDate(endDate);
                contract.setContractDeposit(resultSet.getDouble("contract_deposit"));
                contract.setContractTotalMoney(resultSet.getDouble("contract_total_money"));
                contract.setEmployeeId(resultSet.getInt("employee_id"));
                contract.setCustomerId(resultSet.getInt("customer_id"));
                contract.setServiceId(resultSet.getInt("service_id"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contract;
    }

    @Override
    public void insertContractStore(Contract contract) throws SQLException {
        CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call insert_contract(?,?,?,?,?,?,?,?,?)");
        callableStatement.setInt(1, contract.getContractId());
        callableStatement.setDate(2, Date.valueOf(contract.getContractStartDate()));
        callableStatement.setDate(3, Date.valueOf(contract.getContractEndDate()));
        callableStatement.setDouble(4, contract.getContractDeposit());
        callableStatement.setDouble(5, contract.getContractTotalMoney());
        callableStatement.setInt(6, contract.getEmployeeId());
        callableStatement.setInt(7, contract.getCustomerId());
        callableStatement.setInt(8, contract.getServiceId());
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
