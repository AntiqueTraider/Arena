package company;

import company.characters.*;
import company.characters.necromancer_army.Dark_Knight;
import company.characters.necromancer_army.Lich;
import company.items.*;

import java.util.Scanner;

/*
Внутренний класс field будет содержать кодовый символ,
для каждого объекта, свободной ячейки ("*")
далее - ниже
 */
public class Arena {
    public final int wide=4;
    public String command;

    private Person_Knight knights[] = new Person_Knight[2]; // k - for knights
    private Person_Paladin paladins[] = new Person_Paladin[2];// p - paladins
    private Person_Wizzard gendalvs[] = new Person_Wizzard[2];//g - wizzards
    private Person_Necromancer pathologists[]= new Person_Necromancer[2];//n - necros
    private Dark_Knight dark_knights[] = new Dark_Knight[2]; //d - dark knights
    private Lich lichs[] = new Lich [2]; //l - lichs

    static
    {
        System.out.println("Поздравляю с созданием первой Арены");
    }
    public class field {
        public char code;
        public char color;

        public field(char a) {
            code = a;
            color=' ';
        }
        public void setCell(char a, char c){
            code = a;
            color = c;
        }

    }
    public field  [][] battle = new field[wide][wide];


    public Arena (){
        for (int i = 0; i < wide; i++) {
            for (int j = 0; j < wide; j++)
               battle[i][j]=new field('*');
        }
        knights[0] = null; knights[1] = null;
        paladins[0] = null; paladins[1] = null;
        pathologists[0] = null; pathologists[1] = null;
        gendalvs[0] = null; gendalvs[1] = null;
        dark_knights[0] = null; dark_knights[1] = null;
        lichs[0] = null; lichs[1] = null;
    }

    public void doDamage (int x,int y, int damage, Status.Opponents team){
        if (team == Status.Opponents.Red && battle[x][y].code != ' ') {
            switch (battle[x][y].code) {
                case 'k':
                    knights[0].take_Damage(damage);
                    break;
                case 'p':
                    paladins[0].take_Damage(damage);
                    break;
                case 'g':
                    gendalvs[0].take_Damage(damage);
                    break;
                case 'n':
                    pathologists[0].take_Damage(damage);
                    break;
            }
        }
        else {
            switch (battle[x][y].code) {
                case 'k':
                    knights[1].take_Damage(damage);
                    break;
                case 'p':
                    paladins[1].take_Damage(damage);
                    break;
                case 'g':
                    gendalvs[1].take_Damage(damage);
                    break;
                case 'n':
                    pathologists[1].take_Damage(damage);
                    break;
            }
        }

    }
    public void doCurse (int x,int y, Status.Opponents team){
        if (team == Status.Opponents.Red && battle[x][y].code != ' ') {
            switch (battle[x][y].code) {
                case 'k':
                    knights[0].setBaf_debuf(Status.Effects.Poisoned);
                    break;
                case 'p':
                    paladins[0].setBaf_debuf(Status.Effects.Poisoned);
                    break;
                case 'g':
                    gendalvs[0].setBaf_debuf(Status.Effects.Poisoned);
                    break;
                case 'n':
                    pathologists[0].setBaf_debuf(Status.Effects.Poisoned);
                    break;
            }
        }
        else {
            switch (battle[x][y].code) {
                case 'k':
                    knights[1].setBaf_debuf(Status.Effects.Poisoned);
                    break;
                case 'p':
                    paladins[1].setBaf_debuf(Status.Effects.Poisoned);
                    break;
                case 'g':
                    gendalvs[1].setBaf_debuf(Status.Effects.Poisoned);
                    break;
                case 'n':
                    pathologists[1].setBaf_debuf(Status.Effects.Poisoned);
                    break;
            }
        }

    }

