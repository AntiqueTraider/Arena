package com.company.characters;

import com.company.Arena;
import com.company.items.*;

public abstract class Person {
    private int health;
    private int [] location= new int [2];
    private String name;
    private int attack;
    private Status.Effects baf_debuf;
    private Status.Life_Status life;
    private Status.Gender sex;
    private int weigtht_can_carry;
    private int weigth_carried;
    private int gold;
    private int hp_MAX;
    public Status.Opponents team;
    public Item_Potion drinks;
    public Item_Armor shell;
    public Item_Artifact tool;
    public boolean sp_moveUsed = false;

    static
    {
        System.out.println("Поздравляю с созданием первого персонажа");
    }

    public Person(){
        baf_debuf = Status.Effects.No_Effects;
        weigth_carried = 0;
        gold = 30;
        drinks = null;
        shell = null;
        tool = null;
    }

    public void setTeam( Status.Opponents team){
        this.team = team;
    }
    public void setWeigth_carried( int x) {
         weigth_carried = x;
    }
    public void setAttack(int x) {
         attack = x;
    }
    public void setHealth(int x) {
         health = x;
    }
    public void setBaf_debuf(Status.Effects x) {
         baf_debuf = x;
    }
    public void setSex(Status.Gender x) {
        sex = x;
    }
    public void setWeigtht_can_carry(int x) {
         weigtht_can_carry = x;
    }
    public void setName(String x) {
        name = x;
    }
    public void setLocation(int x, int y) {
       location[0] = x;
       location[1] = y;
    }
    public void setLife(Status.Life_Status x) {
        life = x;
    }
    public void setGold (int x) {
        gold = x;
    }
    public void setHp_MAX(int hp_MAX) {
        this.hp_MAX = hp_MAX;
    }


    public Status.Opponents getTeam() {
        return team;
    }
    public int getWeigth_carried() {
        return weigth_carried;
    }
    public int getAttack() {
        return attack;
    }
    public int getHealth() {
        return health;
    }
    public Status.Effects getBaf_debuf() {
        return baf_debuf;
    }
    public Status.Gender getSex() {
        return sex;
    }
    public int getWeigth_can_carry() {
        return weigtht_can_carry;
    }
    public String getName() {
        return name;
    }
    public int[] getLocation() {
        return location;
    }
    public Status.Life_Status getLife() {
        return life;
    }
    public int getGold() {
        return gold;
    }
    public int getHp_MAX() {
        return hp_MAX;
    }

    public void take_Damage (int damage)
    {
        if (life == Status.Life_Status.Alive) {
            if (shell == null) {
                health -= damage;
                if (health < 0)
                    life = Status.Life_Status.Dead;
            }
            else {
                System.out.println("Броня поглощает весь урон, но становится металаломом");
                shell = null;
            }
        }
        else
            System.out.println("Уже мертво и хуже ему не станет");

    }




    public abstract boolean attack_Enemy (Arena field, Status.Diraction turn);
    public abstract void special_action (Person enemy);
}
