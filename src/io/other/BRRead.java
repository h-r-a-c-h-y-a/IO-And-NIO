package io.other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class BRRead {
    public static void main(String[] args) throws IOException {
        char c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            c = (char) br.read();
            System.out.print(c);
        } while (c != 'q');
    }
}

class BRReadLines {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        do {
            str = br.readLine();
            if (str.trim().equals("exit")) break;
            System.out.println(str);
        } while (!str.trim().equals("exit"));
    }
}

class TinyEdit {
    public static void main(String[] args) throws IOException {
        String[] strings = new String[100];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = 0;
        do {
            strings[i] = br.readLine();
            if (strings[i].trim().equals("exit")) break;
            i++;
        } while (i < 100);
        for (String string : strings) {
            if (strings[i].trim().equals("exit")) break;
            System.out.println(string);
        }
    }
}

class PrintWriterDemo{
    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);
        pw.println("this text");
        pw.println(-7);
        pw.println(4.5e-7);
        pw.flush();
    }
}