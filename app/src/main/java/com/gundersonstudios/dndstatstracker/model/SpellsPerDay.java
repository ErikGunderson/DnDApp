package com.gundersonstudios.dndstatstracker.model;

import com.gundersonstudios.dndstatstracker.base.IConvertible;

import org.json.JSONException;
import org.json.JSONObject;

public class SpellsPerDay implements IConvertible{
    private int levelOneSpellsCast = 0;
    private int levelTwoSpellsCast = 0;
    private int levelThreeSpellsCast = 0;
    private int levelFourSpellsCast = 0;
    private int levelFiveSpellsCast = 0;
    private int levelSixSpellsCast = 0;
    private int levelSevenSpellsCast = 0;
    private int levelEightSpellsCast = 0;
    private int levelNineSpellsCast = 0;

    public SpellsPerDay() {
    }

    public int getLevelOneSpellsCast() {
        return levelOneSpellsCast;
    }

    public void setLevelOneSpellsCast(int levelOneSpellsCast) {
        this.levelOneSpellsCast = levelOneSpellsCast;
    }

    public int getLevelTwoSpellsCast() {
        return levelTwoSpellsCast;
    }

    public void setLevelTwoSpellsCast(int levelTwoSpellsCast) {
        this.levelTwoSpellsCast = levelTwoSpellsCast;
    }

    public int getLevelThreeSpellsCast() {
        return levelThreeSpellsCast;
    }

    public void setLevelThreeSpellsCast(int levelThreeSpellsCast) {
        this.levelThreeSpellsCast = levelThreeSpellsCast;
    }

    public int getLevelFourSpellsCast() {
        return levelFourSpellsCast;
    }

    public void setLevelFourSpellsCast(int levelFourSpellsCast) {
        this.levelFourSpellsCast = levelFourSpellsCast;
    }

    public int getLevelFiveSpellsCast() {
        return levelFiveSpellsCast;
    }

    public void setLevelFiveSpellsCast(int levelFiveSpellsCast) {
        this.levelFiveSpellsCast = levelFiveSpellsCast;
    }

    public int getLevelSixSpellsCast() {
        return levelSixSpellsCast;
    }

    public void setLevelSixSpellsCast(int levelSixSpellsCast) {
        this.levelSixSpellsCast = levelSixSpellsCast;
    }

    public int getLevelSevenSpellsCast() {
        return levelSevenSpellsCast;
    }

    public void setLevelSevenSpellsCast(int levelSevenSpellsCast) {
        this.levelSevenSpellsCast = levelSevenSpellsCast;
    }

    public int getLevelEightSpellsCast() {
        return levelEightSpellsCast;
    }

    public void setLevelEightSpellsCast(int levelEightSpellsCast) {
        this.levelEightSpellsCast = levelEightSpellsCast;
    }

    public int getLevelNineSpellsCast() {
        return levelNineSpellsCast;
    }

    public void setLevelNineSpellsCast(int levelNineSpellsCast) {
        this.levelNineSpellsCast = levelNineSpellsCast;
    }

    public void levelOneSpellCast() {
        levelOneSpellsCast++;
    }

    public void levelTwoSpellCast() {
        levelTwoSpellsCast++;
    }

    public void levelThreeSpellCast() {
        levelThreeSpellsCast++;
    }

    public void levelFourSpellCast() {
        levelFourSpellsCast++;
    }

    public void levelFiveSpellCast() {
        levelFiveSpellsCast++;
    }

    public void levelSixSpellCast() {
        levelSixSpellsCast++;
    }

    public void levelSevenSpellCast() {
        levelSevenSpellsCast++;
    }

    public void levelEightSpellCast() {
        levelEightSpellsCast++;
    }

    public void levelNineSpellCast() {
        levelNineSpellsCast++;
    }

    public void levelOneSpellUncast() {
        levelOneSpellsCast--;
    }

    public void levelTwoSpellUncast() {
        levelTwoSpellsCast--;
    }

    public void levelThreeSpellUncast() {
        levelThreeSpellsCast--;
    }

    public void levelFourSpellUncast() {
        levelFourSpellsCast--;
    }

    public void levelFiveSpellUncast() {
        levelFiveSpellsCast--;
    }

    public void levelSixSpellUncast() {
        levelSixSpellsCast--;
    }

    public void levelSevenSpellUncast() {
        levelSevenSpellsCast--;
    }

    public void levelEightSpellUncast() {
        levelEightSpellsCast--;
    }

    public void levelNineSpellUncast() {
        levelNineSpellsCast--;
    }

    @Override
    public void sendToFile(JSONObject jsonObject) {
        try {
            jsonObject.put("Level One Spells Cast", levelOneSpellsCast);
            jsonObject.put("Level Two Spells Cast", levelTwoSpellsCast);
            jsonObject.put("Level Three Spells Cast", levelThreeSpellsCast);
            jsonObject.put("Level Four Spells Cast", levelFourSpellsCast);
            jsonObject.put("Level Five Spells Cast", levelFiveSpellsCast);
            jsonObject.put("Level Six Spells Cast", levelSixSpellsCast);
            jsonObject.put("Level Seven Spells Cast", levelSevenSpellsCast);
            jsonObject.put("Level Eight Spells Cast", levelEightSpellsCast);
            jsonObject.put("Level Nine Spells Cast", levelNineSpellsCast);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getFromFile(JSONObject jsonObject) {
        try {
            levelOneSpellsCast = jsonObject.getInt("Level One Spells Cast");
            levelTwoSpellsCast = jsonObject.getInt("Level Two Spells Cast");
            levelThreeSpellsCast = jsonObject.getInt("Level Three Spells Cast");
            levelFourSpellsCast = jsonObject.getInt("Level Four Spells Cast");
            levelFiveSpellsCast = jsonObject.getInt("Level Five Spells Cast");
            levelSixSpellsCast = jsonObject.getInt("Level Six Spells Cast");
            levelSevenSpellsCast = jsonObject.getInt("Level Seven Spells Cast");
            levelEightSpellsCast = jsonObject.getInt("Level Eight Spells Cast");
            levelNineSpellsCast = jsonObject.getInt("Level Nine Spells Cast");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
