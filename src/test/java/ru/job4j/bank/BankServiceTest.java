package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BankServiceTest {

    @Test
    public void addUser() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        assertThat(bank.findByPassport("3434"), is(user));
    }

    @Test
    public void addAccount() {
    }

    @Test
    public void findByPassport() {
    }

    @Test
    public void findByRequisite() {
    }

    @Test
    public void transferMoney() {
    }
}