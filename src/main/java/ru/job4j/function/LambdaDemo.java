package ru.job4j.function;

public class LambdaDemo {
    public static void main(String[] args) {
        NumericTest isFactor = (n, d) -> (n % d) == 0;

        if (isFactor.test(10, 2)) {
            System.out.println("two is delimiter 10");
        }
        if (!isFactor.test(10, 2)) {
            System.out.println("three is not delimiter 10");
        }

        NumericTest lessThan = (n, m) -> (n < m);

        if (lessThan.test(2, 10)) {
            System.out.println("two less than ten");
        }
        if (!lessThan.test(10, 2)) {
            System.out.println("ten not less than two");
        }
        System.out.println();

        NumericTest absEqual = (n, m) -> (n < 0 ? -n : n) == (m < 0 ? -m : m);

        if (absEqual.test(4, -4)) {
            System.out.println("Absolutely values of four and four less zero to equal");
        }
        System.out.println();

        if (!lessThan.test(4, -5)) {
            System.out.println("Absolutely values four and five less zero not equals");
        }
        System.out.println();
    }
}
