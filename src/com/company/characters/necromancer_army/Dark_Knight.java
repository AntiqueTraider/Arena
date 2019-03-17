package com.company.characters.necromancer_army;

import com.company.Arena;
import com.company.characters.Person;
import com.company.characters.Status;
import com.company.characters.Undead_Features;

public class Dark_Knight extends Person implements Undead_Features {
    private boolean undeadMove = false;

    public Dark_Knight(){
        setHp_MAX(50);
        setHealth(50);
        setAttack(5);
        setWeigtht_can_carry(5);
        setLife(Status.Life_Status.Alive);
        setName("Пешка Некроманта");
        setSex(Status.Gender.Male);
        setTeam(team);
        becomeUndead();
    }
    public void becomeUndead(){
        setLife(Status.Life_Status.Walking_Dead);
    }
    public void undeadSpecialMove(){
        if (!undeadMove)
            System.out.println("Нежить избегает смерти в поседний раз");
    }
    public boolean undeadAttack(Arena field, Status.Diraction turn){
        int[] x = getLocation();
        int a;
        boolean key;
        switch (turn) {

            case Up:
                if (x[1]>0){
                    key=true;
                    a=(x[1]-2 >=0)? x[1]-2: x[1]-1;
                    for(int i = a; i < x[1]; i++)
                        field.doDamage(x[0], i, getAttack(), getTeam());
                }
                else
                    key = false;
                break;

            case Down:
                if (x[1]<field.wide-1){
                    a = (x[1]+2 <= field.wide-1)? x[1]+2:x[1]+1;
                    key = true;
                    for(int i = x[1]+1; i < a; i++)
                        field.doDamage(x[0], i, getAttack(), getTeam());
                }
                else
                    key = false;
                break;

            case Right:
                if (x[0]<field.wide-1){
                    a = (x[0]+2 <= field.wide-1)? x[0]+2:x[0]+1;
                    key = true;
                    for(int i = x[0]+1; i < a; i++)
                        field.doDamage(i, x[1], getAttack(), getTeam());
                }
                else
                    key = false;
                break;

            case Left:
                if (x[0]>0){
                    a=(x[0]-2 >=0)? x[0]-2: x[0]-1;
                    key=true;
                    for(int i = a; i < x[0]; i++)
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
    public boolean attack_Enemy (Arena field, Status.Diraction turn) throws Exception {
        throw new Exception();
    }
    public void special_action (Person enemy) throws Exception{
        throw new Exception();
    }
}
