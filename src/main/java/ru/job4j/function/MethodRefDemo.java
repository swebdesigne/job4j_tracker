package ru.job4j.function;

import java.util.function.Predicate;

public class MethodRefDemo {
    static boolean numTest(IntPredicate p, int v) {
        return p.test(v);
    }

    public static void main(String[] args) {
        boolean result;
        result = numTest(MyIntPredicate::isPrime, 17);
        if (result) {
            System.out.println("Seventeen is prime number");
        }
        result = numTest(MyIntPredicate::isEven, 12);
        if (result) {
            System.out.println("Twelve is even number");
        }
        result = numTest(MyIntPredicate::isPositive, 11);
        if (result) {
            System.out.println("Eleven is positive number");
        }
    }
}
