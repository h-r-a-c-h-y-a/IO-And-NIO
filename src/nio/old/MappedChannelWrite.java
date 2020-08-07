package nio.old;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Objects;

public class MappedChannelWrite {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        FileChannel fChan = null;
        MappedByteBuffer mBuf;
        try {
            fos = new FileOutputStream("src/.new_comb.txt");
            fChan = fos.getChannel();
            mBuf = fChan.map(FileChannel.MapMode.READ_WRITE, 0,26);
            for (int i = 0; i < 26; i++) {
                mBuf.put((byte) ('A' + i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                Objects.requireNonNull(fChan).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Objects.requireNonNull(fos).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
