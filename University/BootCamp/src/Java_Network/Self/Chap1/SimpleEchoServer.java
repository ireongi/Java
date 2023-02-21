package Java_Network.Self.Chap1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleEchoServer {
    public static void main(String[] args) {
        System.out.println("Simple Echo Server");
        try(ServerSocket serverSocket = new ServerSocket(6000)){ // 1) 서버소켓 생성(포트 6000번)
            System.out.println("Waiting for connection ...");
            Socket clientSocket = serverSocket.accept(); // 2) 접속 요청이 오면 소켓 생성
            System.out.println("Connection to client");
            try(BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); // 3) 귀(읽음) & Input
                PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true)){ // 4) 입(쓰고) & Output // 5) autoFlush 자동 flushing

                String Line;
                while ((Line = br.readLine()) != null){ // Line을 readLine으로 한 줄씩 읽고 Null 값이 아니라면 서버에 출력 및
                    System.out.println("Client request : " + Line);
                    pw.println("oh you said " + Line + "?");                           // 클라이언트로 Line 내보내기
                }
                }catch(IOException ex){

            }

        }catch (IOException ex){
            System.out.println("Exception");
        }
    }
}
