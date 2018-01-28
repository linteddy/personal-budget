package demo.budgetapp.service.impl;

import demo.budgetapp.domain.BudgetTransaction;
import demo.budgetapp.repository.TransactionRepository;
import demo.budgetapp.service.BudgetTransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ndumiso on 1/28/2018.
 */
@Service
@Transactional
public class BudgetTransactionServiceImpl implements BudgetTransactionService {

    private final Logger logger = LoggerFactory.getLogger(BudgetTransactionServiceImpl.class);
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<BudgetTransaction> findAll() {
        logger.debug("Service Request to find all Transactions");
        return transactionRepository.findAll();
    }

    @Override
    public BudgetTransaction findById(Long id) {
        logger.debug("Service Request to find Transaction with id : " + id);
        return transactionRepository.getOne(id);
    }

    @Override
    public BudgetTransaction save(BudgetTransaction transaction) {
        logger.debug("Service Request to save Transaction");
        return transactionRepository.save(transaction);
    }

    @Override
    public BudgetTransaction update(BudgetTransaction transaction) {
        logger.debug("Service Request to update Transaction");
        return transactionRepository.save(transaction);
    }
}
