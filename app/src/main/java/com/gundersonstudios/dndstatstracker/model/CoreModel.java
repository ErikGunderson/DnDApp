package com.gundersonstudios.dndstatstracker.model;

import com.gundersonstudios.dndstatstracker.base.IConvertible;

import org.json.JSONObject;

public class CoreModel implements IConvertible{
    public AbilityScores mAbilityScores;
    public SpellsPerDay mSpellsPerDay;
    public Health mHealth;

    public CoreModel() {
        mAbilityScores = new AbilityScores();
        mSpellsPerDay = new SpellsPerDay();
        mHealth = new Health();
    }


    @Override
    public void sendToFile(JSONObject jsonObject) {
        mAbilityScores.sendToFile(jsonObject);
        mHealth.sendToFile(jsonObject);
        mSpellsPerDay.sendToFile(jsonObject);
    }

    @Override
    public void getFromFile(JSONObject jsonObject) {
        mAbilityScores.getFromFile(jsonObject);
        mHealth.getFromFile(jsonObject);
        mSpellsPerDay.getFromFile(jsonObject);
    }
}
