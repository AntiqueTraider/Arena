package com.company.items;

import com.company.characters.Person;

public abstract class Item {
    private int use_Range;
    private int weigth;
    private int cost;

    public int getUse_Range() {
        return use_Range;
    }
    public int getWeigth() {
        return weigth;
    }
    public int getCost() {
        return cost;
    }

    public void setUse_Range(int use_Range) {
        this.use_Range = use_Range;
    }
    public void setWeigth(int weigth) {
        this.weigth = weigth;
    }
    public void setCost(int cost){
        this.cost=cost;
    }


    public abstract void drop_Item (Person user);
    public abstract void pass_item(Person user, Person friend) throws Exception;
    public abstract void sell_item (Person user);
}
