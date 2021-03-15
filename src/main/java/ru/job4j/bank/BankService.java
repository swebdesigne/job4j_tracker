package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<String, List<User>> users = new HashMap<>();

    public void addUser(User user) {
        List<User> account = new ArrayList<>();
        if (!users.containsKey(user.getPassport())) {
            account.add(user);
            users.put(user.getPassport(), account);
        }
    }

    public void addAccount(String passport, Account account) {

    }

    public User findByPassport(String passport) {
        for (String value : users.keySet()) {
            if (value.equals(passport)) {
            }
        }
        return users.get(passport);
    }

    public Account findByRequisite(String passport, String requisite) {
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
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
