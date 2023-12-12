package org.factory.factorymethod;

/*
    具体产品角色
 */
public class DaggerFactory extends WeaponFactory{
    @Override
    public Weapon get() {
        return new Dagger();
    }
}
