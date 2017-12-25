package com.pathashala;

//Represents the money needed to be paid by a person to another person to settle his due
public class Transaction {
  private final String payer;
  private final String payee;
  private final int amount;

  Transaction(String payer, String payee, int amount) {
    this.payer = payer;
    this.payee = payee;
    this.amount = amount;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (getClass() != other.getClass()) {
      return false;
    }
    Transaction otherTransaction = (Transaction) other;
    if (amount != otherTransaction.amount) {
      return false;
    }
    if (payer != null ? !payer.equals(otherTransaction.payer) : otherTransaction.payer != null) {
      return false;
    }
    return payee != null ? payee.equals(otherTransaction.payee) : otherTransaction.payee == null;
  }

  @Override
  public int hashCode() {
    int result = payer != null ? payer.hashCode() : 0;
    result = 31 * result + (payee != null ? payee.hashCode() : 0);
    result = 31 * result + amount;
    return result;
  }

  @Override
  public String toString() {
    return payer + "->" + payee + " " + amount;
  }
}