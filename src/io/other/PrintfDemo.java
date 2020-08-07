package io.other;

public class PrintfDemo {
    public static void main(String[] args) {
        System.out.printf("%d %(d %+d %05d%n", 3, -3, 3, 3);
        System.out.println();

        System.out.printf("%f%n", 1234567.123);
        System.out.println();

        System.out.printf("%,f%n", 1234567.123);
        System.out.println();

        System.out.printf("%,f%n", -1234567.123);
        System.out.println();

        System.out.printf("%,(f%n", -1234567.123);
        System.out.println();

        System.out.printf("% ,.2f%n ,.2f%n", -1234567.123);
        System.out.println();

    }
}
