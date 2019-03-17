package company.characters;

import company.Arena;

public class Person_Necromancer extends Person implements Undead_Features{


    private boolean undeadSP=false;
    public Person_Necromancer(String name, Status.Gender gen, Status.Opponents team){
        setHp_MAX(200);
        setHealth(200);
        setAttack(5);
        setWeigtht_can_carry(5);
        setLife(Status.Life_Status.Alive);
        setName(name);
        setSex(gen);
        setTeam(team);
    }

    @Override
    public boolean attack_Enemy(Arena field, Status.Diraction turn) {
        int[] x = getLocation();
        boolean key;
        if (getLife() != Status.Life_Status.Walking_Dead)
            switch (turn) {

            case Up:
                if (x[1]>0){
                    key=true;
                    for(int i = 0; i < x[1]; i++)
                        field.doCurse(x[0], i, getTeam());
                }
                else
                    key = false;
                break;

            case Down:
                if (x[1]<field.wide-1){
                    key = true;
                    for(int i = x[1]+1; i < field.wide; i++)
                        field.doCurse(x[0], i, getTeam());
                }
                else
                    key = false;
                break;

            case Right:
                if (x[0]<field.wide-1){
                    key = true;
                    for(int i = x[0]+1; i < field.wide; i++)
                        field.doCurse(i, x[1], getTeam());
                }
                else
                    key = false;
                break;

            case Left:
                if (x[0]>0){
                    key=true;
                    for(int i = 0; i < x[0]; i++)
                        field.doCurse(i, x[1], getTeam());
                }
                else
                    key = false;
                break;

            default:
                key=false;
                break;
        }
        else
            key = false;
        return key;
    }

    @Override
    public void special_action(Person enemy) {
        if (!sp_moveUsed && enemy.getLife()== Status.Life_Status.Dead) {
            enemy = null;
            sp_moveUsed = true;
        }
    }

    @Override
    public void becomeUndead() {
        sp_moveUsed = true;
        setLife(Status.Life_Status.Walking_Dead);
        setHealth(50);
        setAttack(10);
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
            switch (turn){
                case  Up:
                    if (x[1]>0) {
                        key = true;
                        field.doDamage(x[0],x[1]-1,getAttack(),getTeam());
                        field.doCurse(x[0],x[1]-1,getTeam());
                    }
                    else
                        key=false;
                    break;
                case  Down:
                    if (x[1]<field.wide-1) {
                        key = true;
                        field.doDamage(x[0],x[1]+1,getAttack(),getTeam());
                        field.doCurse(x[0],x[1]+1,getTeam());
                    }
                    else
                        key=false;
                    break;
                case  Right:
                    if (x[0]<field.wide-1) {
                        key = true;
                        field.doDamage(x[0]+1,x[1],getAttack(),getTeam());
                        field.doCurse(x[0]+1,x[1],getTeam());
                    }
                    else
                        key=false;
                    break;
                case  Left:
                    if (x[0]>0) {
                        key = true;
                        field.doDamage(x[0]-1,x[1],getAttack(),getTeam());
                        field.doCurse(x[0]-1,x[1],getTeam());
                    }
                    else
                        key=false;
                    break;

                default:
                    key=false;
                    break;
            }
            return key;
    }
}

