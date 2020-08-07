package io.char_stream;

import java.io.CharArrayReader;
import java.io.IOException;
import java.io.PushbackReader;

public class PushBackReaderDemo {
    public static void main(String[] args) {
        String s = "if (a == 4) a = 0;\n";
        char[] buf = new char[s.length()];
        s.getChars(0, s.length(), buf, 0);
        int c;
        CharArrayReader in = new CharArrayReader(buf);
        try(PushbackReader push = new PushbackReader(in)) {
            while ((c = push.read()) != -1){
                switch (c){
                    case '=':
                        if ((c = push.read()) == '=') {
                            System.out.print(".eq.");
                        }else {
                            push.unread(c);
                            System.out.print("=");
                        }
                        break;
                    default:
                        System.out.print((char) c);
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
