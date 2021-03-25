package ru.job4j.bank;

import ru.job4j.collection.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Этот метод должен добавить пользователя в систему.
     * Чтобы добавить пользователя в систему нужно использовать метод Map.put.
     * Этот метод принимает два параметра: пользователя и список счетов.
     * По умолчанию нужно добавить пустой список - new ArrayList<Account>().
     * В методе должна быть проверка, что такого пользователя еще нет в системе.
     * Если он есть, то нового добавлять не надо.
     */

    public void addUser(User user) {
        List<Account> account = new ArrayList<>();
        if (!users.containsKey(user.getPassport())) {
            users.put(user, account);
        }
    }

    /**
     * Должен добавить новый счет к пользователю.
     * Первоначально пользователя нужно найти по паспорту.
     * Для этого нужно использовать метод findByPassport.
     * После этого мы получим список всех счетов пользователя и добавим новый счет к ним.
     * В этом методе должна быть проверка, что такого счета у пользователя еще нет.
     */

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (findByRequisite(passport, account.getRequisite()) == null) {
            users.get(user).add(account);
        }
    }

    /**
     * Этот метод ищет пользователя по номеру паспорта.
     * Здесь нужно использовать перебор всех элементов через цикл for-earch и метод Map.keySet.
     */

    public User findByPassport(String passport) {
        User result = null;
        for (User value : users.keySet()) {
            if (value.getPassport().equals(passport)) {
                result = value;
            }
        }
        return result;
    }

    /**
     * Этот метод ищет счет пользователя по реквизитам. Сначала нужно найти пользователя.
     * Потом получить список счетов этого пользователя и в нем найти нужный счет.
     */

    public Account findByRequisite(String passport, String requisite) {
        Account result = null;
        User user = findByPassport(passport);
        if (user != null) {
            for (User value : users.keySet()) {
                for (Account list : users.get(value)) {
                    if (list.getRequisite().equals(requisite)) {
                        result = list;
                        break;
                    }
                }
            }
        }
        return result;
    }

    /**
     * Метод для перечисления денег с одного счёта на другой счёт.
     * Если счёт не найден или не хватает денег
     * на счёте srcAccount (с которого переводят), то метод должен вернуть false.
     *
     * Метод putIfAbsent позволяет проверить, если ли такой ключ в карте или нет и если его нет,
     * то произвести вставку данных.
     * Этот метод позволяет уменьшить количество кода.
     *
     * Метод List.indexOf позволяет найти индекс элемента по значению.
     * Проверка элементов в этом методе происходит по методу equals.
     * Обратите внимание, что в моделях User и Account используется
     * только одно поле passport и requisite для сравнения объектов.
     * Это позволяет использовать эти методы, без информации о всех полях.
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account account1 = findByRequisite(srcPassport, srcRequisite);
        Account account2 = findByRequisite(destPassport, destRequisite);
        if (account1.getBalance() >= amount) {
            account1.setBalance(account1.getBalance() + 150);
            account2.setBalance(account2.getBalance() + 150);
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
