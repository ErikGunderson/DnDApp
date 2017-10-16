package com.gundersonstudios.dndstatstracker.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.gundersonstudios.dndstatstracker.R;
import com.gundersonstudios.dndstatstracker.model.CoreModel;
import com.gundersonstudios.dndstatstracker.model.DependencyRepository;
import com.gundersonstudios.dndstatstracker.presenter.HealthFragmentPresenter;
import com.gundersonstudios.dndstatstracker.utils.Constants;

public class HealthFragment extends Fragment {
    private HealthFragmentPresenter mPresenter;
    private View mFragmentView;
    public int mFragmentSectionNumber;

    public HealthFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mFragmentSectionNumber = getArguments().getInt(Constants.FRAG_SECTION_NUMBER);
        mFragmentView = inflater.inflate(R.layout.fragment_health, container, false);
        mPresenter = new HealthFragmentPresenter(this, (CoreModel) DependencyRepository.resolveDependency(CoreModel.class));

        setUpUI();

        return mFragmentView;
    }

    public void setUpUI() {
        EditText healthTextBox = (EditText) mFragmentView.findViewById(R.id.healthTextBox);
        healthTextBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                setCurrentHealth(Integer.valueOf(editable.toString()));
            }
        });

        Button button = (Button) mFragmentView.findViewById(R.id.minus1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAmountToCurrentHealth(-1);
            }
        });

        Button button2 = (Button) mFragmentView.findViewById(R.id.minus5);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAmountToCurrentHealth(-5);
            }
        });

        Button button3 = (Button) mFragmentView.findViewById(R.id.minus10);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAmountToCurrentHealth(-10);
            }
        });

        Button button4 = (Button) mFragmentView.findViewById(R.id.plus1);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAmountToCurrentHealth(1);
            }
        });

        Button button5 = (Button) mFragmentView.findViewById(R.id.plus5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAmountToCurrentHealth(5);
            }
        });

        Button button6 = (Button) mFragmentView.findViewById(R.id.plus10);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAmountToCurrentHealth(10);
            }
        });
    }

    public void setCurrentHealth(int currentHealth) {
        mPresenter.setCurrentHealth(currentHealth);
    }

    public void addAmountToCurrentHealth(int amountToAdd) {
        mPresenter.addAmountToCurrentHealth(amountToAdd);
    }
}
