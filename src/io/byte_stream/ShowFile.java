package io.byte_stream;

import java.io.*;

public class ShowFile {
    public static void main(String[] args) {
        int i;
        FileInputStream fin = null;
        try {
            fin = new FileInputStream("src/io/byte_stream/combinations.txt");
            try {
                do {
                    i = fin.read();
                    if (i != -1) System.out.print((char) i);
                } while (i != -1);
            } catch (IOException e) {
                System.out.println(" Oшибкa чтения из файла ");
            }
        } catch (FileNotFoundException e) {
            System.out.println("cannot read file");
        } finally {
            try {
                if (fin != null) fin.close();
            } catch (IOException e) {
                System.out.println("Oшибкa закрытия файла");
            }
        }
    }
}

class CopyFile{
    public static void main(String[] args) {
        int i;
        FileInputStream fin = null;
        FileOutputStream fos = null;
        File file = new File("src/io/byte_stream/a/b/c/d/");
        System.out.println(file.mkdirs());
        try{
            fin = new FileInputStream("src/io/byte_stream/combinations.txt");
            fos = new FileOutputStream(file.getPath() + "/comb.txt");
            do {
                i = fin.read();
                if (i != -1) fos.write((char)i);
                System.out.print((char)i);
            }while (i != -1);
        } catch (FileNotFoundException e) {
           e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}