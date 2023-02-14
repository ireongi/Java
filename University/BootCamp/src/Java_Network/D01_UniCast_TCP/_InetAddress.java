// IP 주소 구하기
package Java_Network.D01_UniCast_TCP;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class _InetAddress {
    public static void main(String[] args) {
        try {
            InetAddress addr = InetAddress.getByName("www.inha.ac.kr");
           // InetAddress addr2 = InetAddress.getByName("www.kiminha.ac.kr"); Exception
            System.out.println(addr);
            System.out.println(addr.getCanonicalHostName()); // ip만 가져오기
            System.out.println(addr.getHostAddress()); // 165.246.13.107
            System.out.println(addr.getHostName()); // www.inha.ac.kr
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
            //System.out.println("해당 URL은 존재하지 않습니다.");
        }

    }
}
