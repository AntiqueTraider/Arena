package com.company.characters;

import com.company.Arena;

public class Person_Wizzard extends Person {

    public Person_Wizzard(String name, Status.Gender gen, Status.Opponents team){
        setHp_MAX(150);
        setHealth(1500);
        setAttack(50);
        setWeigtht_can_carry(5);
        setLife(Status.Life_Status.Alive);
        setName(name);
        setSex(gen);
        setTeam(team);
    }
    @Override
    public void attack_Enemy(Arena battlefield, Status.Diraction turn) {

    }

    @Override
    public void special_action(Arena battlefield, Status.Diraction turn) {

    }

    @Override
    public void move(Arena battlefield) {

    }
}
