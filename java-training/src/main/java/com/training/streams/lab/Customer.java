package com.training.streams.lab;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Customer {
    private String name;
    private String surname;
    private String username;
    private String password;
    private List<Account> accountList;
    private boolean active;


    public Customer() {
    }


    public Customer(final String nameParam,
                    final String surnameParam,
                    final String usernameParam,
                    final String passwordParam,
                    final List<Account> accountListParam,
                    final boolean activeParam) {
        super();
        this.name = nameParam;
        this.surname = surnameParam;
        this.username = usernameParam;
        this.password = passwordParam;
        this.accountList = accountListParam;
        this.active = activeParam;
    }

    public Customer setAccountList(List<Account> accountList) {
        this.accountList = accountList;
        return this;
    }

    public Customer parseAccounts(String str){
        accountList = Arrays.stream(str.split(";"))
              .map(s -> s.split("\\#"))
              .map(stra -> new Account(EAccountType.valueOf(stra[0]),
                                       new BigDecimal(stra[1],
                                                      MathContext.DECIMAL64)))
              .collect(Collectors.toList());
        return this;
    }

    public static Customer createCustomer() {
        return new Customer();
    }

    public String getName() {
        return this.name;
    }

    public Customer setName(final String nameParam) {
        this.name = nameParam;
        return this;
    }

    public String getSurname() {
        return this.surname;
    }

    public Customer setSurname(final String surnameParam) {
        this.surname = surnameParam;
        return this;
    }

    public String getUsername() {
        return this.username;
    }

    public Customer setUsername(final String usernameParam) {
        this.username = usernameParam;
        return this;
    }

    public String getPassword() {
        return this.password;
    }

    public Customer setPassword(final String passwordParam) {
        this.password = passwordParam;
        return this;
    }

    public List<Account> getAccountList() {
        return this.accountList;
    }


    public Customer addAccount(final Account accountParam) {
        if (this.accountList == null) {
            this.accountList = new ArrayList<>();
        }
        this.accountList.add(accountParam);
        return this;
    }

    public boolean isActive() {
        return this.active;
    }

    public Customer setActive(final boolean activeParam) {
        this.active = activeParam;
        return this;
    }


    @Override
    public String toString() {
        return "Customer [name="
                + this.name
                + ", surname="
                + this.surname
                + ", username="
                + this.username
                + ", password="
                + this.password
                + ", accountList="
                + this.accountList
                + ", active="
                + this.active
                + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return active == customer.active && name.equals(customer.name) && surname.equals(customer.surname)
                && username.equals(customer.username) && password.equals(customer.password)
                && accountList.equals(customer.accountList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,
                            surname,
                            username,
                            password,
                            accountList,
                            active);
    }


}
