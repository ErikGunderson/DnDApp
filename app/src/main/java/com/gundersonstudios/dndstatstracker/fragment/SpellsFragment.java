package com.gundersonstudios.dndstatstracker.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.gundersonstudios.dndstatstracker.R;
import com.gundersonstudios.dndstatstracker.model.CoreModel;
import com.gundersonstudios.dndstatstracker.model.DependencyRepository;
import com.gundersonstudios.dndstatstracker.presenter.SpellsFragmentPresenter;
import com.gundersonstudios.dndstatstracker.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class SpellsFragment extends Fragment {
    private SpellsFragmentPresenter mPresenter;
    private View mFragmentView;
    public int mFragmentSectionNumber;
    private List<CheckBox> mCheckboxes;

    public SpellsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mFragmentSectionNumber = getArguments().getInt(Constants.FRAG_SECTION_NUMBER);
        mFragmentView = inflater.inflate(R.layout.fragment_spells, container, false);
        mPresenter = new SpellsFragmentPresenter(this, (CoreModel) DependencyRepository.resolveDependency(CoreModel.class));

        setUpCheckboxArray();
        setUpResetSpellsButton();

        return mFragmentView;
    }

    public void setUpResetSpellsButton() {
        Button resetSpellsButton = (Button) mFragmentView.findViewById(R.id.button);
        resetSpellsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetAllCheckboxes();
                mPresenter.resetAllSpells();
            }
        });
    }

    public void resetAllCheckboxes() {
        for (CheckBox checkbox : mCheckboxes) {
            checkbox.setChecked(false);
        }
    }

    public void setUpCheckboxArray() {
        mCheckboxes = new ArrayList<>();
        //Level One
        mCheckboxes.add((CheckBox) mFragmentView.findViewById(R.id.checkBox));
        mCheckboxes.add((CheckBox) mFragmentView.findViewById(R.id.checkBox2));
        mCheckboxes.add((CheckBox) mFragmentView.findViewById(R.id.checkBox3));
        mCheckboxes.add((CheckBox) mFragmentView.findViewById(R.id.checkBox4));
        mCheckboxes.add((CheckBox) mFragmentView.findViewById(R.id.checkBox5));
        mCheckboxes.add((CheckBox) mFragmentView.findViewById(R.id.checkBox6));
        mCheckboxes.add((CheckBox) mFragmentView.findViewById(R.id.checkBox7));

        //Level Two
        mCheckboxes.add((CheckBox) mFragmentView.findViewById(R.id.checkBox8));
        mCheckboxes.add((CheckBox) mFragmentView.findViewById(R.id.checkBox9));
        mCheckboxes.add((CheckBox) mFragmentView.findViewById(R.id.checkBox10));
        mCheckboxes.add((CheckBox) mFragmentView.findViewById(R.id.checkBox11));
        mCheckboxes.add((CheckBox) mFragmentView.findViewById(R.id.checkBox12));
        mCheckboxes.add((CheckBox) mFragmentView.findViewById(R.id.checkBox13));
        mCheckboxes.add((CheckBox) mFragmentView.findViewById(R.id.checkBox14));

        //Level Three
        mCheckboxes.add((CheckBox) mFragmentView.findViewById(R.id.checkBox15));
        mCheckboxes.add((CheckBox) mFragmentView.findViewById(R.id.checkBox16));
        mCheckboxes.add((CheckBox) mFragmentView.findViewById(R.id.checkBox17));
        mCheckboxes.add((CheckBox) mFragmentView.findViewById(R.id.checkBox18));
        mCheckboxes.add((CheckBox) mFragmentView.findViewById(R.id.checkBox19));
        mCheckboxes.add((CheckBox) mFragmentView.findViewById(R.id.checkBox20));
        mCheckboxes.add((CheckBox) mFragmentView.findViewById(R.id.checkBox21));

        for (CheckBox checkbox : mCheckboxes) {
            checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    if (isChecked) {
                        spellWasCast(mCheckboxes.indexOf((CheckBox) compoundButton));
                    } else {
                        spellWasUncast(mCheckboxes.indexOf((CheckBox) compoundButton));
                    }
                }
            });
        }
    }

    private void spellWasCast(int index) {
        mPresenter.spellWasCast(index);
    }

    private void spellWasUncast(int index) {
        mPresenter.spellWasUncast(index);
    }
}
