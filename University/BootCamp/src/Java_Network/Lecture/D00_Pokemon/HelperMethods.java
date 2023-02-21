package Java_Network.Lecture.D00_Pokemon;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class HelperMethods {
    private static final Charset CHARSET = StandardCharsets.UTF_8;

    public static void sendMessage(SocketChannel socketChannel, String message) throws IOException {
        ByteBuffer buffer = CHARSET.encode(message);
        socketChannel.write(buffer);
    }

    public static String receiveMessage(SocketChannel socketChannel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        socketChannel.read(buffer);
        buffer.flip();
        CharBuffer charBuffer = CHARSET.decode(buffer);
        return charBuffer.toString();
    }
}
