package org.factory.simplefactory;

public class Tank extends Weapon{
    @Override
    public void attack() {
        System.out.println("坦克攻击！");
    }
}
