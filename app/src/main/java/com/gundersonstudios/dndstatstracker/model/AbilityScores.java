package com.gundersonstudios.dndstatstracker.model;

import com.gundersonstudios.dndstatstracker.base.IConvertible;

import org.json.JSONException;
import org.json.JSONObject;

public class AbilityScores implements IConvertible {

    private int strScore = 0;
    private int dexScore = 0;
    private int conScore = 0;
    private int intScore = 0;
    private int wisScore = 0;
    private int chaScore = 0;

    public AbilityScores() {
    }

    public AbilityScores(int strScore, int dexScore, int conScore, int intScore, int wisScore, int chaScore) {
        this.strScore = strScore;
        this.dexScore = dexScore;
        this.conScore = conScore;
        this.intScore = intScore;
        this.wisScore = wisScore;
        this.chaScore = chaScore;
    }

    public int getStrScore() {
        return strScore;
    }

    public void setStrScore(int strScore) {
        this.strScore = strScore;
    }

    public int getDexScore() {
        return dexScore;
    }

    public void setDexScore(int dexScore) {
        this.dexScore = dexScore;
    }

    public int getConScore() {
        return conScore;
    }

    public void setConScore(int conScore) {
        this.conScore = conScore;
    }

    public int getIntScore() {
        return intScore;
    }

    public void setIntScore(int intScore) {
        this.intScore = intScore;
    }

    public int getWisScore() {
        return wisScore;
    }

    public void setWisScore(int wisScore) {
        this.wisScore = wisScore;
    }

    public int getChaScore() {
        return chaScore;
    }

    public void setChaScore(int chaScore) {
        this.chaScore = chaScore;
    }

    @Override
    public void sendToFile(JSONObject jsonObject) {
        try {
            jsonObject.put("Strength", strScore);
            jsonObject.put("Dexterity", dexScore);
            jsonObject.put("Constitution", conScore);
            jsonObject.put("Intelligence", wisScore);
            jsonObject.put("Wisdom", wisScore);
            jsonObject.put("Charisma", chaScore);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getFromFile(JSONObject jsonObject) {
        try {
            strScore = jsonObject.getInt("Strength");
            dexScore = jsonObject.getInt("Dexterity");
            conScore = jsonObject.getInt("Constitution");
            intScore = jsonObject.getInt("Intelligence");
            wisScore = jsonObject.getInt("Wisdom");
            chaScore = jsonObject.getInt("Charisma");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
