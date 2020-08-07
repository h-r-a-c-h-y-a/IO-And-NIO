package nio;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NIOStreamWrite {
    public static void main(String[] args) {
        try(OutputStream out = new BufferedOutputStream(
                Files.newOutputStream(Paths.get("src/test.txt")))){
            for (int i = 0; i < 26; i++) {
                out.write((byte) ('A' + i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
