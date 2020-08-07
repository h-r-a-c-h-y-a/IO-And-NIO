package io.char_stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("src/io/char_stream/FileReaderDemo.java")) {
            int c;
            while ((c = fr.read()) != -1) System.out.print((char) c);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class FileWriterDemo {
    public static void main(String[] args) {
        String source = "Now is the time for all good men\n" +
                " to соmе to the aid of their country\n" +
                " and рау their due taxes.";
        char[] buf = new char[source.length()];
        source.getChars(0, source.length(), buf, 0);
        try(FileWriter fw1 = new FileWriter("test1.txt");
            FileWriter fw2 = new FileWriter("test2.txt");
            FileWriter fw3 = new FileWriter("test3.txt"); ){
            for (int i = 0; i < buf.length; i += 2) {
                fw1.write(buf[i]);
            }
            fw2.write(buf);
            fw3.write(buf, buf.length - buf.length / 4, buf.length / 4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
