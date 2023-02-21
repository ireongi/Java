package Java_Network.Lecture.D02_MultiCast_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

// Time Client
public class MulitCastClient {
    public static void main(String args[]) {
        System.out.println("Multicast  Time Client");
        try (MulticastSocket socket = new MulticastSocket(10000))
        {
             InetAddress group = InetAddress.getByName("224.0.0.117");
             socket.joinGroup(group);
             System.out.println("Multicast  Group Joined");
             byte[] buffer = new byte[256];
             DatagramPacket packet = new DatagramPacket(buffer, buffer.length); // 인수 2개
             for (int i = 0; i < 10; i++) {
                socket.receive(packet);
                String received = new String(packet.getData());
                System.out.println(received.trim());
            }
            socket.leaveGroup(group); // 멀티 캐스트 타임 서버 탙퇴
        } catch (IOException ex) {// Handle exception
            }
        System.out.println("Multicast  Time Client Terminated");
    }
}
