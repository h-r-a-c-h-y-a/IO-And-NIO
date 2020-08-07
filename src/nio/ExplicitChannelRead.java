package nio;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;

public class ExplicitChannelRead {
    public static void main(String[] args) {
        int count;
        try (SeekableByteChannel fChannel = Files.newByteChannel(Paths.get("src/.new_comb.txt"))) {
            ByteBuffer mBuf = ByteBuffer.allocate(2048);
            do {
                count = fChannel.read(mBuf);
                if (count != -1) {
                    mBuf.rewind();
                    for (int i = 0; i < count; i++) {
                        System.out.print((char) mBuf.get());
                    }
                }
            } while (count != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

class ExplicitChannelWrite {
    public static void main(String[] args) {
        try (FileChannel fChan = (FileChannel) Files.newByteChannel(Paths.get("src/test.txt"), CREATE, WRITE)) {
            ByteBuffer mBuf = ByteBuffer.allocate(26);
            for (int i = 0; i < 3; i++) {
                for (char c = 'A'; c <= 'Z'; ) {
                    mBuf.put((byte) (c++));
                }
                mBuf.rewind();
                fChan.write(mBuf);
                mBuf.rewind();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ReadAllBytes{
    public static void main(String[] args) throws IOException {
//        byte[] content = null;
//        content  = Files.readAllBytes(Paths.get("src/.new_comb.txt"));
//        for (int i = 0; i < content.length; i++) {
//            System.out.print((char) content[i]);
//        }
        String[] themes = {"Collections", "IO & NIO", "Linux command line"};
        List<String> list = new ArrayList<>();
        list.add("Astxik");
        list.add("Arshak");
        list.add("Hrachya");
        for (int i = 0; i < 20; i++) {
            Collections.shuffle(list);
        }
        int i = 0;
        for (String name: list) {
            System.out.println(name + " -> " + themes[i++]);
        }
    }
}
