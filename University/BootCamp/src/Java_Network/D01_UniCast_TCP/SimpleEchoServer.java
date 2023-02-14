// 1) 그냥 소켓, 서버 소켓 하나씩 생성
// 2) buffer 2가지(송신pw, 수신br)만들어 데코레이트
// 3) Br(getInputStream으로 클라이언트 소켓에서 가져옴)
// 4) Pw(getOutputStream으로 클라이언트 소켓에서 받아옴, autoFlush로 버퍼를 자동 비움)
// 5) ReadLine 메소드로 한줄씩 받아서

package Java_Network.D01_UniCast_TCP;

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
                                                                                    // autoFlush buffer를 자동으로 비움
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
//                    out.close(); try(){} -> try{} 일때 세트 (클래식 코드)
                }
            }
        } catch (IOException ex) {  // Handle exceptions
            System.out.println("Connection Miss"); //예외처리
        }
    }
}
