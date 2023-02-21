package Java_Network.Lecture.D00_Pokemon;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class PokemonClient {
    public PokemonClient() {
        SocketAddress address = new InetSocketAddress("127.0.0.1", 3000);
        try (SocketChannel socketChannel = SocketChannel.open(address)) {
            System.out.println("포켓몬 서버 접속됨");
            String message;
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("서버 메세지 수신 대기중...");
                System.out.println("서버 메세지: ");
                System.out.println(HelperMethods.receiveMessage(socketChannel));
                System.out.print("> ");
                message = scanner.nextLine();
                if (message.equals("q")) {
                    HelperMethods.sendMessage(socketChannel, message);
                    break;
                }
                HelperMethods.sendMessage(socketChannel, message);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new PokemonClient();
    }
}
