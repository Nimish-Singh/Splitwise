package com.pathashala;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Represents an application to equally distribute settlements amongst friends
public class Splitwise {
  private List<Person> members;
  private int averageExpensePerPerson;

  Splitwise(List<Person> members, int averageExpensePerPerson) {
    this.members = members;
    this.averageExpensePerPerson = averageExpensePerPerson;
    members.forEach(member -> updateExpenses(member));
  }

  private void updateExpenses(Person member) {
    member.updateDueAmount(averageExpensePerPerson);
  }

  List<Transaction> settleDebts() {
    List<Transaction> transactions = new ArrayList<>();
    Optional<Person> maxDebit = members.stream().min(Person::compareTo);
    Optional<Person> maxCredit = members.stream().max(Person::compareTo);
    if (!maxDebit.isPresent() || !maxCredit.isPresent()) {
      return transactions;
    }
    while (maxDebit.get().hasToSettle() && maxCredit.get().hasToSettle()) {
      transactions.add(maxDebit.get().paysTo(maxCredit.get()));
      maxDebit = members.stream().min(Person::compareTo);
      maxCredit = members.stream().max(Person::compareTo);
    }
    return transactions;
  }
}
