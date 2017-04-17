package antera.needsver2.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;

import antera.needsver2.DemoData;
import antera.needsver2.MainActivity;
import antera.needsver2.R;
import me.crosswall.lib.coverflow.CoverFlow;
import me.crosswall.lib.coverflow.core.PagerContainer;

/**
 * Created by Fajar on 4/3/2017.
 */

public class HomeFragment extends Fragment {
    public MainActivity main = (MainActivity) getActivity();
    public final static int LOOPS = 1000;
    public ViewPager pager;
    public static int count = 10; //ViewPager items size
    /**
     * You shouldn't define first page = 0.
     * Let define firstpage = 'number viewpager size' to make endless carousel
     */
    public static int FIRST_PAGE = 10;

    int currentPage = 0;
    public int NUM_PAGES = DemoData.covers.length;
    private View myFragmentView;
    private Runnable animateVP;
    private ViewPager viewPager;

    public HomeFragment() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myFragmentView = inflater.inflate(R.layout.activity_normal, container, false);
        PagerContainer pagerContainer = (PagerContainer) myFragmentView.findViewById(R.id.pager_container);
        pagerContainer.setOverlapEnabled(true);

        viewPager = pagerContainer.getViewPager();
        MyFragmentPagerAdapter pagerAdapter = new MyFragmentPagerAdapter(getFragmentManager());
        viewPager.setOffscreenPageLimit(pagerAdapter.getCount());
        viewPager.setAdapter(pagerAdapter);

        new CoverFlow.Builder().with(viewPager)
                .scale(0.3f)
                .pagerMargin(getResources().getDimensionPixelSize(R.dimen.overlap_pager_margin))
                .spaceSize(0f)
                .build();

        //Manually setting the first View to be elevated
        viewPager.post(new Runnable() {
            @Override
            public void run() {
                Fragment fragment = (Fragment) viewPager.getAdapter().instantiateItem(viewPager, currentPage);
                ViewCompat.setElevation(fragment.getView(), 8.0f);
                start();
            }
        });


        return myFragmentView;
    }

    private boolean started = false;
    private Handler handler = new Handler();

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (currentPage < NUM_PAGES){
                currentPage = currentPage+1;
            } else {
                currentPage = 0;
            }
            viewPager.setCurrentItem(currentPage,true);
            if(started) {
                start();
            }
        }
    };

    public void stop() {
        started = false;
        handler.removeCallbacks(runnable);
    }

    public void start() {
        started = true;
        handler.postDelayed(runnable, 5000);
    }
    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return OverlapFragment.newInstance(DemoData.covers[position]);
        }

        @Override
        public int getCount() {
            return DemoData.covers.length;
        }
    }

}
