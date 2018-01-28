package demo.budgetapp.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.Month;
import java.util.Set;

/**
 * Created by Ndumiso on 1/27/2018.
 */
@Entity
@Table
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"disposableCash", "transactions"}, callSuper = true)
public class Budget extends BaseEntity {

    @NotNull
    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    private Month month;

    @NotNull
    @Column
    private double disposableCash;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<BudgetTransaction> transactions;

    public Budget(@NotNull Month month, @Min(1) Set<BudgetTransaction> transactions) {
        this.month = month;
        this.transactions = transactions;
        this.calculateDisposableCash();
    }

    private void calculateDisposableCash() {
        this.disposableCash = getSumOfTransactionType(TransactionType.INCOME) -
                getSumOfTransactionType(TransactionType.EXPENSE);
    }

    private double getSumOfTransactionType(TransactionType transactionType) {
        return this.transactions.stream().parallel()
                .filter(t -> t.getTransactionType().equals(transactionType))
                .mapToDouble(t -> t.getAmount())
                .sum();
    }
}
