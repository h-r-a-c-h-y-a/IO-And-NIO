package nio.old;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Objects;

public class ExplicitChannelRead {
    public static void main(String[] args) {
        FileInputStream fin = null;
        FileChannel fChan = null;
        ByteBuffer mBuf;
        int count;
        try {
            fin = new FileInputStream("src/.new_comb.txt");
            fChan = fin.getChannel();
            mBuf = ByteBuffer.allocate(128);
            do {
                count = fChan.read(mBuf);
                if (count != -1) {
                    mBuf.rewind();
                    for (int i = 0; i < count; i++) {
                        System.out.print((char) mBuf.get());
                    }
                }
            } while (count != -1);
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                Objects.requireNonNull(fChan).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (fin != null){
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
