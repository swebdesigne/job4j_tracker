package ru.job4j.function;

public class MethodRefDemo2 {
    public static void main(String[] args) {
        boolean result;
        MyIntNum myNum = new MyIntNum(12);
        MyIntNum myNum2 = new MyIntNum(16);
        IntPredicate ip = myNum::isFactor;
        result = ip.test(3);
        if (result) {
            System.out.println("Three is delimiter: " + myNum.getNum());
        }
        ip = myNum2::isFactor;
        result = ip.test(3);
        if (!result) {
            System.out.println("Three is not delimiter: " + myNum2.getNum());
        }
    }
}
