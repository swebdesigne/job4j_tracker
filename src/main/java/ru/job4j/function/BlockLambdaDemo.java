package ru.job4j.function;

public class BlockLambdaDemo {
    public static void main(String[] args) {
        NumericFuc func = (n) -> {
            int result = 1;
            n = n < 0 ? -n : n;
            for (int i = 2; i <= n / i; i++) {
                if ((n % i) == 0) {
                    result = i;
                    break;
                }
            }
            return result;
        };
        System.out.println("Most less delimiter of the number of 12 " + func.func(12));
        System.out.println("Most less delimiter of the number of 11 " + func.func(11));
    }
}
