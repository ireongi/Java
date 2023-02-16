package Java_Network.D03_;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Day24 {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = null;

        InetAddress names[] = InetAddress.getAllByName("www.naver.com");
        for(InetAddress element : names) {
            System.out.println(element);
        }

        try {
            address = InetAddress.getByName("www.packtpub.com");
        } catch (UnknownHostException e){

        }
    }
}
