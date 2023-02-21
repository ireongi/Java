package Java_Network.Self.Chap1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ModernEchoClient {
    public static <Suppier> void main(String[] args) {
        System.out.println("Simple Echo Client");
        try{
            System.out.println("Wating for connection ...");
            InetAddress localAdress = InetAddress.getLocalHost(); // 1) 내 컴퓨터 IP 주소 받기

            try(Socket clientSocket = new Socket(localAdress, 3000); // 2) 소켓 생성 -> 내 IP, 포트번호로 서버 식별
                PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())))
            {
                System.out.println("Connection to server");
                Scanner sc = new Scanner(System.in);
                Supplier<String> scInput = () -> sc.next();
                System.out.print("Enter text : ");
                Stream.generate(scInput)
                      .map(s -> {pw.println(s);
                          System.out.println("Server response : Oh did you say " + s + "?");
                          System.out.print("Enter text : ");
                          return s;})
                      .allMatch(s -> !"quit".equalsIgnoreCase(s));
                }
            }catch (IOException e){}
    }
}
