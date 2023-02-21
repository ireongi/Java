package Java_Network.D00_Pokemon;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class PokemonServer {

    public static void main(String[] args) {
        new PokemonServer();
        System.out.println("포켓몬 서버 시작됨");
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(3000));
            System.out.println("요청 대기중 ...");
            SocketChannel socketChannel = serverSocketChannel.accept();
            System.out.println("클라이언트 접속됨");

            boolean running = true;
            while (running) {
                while (true) {
                    System.out.println("클라이언트 메세지 수신 대기중...");
                    HelperMethods.sendMessage(socketChannel, "총 " + Pokemon.count + "마리의 포켓몬이 생성되었습니다\n");
                    HelperMethods.sendMessage(socketChannel, "1) 포켓몬 생성  q) 프로그램 종료 :");
                    System.out.print("클라이언트 메세지: ");
                    if (HelperMethods.receiveMessage(socketChannel).equalsIgnoreCase("q")) {
                        System.out.println("q");
                        System.out.println("포켓몬 서버를 종료합니다");
                        running = false;
                        break;
                    } else {
                        System.out.println("1");
                        HelperMethods.sendMessage(socketChannel, "1) 피카츄  2) 꼬부기  3) 파이리 :");
                        String num = HelperMethods.receiveMessage(socketChannel);
                        System.out.println();
                        HelperMethods.sendMessage(socketChannel, "플레이어 이름 입력 :");
                        String owner = HelperMethods.receiveMessage(socketChannel);
                        HelperMethods.sendMessage(socketChannel, "사용 가능한 기술 입력(/로 구분하여 입력) :");
                        String skills = HelperMethods.receiveMessage(socketChannel);
                        Pokemon poke = null;
                        switch (num) {
                            case "1" -> poke = new Pikachu(owner, skills);
                            case "2" -> poke = new Ggoboogi(owner, skills);
                            case "3" -> poke = new Pairi(owner, skills);
                            default -> {
                                HelperMethods.sendMessage(socketChannel, "메뉴에서 골라주세요");
                            }
                        }
                        int idx = 0;
                        HelperMethods.sendMessage(socketChannel, poke.getOwner() + "의 포켓몬이 사용 가능한 스킬");
                        for(String skill : poke.getSkills()){HelperMethods.sendMessage(socketChannel, ++idx + " : " + skill +"\n");}

                        HelperMethods.sendMessage(socketChannel, "공격 번호 선택 :");
                        int i = Integer.parseInt(HelperMethods.receiveMessage(socketChannel));
                        HelperMethods.sendMessage(socketChannel, poke.getSkills().get(i-1) + "공격 시전!\n");
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}











