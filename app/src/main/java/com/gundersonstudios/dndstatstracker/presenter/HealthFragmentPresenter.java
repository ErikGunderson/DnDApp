package com.gundersonstudios.dndstatstracker.presenter;

import android.support.v4.app.Fragment;

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

    public void setDamageResistance(int damageReduction) {
        mCoreModel.mHealth.setDamageResistance(damageReduction);
    }

    public void addAmountToDamageResistance(int amountToAdd) {
        mCoreModel.mHealth.addAmountToDamageResistance(amountToAdd);
    }

    public void setTotalHealth(int totalHealth) {
        mCoreModel.mHealth.setTotalHealth(totalHealth);
    }

    public void addAmountToTotalHealth(int amountToAdd) {
        mCoreModel.mHealth.addAmountToTotalHealth(amountToAdd);
    }

    public void setNonlethalDamage(int nonlethalDamage) {
        mCoreModel.mHealth.setNonlethalDamage(nonlethalDamage);
    }

    public void addAmountToNonlethalDamage(int amountToAdd) {
        mCoreModel.mHealth.addAmountToNonlethalDamage(amountToAdd);
    }

    public int getTotalHealth() {
        return mCoreModel.mHealth.getTotalHealth();
    }

    public int getCurrentHealth() {
        return mCoreModel.mHealth.getCurrentHealth();
    }

    public int getNonlethalDamage() {
        return mCoreModel.mHealth.getNonlethalDamage();
    }

    public int getDamageResistance() {
        return mCoreModel.mHealth.getDamageResistance();
    }
}
