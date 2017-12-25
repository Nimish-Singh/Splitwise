package com.pathashala;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
  @Test
  void expectPersonWithCreditToBeEligibleForSettlement() {
    Person A = new Person("A",100);
    assertTrue(A.hasToSettle());
  }

  @Test
  void expectPersonWithNoCreditToBeIneligibleForSettlement() {
    Person A = new Person("A", 0);
    assertFalse(A.hasToSettle());
  }

  @Test
  void expectAGivesB50WhenAOwes50ToB() {
    Person A = new Person("A",150);
    Person B = new Person("B",50);
    assertEquals(new Transaction("A","B",50), A.paysTo(B));
  }

  @Test
  void expectDummyTransactionWhenBothPayEqually() {
    Person A = new Person("A",150);
    Person B = new Person("B",150);
    A.updateDueAmount(150);
    B.updateDueAmount(150);
    assertEquals(new Transaction("A","B",0), A.paysTo(B));
  }

  @Test
  void expectPersonWithCreditToBeRankedHigherThanPersonWithDebit() {
    Person A = new Person("A",1);
    Person B = new Person("B",-1);
    assertEquals(2, A.compareTo(B));
  }

  @Test
  void expectPersonWithDebitToBeRankedHigherThanPersonWithCredit() {
    Person A = new Person("A",-1);
    Person B = new Person("B",1);
    assertEquals(-2, A.compareTo(B));
  }
}