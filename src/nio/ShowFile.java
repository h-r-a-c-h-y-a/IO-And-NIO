package nio;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ShowFile {
    public static void main(String[] args) {
        int i;
        if (args.length != 1) {
            System.out.println("Note: where and where to copy");
            return;
        }
        try (InputStream in = Files.newInputStream(Paths.get(args[0]))) {
            do {
                i = in.read();
                if (i != -1) System.out.print((char) i);
            }while (i != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
