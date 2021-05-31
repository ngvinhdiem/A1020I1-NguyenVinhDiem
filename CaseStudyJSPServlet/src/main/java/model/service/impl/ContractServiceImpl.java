package model.service.impl;

import model.bean.Contract;
import model.repository.ContractRepository;
import model.repository.impl.ContractRepositoryImpl;
import model.service.ContractService;

import java.sql.SQLException;
import java.util.List;

public class ContractServiceImpl implements ContractService {
    private ContractRepository ContractRepository = new ContractRepositoryImpl();

    @Override
    public List<Contract> selectAllContract() {
        return ContractRepository.selectAllContract();
    }

    @Override
    public boolean deleteContract(int id) throws SQLException {
        return ContractRepository.deleteContract(id);
    }

    @Override
    public boolean updateContract(Contract Contract) throws SQLException {
        return ContractRepository.updateContract(Contract);
    }


    @Override
    public Contract getContractById(int id) {
        return ContractRepository.getContractById(id);
    }

    @Override
    public void insertContractStore(Contract Contract) throws SQLException {
        ContractRepository.insertContractStore(Contract);
    }
}
