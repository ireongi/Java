package Java_Network.Self.Chap1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class SimpleEchoClient {
    public static void main(String[] args) {
        System.out.println("Simple Echo Client");
        try{
            System.out.println("Wating for connection ...");
            InetAddress localAdress = InetAddress.getLocalHost(); // 1) 내 컴퓨터 IP 주소 받기

            try(Socket clientSocket = new Socket(localAdress, 6000); // 2) 소켓 생성 -> 내 IP, 포트번호로 서버 식별
                PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))){
                System.out.println("Connection to server");
                Scanner sc = new Scanner(System.in);
                while(true){
                    System.out.print("Enter text : ");
                    String Line = sc.nextLine();
                    if("quit".equalsIgnoreCase(Line)){
                        break;
                    }
                    pw.println(Line); // scanner로 받은 문자열을 서버의 br로 Line 보냄
                    String rp = br.readLine(); // 서버에서 오는 값을 클라이언트의 br로 받아 rp에 저장
                    System.out.println("Server response : " + rp);
                }
            }catch (IOException e){}
        }catch (IOException ex){}
    }
}
