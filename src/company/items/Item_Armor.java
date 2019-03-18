package company.items;

import company.characters.Person;

public class Item_Armor implements Item{
    public static int use_Range;
    public static int weigth;
    public static int cost;

    public Item_Armor(){
        cost = 10 ;
        weigth = 10;
        use_Range = 0;
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
