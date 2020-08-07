package io.other;

import java.io.Console;

public class ConsoleDemo {
    public static void main(String[] args) {
        String str;
        Console console;
        console = System.console();
        if (console == null) return;
        str = console.readLine("enter string: ");
        console.printf("your str: %s, thank for writing)");
    }
}
