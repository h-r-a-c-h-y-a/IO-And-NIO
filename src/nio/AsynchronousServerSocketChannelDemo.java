package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AsynchronousServerSocketChannelDemo {
    private int port = 8080;

    public static void main(String[] args) {
        AsynchronousServerSocketChannelDemo server = new AsynchronousServerSocketChannelDemo();
        server.startAsyncServer();
    }

    public void startAsyncServer() {
       try {
           AsynchronousServerSocketChannel assc =
                   AsynchronousServerSocketChannel.open()
                   .bind(new InetSocketAddress(port));
           while (true){
               Future<AsynchronousSocketChannel> socketFuture = assc.accept();
               while (!socketFuture.isDone()){
                   Thread.sleep(200);
               }
               AsynchronousSocketChannel asc = socketFuture.get();
               ByteBuffer bb = ByteBuffer.allocate(1200);
               int byteCount = asc.read(bb).get();
               System.out.println("bytes read from client " + byteCount);
               bb.flip();
               String clientInput = Charset.defaultCharset().decode(bb).toString();
               System.out.println(clientInput);

               ByteBuffer bbOut = ByteBuffer.wrap("take the info".getBytes());
               bbOut.rewind();
               asc.write(bbOut, null, new CompletionHandler<Integer, Object>() {
                   @Override
                   public void completed(Integer result, Object o) {
                       System.out.println("number of bytes sent to client " + result);
                   }

                   @Override
                   public void failed(Throwable throwable, Object attachment) {
                       System.out.println("failed to sent resp " + attachment);
                   }
               });
               Thread.sleep(1000);
               asc.close();
           }
       } catch (IOException | ExecutionException | InterruptedException e) {
           e.printStackTrace();
       }
    }
}
