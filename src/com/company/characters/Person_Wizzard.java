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
    public boolean attack_Enemy(Arena field, Status.Diraction turn) {
        int[] x = getLocation();
        boolean key;
        switch (turn) {

                case Up:
                   if (x[1]>0){
                     key=true;
                     for(int i = 0; i < x[1]; i++)
                        field.doDamage(x[0], i, getAttack(), getTeam());
                   }
                   else
                        key = false;
                break;

                case Down:
                    if (x[1]<field.wide-1){
                        key = true;
                        for(int i = x[1]+1; i < field.wide; i++)
                            field.doDamage(x[0], i, getAttack(), getTeam());
                    }
                    else
                        key = false;
                break;

                case Right:
                     if (x[0]<field.wide-1){
                         key = true;
                         for(int i = x[0]+1; i < field.wide; i++)
                             field.doDamage(i, x[1], getAttack(), getTeam());
                     }
                     else
                         key = false;
                break;

                case Left:
                    if (x[0]>0){
                        key=true;
                        for(int i = 0; i < x[0]; i++)
                            field.doDamage(i, x[1], getAttack(), getTeam());
                    }
                    else
                        key = false;
                break;

                default:
                    key=false;
                    break;
        }
        return key;
    }

    @Override
    public void special_action(Person enemy) {
        if (!sp_moveUsed) {
            enemy.setBaf_debuf(Status.Effects.Power_Up);
            enemy.setAttack(enemy.getAttack() + getAttack());
            sp_moveUsed = true;
        }
    }
}
