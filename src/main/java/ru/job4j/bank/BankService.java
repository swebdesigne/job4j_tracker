package ru.job4j.bank;

import com.sun.source.tree.BreakTree;
import ru.job4j.collection.Order;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent() && !users.get(user.get()).contains(account)) {
            users.get(user.get()).add(account);
        }
    }

    /**
     * Метод ищет владельца счёта в списке users по его паспортным данным
     *
     * @param passport принимает параметром паспортные данные в формате строки
     * @return возвращает User, если владелец счета найден в перечне users, или null
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(value -> value.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод ищет счет по реквизитам и паспортным данным владельца счета
     *
     * @param passport  принимает параметром паспортные данные в формате строки
     * @param requisite принимает параметром реквизиты в формате строки
     * @return Если счет найден, возвращает Account. Если не найден, то null
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        Optional<Account> rsl = Optional.empty();
        if (user.isPresent()) {
            rsl = users.get(user.get())
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst();
        }
        return rsl;
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
        Optional<Account> account1 = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> account2 = findByRequisite(destPassport, destRequisite);
        if ((account1 != null && account2 != null) && account1.get().getBalance() >= amount) {
            account1.get().setBalance(account1.get().getBalance() - amount);
            account2.get().setBalance(account2.get().getBalance() + amount);
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
