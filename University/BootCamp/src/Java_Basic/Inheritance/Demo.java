package Java_Basic.Inheritance;

public class Demo {
    public static void main(String[] args) {
        Babarian b1 = new Babarian();
        Sorceress s1 = new Sorceress();
        Bow windForce = new Bow();
        Axe berserkerAxe = new Axe();
        b1.setWeapon(berserkerAxe);
        s1.setWeapon(windForce); // get weapon
        s1.performWeapon();
        b1.performWeapon();
        s1.setWeapon(new Axe());
        s1.performWeapon();
    }
}
