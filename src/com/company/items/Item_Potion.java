package com.company.items;

import com.company.characters.Person;
import com.company.characters.Status;

public class Item_Potion extends Item {
    private int count;
    private int healed_HP;
    public Item_Potion(){
        count = 1;
        healed_HP = 50;
        setCost(2) ;
        setWeigth(1);
        setUse_Range(2);
    }

    public void setCount(int count) {
        this.count = count;
    }
    public int getCount() {
        return count;
    }
    public int gethealed_HP() {
        return healed_HP;
    }

    public void use_Potion(Person user){
        if(user.getLife() == Status.Life_Status.Dead) {
            System.out.println("Смерть зельями не лечится.");
        }
        else {
           user.setHealth(user.getHealth() + healed_HP);
           if (user.getLife() == Status.Life_Status.Alive && user.getHealth()>user.getHp_MAX()) {
               user.setHealth(user.getHp_MAX());
           }
           if (user.getLife() == Status.Life_Status.Walking_Dead && user.getHealth() >= 0) {
                user.setLife(Status.Life_Status.Dead);
           }
        }

    }

    @Override
    public void drop_Item (Person user) {
        if (user.drinks == null)
            System.out.println("Вы выбросили воздух, ужу чувствуете себя легче?");
        else {
            user.setWeigth_carried(user.getWeigth_carried() - getWeigth());
            if (count>1)
                count--;
            else
                user.drinks = null;
        }
    }

    @Override
    public void pass_item(Person user, Person friend) {
        if (user.drinks == null)
            System.out.println(user.getName()+" не может передать отсутсвие предмета.");
        else {
            int [] x1=user.getLocation();
            int [] x2=friend.getLocation();
            if (friend.getWeigth_can_carry() - friend.getWeigth_carried() >= getWeigth() && Math.abs(x1[0]-x2[0])+Math.abs(x1[1]-x2[1])== getUse_Range()){
                user.setWeigth_carried(user.getWeigth_carried() - getWeigth());
                if (count>1)
                    count--;
                else
                    user.drinks = null;
                if (friend.drinks == null) {
                    friend.drinks=new Item_Potion();
                    friend.setWeigth_carried(friend.getWeigth_carried()+getWeigth());
                }
                else
                    friend.drinks.setCount(friend.drinks.getCount()+1);
            }
            else
                System.out.println(friend.getName()+" не сможет принять зелье");
        }
    }

    @Override
    public void sell_item(Person user) {
        if (user.getGold() >= getCost() && (user.getWeigth_can_carry() - user.getWeigth_carried() >= getWeigth()) ){
            user.setGold( user.getGold() - getCost());
            user.setWeigth_carried(user.getWeigth_carried()+getWeigth());
            if (user.drinks == null)
                user.drinks = new Item_Potion();
            else
                user.drinks.setCount(getCount()+1);
        }
        else {
            System.out.println(user.getName()+" не может купить зелья");
        }
    }
}
