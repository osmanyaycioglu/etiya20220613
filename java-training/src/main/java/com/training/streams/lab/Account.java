package com.training.streams.lab;

import java.math.BigDecimal;

public class Account {
    private EAccountType     name;
    private BigDecimal amount;

    public Account() {

    }

    public Account(final EAccountType nameParam,
                   final BigDecimal amountParam) {
        super();
        this.name = nameParam;
        this.amount = amountParam;
    }

    public static Account createAccount(){
        return new Account();
    }

    public EAccountType getName() {
        return this.name;
    }

    public Account setName(final EAccountType nameParam) {
        this.name = nameParam;
        return this;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public Account setAmount(final BigDecimal amountParam) {
        this.amount = amountParam;
        return this;
    }

    @Override
    public String toString() {
        return "Account [name=" + this.name + ", amount=" + this.amount + "]";
    }


}
