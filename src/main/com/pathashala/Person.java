package com.pathashala;

//Represents an individual with related expenditure
public class Person implements Comparable<Person> {
  private final String name;
  private final int amountSpent;
  private int amountToBeSettled;

  Person(String name) {
    this(name, 0);
  }

  Person(String name, int amountSpent) {
    this.name = name;
    this.amountSpent = amountSpent;
    this.amountToBeSettled = amountSpent;
  }

  void updateDueAmount(int averageExpensePerPerson) {
    amountToBeSettled -= averageExpensePerPerson;
  }

  boolean hasToSettle() {
    return (amountToBeSettled != 0);
  }

  Transaction paysTo(Person other) {
    int settlementAmount = Math.min(Math.abs(amountToBeSettled), Math.abs(other.amountToBeSettled));
    Transaction transaction = new Transaction(name, other.name, settlementAmount);
    amountToBeSettled += settlementAmount;
    other.amountToBeSettled -= settlementAmount;
    return transaction;
  }

  @Override
  public int compareTo(Person other) {
    return amountToBeSettled - other.amountToBeSettled;
  }
}