package com.gundersonstudios.dndstatstracker.base;


import android.content.Context;
import android.support.v4.app.Fragment;

public interface IStatFragment {
    String getFragmentName();

    Fragment getFragment();
}
