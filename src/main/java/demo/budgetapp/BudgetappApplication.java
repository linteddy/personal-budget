package demo.budgetapp;

import demo.budgetapp.domain.Budget;
import demo.budgetapp.domain.BudgetTransaction;
import demo.budgetapp.domain.TransactionType;
import demo.budgetapp.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import java.time.Month;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EntityScan(basePackages = "demo.budgetapp.domain")
@ComponentScan(basePackages = "demo.budgetapp")
public class BudgetappApplication implements CommandLineRunner {

    @Autowired
    private BudgetRepository budgetRepository;

    public static void main(String[] args) {
        SpringApplication.run(BudgetappApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Set<BudgetTransaction> transactions = new HashSet<>();
        transactions.add(new BudgetTransaction(20_000, "Salary", TransactionType.INCOME));
        transactions.add(new BudgetTransaction(4_566, "Monthly Rent", TransactionType.EXPENSE));
        Set<BudgetTransaction> transactions2 = new HashSet<>();
        transactions2.add(new BudgetTransaction(20_000, "Salary", TransactionType.INCOME));
        transactions2.add(new BudgetTransaction(4_566, "Monthly Rent", TransactionType.EXPENSE));
        transactions2.add(new BudgetTransaction(199, "Planet Fitness Payment", TransactionType.EXPENSE));
        transactions2.add(new BudgetTransaction(2300, "Car Payment", TransactionType.EXPENSE));
        transactions2.add(new BudgetTransaction(2300, "Car Payment", TransactionType.EXPENSE));
        Budget result = budgetRepository.save(new Budget(Month.JANUARY, transactions));
        Budget result2 = budgetRepository.save(new Budget(Month.FEBRUARY, transactions2));
        System.out.println("******************* Initial budgets data persisted *******************");
        System.out.println("{ ");
        System.out.print(result + " , \n" + result2);
        System.out.print(" }");
    }
}
