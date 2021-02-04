package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private final Output output;
    private Scanner scanner = new Scanner(System.in);

    public ConsoleInput(Output output) {
        this.output = output;
    }

    @Override
    public String askStr(String question) {
        output.println(question);
        return scanner.nextLine();
    }

    @Override
    public int askInt(String question) {
        return Integer.valueOf(askStr(question));
    }
}
