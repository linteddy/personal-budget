package sideprojects.ndumiso.budgetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sideprojects.ndumiso.budgetapp.domain.Budget;

import java.time.Month;

/**
 * Created by Ndumiso on 1/27/2018.
 */
@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {

    Budget findByMonth(Month month);
}
