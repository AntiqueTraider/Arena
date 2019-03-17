package com.company.items;

import com.company.characters.Person;

public class Item_Artifact extends Item {
    private int attack_bonus;
    public Item_Artifact(){
        attack_bonus = 20;
        setCost(20);
        setWeigth(5);
        setUse_Range(5);
    }

    @Override
    public void drop_Item(Person user) {
        if (user.tool == null)
            System.out.println("Вы выбросили воздух, ужу чувствуете себя легче?");
        else {
            user.setWeigth_carried(user.getWeigth_carried() - getWeigth());
            user.tool=null;
        }
    }

    @Override
    public void pass_item(Person user, Person friend) {
        if (user.tool == null)
            System.out.println(user.getName()+" не может передать отсутсвие предмета.");
        else {
            int [] x1=user.getLocation();
            int [] x2=friend.getLocation();
            if (friend.tool == null && friend.getWeigth_can_carry() - friend.getWeigth_carried() >= getWeigth() && Math.abs(x1[0]-x2[0])+Math.abs(x1[1]-x2[1])== getUse_Range()) {
                user.setWeigth_carried(user.getWeigth_carried() - getWeigth());
                user.setAttack(user.getAttack()-attack_bonus);
                user.tool = null;
                friend.tool = new Item_Artifact();
                friend.setWeigth_carried(friend.getWeigth_carried() + getWeigth());
                friend.setAttack(friend.getAttack()+attack_bonus);
            }
            else
                System.out.println(friend.getName()+" не сможет принять зелье");
        }
    }

    @Override
    public void sell_item(Person user) {
        if (user.getGold() >= getCost() && (user.getWeigth_can_carry() - user.getWeigth_carried() >= getWeigth()) ){
            if (user.tool == null) {
                user.drinks = new Item_Potion();
                user.setGold( user.getGold() - getCost());
                user.setWeigth_carried(user.getWeigth_carried()+getWeigth());
            }
            else {
                System.out.println(user.getName()+" уже имеет артефакт, более одно использовать нельзя");
            }
        }
        else {
            System.out.println(user.getName()+" не может купить артефакт");
        }
    }
}
