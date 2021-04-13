package ru.job4j.function;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.*;

public class FunctionInterfaceUsage {
    public static void main(String[] args) {
        List<String> list = List.of("one", "two", "three", "one", "two", "three");
        System.out.println("list is empty ? " + list.isEmpty());
        Supplier<Set<String>> sup = () -> new HashSet<>(list);
        BiConsumer<Integer, String> consumer = (s, s1) -> System.out.println(s + s1);
        Set<String> strings = sup.get();
        int i = 1;
        for (String s : strings) {
            consumer.accept(i++, " is " + s);
        }
        Predicate<String> pred = s -> s.isEmpty();
        System.out.println("String is empty: " + pred.test(""));
        System.out.println("String is empty: " + pred.test("test"));
        BiPredicate<String, Integer> cond = (s, c) -> s.contains(c.toString());
        System.out.println("String have substring: " + cond.test("Name123", 123));
        System.out.println("String have substring: " + cond.test("Name", 123));
        String name = "Igor";
        Function<String, Character> func = s -> s.charAt(2);
        BiFunction<String, Integer, String> biFunc = (s, d) -> s.concat(" ").concat(d.toString());
        System.out.println("Result the work biFunction: " + biFunc.apply("Name", 123));
        System.out.println("Result the work biFunction: " + biFunc.apply("Name", 12345));
        UnaryOperator<StringBuilder> builder = b -> b.reverse();
        System.out.println("String after reverse: " + builder.apply(new StringBuilder("String for test")));
        System.out.println("String after reverse: " + builder.apply(new StringBuilder("tset rof gnirtS")));
        BinaryOperator<StringBuilder> biBuilder = (b1, b2) -> b1.append(" ").append(b2);
        System.out.println(
                "String after concatenation: " + biBuilder.apply(
                        new StringBuilder("first string"),
                        new StringBuilder("second string")
                )
        );
    }
}
