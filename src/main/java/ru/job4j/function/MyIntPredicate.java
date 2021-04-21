package ru.job4j.function;

/**
 * @author Igor Sivolobv
 * @since 21.04.20
 * @version 1.0
 */
public class MyIntPredicate {
    /**
     * @param n - the number which input
     * @return - return true if n is prime number else false
     */
    static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= n / i; i++) {
            if ((n % i) == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param n - the number which input
     * @return - return true if n is even number else false
     */

    static boolean isEven(int n) {
        return (n % 2) == 0;
    }

    /**
     * @param n - the number which input
     * @return - return true if n is positive number else false
     */
    static boolean isPositive(int n) {
        return n > 0;
    }
}
