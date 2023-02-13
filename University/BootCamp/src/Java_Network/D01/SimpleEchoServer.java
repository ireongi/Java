package Java_Network.D01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleEchoServer {
    public static void main(String[] args) {
        System.out.println("Echo Server");
        try (ServerSocket serverSocket = new ServerSocket(6000)) { // 클라이언트 받을 소켓 생성
            System.out.println("Waiting for client connection.....");
            Socket clientSocket = serverSocket.accept(); // 클라이언트 연결됨
            System.out.println("Connected to client");
            try (BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true)) // 받고 & 출력
            {
                String inputLine; // 한줄씩 받아 출력
                while ((inputLine = br.readLine()) != null) {
                    System.out.println("Message from Client : " + inputLine);
                    pw.println(inputLine); // 클라이언트로 송신(out 객체로 보냄)
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                {
//                    br.close();
//                    out.close(); try(){} -> try{} 일때 세트
                }
            }
        } catch (IOException ex) {  // Handle exceptions
            System.out.println("Connection Miss"); //예외처리
        }
    }
}
