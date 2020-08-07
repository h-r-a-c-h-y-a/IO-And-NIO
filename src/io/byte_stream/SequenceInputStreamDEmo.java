package io.byte_stream;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

public class SequenceInputStreamDEmo {
    public static void main(String[] args) {
        int c;
        Vector<String> files = new Vector<>();
        files.add("src/file1.txt");
        files.add("src/file2.txt");
        files.add("src/file3.txt");
        InputStreamEnumerator ise = new InputStreamEnumerator(files);
        InputStream in = new SequenceInputStream(ise);
        try{
            while ((c = in.read()) != -1){
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class InputStreamEnumerator implements Enumeration<FileInputStream>{

    private Enumeration<String> files;

    public InputStreamEnumerator(Vector<String> files){
        this.files = files.elements();
    }

    @Override
    public boolean hasMoreElements() {
        return files.hasMoreElements();
    }

    @Override
    public FileInputStream nextElement() {
        try {
            return new FileInputStream(files.nextElement());
        } catch (FileNotFoundException e) {
           return null;
        }
    }
}