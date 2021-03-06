package antera.needsver2.supermarket;

import android.graphics.PorterDuff;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import antera.needsver2.R;
import antera.needsver2.fragment.GudangHistoryFragment;
import antera.needsver2.fragment.GudangOrderFragment;
import antera.needsver2.fragment.KurirHistoryFragment;
import antera.needsver2.fragment.KurirOrderFragment;

public class KurirMainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.drawable.ic_reorder_black_24dp,
            R.drawable.ic_history_black_24dp
    };
    private int[] tabTitle = {
            R.string.order,
            R.string.history
    };
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kurir_main);

        toolbar = (Toolbar) findViewById(R.id.htab_toolbar);
        toolbar.setTitle("Nama Kurir");
        setSupportActionBar(toolbar);

        //getSupportActionBar().setTitle(null);
        getSupportActionBar().setIcon(R.mipmap.ic_app_bar_icon);

        viewPager = (ViewPager) findViewById(R.id.kurir_viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.kurir_tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int tabIconColor = ContextCompat.getColor(getApplicationContext(), R.color.colorAccent);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int tabIconColor = ContextCompat.getColor(getApplicationContext(), R.color.white);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab   ) {

            }
        });
        setupTabIcons();

    }

    protected void setupViewPager(ViewPager viewPager) {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new KurirOrderFragment(), getResources().getString(tabTitle[0]));
        adapter.addFrag(new KurirHistoryFragment(), getResources().getString(tabTitle[1]));
        viewPager.setAdapter(adapter);
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
