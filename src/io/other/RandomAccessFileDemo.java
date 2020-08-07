package io.other;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Objects;

public class RandomAccessFileDemo {
    public static void main(String[] args) throws IOException {
        String filePath = "src/file.txt";
//        writeData(filePath, "DATA", 0);
//        appendData(filePath, "sequence");
//        System.out.println(new String(Objects.requireNonNull(readCharsFromFile(filePath, 0, 50))));
        RandomAccessFile raFile = new RandomAccessFile(filePath, "r");
        while (raFile.getFilePointer() < raFile.length()-1){
            System.out.print( raFile.readUTF());
        }
    }

    private static void appendData(String filePath, String data) {
        RandomAccessFile raFile = null;
        try {
            raFile = new RandomAccessFile(filePath, "rw");
            System.out.println("file length: " + raFile.length());
            raFile.seek(raFile.length());
            System.out.println("current pointer: " + raFile.getFilePointer());
            raFile.writeUTF(data);
            System.out.println("file length: " + raFile.length());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raFile != null) {
                try {
                    raFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void writeData(String filePath, String data, int position) {
        RandomAccessFile file = null;
        try {
            file = new RandomAccessFile(filePath, "rw");
            System.out.println("file length: " + file.length());
            file.seek(position);
            file.writeUTF(data);
            System.out.println("file length: " + file.length());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static byte[] readCharsFromFile(String filePath, int position, int chars) {
        RandomAccessFile file = null;
        try {
            file = new RandomAccessFile(filePath, "r");
            file.seek(position);
            byte[] buf = new byte[chars];
            file.read(buf);
            return buf;
        } catch (IOException e) {
            return null;
        } finally {
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

