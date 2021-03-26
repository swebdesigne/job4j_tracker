package ru.job4j.bank;

import ru.job4j.collection.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        List<Account> account = new ArrayList<>();
        users.putIfAbsent(user, account);
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (findByRequisite(passport, account.getRequisite()) == null) {
            users.get(user).add(account);
        }
    }

    public User findByPassport(String passport) {
        User result = null;
        for (User value : users.keySet()) {
            if (value.getPassport().equals(passport)) {
                result = value;
            }
        }
        return result;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account result = null;
        User user = findByPassport(passport);
        if (user != null) {
            for (User value : users.keySet()) {
                for (Account list : users.get(value)) {
                    if (list.getRequisite().equals(requisite)) {
                        result = list;
                    }
                }
            }
        }
        return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount)
            throws NullPointerException {
        boolean rsl = false;
        Account account1 = findByRequisite(srcPassport, srcRequisite);
        Account account2 = findByRequisite(destPassport, destRequisite);
        if (account1.getBalance() >= amount) {
            account1.setBalance(account1.getBalance() - amount);
            account2.setBalance(account2.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        String requisite = "3fdsbb9";
        accounts.add(new Account("3fdsbb9", 140));
        int index = accounts.indexOf(new Account(requisite, -1));
        Account find = accounts.get(index);
        System.out.println(find.getRequisite() + " -> " + find.getBalance());
    }
}
