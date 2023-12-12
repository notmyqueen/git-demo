package org.factory.factorymethod;

/*
    客户端
 */
public class Test {
    public static void main(String[] args) {
        WeaponFactory weaponFactory = new DaggerFactory();
        Weapon dagger = weaponFactory.get();
        dagger.attack();

        WeaponFactory weaponFactory1 = new TankFactory();
        Weapon tank = weaponFactory.get();
        tank.attack();
    }
}
