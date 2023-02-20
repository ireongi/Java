// 1) 그냥 소켓, 서버 소켓 하나씩 생성
// 2) buffer 2가지(송신pw, 수신br)만들어 데코레이트
// 3) Br(getInputStream으로 클라이언트 소켓에서 가져옴)
// 4) Pw(getOutputStream으로 클라이언트 소켓에서 받아옴, autoFlush로 버퍼를 자동 비움)
// 5) ReadLine 메소드로 한줄씩 받아서

package Java_Network.D03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class SimpleEchoServer {
    public static void main(String[] args) {
        System.out.println("Echo Server");
        try (ServerSocket serverSocket = new ServerSocket(6000)) { // 클라이언트 받을 소켓 생성
            System.out.println("Waiting for client connection.....");
            Socket clientSocket = serverSocket.accept(); // 클라이언트 연결됨
            System.out.println("Connected to client");
            try (BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true)) // 받고 & 출력
            // autoFlush buffer를 자동으로 비움
            {
                String Line; // 한줄씩 받아 출력
                while ((Line = br.readLine()) != null) {
                    try {
                        StringTokenizer st = new StringTokenizer(Line, "+,-,*,/", true);
                        int result = 0, operand = 0;
                        char operator = '+';
                        while (st.hasMoreTokens()) {
                            String token = st.nextToken().trim(); // trim : 불필요한 공란 등 제거

                            if ("+-*/".indexOf(token) >= 0) {
                                operator = token.charAt(0);
                            } else {
                                operand = Integer.parseInt(token);

                                switch (operator) {
                                    case '+':
                                        result = result + operand;
                                        break;
                                    case '-':
                                        result = result - operand;
                                        break;
                                    case '*':
                                        result = result * operand;
                                        break;
                                    case '/':
                                        result = result / operand;
                                        break;
                                }
                            }
                        }
                        pw.println(Line + "=" + result);

                    } catch (NumberFormatException err) {
                        pw.println("유효하지 않은 입력 값 입니다. 숫자를 입력해주세요.");
                    }
                }
                System.out.println(Thread.currentThread() + " 클라이언트가 종료됨");
            } catch (IOException ex) {
                System.out.println("입출력 예외 발생!");
            }
        } catch (IOException e) {
            System.out.println();
        }
    }
}