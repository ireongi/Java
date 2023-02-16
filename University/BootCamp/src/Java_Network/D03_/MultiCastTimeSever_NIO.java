package Java_Network.D03_;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;

public class MultiCastTimeSever_NIO {
    public static void main(String args[]) {
        System.out.println("Multicast  Time Server");
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress(2000));
            while(true){
                System.out.println();
                SocketChannel sc = ssc.accept();
                String dt = null;
                if (sc != null){
                    dt = "Date: " + new Date(System.currentTimeMillis());
                }
                ByteBuffer buf = ByteBuffer.allocate(64);
                buf.put(dt.getBytes());
                buf.flip();
                while(buf.hasRemaining()){
                    sc.write(buf);
                }
                System.out.println("전송됨: " + dt);
            }
        } catch (IOException ex) {
            System.out.println("Exception!");
        }
    }
}

