package ru.job4j.function;

public class GenericFunctionalInterfaceDemo {
    public static void main(String[] args) {
        SomeTest<Integer> isFactor = (n, d) -> (n % d) == 0;
        if (isFactor.test(10, 2)) {
            System.out.println("Two is delimiter of the 10");
        }
        System.out.println();
        SomeTest<Double> isFactorD = (n, d) -> (n % d) == 0;
        if (isFactorD.test(212.0, 4.0)) {
            System.out.println("Two is delimiter of the 212.0");
        }
        System.out.println();
        SomeTest<String> isIn = (a, b) -> a.indexOf(b) != -1;
        String str = "Full functional interface";
        if (isIn.test(str, "face")) {
            System.out.println("'face' found");
        } else {
            System.out.println("'face' not fond");
        }
    }
}
