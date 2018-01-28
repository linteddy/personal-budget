package demo.budgetapp.service;

import demo.budgetapp.domain.Budget;

import java.time.Month;

/**
 * Created by Ndumiso on 1/28/2018.
 */
public interface BudgetService extends  AbtractCrudService<Budget>{

    /**
     * Returns a budget of the specified month
     * @return
     */
    Budget findByMonth(Month month);

}
