package com.company.characters;

import com.company.Arena;

public class Person_Paladin extends Person {

    private final int hp_can_heal =  100;
    public Person_Paladin(String name, Status.Gender gen, Status.Opponents team){
        setHp_MAX(200);
        setHealth(200);
        setAttack(15);
        setWeigtht_can_carry(10);
        setLife(Status.Life_Status.Alive);
        setName(name);
        setSex(gen);
        setTeam(team);
    }


    @Override
    public boolean attack_Enemy(Arena field, Status.Diraction turn) {
        int[] x = getLocation();
        int a;
        boolean key;
        switch (turn){
            
        }
        return key;
    }

    @Override
    public void special_action(Person enemy) {
        int hp=hp_can_heal+enemy.getHealth();
        if (hp>enemy.getHp_MAX())
             enemy.setHealth(getHp_MAX());
        else
            enemy.setHealth(hp);
    }
}
