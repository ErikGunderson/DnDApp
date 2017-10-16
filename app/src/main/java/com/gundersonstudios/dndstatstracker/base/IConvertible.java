package com.gundersonstudios.dndstatstracker.base;

import org.json.JSONObject;

public interface IConvertible {
    void sendToFile(JSONObject jsonObject);

    void getFromFile(JSONObject jsonObject);
}
