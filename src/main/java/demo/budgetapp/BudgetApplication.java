package demo.budgetapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = "demo.budgetapp.domain")
@ComponentScan(basePackages = "demo.budgetapp")
public class BudgetApplication {


    public static void main(String[] args) {
        SpringApplication.run(BudgetApplication.class, args);
    }


}
