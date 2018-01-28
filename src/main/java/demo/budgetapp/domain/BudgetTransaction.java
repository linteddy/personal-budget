package demo.budgetapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Ndumiso on 1/27/2018.
 */
@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BudgetTransaction extends BaseEntity {

    @Column
    @NotNull(message = "amount is required")
    private double amount;

    @NotNull(message = "detail is required")
    @Column
    private String detail;

    @NotNull
    @Column
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

}
