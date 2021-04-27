package ru.job4j.map;

import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }

    public static void main(String[] args) {
        Stream.of(Suit.values())
        .flatMap(level -> Stream.of(Value.values())
                .map(task  -> level + " " + task))
        .forEach(System.out::println);
    }
}
