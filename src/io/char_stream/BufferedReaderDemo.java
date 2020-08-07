package io.char_stream;

import java.io.*;

public class BufferedReaderDemo {
    public static void main(String[] args) {
        String s = " Это знак авторского права &сору; " + ", а &сору - нет.\n";
        char[] buf = new char[s.length()];
        s.getChars(0, s.length(), buf, 0);
        boolean marked = false;
        int c;
        CharArrayReader in = new CharArrayReader(buf);
        try (BufferedReader br = new BufferedReader(in)) {
            while ((c = br.read()) != -1) {
                switch (c) {
                    case '&':
                        if (!marked) {
                            marked = true;
                            br.mark(32);
                        }
                        break;
                    case ';':
                        if (marked) {
                            System.out.print("(c)");
                            marked = false;
                        } else {
                            System.out.print((char) c);
                        }
                        break;
                    case ' ':
                        if (marked) {
                            marked = false;
                            br.reset();
                            System.out.print("&");
                        } else {
                            System.out.print((char) c);
                        }
                        break;
                    default: {
                        if (marked) break;
                        System.out.print((char) c);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


class BufReaderDemo{
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/.new_comb.txt"))) {
            br.lines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}