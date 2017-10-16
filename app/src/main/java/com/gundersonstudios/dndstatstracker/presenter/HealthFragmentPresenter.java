package com.gundersonstudios.dndstatstracker.presenter;

import android.app.Fragment;
import com.gundersonstudios.dndstatstracker.model.CoreModel;

public class HealthFragmentPresenter {
    private Fragment mFragment;
    private CoreModel mCoreModel;

    public HealthFragmentPresenter(Fragment fragment, CoreModel coreModel){
        mFragment = fragment;
        mCoreModel = coreModel;
    }

    public void setCurrentHealth(int currentHealth) {
        mCoreModel.mHealth.setCurrentHealth(currentHealth);
    }

    public void addAmountToCurrentHealth(int amountToAdd) {
        mCoreModel.mHealth.addAmountToCurrentHealth(amountToAdd);
    }
}
