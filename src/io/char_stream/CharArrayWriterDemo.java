package io.char_stream;

import java.io.CharArrayWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CharArrayWriterDemo {
    public static void main(String[] args) {
        CharArrayWriter f = new CharArrayWriter();
        String s = "this elements must be puts to array";
        char[] buf = new char[s.length()];
        s.getChars(0, s.length(), buf, 0);
        try {
            f.write(buf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(f.toString());
        buf = f.toCharArray();
        for (int i = 0; i < buf.length; i++) {
            System.out.print(buf[i]);
        }
        System.out.println();
        try(FileWriter fw = new FileWriter("text.txt")){
           f.writeTo(fw);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        f.reset();
        for (int i = 0; i < 3; i++) {
            f.write('X');
        }
        System.out.println(f.toString());
    }
}
