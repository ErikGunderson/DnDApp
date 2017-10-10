package com.gundersonstudios.dndstatstracker;

import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Erik on 9/17/2016.
 */
public class HealthFragment{
    public int health = 0;
    public View view;
    public String filename = "healthLog";
    public Context context;
    public EditText tb;
    public boolean viewingHealthLog = false;

    private Button button;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;

    public HealthFragment(View view, Context context){
        this.view = view;
        this.context = context;

        tb = (EditText) view.findViewById(R.id.healthTextBox);
        tb.setMovementMethod(new ScrollingMovementMethod());

        Button viewHealthLogButton = (Button) view.findViewById(R.id.viewHealthLog);
        viewHealthLogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHealthLog();
            }
        });

        button = (Button) view.findViewById(R.id.minus1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subtractOne();
            }
        });

        button2 = (Button) view.findViewById(R.id.minus5);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subtractFive();
            }
        });

        button3 = (Button) view.findViewById(R.id.minus10);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subtractTen();
            }
        });

        button4 = (Button) view.findViewById(R.id.plus1);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addOne();
            }
        });

        button5 = (Button) view.findViewById(R.id.plus5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFive();
            }
        });

        button6 = (Button) view.findViewById(R.id.plus10);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTen();
            }
        });
    }

    public void viewHealthLog(){
        if (!viewingHealthLog){
            readHealthLog();
            viewingHealthLog = true;
            disableAllButtons();
        }
        else {
            tb.setText(Integer.toString(health));
            viewingHealthLog = false;
            enableAllButtons();
        }
    }

    public void disableAllButtons(){
        button.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
        button5.setEnabled(false);
        button6.setEnabled(false);
    }
    
    public void enableAllButtons(){
        button.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);
        button5.setEnabled(true);
        button6.setEnabled(true);
    }

    public void subtractOne(){
        health = Integer.parseInt(tb.getText().toString());
        health -= 1;
        tb.setText(Integer.toString(health));
        writeToHealthLog("- 1", String.valueOf(health));
    }

    public void subtractFive(){
        health = Integer.parseInt(tb.getText().toString());
        health -= 5;
        tb.setText(Integer.toString(health));
        writeToHealthLog("- 5", String.valueOf(health));
    }

    public void subtractTen(){
        health = Integer.parseInt(tb.getText().toString());
        health -= 10;
        tb.setText(Integer.toString(health));
        writeToHealthLog("- 10", String.valueOf(health));
    }

    public void addOne(){
        health = Integer.parseInt(tb.getText().toString());
        health += 1;
        tb.setText(Integer.toString(health));
        writeToHealthLog("+ 1", String.valueOf(health));
    }

    public void addFive(){
        health = Integer.parseInt(tb.getText().toString());
        health += 5;
        tb.setText(Integer.toString(health));
        writeToHealthLog("+ 5", String.valueOf(health));
    }

    public void addTen(){
        health = Integer.parseInt(tb.getText().toString());
        health += 10;
        tb.setText(Integer.toString(health));
        writeToHealthLog("+ 10", String.valueOf(health));
    }

    public void writeToHealthLog(String amountChanged, String currentHealth){
        FileOutputStream output;

        try{
            output = context.openFileOutput(filename, Context.MODE_PRIVATE);
            String outputString = "previous health " + amountChanged + " = " + currentHealth;
            output.write(outputString.getBytes());
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readHealthLog(){
        FileInputStream input;

        try{
            input = context.openFileInput(filename);
            DataInputStream dataInput = new DataInputStream(input);
            String currentLine = dataInput.readLine();

            while(currentLine != null){
                tb.append(currentLine + "\n");
                currentLine = dataInput.readLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
