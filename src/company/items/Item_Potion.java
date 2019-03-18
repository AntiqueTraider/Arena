package company.items;

import company.characters.Person;
import company.characters.Status;

public class Item_Potion implements Item {
    private int count;
    private int healed_HP;
    public static int use_Range;
    public static int weigth;
    public static int cost;
    public Item_Potion(){
        count = 1;
        healed_HP = 50;
        cost = 2 ;
        weigth = 1;
        use_Range = 2;
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
           if (user.getLife()== Status.Life_Status.Walking_Dead) {
               user.setHealth(user.getHealth() - gethealed_HP());
               if (user.getHealth() < 0) {
                   System.out.println("В следующий раз дважды подумайте, прежде чем лечить нежить зельями для живых");
                   user.setLife(Status.Life_Status.Dead);
               }
           }
           else{
               user.setHealth(gethealed_HP()+user.getHealth());
               if(user.getHealth()>user.getHp_MAX()) {
                   user.setHealth(user.getHp_MAX());
               }
           }
        }
    }

    @Override
    public void drop_Item (Person user) {
            user.setWeigth_carried(user.getWeigth_carried() - weigth);
            if (count>1)
                count--;
            else
                user.drinks = null;
    }

    @Override
    public void pass_item(Person user, Person friend) {
            int [] x1=user.getLocation();
            int [] x2=friend.getLocation();
            if (friend.getWeigth_can_carry() - friend.getWeigth_carried() >= weigth && Math.abs(x1[0]-x2[0])+Math.abs(x1[1]-x2[1]) == use_Range){
                user.setWeigth_carried(user.getWeigth_carried() - weigth);
                if (count>1)
                    count--;
                else
                    user.drinks = null;
                if (friend.drinks == null) {
                    friend.drinks=new Item_Potion();
                    friend.setWeigth_carried(friend.getWeigth_carried()+weigth);
                }
                else
                    friend.drinks.setCount(friend.drinks.getCount()+1);
            }
            else
                System.out.println(friend.getName()+" не сможет принять зелье");
        }

}
