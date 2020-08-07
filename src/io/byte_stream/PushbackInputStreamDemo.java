package io.byte_stream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.PushbackInputStream;

public class PushbackInputStreamDemo {
    public static void main(String[] args) {
        String s = "if (a == 4) a = 0;\n ";
        byte[] buf = s.getBytes();
        ByteArrayInputStream bais = new ByteArrayInputStream(buf);
        int c;
        try(PushbackInputStream pusback = new PushbackInputStream(bais, buf.length)) {
            while((c = pusback.read()) != -1){
                switch (c){
                    case '=':
                        if ((c = pusback.read()) == '='){
                            System.out.print(".eq.");
                        }else {
                            System.out.print("<-");
                            pusback.unread(c);
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

class PushbackInputDemo{
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out, true);
        String str = "GeeksforGeeks a computer science portal ";
        byte[] buf = str.getBytes();
        ByteArrayInputStream bais = new ByteArrayInputStream(buf);
        PushbackInputStream push = new PushbackInputStream(bais, buf.length);
        int c;
        while ((c = push.read()) != -1){
            pw.print((char) c);
        }
        pw.println();
//        push.unread(buf);
        push.unread(buf, buf.length - 15, 15);
        while ((c = push.read()) != -1){
            pw.print((char) c);
        }
        pw.println();
        pw.close();
        push.close();
    }
}
