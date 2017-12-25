package com.pathashala;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SplitwiseTest {
  @Test
  void expectNoTransactionForEqualContributionInTwoPeopleTrip() {
    Person A = new Person("A", 50);
    Person B = new Person("B", 50);
    List<Person> listOfPersons = new ArrayList<>();

    listOfPersons.add(A);
    listOfPersons.add(B);
    Splitwise split = new Splitwise(listOfPersons, 50);

    assertEquals(Collections.emptyList(), split.settleDebts());
  }

  @Test
  void expectBGivesA50ForUnequalContributionInTwoPeopleTrip() {
    Person A = new Person("A", 100);
    Person B = new Person("B", 0);
    List<Person> listOfPersons = new ArrayList<>();

    listOfPersons.add(A);
    listOfPersons.add(B);
    Splitwise split = new Splitwise(listOfPersons, 50);
    List<Transaction> transactions = new ArrayList<>();
    transactions.add(new Transaction("B", "A", 50));

    assertEquals(transactions, split.settleDebts());
  }

  @Test
  void expectAGivesB50AndAGivesC50ForUnequalContributionInThreePeopleTrip() {
    Person A = new Person("A");
    Person B = new Person("B", 150);
    Person C = new Person("C", 150);
    List<Person> listOfPersons = new ArrayList<>();

    listOfPersons.add(A);
    listOfPersons.add(B);
    listOfPersons.add(C);
    Splitwise split = new Splitwise(listOfPersons, 100);
    List<Transaction> transactions = new ArrayList<>();
    transactions.add(new Transaction("A", "B", 50));
    transactions.add(new Transaction("A", "C", 50));

    assertEquals(transactions, split.settleDebts());
  }

  @Test
  void expectAGivesB50AndCGivesB50ForUnequalContributionInThreePeopleTrip() {
    Person A = new Person("A", 150);
    Person B = new Person("B", 300);
    Person C = new Person("C", 150);
    List<Person> listOfPersons = new ArrayList<>();

    listOfPersons.add(A);
    listOfPersons.add(B);
    listOfPersons.add(C);
    Splitwise split = new Splitwise(listOfPersons, 200);
    List<Transaction> transactions = new ArrayList<>();
    transactions.add(new Transaction("A", "B", 50));
    transactions.add(new Transaction("C", "B", 50));

    assertEquals(transactions, split.settleDebts());
  }
}