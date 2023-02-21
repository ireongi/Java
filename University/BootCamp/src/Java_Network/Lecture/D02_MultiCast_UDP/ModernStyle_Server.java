package Java_Network.Lecture.D02_MultiCast_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;

public class ModernStyle_Server {

        public static void main(String args[]) {
            System.out.println("Multicast  Time Server");
            DatagramSocket serverSocket = null;
            try {
                serverSocket = new DatagramSocket(); // UDP
                while (true) {
                    String dateText = new Date().toString(); // 시간 정보 가져오기
                    byte[] buffer = new byte[256];
                    buffer = dateText.getBytes();
                    InetAddress group = InetAddress.getByName("224.0.0.7");
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, 10000); // 인수 4개
                    // 224.0.0.7로 10000번 Packet을 계속 보냄,    224.0.0.7에 group을 만듦
                    serverSocket.send(packet);
                    System.out.println("Time sent: " + dateText); // 전송된 시간
                    try {
                        Thread.sleep(1000); // 1초 단위 딜레이(Try 구문 안에서만 Thread.sleep 사용 가능)
                    } catch (InterruptedException ex) {
                        // Handle exception
                    }
                }
            } catch (SocketException ex) {
                // Handle exception
            } catch (IOException ex) {
                // Handle exception
            }
        }
    }



