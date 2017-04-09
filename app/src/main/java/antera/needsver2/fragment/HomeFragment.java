package antera.needsver2.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import antera.needsver2.HomeActivity;
import antera.needsver2.R;
import antera.needsver2.adapter.CarouselPagerAdapter;

/**
 * Created by Fajar on 4/3/2017.
 */

public class HomeFragment extends Fragment {
    public HomeActivity main = (HomeActivity) getActivity();
    public final static int LOOPS = 1000;
    public CarouselPagerAdapter carouselPagerAdapter;
    public ViewPager pager;
    public static int count = 10; //ViewPager items size
    /**
     * You shouldn't define first page = 0.
     * Let define firstpage = 'number viewpager size' to make endless carousel
     */
    public static int FIRST_PAGE = 10;


    private View myFragmentView;


    public HomeFragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myFragmentView = inflater.inflate(R.layout.fragment_home, container, false);
        pager = (ViewPager) myFragmentView.findViewById(R.id.myviewpager);
        //set page margin between pages for viewpager
        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int pageMargin = ((metrics.widthPixels / 4) * 2);
        pager.setPageMargin(-pageMargin);

        carouselPagerAdapter = new CarouselPagerAdapter(this, getActivity().getSupportFragmentManager());
        pager.setAdapter(carouselPagerAdapter);
        carouselPagerAdapter.notifyDataSetChanged();


        pager.addOnPageChangeListener(carouselPagerAdapter);

        // Set current item to the middle page so we can fling to both
        // directions left and right
        pager.setCurrentItem(FIRST_PAGE);
        pager.setOffscreenPageLimit(3);

        return myFragmentView;
    }

}
