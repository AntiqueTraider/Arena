package com.company.company.characters.necromancer_army;

import com.company.company.Arena;
import com.company.company.characters.Person;
import com.company.company.characters.Status;
import com.company.company.characters.Undead_Features;

public class Dark_Knight extends Person implements Undead_Features {
    public boolean undeadSP = false;

    public Dark_Knight(Status.Opponents x) {
        setHp_MAX(60);
        setHealth(60);
        setAttack(10);
        setWeigtht_can_carry(15);
        becomeUndead();
        setName("Живой мертвец Черный Рыцарь");
        setSex(Status.Gender.Male);
        setTeam(x);
    }
    @Override
    public void becomeUndead() {
        setLife(Status.Life_Status.Walking_Dead);
    }

    @Override
    public void undeadSpecialMove() {
        if (!undeadSP) {
            setHealth(getHp_MAX());
            System.out.println("Нежить избегает смерти в последний раз");
            undeadSP = true;
        }
    }

    @Override
    public boolean undeadAttack(Arena field, Status.Diraction turn) {

        int[] x = getLocation();
        boolean key;
        int a;
        switch (turn) {

            case Up:
                if (x[0]>0){
                    a = (x[0]-2 >= 0)? x[0]-2 : x[0]-1;
                    key=true;
                    for(int i = a; i < x[0]; i++)
                        field.doDamage(i, x[1], getAttack(), getTeam());
                }
                else
                    key = false;
                break;

            case Down:
                if (x[0]<field.wide-1){
                    a = (x[0]+2 <= field.wide-1) ? x[0]+2 : x[0]+1;
                    key = true;
                    for(int i = x[0]+1; i < a; i++)
                        field.doDamage(i, x[1], getAttack(), getTeam());
                }
                else
                    key = false;
                break;

            case Right:
                if (x[1]<field.wide-1){
                    a = (x[1]+2 <= field.wide-1) ? x[1]+2 : x[1]+1;
                    key = true;
                    for(int i = x[1]+1; i < a; i++)
                        field.doDamage(x[0], i, getAttack(), getTeam());
                }
                else
                    key = false;
                break;

            case Left:
                if (x[1]>0){
                    a = (x[1]-2 >= 0)? x[1]-2 : x[1]-1;
                    key=true;
                    for(int i = a; i < x[1]; i++)
                        field.doDamage(x[0], i, getAttack(), getTeam());
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
    public boolean attack_Enemy(Arena field, Status.Diraction turn) {
        return false;
    }

    @Override
    public void special_action(Person enemy)  {
        System.out.println();
    }

}
