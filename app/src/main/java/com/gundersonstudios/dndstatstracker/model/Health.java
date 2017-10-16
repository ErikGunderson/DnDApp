package com.gundersonstudios.dndstatstracker.model;

import com.gundersonstudios.dndstatstracker.base.IConvertible;

import org.json.JSONException;
import org.json.JSONObject;

public class Health implements IConvertible{
    private int totalHealth = 0;
    private int currentHealth = 0;
    private int nonlethalDamage = 0;
    private int damageResistance = 0;

    public Health() {
    }

    public int getTotalHealth() {
        return totalHealth;
    }

    public void setTotalHealth(int totalHealth) {
        this.totalHealth = totalHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getNonlethalDamage() {
        return nonlethalDamage;
    }

    public void setNonlethalDamage(int nonlethalDamage) {
        this.nonlethalDamage = nonlethalDamage;
    }

    public int getDamageResistance() {
        return damageResistance;
    }

    public void setDamageResistance(int damageResistance) {
        this.damageResistance = damageResistance;
    }

    public void addAmountToCurrentHealth(int amountToAdd) {
        currentHealth += amountToAdd;
    }

    public void addAmountToNonlethalDamage(int amountToAdd) {
        nonlethalDamage += amountToAdd;
    }

    @Override
    public void sendToFile(JSONObject jsonObject) {
        try {
            jsonObject.put("Total Health", totalHealth);
            jsonObject.put("Damage Resistance", damageResistance);
            jsonObject.put("Current Health", currentHealth);
            jsonObject.put("Nonlethal Damage", nonlethalDamage);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getFromFile(JSONObject jsonObject) {
        try {
            totalHealth = jsonObject.getInt("Total Health");
            damageResistance = jsonObject.getInt("Damage Resistance");
            currentHealth = jsonObject.getInt("Current Health");
            nonlethalDamage = jsonObject.getInt("Nonlethal Damage");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
