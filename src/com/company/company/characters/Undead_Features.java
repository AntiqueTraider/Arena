package com.company.company.characters;

import com.company.company.Arena;

public interface Undead_Features {
    public void becomeUndead();
    public void undeadSpecialMove();
    public boolean undeadAttack(Arena field, Status.Diraction turn);
}
