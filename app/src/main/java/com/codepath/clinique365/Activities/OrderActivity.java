package com.codepath.clinique365.Activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.astuetz.PagerSlidingTabStrip;
import com.codepath.clinique365.Fragments.DrugOrderFragment;
import com.codepath.clinique365.Fragments.LabOrderFragment;
import com.codepath.clinique365.R;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        //get the veiw pager adapter
        ViewPager vpPage = (ViewPager) findViewById(R.id.viewpager);
        //set the view pager for the viewpagerAdapter
        vpPage.setAdapter(new OrderPageAdapter(getSupportFragmentManager()));
        //find the sliding tabs
        PagerSlidingTabStrip tabStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        //attach the pager
        tabStrip.setViewPager(vpPage);
    }

    //return the order of the fragments and the viewpager
    public class OrderPageAdapter extends FragmentPagerAdapter {

        final int PAGE_COUNT = 2;
        String TabTitles[] = {"Laboratoire","Prescription"};


        public OrderPageAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position == 0){
                return new LabOrderFragment();
            }
            else if(position == 1){
                return new DrugOrderFragment();
            }
            else{
                return null;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TabTitles[position];
        }

        @Override
        public int getCount() {
            return TabTitles.length;
        }
    }

}
