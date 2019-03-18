package company.items;

import company.characters.Person;

public class Item_Armor extends Item{


    public Item_Armor(){
        setCost(10) ;
        setWeigth(10);
        setUse_Range(0);
    }

    @Override
    public void drop_Item(Person user) {
        if (user.shell == null)
            System.out.println("Вы выбросили воздух, ужу чувствуете себя легче?");
        else {
            user.setWeigth_carried(user.getWeigth_carried() - getWeigth());
            user.shell=null;
        }
    }
    @Override
    public void pass_item(Person user, Person friend) {
        System.out.println();
    }
    @Override
    public void sell_item(Person user) {
        if (user.getGold() >= getCost() && (user.getWeigth_can_carry() - user.getWeigth_carried() >= getWeigth()) ){
            user.setGold( user.getGold() - getCost());
            user.setWeigth_carried(user.getWeigth_carried()+getWeigth());
            user.shell = new Item_Armor();
        }
        else {
            System.out.println(user.getName()+" не может купить броню");
        }
    }
}
