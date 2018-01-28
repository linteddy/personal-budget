package demo.budgetapp.domain;

import junit.framework.TestCase;
import org.junit.Test;

import java.time.Month;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Ndumiso on 1/28/2018.
 */
public class BudgetTest extends TestCase {


    @Test
    public void testShouldcalculateCorrectDisposableCash() throws Exception {
        Set<BudgetTransaction> transactions = new HashSet<>(Arrays.asList(
                new BudgetTransaction(1, "pay laon", TransactionType.EXPENSE),
                new BudgetTransaction(2, "pay laon", TransactionType.EXPENSE),
                new BudgetTransaction(5, "salary", TransactionType.INCOME)
        ));
        Budget budget = new Budget(Month.JANUARY, transactions);
        assertEquals(2.0,budget.getDisposableCash());
    }

}