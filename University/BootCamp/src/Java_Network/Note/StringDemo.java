package Java_Network.Note;

import java.util.Arrays;
import java.util.Comparator;

public class StringDemo{
    public static void main(String[] args) {
        String[] strings = {"Hello friend professor1", "Hi", "Hello friend", "Hello friend professor2"};

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                System.out.println(o1);
                System.out.println(o2);
                System.out.println();
                return o1.length() - o2.length();
            }
        });

        for(String s : strings)
            System.out.println(s);
    }
}
