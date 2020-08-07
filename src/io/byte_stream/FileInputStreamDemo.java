package io.byte_stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamDemo {
    public static void main(String[] args) {
        int size;
        try(FileInputStream fin = new FileInputStream("src/io/FileDemo.java")){
            System.out.println("file available size " + (size = fin.available()));
            int n = size / 40;
            System.out.println("first " + n + " bytes");
            for (int i = 0; i < n; i++) {
                System.out.println((char) fin.read());
            }
            System.out.println("available " + fin.available());
            byte[] bytes = new byte[n];
            if (fin.read(bytes) != n){
                System.err.println("Нельзя прочитать " + n + " байтов.") ;
            }
            System.out.println(new String(bytes, 0, n));
            System.out.println("available " + (size = fin.available()));
            fin.skip(size / 2);
            if (fin.read(bytes, n / 2, n / 2) != n / 2){
                System.err.println("Нельзя прочитать "+ n/2 + " байтов.");
            }
            System.out.println(new String(bytes, 0, bytes.length));
            System.out.println("available " + fin.available());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class FileOutputStreamDemo {
    public static void main(String[] args) {
        String source = "Now is the time for all good men\n" +
                " to come to the aid of their country\n" +
                " and рау their due taxes.";
        byte[] buf = source.getBytes();
        try(FileOutputStream f1 = new  FileOutputStream("file1.txt");
            FileOutputStream f2 = new  FileOutputStream("file2.txt");
            FileOutputStream f3 = new  FileOutputStream("file3.txt")){

            for (int i = 0; i < buf.length; i += 2) {
                f1.write(buf[i]);
            }

            f2.write(buf);

            f3.write(buf, buf.length - buf.length / 4, buf.length / 4);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}