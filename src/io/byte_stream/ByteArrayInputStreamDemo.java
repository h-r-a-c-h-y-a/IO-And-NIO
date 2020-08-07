package io.byte_stream;

import java.io.*;

public class ByteArrayInputStreamDemo {
    public static void main(String[] args) {
        String tmp = "abcdefghijklmnopqrstuvwxyz";
        byte[] buf = tmp.getBytes();
        ByteArrayInputStream input1 = new ByteArrayInputStream(buf);
        ByteArrayInputStream input2 = new ByteArrayInputStream(buf, 0, 3);
        int i;
        do {
            i = input1.read();
            if (i != -1) System.out.println((char) i);
        } while (i != -1);
        System.out.println();
        do {
            i = input2.read();
            if (i != -1) System.out.println((char) i);
        } while (i != -1);
    }
}

class ByteArrayInputStreamReset{
    public static void main(String[] args) {
        String tmp = "abc";
        byte[] buf = tmp.getBytes();
        ByteArrayInputStream in = new ByteArrayInputStream(buf);
            int c;
            in.mark(buf[0]);
            while ((c = in.read()) != -1){
                    System.out.print((char) c);
            }
        System.out.println();
            in.reset();
            while ((c = in.read()) != -1){
            in.mark(buf[0]);
                System.out.print(Character.toUpperCase((char) c));
        }
            System.out.println();
    }
}

class ByteArrayOutputStreamDemo{
    public static void main(String[] args) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String s = "This text must written to array";
        byte[] buf = s.getBytes();
        try {
            baos.write(buf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(baos.toString());
        buf = baos.toByteArray();
        for (int i = 0; i < buf.length; i++) {
            System.out.print((char) buf[i]);
        }
        System.out.println();
        try(FileOutputStream out = new FileOutputStream("test.txt")) {
            baos.writeTo(out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        baos.reset();
        for (int i = 0; i < 3; i++) {
            baos.write('X');
        }
        System.out.println(baos.toString());
    }
}