    public void  setBlue(){
        knights[0] = new Person_Knight("Blue Knight", Status.Gender.Male, Status.Opponents.Blue);
        knights[0].setLocation(0,0);
        battle[0][0].setCell('k','b');

        paladins[0] = new Person_Paladin("Blue Paladin",Status.Gender.Female,Status.Opponents.Blue);
        paladins[0].setLocation(1,0);
        battle[1][0].setCell('p','b');

        gendalvs[0] = new Person_Wizzard("Blue Wizzard",Status.Gender.Female,Status.Opponents.Blue);
        gendalvs[0].setLocation(2,0);
        battle[2][0].setCell('g','b');

        pathologists[0] = new Person_Necromancer("Blue Necromancer",Status.Gender.Male,Status.Opponents.Blue);
        pathologists[0].setLocation(3,0);
        battle[3][0].setCell('n','b');
    }
    public void  setRed(){
        knights[1] = new Person_Knight("Red Knight", Status.Gender.Male, Status.Opponents.Red);
        knights[1].setLocation(0,wide-1);
        battle[0][wide-1].setCell('k','r');

        paladins[1] = new Person_Paladin("Red Paladin",Status.Gender.Female,Status.Opponents.Red);
        paladins[1].setLocation(1,wide-1);
        battle[1][wide-1].setCell('p','r');

        gendalvs[1] = new Person_Wizzard("Red Wizzard",Status.Gender.Female,Status.Opponents.Red);
        gendalvs[1].setLocation(2,wide-1);
        battle[2][wide-1].setCell('g','r');

        pathologists[1] = new Person_Necromancer("Blue Necromancer",Status.Gender.Male,Status.Opponents.Red);
        pathologists[1].setLocation(3,wide-1);
        battle[3][wide-1].setCell('n','r');
    }


    Scanner in = new Scanner(System.in);

    private void rec (Person man){
       anybodyTurn(man);
    }
    private void sp_info (Person man){
        if (man instanceof Person_Knight)
            System.out.println("Спец прием рыцаря накладывает кровотечение на любого противника");
        if (man instanceof Person_Paladin)
            System.out.println("Спец прием лечит на любого союзника");
        if (man instanceof Person_Wizzard)
            System.out.println("Спец прием увеличивает атаку любого союзика");
    }

    private void personMove (Person man, char d) {
        boolean key = false;
        char c ;
        if (man.getTeam() == Status.Opponents.Blue)
            c = 'b';
        else
            c = 'r';
        System.out.println("Выберете направление движения");
        command = in.nextLine();
        int[] x = man.getLocation();

        if (command.equals("Вверх") && x[1] > 0) {
            for (int i = 0; i < wide; i++) {
                for (int j = 0; j < wide; j++)
                    if (battle[i][j].code == d && battle[i][j].color == c) {
                        battle[i][j].setCell('*', ' ');
                        battle[i][j - 1].setCell(d, c);
                        key=true;
                    }
            }
        }
        if (command.equals("Вниз") && x[1]<wide-1) {
            for (int i = 0; i < wide; i++) {
                for (int j = 0; j < wide; j++)
                    if (battle[i][j].code == d && battle[i][j].color == c) {
                        battle[i][j].setCell('*', ' ');
                        battle[i][j + 1].setCell(d, c);
                        key=true;
                    }
            }
        }

        if (command.equals("Вправо") && x[0] < wide-1) {
            for (int i = 0; i < wide; i++) {
                for (int j = 0; j < wide-1; j++)
                    if (battle[i][j].code == d && battle[i][j].color == c) {
                        battle[i][j].setCell('*', ' ');
                        battle[i+1][j].setCell(d, c);
                        key=true;
                    }
            }
        }

        if (command.equals("Лево")&& x[0] > 0) {
            for (int i = 0; i < wide; i++) {
                for (int j = 0; j < wide-1; j++)
                    if (battle[i][j].code == d && battle[i][j].color == c) {
                        battle[i][j].setCell('*', ' ');
                        battle[i-1][j].setCell(d, c);
                        key=true;
                    }
            }
        }

        if (!key){
            System.out.println("Данное направление движения невозможно, желаете выбрать другое направление?");
            command = in.nextLine();
            if (command.equals("Да"))
                personMove(man,d);
            else {
                rec(man);
            }

        }

    }

