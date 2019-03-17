package com.company;

import com.company.characters.*;

public class Arena {
    public int wide;
    public int characters_teming;
    private Person_Knight [] knights; // k - for knights
    private Person_Spear_Master [] masters; //m - for masters
    private Person_Paladin [] paladins;// p - paladins
    private Person_Wizzard [] gendalvs;//g - wizzards
    private Person_Necromancer [] pathologists;//n - necros

    static
    {
        System.out.println("Поздравляю с созданием первой Арены");
    }


    public Arena (int  wide){
        this.wide = wide;
    }
}
