package com.gundersonstudios.dndstatstracker.model;

import com.gundersonstudios.dndstatstracker.base.IConvertible;

import org.json.JSONException;
import org.json.JSONObject;

public class BardicPerformance implements IConvertible{
    private int performanceRounds = 0;
    private int totalPerformanceRounds = 0;

    public BardicPerformance() {
    }

    public int getPerformanceRounds() {
        return performanceRounds;
    }

    public void setPerformanceRounds(int performanceRounds) {
        this.performanceRounds = performanceRounds;
    }

    public int getTotalPerformanceRounds() {
        return totalPerformanceRounds;
    }

    public void setTotalPerformanceRounds(int totalPerformanceRounds) {
        this.totalPerformanceRounds = totalPerformanceRounds;
    }

    @Override
    public void sendToFile(JSONObject jsonObject) {
        try {
            jsonObject.put("Total Performance Rounds", totalPerformanceRounds);
            jsonObject.put("Bardic Performance Rounds Used", performanceRounds);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getFromFile(JSONObject jsonObject) {
        try {
            totalPerformanceRounds = jsonObject.getInt("Total Performance Rounds");
            performanceRounds = jsonObject.getInt("Bardic Performance Rounds Used");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
