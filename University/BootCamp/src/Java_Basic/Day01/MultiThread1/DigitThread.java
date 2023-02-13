package Java_Basic.Day01.MultiThread1;

class DigitThread extends Thread {
    public void run() {
        for (int cnt = 0; cnt < 10; cnt++)
            System.out.print(cnt);
    }
}

