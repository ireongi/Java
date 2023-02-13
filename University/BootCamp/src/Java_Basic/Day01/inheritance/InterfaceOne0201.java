package Java_Basic.Day01.inheritance;

class Carrier {
    public void fetch() {
        System.out.println("승객을 운반하다");
    }
}

class Car extends Carrier implements IVehicle
{
    public Car(){
        System.out.println("난 Car 기본생성자");
    }
    @Override
    public void fetch(){
        System.out.println("Car가 승객을 탑승시킴");
    }
    @Override
    public void driving(){
        System.out.println("Car 타고 드라이빙");
    }
    @Override
    public void stop(){
        System.out.println("Car 가 정지한다.");
    }
    @Override
    public void start() {
        System.out.println("Car 가 출발한다.");

    }

}

interface IZerg{
    public abstract void display(); //종족 개수
    default public void zergAttack(){System.out.println("Zerg 공격개시");}
}
interface ITerran{ public abstract void terranAttack();}
interface IProtous{ public abstract void protousAttack();}
interface IGame extends IZerg, ITerran, IProtous{ public abstract void Goodgame();} //GG}

class StarCraft implements IGame{
    @Override
    public void display() {System.out.println("Zerg종족 개수 표시");}
    @Override
    public void Goodgame() {System.out.println("좋은 게임이었다.");}
    @Override
    public void terranAttack() {System.out.println("Terran 공격개시");}
    @Override
    public void protousAttack() {System.out.println("Protous 공격개시");}
}


public class InterfaceOne0201 {
    public static void main(String[] args) {
        //Car k5 = new Car();
        IVehicle k5 = new Car(); // UpCasting 자식객체를 부모타입에 넣기 - 다형성
        k5.start();
        k5.stop();
        //k5.turn(); error
        IVehicle.turn(); //정적 메서드는 해당 클래스명으로 호출(객체생성 변수로 호출 x)
        k5.driving(); //IVehicle 안 abstract 메소드 만들기 abstract void driving();

        StarCraft g1 = new StarCraft();
        g1.zergAttack();
        g1.display();
        g1.Goodgame();
        g1.terranAttack();
        g1.protousAttack();
    }

}

