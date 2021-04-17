package ru.job4j.function;

public class LamdaDemo2 {
    public static void main(String[] args) {
        StringTest isIn = (a, b) -> a.indexOf(b) != -1;
        String str = "This is test";
        System.out.println("String of testing: " + str);

        if (isIn.test(str, "This")) {
            System.out.println("This`s this is found");
        } else {
            System.out.println("This`s this is not found");
        }
    }
}
