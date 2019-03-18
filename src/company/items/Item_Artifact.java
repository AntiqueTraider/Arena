package company.items;

import company.characters.Person;

public class Item_Artifact implements Item {
    private int attack_bonus;
    public static int use_Range;
    public static int weigth;
    public static int cost;

    public Item_Artifact(){
        attack_bonus = 20;
        cost = 20;
        weigth = 5;
        use_Range = 5;
    }


    @Override
    public void drop_Item(Person user) {

            user.setWeigth_carried(user.getWeigth_carried() - weigth);
            user.tool=null;
    }

    @Override
    public void pass_item(Person user, Person friend) {
            int [] x1=user.getLocation();
            int [] x2=friend.getLocation();
            if (friend.tool == null && friend.getWeigth_can_carry() - friend.getWeigth_carried() >= weigth && Math.abs(x1[0]-x2[0])+Math.abs(x1[1]-x2[1])== use_Range) {
                user.setWeigth_carried(user.getWeigth_carried() - weigth);
                user.setAttack(user.getAttack()-attack_bonus);
                user.tool = null;
                friend.tool = new Item_Artifact();
                friend.setWeigth_carried(friend.getWeigth_carried() + weigth);
                friend.setAttack(friend.getAttack()+attack_bonus);
            }
            else
                System.out.println(friend.getName()+" не сможет принять Артефакт");
    }

}
