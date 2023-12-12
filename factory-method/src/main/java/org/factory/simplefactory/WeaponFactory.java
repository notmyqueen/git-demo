package org.factory.simplefactory;

public class WeaponFactory {
    public static Weapon get(String weaponType) {
        if("FIGHTER".equals(weaponType)) {
            return new Fighter();
        } else if("TANK".equals(weaponType)) {
            return new Tank();
        } else {
            throw new RuntimeException("不支持该生产类型");
        }
    }
}
