package com.company.characters;

import com.company.Arena;

public class Person_Necromancer extends Person implements Undead_Features{

    public Person_Necromancer(String name, Status.Gender gen, Status.Opponents team){
        setHp_MAX(200);
        setHealth(200);
        setAttack(5);
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
