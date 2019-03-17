package com.company.characters;

import com.company.Arena;

public class Person_Knight extends Person {

    public Person_Knight(String name, Status.Gender gen){
        setHp_MAX(300);
        setHealth(300);
        setAttack(25);
        setWeigtht_can_carry(15);
        setLife(Status.Life_Status.Alive);
        setName(name);
        setSex(gen);
    }
    @Override
    public void attack_Enemy(Arena battlefield, Status.Diraction turn) {
        int [] x = getLocation();
        int a,b;
        switch (turn){
            case Up:
                if (x[1]<=0){
                    a=(x[0]-1<0)?0:x[0]-1;
                    b=(x[0]>battlefield.wide-1)?battlefield.wide-1:x[0]+1;

                }
        }
    }

    @Override
    public void special_action(Arena battlefield, Status.Diraction turn) {

    }


    @Override
    public void move(Arena battlefield) {

    }
}
