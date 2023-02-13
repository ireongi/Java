package Java_Basic.Day01.MultiThread1;

// 1) Tread만 상속

public class MultithreadExample1 {
    public static void main(String args[]) {
        Thread thread = new DigitThread();
        thread.start();
        for (char ch = 'A'; ch <= 'Z'; ch++)
            System.out.print(ch);
    }
}

