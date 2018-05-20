package com.gundersonstudios.dndstatstracker.utils;

import android.content.Context;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

public class FileManager {
    public FileManager() {
    }

    /**
     * Returns true if the file write was successful, false otherwise
     *
     * @param fileName
     * @param context
     * @param jsonObject
     * @return
     */
    public boolean writeToFile(String fileName, Context context, JSONObject jsonObject) {
        try {
            FileOutputStream outputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            outputStream.write(jsonObject.toString().getBytes());
            outputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Reads the JSON object from the file
     *
     * @param fileName
     * @param context
     * @return
     */
    public JSONObject readFromFile(String fileName, Context context) {
        File file = new File(context.getFilesDir(), fileName);

        if (!file.exists()) {
            return null;
        }

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String inputLine;

            while ((inputLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(inputLine);
            }

            bufferedReader.close();

            JSONObject object = new JSONObject(stringBuilder.toString());
            return object;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Finds the list of all saved character files
     *
     * @param context
     * @return
     */
    public String[] findExistingCharacterFiles(Context context) {
        return context.fileList();
    }
}
