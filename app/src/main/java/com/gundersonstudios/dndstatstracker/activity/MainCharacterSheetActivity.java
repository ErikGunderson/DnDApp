package com.gundersonstudios.dndstatstracker.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gundersonstudios.dndstatstracker.R;
import com.gundersonstudios.dndstatstracker.base.IStatFragment;
import com.gundersonstudios.dndstatstracker.fragment.HealthFragment;
import com.gundersonstudios.dndstatstracker.fragment.SpellsFragment;
import com.gundersonstudios.dndstatstracker.model.DependencyRepository;
import com.gundersonstudios.dndstatstracker.presenter.HealthFragmentPresenter;
import com.gundersonstudios.dndstatstracker.presenter.SpellsFragmentPresenter;
import com.gundersonstudios.dndstatstracker.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.fragment;

public class MainCharacterSheetActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_home);

        context = getApplicationContext();
        DependencyRepository.initDependencyRepository();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_stats_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings:
                return true;
            case R.id.add_health_frag:
                mSectionsPagerAdapter.addHealthFragment();
                return true;
            case R.id.add_spells_frag:
                mSectionsPagerAdapter.addSpellsFragment();
                return true;
            default:
                Log.e(getClass().getSimpleName(), "Failed to find an id matching the clicked menu item");
        }

        return super.onOptionsItemSelected(item);
    }




    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private List<IStatFragment> mFragments = new ArrayList<IStatFragment>();

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);

            buildAndAddHealthFragment(mFragments);

            buildAndAddSpellsFragment(mFragments);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position).getFragment();
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragments.get(position).getFragmentName();
        }

        public void addHealthFragment() {
            buildAndAddHealthFragment(mFragments);
            notifyDataSetChanged();
        }

        public void addSpellsFragment() {
            buildAndAddSpellsFragment(mFragments);
            notifyDataSetChanged();
        }
    }

    public void buildAndAddHealthFragment(List<IStatFragment> fragmentList) {
        Bundle args = new Bundle();
        args.putInt(Constants.FRAG_SECTION_NUMBER, 1);
        Fragment fragment = new HealthFragment();
        fragment.setArguments(args);
        fragmentList.add((IStatFragment) fragment);
    }

    public void buildAndAddSpellsFragment(List<IStatFragment> fragmentList) {
        Bundle args = new Bundle();
        args.putInt(Constants.FRAG_SECTION_NUMBER, 2);
        Fragment fragment = new SpellsFragment();
        fragment.setArguments(args);
        fragmentList.add((IStatFragment) fragment);
    }
}
