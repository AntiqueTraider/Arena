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
            case  Up:
                if (x[1]>0) {
                    key = true;
                    field.doDamage(x[0],x[1]-1,getAttack(),getTeam());
                }
                else
                    key=false;
                break;
            case  Down:
                if (x[1]<field.wide-1) {
                    key = true;
                    field.doDamage(x[0],x[1]+1,getAttack(),getTeam());
                }
                else
                    key=false;
                break;
            case  Right:
                if (x[0]<field.wide-1) {
                    key = true;
                    field.doDamage(x[0]+1,x[1],getAttack(),getTeam());
                }
                else
                    key=false;
                break;
            case  Left:
                if (x[0]>0) {
                    key = true;
                    field.doDamage(x[0]-1,x[1],getAttack(),getTeam());
                }
                else
                    key=false;
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
            int hp = hp_can_heal + enemy.getHealth();
            if (hp > enemy.getHp_MAX())
                enemy.setHealth(getHp_MAX());
            else
                enemy.setHealth(hp);
            sp_moveUsed=true;
        }
    }
}
