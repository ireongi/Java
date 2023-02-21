package Java_Network.Self.Chap1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ModernEchoServer {
    public static void main(String[] args) {
        System.out.println("Simple Echo Server");
        try(ServerSocket serverSocket = new ServerSocket(3000)){ // 1) 서버소켓 생성(포트 6000번)
            System.out.println("Waiting for connection ...");
            Socket clientSocket = serverSocket.accept(); // 2) 접속 요청이 오면 소켓 생성
            System.out.println("Connection to client");
            try(BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); // 3) 귀(읽음) & Input
                PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true)){ // 4) 입(쓰고) & Output // 5) autoFlush 자동 flushing

                Supplier<String> socketInput = () -> {try{return br.readLine();}catch (IOException ex){return null;}};
                Stream<String> stream = Stream.generate(socketInput);
                stream.map(s->{System.out.println("Client request: " + s); pw.println(s); return s; })
                      .allMatch(s->s!=null);

            }catch(IOException ex){}

        }catch (IOException ex){
            System.out.println("Exception");
        }
    }
}
