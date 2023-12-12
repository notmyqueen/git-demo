package org.factory.simplefactory;

public class Test {
    public static void main(String[] args) {
        Weapon tank = WeaponFactory.get("TANK");
        tank.attack();

        Weapon fighter = WeaponFactory.get("FIGHTER");
        fighter.attack();

        Weapon dagger = WeaponFactory.get("DAGGER");
        dagger.attack();
    }
}
