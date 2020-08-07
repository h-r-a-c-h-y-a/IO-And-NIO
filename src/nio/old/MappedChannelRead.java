package nio.old;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Objects;

public class MappedChannelRead {
    public static void main(String[] args) {
        FileInputStream fin = null;
        FileChannel fChan = null;
        MappedByteBuffer mBuf;
        try {
            fin = new FileInputStream("src/.new_comb.txt");
            fChan = fin.getChannel();
            mBuf = fChan.map(FileChannel.MapMode.READ_ONLY, 0, fChan.size());

            for (int i = 0; i < fChan.size(); i++) {
                System.out.print((char) mBuf.get());
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
                Objects.requireNonNull(fin).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
