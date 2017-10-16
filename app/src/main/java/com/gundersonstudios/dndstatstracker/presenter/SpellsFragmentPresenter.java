package com.gundersonstudios.dndstatstracker.presenter;

import android.app.Fragment;

import com.gundersonstudios.dndstatstracker.model.CoreModel;
import com.gundersonstudios.dndstatstracker.utils.Constants;

public class SpellsFragmentPresenter{
    private Fragment mFragmentView;
    private CoreModel mCoreModel;

    public SpellsFragmentPresenter(Fragment fragment, CoreModel coreModel) {
        mFragmentView = fragment;
        mCoreModel = coreModel;
    }

    public void spellWasCast(int index) {
        if (index < Constants.MAX_SPELLS_PER_LEVEL) {
            mCoreModel.mSpellsPerDay.levelOneSpellCast();
        } else if (Constants.MAX_SPELLS_PER_LEVEL <= index &&
                    index < (Constants.MAX_SPELLS_PER_LEVEL * 2)) {
            mCoreModel.mSpellsPerDay.levelTwoSpellCast();
        } else if ((Constants.MAX_SPELLS_PER_LEVEL * 2) <= index &&
                index < (Constants.MAX_SPELLS_PER_LEVEL * 3)) {
            mCoreModel.mSpellsPerDay.levelThreeSpellCast();
        }
    }

    public void spellWasUncast(int index) {
        if (index < Constants.MAX_SPELLS_PER_LEVEL) {
            mCoreModel.mSpellsPerDay.levelOneSpellUncast();
        } else if (Constants.MAX_SPELLS_PER_LEVEL <= index &&
                index < (Constants.MAX_SPELLS_PER_LEVEL * 2)) {
            mCoreModel.mSpellsPerDay.levelTwoSpellUncast();
        } else if ((Constants.MAX_SPELLS_PER_LEVEL * 2) <= index &&
                index < (Constants.MAX_SPELLS_PER_LEVEL * 3)) {
            mCoreModel.mSpellsPerDay.levelThreeSpellUncast();
        }
    }

    public void resetAllSpells() {
        mCoreModel.mSpellsPerDay.setLevelOneSpellsCast(0);
        mCoreModel.mSpellsPerDay.setLevelThreeSpellsCast(0);
        mCoreModel.mSpellsPerDay.setLevelTwoSpellsCast(0);
    }
}
