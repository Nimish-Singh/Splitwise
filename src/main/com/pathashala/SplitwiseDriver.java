package com.pathashala;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Represents the I/O for splitwise
public class SplitwiseDriver {
  public static void main(String[] args) {
    String members = "A,B,C,D";
    String[] expenses = {"A 300 Snacks", "C 100 Tickets", "D 200 Taxi"};
    HashMap<String, Integer> personList = new HashMap<>();
    List<Person> memberList = new ArrayList<>();
    String[] names = members.split(",");
    int averageExpensePerPerson = 0;

    for (int i = 0; i < names.length; i++) {
      personList.put(names[i], 0);
    }

    for (int i = 0; i < expenses.length; i++) {
      String[] expensePerPerson = expenses[i].split(" ");
      String name = expensePerPerson[0];
      int expense = Integer.parseInt(expensePerPerson[1]);
      if (personList.containsKey(name)) {
        personList.put(name, personList.get(name) + expense);
      }
      averageExpensePerPerson += expense;
    }
    averageExpensePerPerson /= names.length;

    for (HashMap.Entry<String, Integer> entry : personList.entrySet()) {
      memberList.add(new Person(entry.getKey(), entry.getValue()));
    }

    Splitwise trip = new Splitwise(memberList, averageExpensePerPerson);
    List<Transaction> transactions = trip.settleDebts();
    transactions.forEach(transaction -> System.out.println(transaction));
  }
}