    private void inventory (Person man){
        boolean key = false;
        System.out.println("Допустимые действия:");
        System.out.print("Купить, Инвентарь");
        if (man.drinks != null)
            System.out.print(", Выпить");
        if (man.drinks != null || man.tool != null)
            System.out.print(", Передать, Бросить");
        System.out.println();
        command = in.nextLine();
        if (command.equals("Купить")){
            System.out.println("Броня, Артефакт, Зелье");
            command = in.nextLine();
            if (command.equals("Броня")){
                key = man.sell_Armor();
            }
            if (command.equals("Артефакт")){
                key = man.sell_Artefact();
            }
            if (command.equals("Зелье")){
                key = man.sell_Potion();
            }
        }
        else {
            if (command.equals("Инвентарь")) {
                if (man.tool == null)
                    System.out.print("Нет артефакта, ");
                else
                    System.out.print("Артефакт в наличии, ");
                if (man.shell == null)
                    System.out.print("Нет брони, ");
                else
                    System.out.print("Броня в наличии, ");
                if (man.drinks == null)
                    System.out.println("Нет зелий");
                else
                    System.out.println("Зелий -  " + man.drinks.getCount());
            }
            else {
                if (command.equals("Передать")){
                    int i;
                    if (man.getTeam() == Status.Opponents.Blue)
                        i=0;
                    else
                        i=1;
                    System.out.println("Что желаете передать и кому, у персонажа есть:");
                    if (man.tool != null)
                         System.out.println("Артефакт");
                    if(man.drinks != null)
                         System.out.println(man.drinks.getCount()+" Зелий");

                    if (command.equals("Зелье Рыцарь")) {
                         man.drinks.pass_item(man,knights[i]);
                    }
                    if (command.equals("Зелье Паладин")) {
                        man.drinks.pass_item(man,paladins[i]);
                    }
                    if (command.equals("Зелье Некр")) {
                        man.drinks.pass_item(man,pathologists[i]);
                    }
                    if (command.equals("Зелье Маг")) {
                        man.drinks.pass_item(man,gendalvs[i]);
                    }
                    if (command.equals("Артефакт Рыцарь")) {
                        man.tool.pass_item(man,knights[i]);
                    }
                    if (command.equals("Артефакт Паладин")) {
                        man.tool.pass_item(man,paladins[i]);
                    }
                    if (command.equals("Артефакт Некр")) {
                        man.tool.pass_item(man,pathologists[i]);
                    }
                    if (command.equals("Артефакт Маг")) {
                        man.tool.pass_item(man,gendalvs[i]);
                    }


                }
                else {
                    if (command.equals("Бросить")) {
                        command = in.nextLine();
                        System.out.println("Бросить что?");

                        if (command.equals("Броня")) {
                            man.shell.drop_Item(man);
                        }
                        if (command.equals("Артефакт")) {
                            man.tool.drop_Item(man);
                        }
                        if (command.equals("Зелье")) {
                            man.drinks.drop_Item(man);
                        }
                    }
                    else {
                        man.drinks.use_Potion(man);
                        key = true;
                    }
                }
            }
        }
        if (!key) {
           rec(man);
        }
    }

    private void anybodyAttack(Person man){
        boolean key=false;
        System.out.println("Выбор направления атаки");
        command = in.nextLine();
        if (command.equals("Вверх"))
            key = man.attack_Enemy(this, Status.Diraction.Up);
        if (command.equals("Вниз"))
            key = man.attack_Enemy(this, Status.Diraction.Down);
        if (command.equals("Вправо"))
            key = man.attack_Enemy(this, Status.Diraction.Right);
        if (command.equals("Лево"))
            key = man.attack_Enemy(this, Status.Diraction.Left);

        if (!key)
            rec(man);
    }
    private void anybodyTurn(Person man){
        if (man != null && man.getLife() == Status.Life_Status.Alive) {
            int i;
            if (man instanceof Person_Knight) {
               if (man.getTeam() == Status.Opponents.Blue)
                   i = 1;
               else
                   i = 0;
            }
            else {
                if (man.getTeam() == Status.Opponents.Blue)
                    i = 0;
                else
                    i = 1;
            }

            System.out.println("Допустимые действия:");
            System.out.println("Атака, Движение, Спец прием, Инвентарь, Характеристики ");
            command = in.nextLine();
            if (command.equals("Атака"))
                anybodyAttack(man);
            else if (command.equals("Движение")) {
                personMove(man,'k');
            }else if (command.equals("Инвентарь")){
                inventory(man);
            }else if (command.equals("Спец прием")) {
                sp_info(man);
                command = in.nextLine();
                if (command.equals("Рыцарь") ){
                    man.special_action(knights[i]);
                }
                if (command.equals("Паладин") ){
                    man.special_action(paladins[i]);
                }
                if (command.equals("Некр") ){
                    man.special_action(pathologists[i]);
                }
                if (command.equals("Маг") ){
                    man.special_action(gendalvs[i]);
                }
            }
            if (command.equals("Характеристики")){
                man.showCharacteristics();
                //System.out.print("Спец прием - Кровотечение");
                if (man.sp_moveUsed)
                    System.out.println(" использован");
                else
                    System.out.println(" не использован");
                anybodyTurn(man);
            }
        }
    }
    public void gamePlay (int rounds){
        for (int i = 0; i < wide; i++) {
            for (int j = 0; j < wide; j++)
                System.out.println(battle[j][i].code + "" + battle[j][i].color + " ");
            System.out.println();
        }
        // урон с эффектов

        System.out.println("Ход синей команды");
        System.out.println("Ход "+knights[0].getName());
        anybodyTurn(knights[0]);
        System.out.println("Ход "+paladins[0].getName());
        anybodyTurn(paladins[0]);
        System.out.println("Ход "+paladins[0].getName());
        anybodyTurn(paladins[0]);
    }
}