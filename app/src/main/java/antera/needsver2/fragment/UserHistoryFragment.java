package antera.needsver2.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import antera.needsver2.R;

/**
 * Created by Fajar on 4/3/2017.
 */

public class UserHistoryFragment extends Fragment{
    private TabLayout tabLayout;
    private ViewPager viewPager;
    View mView;
    private int[] tabTitle = {
            R.string.supermarket,
            R.string.ticket,
            R.string.foods
    };

    public UserHistoryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView =  inflater.inflate(R.layout.fragment_two, container, false);


        viewPager = (ViewPager) mView.findViewById(R.id.hostory_tab_viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) mView.findViewById(R.id.tab_history_frag);
        tabLayout.setupWithViewPager(viewPager);
        return  mView;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.addFragment(new HistorySupermarketFragment(), getResources().getString(tabTitle[0]));
        adapter.addFragment(new HistoryTicketFragment(), getResources().getString(tabTitle[1]));
        adapter.addFragment(new HistoryFoodsFragment(), getResources().getString(tabTitle[2]));
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
