package com.gundersonstudios.dndstatstracker.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.gundersonstudios.dndstatstracker.R;
import com.gundersonstudios.dndstatstracker.base.IStatFragment;
import com.gundersonstudios.dndstatstracker.model.CoreModel;
import com.gundersonstudios.dndstatstracker.model.DependencyRepository;
import com.gundersonstudios.dndstatstracker.presenter.HealthFragmentPresenter;
import com.gundersonstudios.dndstatstracker.utils.Constants;

public class HealthFragment extends Fragment implements IStatFragment {
    private HealthFragmentPresenter mPresenter;
    private View mFragmentView;
    public int mFragmentSectionNumber;
    private View currentViewSelected;
    private String mName = "Character Health Stats";

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
        final EditText totalHealth = (EditText) mFragmentView.findViewById(R.id.totalHp);
        totalHealth.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.length() != 0) {
                    setTotalHealth(Integer.valueOf(editable.toString()));
                    totalHealth.setEnabled(false);
                } else {
                    totalHealth.setEnabled(true);
                }
            }
        });
        totalHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectNewButton(view);
            }
        });

        final EditText damageResistance = (EditText) mFragmentView.findViewById(R.id.damageResistance);
        damageResistance.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.length() != 0) {
                    setDamageResistance(Integer.valueOf(editable.toString()));
                    damageResistance.setEnabled(false);
                } else {
                    damageResistance.setEnabled(true);
                }
            }
        });
        damageResistance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectNewButton(view);
            }
        });

        final EditText healthTextBox = (EditText) mFragmentView.findViewById(R.id.currentHp);
        healthTextBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.length() != 0) {
                    setCurrentHealth(Integer.valueOf(editable.toString()));
                    healthTextBox.setEnabled(false);
                } else {
                    healthTextBox.setEnabled(true);
                }
            }
        });
        healthTextBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectNewButton(view);
            }
        });

        final EditText nonlethalDamage = (EditText) mFragmentView.findViewById(R.id.nonlethalDamage);
        nonlethalDamage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.length() != 0) {
                    setNonlethalDamage(Integer.valueOf(editable.toString()));
                    nonlethalDamage.setEnabled(false);
                } else {
                    nonlethalDamage.setEnabled(true);
                }
            }
        });
        nonlethalDamage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            selectNewButton(view);
            }
        });

        Button button = (Button) mFragmentView.findViewById(R.id.minus1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAmountToVariable(-1);
            }
        });

        Button button2 = (Button) mFragmentView.findViewById(R.id.minus5);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAmountToVariable(-5);
            }
        });

        Button button3 = (Button) mFragmentView.findViewById(R.id.minus10);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAmountToVariable(-10);
            }
        });

        Button button4 = (Button) mFragmentView.findViewById(R.id.plus1);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAmountToVariable(1);
            }
        });

        Button button5 = (Button) mFragmentView.findViewById(R.id.plus5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAmountToVariable(5);
            }
        });

        Button button6 = (Button) mFragmentView.findViewById(R.id.plus10);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAmountToVariable(10);
            }
        });
    }

    public void setCurrentHealth(int currentHealth) {
        mPresenter.setCurrentHealth(currentHealth);
    }

    public void addAmountToCurrentHealth(int amountToAdd) {
        mPresenter.addAmountToCurrentHealth(amountToAdd);
    }

    public void setDamageResistance(int damageResistance) {
        mPresenter.setDamageResistance(damageResistance);
    }

    public void addAmountToDamageResistance(int amountToAdd) {
        mPresenter.addAmountToDamageResistance(amountToAdd);
    }

    public void setTotalHealth(int totalHealth) {
        mPresenter.setTotalHealth(totalHealth);
    }

    public void addAmountToTotalHealth(int amountToAdd) {
        mPresenter.addAmountToTotalHealth(amountToAdd);
    }

    public void setNonlethalDamage(int nonlethalDamage) {
        mPresenter.setNonlethalDamage(nonlethalDamage);
    }

    public void addAmountToNonlethalDamage(int amountToAdd) {
        mPresenter.addAmountToNonlethalDamage(amountToAdd);
    }

    public void selectNewButton(View nextSelectedView) {
        nextSelectedView.setBackgroundColor(Color.GRAY);
        nextSelectedView.setAlpha(.5f);

        if (currentViewSelected != null) {
            currentViewSelected.setBackgroundColor(Color.WHITE);
            currentViewSelected.setAlpha(1);
        }

        currentViewSelected = nextSelectedView;
    }

    public void addAmountToVariable(int amount) {
        switch(currentViewSelected.getId()) {
            case R.id.totalHp:
                addAmountToTotalHealth(amount);
                ((EditText) currentViewSelected).setText(mPresenter.getTotalHealth());
                break;
            case R.id.currentHp:
                addAmountToCurrentHealth(amount);
                ((EditText) currentViewSelected).setText(mPresenter.getCurrentHealth());
                break;
            case R.id.nonlethalDamage:
                addAmountToNonlethalDamage(amount);
                ((EditText) currentViewSelected).setText(mPresenter.getNonlethalDamage());
                break;
            case R.id.damageResistance:
                addAmountToDamageResistance(amount);
                ((EditText) currentViewSelected).setText(mPresenter.getDamageResistance());
                break;
            default:
                Log.e(HealthFragment.class.getSimpleName(), "No attribute selected to have an amount added to");
        }
    }

    @Override
    public String getFragmentName() {
        return mName;
    }

    @Override
    public Fragment getFragment() {
        return this;
    }
}
