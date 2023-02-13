package Java_Basic.Day01.inheritance;

public interface IVehicle {

    //int makeYear = 2022 ;
    //final int makeYear = 2022 ;
    //public final int makeYear = 2022 ;
    public static final int makeYear = 2022;

    //void start()  ;
    //abstract void start() ;
    public abstract void start();

    default public void stop() //Interface 안에만 default 메소드 생성가능(가장 기본적인 내용)
    {
        System.out.println("정지한다");
    }

    private void show() {
        System.out.println("makeYear=" +
                makeYear);
    }

    public static void turn() {
        System.out.println("방향전환한다");
    }

    static class Price {
        int salePercent = 10;
    }

    abstract void driving();


}
