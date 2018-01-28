package demo.budgetapp.service.impl;

import demo.budgetapp.domain.Budget;
import demo.budgetapp.repository.BudgetRepository;
import demo.budgetapp.service.BudgetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Month;
import java.util.List;

/**
 * Created by Ndumiso on 1/28/2018.
 */
@Service
@Transactional
public class BudgetServiceImpl implements BudgetService {

    private final Logger logger = LoggerFactory.getLogger(BudgetServiceImpl.class);

    @Autowired
    private BudgetRepository budgetRepository;

    @Override
    public List<Budget> findAll() {
        logger.debug("**** Service Request to find all budgets ****");
        return budgetRepository.findAll();
    }

    @Override
    public Budget findById(Long id) {
        logger.debug("**** Service Request to find budget with id : " + id + " ****");
        return budgetRepository.getOne(id);
    }

    @Override
    public Budget save(Budget entity) {
        logger.debug("**** Service Request to save budget ****");
        return budgetRepository.save(entity);
    }

    @Override
    public Budget update(Budget entity) {
        logger.debug("**** Service Request to update budget with id " + entity.getId() + " ****");
        return budgetRepository.save(entity);
    }

    @Override
    public Budget findByMonth(Month month) {
        logger.debug("Request to find budget for " + month.toString());
        return budgetRepository.findByMonth(month);
    }
}
