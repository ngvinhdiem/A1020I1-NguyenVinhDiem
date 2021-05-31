package model.repository;

import model.bean.Contract;

import java.sql.SQLException;
import java.util.List;

public interface ContractRepository {

    List<Contract> selectAllContract();

    boolean deleteContract(int id) throws SQLException;

    boolean updateContract(Contract Contract) throws SQLException;

    Contract getContractById (int id);

    void insertContractStore(Contract Contract) throws SQLException;

}
