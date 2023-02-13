package Java_Network.D01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.charset.MalformedInputException;

public class _StreamReader {
    public static void main(String[] args) throws IOException {
        try {
            URL url = new URL("www.inha.ac.kr");
            URLConnection urlConnection = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream())
            ); //Buffer에 담아놨다가

            String line; //Line으로 한 줄씩 받기
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close(); //닫아주기
        } catch (MalformedInputException e) {
            throw  new RuntimeException(e);
        } catch (IOException ex){
            System.out.println("입출력 오류");
        }
    }
}