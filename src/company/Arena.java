package company;

import company.characters.*;
import company.items.*;

import java.util.Scanner;

/*
Внутренний класс field будет содержать кодовый символ,
для каждого объекта, свободной ячейки ("*")
далее - ниже
 */
public class Arena {
    public final int wide=4;
    public int characters_teming;
    public String command;

    private Person_Knight knights[] = new Person_Knight[2]; // k - for knights
    private Person_Paladin paladins[] = new Person_Paladin[2];// p - paladins
    private Person_Wizzard gendalvs[] = new Person_Wizzard[2];//g - wizzards
    private Person_Necromancer pathologists[]= new Person_Necromancer[2];//n - necros

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
    private void knightAttack(Person_Knight man){
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
            knightAttack(man);
    }
    public void personMove (Person_Knight man, char d) {
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
            System.out.println("Данное направление движения невозможно, желаете выбрать");
            command = in.nextLine();
            if (command.equals("Нет"))
            personMove(man,d);
        }

    }
    public void knightTurn(Person_Knight man){
        if (man != null && man.getLife() == Status.Life_Status.Alive) {
            System.out.println("Ход "+man.getName());
            System.out.println("Допустимые действия:");
            System.out.println("Атака, Движение, Кровотечение, Купить, Передать Предмет, Характеристики");
            command = in.nextLine();
            if (command.equals("Атака"))
                knightAttack(man);
            if (command.equals("Движение")) {
                personMove(man,'k');
            }
            if (command.equals("Купить")){

            }
        }
    }
    public void gamePlay ( int rounds){
        System.out.println("Ход синей команды");
        knightTurn(knights[0]);

    }
}