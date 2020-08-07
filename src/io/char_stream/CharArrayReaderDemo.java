package io.char_stream;

import java.io.CharArrayReader;
import java.io.IOException;

public class CharArrayReaderDemo {
    public static void main(String[] args) {
        String tmp = "abcdefghijklrnnopqrstuvwxyz";
        int length = tmp.length();
        char[] buf = new char[length];
        tmp.getChars(0, length, buf, 0);
        int i;
        try(CharArrayReader input1 = new CharArrayReader(buf)) {
            System.out.println("input1:");
            while ((i = input1.read()) != -1){
                System.out.print((char) i);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(CharArrayReader input2 = new CharArrayReader(buf, 0, 5)) {
            System.out.println("input2:");
            while ((i = input2.read()) != -1){
                System.out.print((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
