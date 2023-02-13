package Java_Basic.Day01.MultiThread3;

class SmallLetters implements Runnable {
    public void run() {
        for (char ch = 'a'; ch <= 'z'; ch++)
            System.out.print(ch);
    }
}

