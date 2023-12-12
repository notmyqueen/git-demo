package org.factory.simplefactory;

import org.factory.simplefactory.Weapon;

public class Fighter extends Weapon {

    @Override
    public void attack() {
        System.out.println("飞机发射飞毛腿！");
    }
}
