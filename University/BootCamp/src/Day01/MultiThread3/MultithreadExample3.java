package Day01.MultiThread3;

// 다중상속 : Runnable 인터페이스를 받는 자식클래스를 Tread의 매개변수로 넣기

public class MultithreadExample3 {
    public static void main(String args[]) {
        SmallLetters obth = new SmallLetters();
        Thread thread = new Thread(obth);

        //Thread thread = new Thread(new SmallLetters()); //가독성 up
        thread.start();
        char arr[] = { 'ㄱ', 'ㄴ', 'ㄷ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅅ',
                'ㅇ', 'ㅈ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ' };
        for (char ch : arr)
            System.out.print(ch);
    }
}
