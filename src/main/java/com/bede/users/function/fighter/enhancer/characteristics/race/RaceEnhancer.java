package com.bede.users.function.fighter.enhancer.characteristics.race;

import com.bede.users.function.fighter.enhancer.characteristics.CharacteristicsEnhancer;

public class RaceEnhancer extends CharacteristicsEnhancer {
    public RaceEnhancer(int strength, int defense, int vitality, int dexterity, int dodge, int courage) {
        this.strength = strength;
        this.defense = defense;
        this.vitality = vitality;
        this.dexterity = dexterity;
        this.dodge = dodge;
        this.courage = courage;
    }
}
