package com.pathashala;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {
  @Test
  void expectTransactionsWithSamePayerPayeeAmountToBeEqual() {
    assertEquals(new Transaction("A","B",20), new Transaction("A","B",20));
  }

  @Test
  void expectTransactionsWithDifferentPayerPayeeAmountToBeUnequal() {
    assertNotEquals(new Transaction("A","B",20), new Transaction("B","A",20));
  }

  @Test
  void expectEqualTransactionsToHaveEqualHashcode() {
    Transaction AToB20 = new Transaction("A", "B", 20);
    Transaction anotherAToB20 = new Transaction("A", "B", 20);
    assertEquals(AToB20.hashCode(), anotherAToB20.hashCode());
  }

  @Test
  void expectUnequalTransactionsToHaveUnequalHashcode() {
    Transaction AToB20 = new Transaction("A", "B", 20);
    Transaction BToA20 = new Transaction("B", "A", 20);
    assertNotEquals(AToB20.hashCode(), BToA20.hashCode());
  }
}