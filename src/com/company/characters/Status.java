package com.company.characters;

public class Status {
    public enum Life_Status {
        Alive,
        Dead,
        Walking_Dead;
    }
    public enum Effects {
        No_Effects,
        Bleeding,
        Poisoned,
        Light_Buff,
        Blocking_Buff;
    }
    public enum Gender {
        Male,
        Female;
    }
    public enum Opponents{
        Red,
        Blue;
    }
    public enum Diraction{
        Up,
        Domn,
        Left,
        Right;
    }
}
