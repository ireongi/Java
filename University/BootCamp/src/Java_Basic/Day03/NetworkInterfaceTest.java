//package Java_Basic.Day03;
//
//import java.net.InetAddress;
//import java.net.NetworkInterface;
//import java.net.SocketException;
//import java.util.Collections;
//import java.util.Enumeration;
//
//public class NetworkInterfaceTest {
//    public static void main(String[] args) {
//        try {
//            Enumeration<NetworkInterface> interfaceEnum = NetworkInterface.getNetworkInterfaces();
//            System.out.printf("Name Display name\n");
//            for (NetworkInterface element : Collections.list(interfaceEnum)) {
//                System.out.printf("%-10s  %-50s\n", element.getName(), element.getDisplayName());
//                Enumeration<InetAddress> addresses = element.getInetAddresses();
////                for (InetAddress inetAddress : Collections.list(addresses)) {
////                    System.out.printf("InetAddress: %s\n", inetAddress);
////                }
//               Collections
//                       .list(addresses)
//                       .stream()
//                       .forEach(
//                               (inetAddress) -> {System.out.printf("InetAddress : %s\n" + inetAddress);}
//                       );
//               }
//            } catch (SocketException ex){
//                     System.out.println();
//        }
//    }
//}