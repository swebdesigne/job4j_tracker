package ru.job4j.bank;

import ru.job4j.collection.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковского сервиса.
 * @author IGOR SIVOLOBOV
 * @version 1.0
 * @since 04.04.2021
 */
public class BankService {
    /**
     * Класс связывает владельца(User) с его счетами(Account).
     * User хранится в ключе
     * В значении хранится список Account
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет User в список, если в списке такого User еще нет
     *
     * @param user принимает в качестве параметра User,
     *             который должен быть добавлен в списке
     */
    public void addUser(User user) {
        List<Account> account = new ArrayList<>();
        users.putIfAbsent(user, account);
    }

    /**
     * Метод добавляет новый Account в список счетов User'а
     * Сначала ищет владельца счета в списке users
     * по его паспортным данным (String passport)
     * Если User найден, и добавляемого счёта в списке его счетов нет,
     * то производится добавление счёта в список.
     *
     * @param passport принимает параметром паспортные данные в формате строки
     * @param account  принимает параметром счёт, который нужно добавить
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод ищет владельца счёта в списке users по его паспортным данным
     *
     * @param passport принимает параметром паспортные данные в формате строки
     * @return возвращает User, если владелец счета найден в перечне users, или null
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(value -> value.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод ищет счет по реквизитам и паспортным данным владельца счета
     *
     * @param passport  принимает параметром паспортные данные в формате строки
     * @param requisite принимает параметром реквизиты в формате строки
     * @return Если счет найден, возвращает Account. Если не найден, то null
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод осуществляет перевод между счетами
     *
     * @param srcPassport   - паспортные данные владельца,
     *                      со счета которого осуществляется перевод
     * @param srcRequisite  - реквизиты счета, с которого осуществляется перевод
     * @param destPassport  - паспортные данные владельца,
     *                      на счет которого осуществляется перевод
     * @param destRequisite - реквизиты счета, на который осуществляется перевод
     * @param amount        - сумма перевода
     * @return true, если перевод успешен, в противном случае false.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account account1 = findByRequisite(srcPassport, srcRequisite);
        Account account2 = findByRequisite(destPassport, destRequisite);
        if ((account1 != null && account2 != null) && account1.getBalance() >= amount) {
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
