package company.characters;

import company.Arena;

public interface Undead_Features {
    public void becomeUndead();
    public void undeadSpecialMove();
    public boolean undeadAttack(Arena field, Status.Diraction turn);
}
