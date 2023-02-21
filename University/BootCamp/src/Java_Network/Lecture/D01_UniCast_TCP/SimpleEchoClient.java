// 1) 그냥 소켓 생성
// 2)
// 3)
package Java_Network.Lecture.D01_UniCast_TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SimpleEchoClient {

    public static void main(String[] args) {
        System.out.println("Echo Client Start");
        try {
            InetAddress localAddress = InetAddress.getLocalHost();
            try (Socket clientSocket = new Socket(localAddress , 6000);
                 PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())))
                 {
                     System.out.println("Connected to server");
                     Scanner sc = new Scanner(System.in);
                     while (true) {
                         System.out.print("Enter text: ");
                         String inputLine = sc.nextLine();
                         if ("quit".equalsIgnoreCase(inputLine)) {
                             break; // 종료 조건
                         }
                         pw.println(inputLine); // 서버로 전송
                         // 서버로부터 수신받은 객체에서 라인단위 전송
                         System.out.println("Echo from Server : " + br.readLine());
                     }
                 } catch (IOException ex) { System.out.println("InOut Exception");}
        } catch (UnknownHostException e){throw new RuntimeException(e);}
    }
}



