package company.items;

import company.characters.Person;

public interface Item {
    public void drop_Item (Person user);
    public void pass_item(Person user, Person friend);

}
