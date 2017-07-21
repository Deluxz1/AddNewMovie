package  com.example.tjss.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements FragOne.FragmentOneInterface{

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    FragTwo mFragTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }

    @Override
    public void sendNewMovie (Movie movie) {
        mFragTwo.addNewMovie(movie);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);

        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0 :
                    return FragOne.newInstance();
                case 1 :
                    mFragTwo = FragTwo.newInstance();
                    return mFragTwo;
                default :
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 2;       // Show 3 total pages.
        }
    }
}