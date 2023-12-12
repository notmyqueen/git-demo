package org.example.simplefactory;

/*
    这是客户端程序，就是消费者，消费端
 */
public class Test {
    public static void main(String[] args) {
        //需要坦克
        Weapon tank = WeaponFactory.get("TANK");
        tank.attack();
        //需要匕首
        Weapon dagger = WeaponFactory.get("DAGGER");
        dagger.attack();
        //需要战斗机
        Weapon fighter = WeaponFactory.get("FIGHTER");
        fighter.attack();
    }
}
