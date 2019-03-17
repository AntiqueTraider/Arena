package company.characters;

import company.Arena;

public class Person_Knight extends Person {

    public Person_Knight(String name, Status.Gender gen, Status.Opponents team){
        setHp_MAX(300);
        setHealth(300);
        setAttack(15);
        setWeigtht_can_carry(15);
        setLife(Status.Life_Status.Alive);
        setName(name);
        setSex(gen);
        setTeam(team);
    }

    @Override
    public boolean attack_Enemy(Arena field, Status.Diraction turn) {
        int[] x = getLocation();
        int a, b;
        boolean key;
        if ((turn == Status.Diraction.Up && x[1] > 0) || (turn == Status.Diraction.Down && x[1] < field.wide - 1)) {
            a = (x[0] - 1 < 0) ? x[0] : x[0] - 1;
            b = (x[0] + 1 > field.wide - 1) ? x[0] : x[0] + 1;
            for (int i = a; i <= b; i++)
                field.doDamage(i, x[1], getAttack(), getTeam());
            key = true;
        } else {
            if ((turn == Status.Diraction.Left && x[0] > 0) || (turn == Status.Diraction.Right && x[0] < field.wide - 1)) {
                a = (x[1] - 1 < 0) ? x[1] : x[1] - 1;
                b = (x[1] + 1 > field.wide - 1) ? x[1] : x[1] + 1;
                for (int i = a; i <= b; i++)
                    field.doDamage(x[0], i, getAttack(), getTeam());
                key = true;
            } else {
                key = false;
            }
        }
        return key;
    }

    @Override
    public void special_action(Person enemy) {
        if (!sp_moveUsed) {
            enemy.setBaf_debuf(Status.Effects.Bleeding);
            sp_moveUsed=true;
        }
    }
}
