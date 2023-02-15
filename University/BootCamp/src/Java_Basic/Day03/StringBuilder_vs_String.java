package Java_Basic.Day03;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;

public class StringBuilder_vs_String {

    public static void main(String[] args) {
        String s = new String("hello");
        long start = System.nanoTime();
        for(int i = 1; i<100000; i++)
            s = s + "~~";
        long end = System.nanoTime();
        System.out.println(end - start);


        StringBuilder sb = new StringBuilder("hello");
        start = System.nanoTime();
        for(int i = 1; i<100000; i++)
            sb = sb.append("~~");
        end = System.nanoTime();
        System.out.println(end - start);
    }
}