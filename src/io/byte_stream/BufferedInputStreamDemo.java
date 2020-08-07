package io.byte_stream;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class BufferedInputStreamDemo {
    public static void main(String[] args) {
        String s = "this is author permission symbol &...; and this not & ... ;\n";
        ByteArrayInputStream bais = new ByteArrayInputStream(s.getBytes());
        int c;
        boolean marked = false;
        try(BufferedInputStream bis = new BufferedInputStream(bais)) {
            while ((c = bis.read()) != -1){
                switch (c){
                    case '&':
                        if (!marked){
                            bis.mark(32);
                            marked = true;
                        }else {
                            marked = false;
                        }
                        break;
                    case ';':
                        if (marked){
                            marked = false;
                            System.out.print("(c)");
                        }else {
                            System.out.print((char) c);
                        }
                        break;
                    case ' ' :
                        if (marked){
                            marked = false;
                            bis.reset();
                            System.out.print("&");
                        }else {
                            System.out.print((char) c);
                        }
                        break;
                    default:
                        if (!marked){
                            System.out.print((char) c);
                        }
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
