package org.factory.factorymethod2;

public class Test {
    public static void main(String[] args) {
        WeaponFactory wf1 = new FighterFactory();
        Weapon fighter = wf1.get();
        fighter.attack();

        WeaponFactory wf2=new TankFactory();
        Weapon tank = wf2.get();
        tank.attack();
    }
}
