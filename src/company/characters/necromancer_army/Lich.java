package company.characters.necromancer_army;

import company.Arena;
import company.characters.Person;
import company.characters.Status;
import company.characters.Undead_Features;

public class Lich extends Person implements Undead_Features {
    private boolean undeadSP = false;

    @Override
    public void becomeUndead() {

    }

    @Override
    public void undeadSpecialMove() {
        if (!undeadSP) {
            System.out.println("Нежить избегает смерти в последний раз");
            undeadSP = true;
        }
    }

    @Override
    public boolean undeadAttack(Arena field, Status.Diraction turn) {
        int[] x = getLocation();
        boolean key;
        switch (turn) {

            case Up:
                if (x[1]>0){
                    key=true;
                    for(int i = 0; i < x[1]; i++) {
                        field.doDamage(x[0], i, getAttack(), getTeam());
                        field.doCurse(x[0], i, getTeam());
                    }
                }
                else
                    key = false;
                break;

            case Down:
                if (x[1]<field.wide-1){
                    key = true;
                    for(int i = x[1]+1; i < field.wide; i++) {
                        field.doDamage(x[0], i, getAttack(), getTeam());
                        field.doCurse(x[0], i, getTeam());
                    }
                }
                else
                    key = false;
                break;

            case Right:
                if (x[0]<field.wide-1){
                    key = true;
                    for(int i = x[0]+1; i < field.wide; i++) {
                        field.doDamage(i, x[1], getAttack(), getTeam());
                        field.doCurse(i, x[1], getTeam());
                    }
                }
                else
                    key = false;
                break;

            case Left:
                if (x[0]>0){
                    key=true;
                    for(int i = 0; i < x[0]; i++) {
                        field.doDamage(i, x[1], getAttack(), getTeam());
                        field.doCurse(i, x[1], getTeam());
                    }
                }
                else
                    key = false;
                break;

            default:
                key=false;
                break;
        }
        return key;
    }

    @Override
    public boolean attack_Enemy(Arena field, Status.Diraction turn) throws Exception {
        throw new Exception();
    }

    @Override
    public void special_action(Person enemy) throws Exception {
        throw new Exception();
    }
}
