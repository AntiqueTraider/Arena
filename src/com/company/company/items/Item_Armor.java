package com.company.company.items;

import com.company.company.characters.Person;

public class Item_Armor implements Item{
    public static int weigth = 10;
    public static int cost = 10;

    public Item_Armor(){
    }

    @Override
    public void drop_Item(Person user) {
            user.setWeigth_carried(user.getWeigth_carried() - weigth);
            user.shell=null;
    }
    @Override
    public void pass_item(Person user, Person friend) {
        System.out.println();
    }

}
