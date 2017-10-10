package com.gundersonstudios.dndstatstracker;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

/**
 * Created by Erik on 9/17/2016.
 */
public class SpellsFragment {
    public View view;

    public SpellsFragment(View view) {
        this.view = view;

        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.i("spells", "unchecking boxes");
                uncheckAllBoxes();
            }
        });
    }

    public void uncheckAllBoxes(){
        CheckBox cb = (CheckBox) view.findViewById(R.id.checkBox);
        CheckBox cb2 = (CheckBox) view.findViewById(R.id.checkBox2);
        CheckBox cb3 = (CheckBox) view.findViewById(R.id.checkBox3);
        CheckBox cb4 = (CheckBox) view.findViewById(R.id.checkBox4);
        CheckBox cb5 = (CheckBox) view.findViewById(R.id.checkBox5);
        CheckBox cb6 = (CheckBox) view.findViewById(R.id.checkBox6);
        CheckBox cb7 = (CheckBox) view.findViewById(R.id.checkBox7);
        CheckBox cb8 = (CheckBox) view.findViewById(R.id.checkBox8);
        CheckBox cb9 = (CheckBox) view.findViewById(R.id.checkBox9);
        CheckBox cb10 = (CheckBox) view.findViewById(R.id.checkBox10);
        CheckBox cb11 = (CheckBox) view.findViewById(R.id.checkBox11);
        CheckBox cb12 = (CheckBox) view.findViewById(R.id.checkBox12);
        CheckBox cb13 = (CheckBox) view.findViewById(R.id.checkBox13);
        CheckBox cb14 = (CheckBox) view.findViewById(R.id.checkBox14);
        CheckBox cb15 = (CheckBox) view.findViewById(R.id.checkBox15);

        cb.setChecked(false);
        cb2.setChecked(false);
        cb3.setChecked(false);
        cb4.setChecked(false);
        cb5.setChecked(false);
        cb6.setChecked(false);
        cb7.setChecked(false);
        cb8.setChecked(false);
        cb9.setChecked(false);
        cb10.setChecked(false);
        cb11.setChecked(false);
        cb12.setChecked(false);
        cb13.setChecked(false);
        cb14.setChecked(false);
        cb15.setChecked(false);
    }
}
