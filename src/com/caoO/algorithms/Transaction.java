package com.caoO.algorithms;

import java.util.Objects;

public class Transaction implements Comparable<Transaction> {
    /// the name of person who owns this transaction
    private String who;
    /// the date when this transaction was build
    private SmartDate when;
    /// the amount of this transaction
    private double amount;

    public Transaction() {}

    public Transaction(String who, SmartDate when, double amount) {
        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public SmartDate getWhen() {
        return when;
    }

    public void setWhen(SmartDate when) {
        this.when = when;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "who='" + who + '\'' +
                ", when=" + when +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(that.amount, amount) == 0 &&
                Objects.equals(who, that.who) &&
                Objects.equals(when, that.when);
    }

    @Override
    public int hashCode() {

        return Objects.hash(who, when, amount);
    }

    @Override
    public int compareTo(Transaction transaction) {
        if (this.getAmount() < transaction.getAmount())
            return -1;
        else if (this.getAmount() == transaction.getAmount())
            return 0;
        return 1;
    }
}
