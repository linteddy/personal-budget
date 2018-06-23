package sideprojects.ndumiso.budgetapp.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import sideprojects.ndumiso.budgetapp.domain.abstraction.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.Month;
import java.util.Set;

/**
 * <p>A budget encapsulates your anticipated spending for a specific month, leaving you with a rough
 * estimate of how much disposable cash you should be left with.</p>
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Budget extends AbstractEntity {

    @NotNull
    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    private Month month;

    @Column
    private Double disposableCash = 0.0;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<BudgetTransaction> transactions;

    @Column
    private Double shortFall = 0.0;

    @Builder
    public Budget(Month month, Set<BudgetTransaction> transactions) {
        this.month = month;
        this.transactions = transactions;
        this.calculateDisposableCash();
    }

    /**
     * Calculates and sets the disposable cash for this budget.
     */
    public void calculateDisposableCash() {
        double disposableCash = getSumOfTransactionType(TransactionType.INCOME) -
                getSumOfTransactionType(TransactionType.EXPENSE);
        //if there is more expense than income (spending more than you earn)
        if (disposableCash < 0) {
            this.shortFall = Math.abs(disposableCash);
        } else {
            this.disposableCash = disposableCash;
        }
    }

    private double getSumOfTransactionType(TransactionType transactionType) {
        return this.transactions.stream()
                .filter(t -> t.getTransactionType().equals(transactionType))
                .mapToDouble(BudgetTransaction::getAmount)
                .sum();
    }
}
