package org.factory.factorymethod2;

public class FighterFactory extends WeaponFactory {
    @Override
    public Weapon get() {
        return new Fighter();
    }
}
