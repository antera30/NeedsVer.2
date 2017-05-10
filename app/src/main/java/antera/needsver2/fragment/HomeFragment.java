package antera.needsver2.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import antera.needsver2.R;
import antera.needsver2.model.MenuNeeds;
import antera.needsver2.supermarket.DetailPromoActivity;
import antera.needsver2.supermarket.ListPromoActivity;
import antera.needsver2.utils.AdapterContentMainFeature;
import me.crosswall.lib.coverflow.CoverFlow;
import me.crosswall.lib.coverflow.core.PagerContainer;

/**
 * Created by Fajar on 4/3/2017.
 */

public class HomeFragment extends Fragment {
    /**
     * You shouldn't define first page = 0.
     * Let define firstpage = 'number viewpager size' to make endless carousel
     */

    int currentPage = 1;
    //    public int NUM_PAGES = DemoData.covers.length;
    private View myFragmentView;
    private Runnable animateVP;
    private ViewPager viewPager;
    private PagerContainer pagerContainer;
    boolean first_open = true;
    public static int[] covers = {
            R.mipmap.ic_cover_5, R.mipmap.ic_cover_1,
            R.mipmap.ic_cover_2, R.mipmap.ic_cover_3,
            R.mipmap.ic_cover_4, R.mipmap.ic_cover_5,
            R.mipmap.ic_cover_4, R.mipmap.ic_cover_5,
            R.mipmap.ic_cover_1};

    public int NUM_PAGES = covers.length;


    private RecyclerView cv_content;
    private AdapterContentMainFeature adapterContentMainFeature;
    private List<MenuNeeds> needsList;
    private Button btn_promo;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("OnCreate", "even oncreate");
        Log.i("OnCreate cover", String.valueOf(covers.length));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("OnCreate", "even oncreate view");
        Log.i("OnCreateView cover", String.valueOf(covers.length));
        // Inflate the layout for this fragment
        myFragmentView = inflater.inflate(R.layout.activity_normal, container, false);


        //the menu boxes
        cv_content = (RecyclerView) myFragmentView.findViewById(R.id.content_recycler_view);
        needsList = new ArrayList<>();
        adapterContentMainFeature = new AdapterContentMainFeature(getContext(), needsList);
        btn_promo = (Button) myFragmentView.findViewById(R.id.btn_promo);
        btn_promo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), ListPromoActivity.class);
                startActivity(i);
            }
        });
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
        cv_content.setLayoutManager(mLayoutManager);
        cv_content.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(2), true));
        cv_content.setItemAnimator(new DefaultItemAnimator());
        cv_content.setAdapter(adapterContentMainFeature);
        prepareMenu();
        setupCarousel();
        return myFragmentView;
    }

    public void setupCarousel() {
        pagerContainer = (PagerContainer) myFragmentView.findViewById(R.id.pager_container);
        pagerContainer.setOverlapEnabled(true);
        //setup carousel
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
                Fragment fragment = (Fragment) viewPager.getAdapter().instantiateItem(viewPager, 0);
                ViewCompat.setElevation(fragment.getView(), 8.0f);
                viewPager.setCurrentItem(0);
            }
        });


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //Toast.makeText(getContext(), "" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //stop();

            }
        });
    }

    private boolean started = false;
    private Handler handler = new Handler();

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (currentPage < NUM_PAGES - 2) {
                currentPage = currentPage + 1;
                viewPager.setCurrentItem(currentPage, true);
            } else {
                currentPage = 1;
                viewPager.setCurrentItem(currentPage, false);
            }
            if (started) {
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
            return OverlapFragment.newInstance(covers[position], position);
        }

        @Override
        public int getCount() {
            return covers.length;
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    /**
     * Adding few albums for testing
     */
    private void prepareMenu() {
        int[] covers = new int[]{
                R.mipmap.ic_launcher
        };

        MenuNeeds a;

        a = new MenuNeeds("Supermarket", covers[0]);
        needsList.add(a);
        a = new MenuNeeds("Tiket", covers[0]);
        needsList.add(a);
        a = new MenuNeeds("Foods", covers[0]);
        needsList.add(a);
        a = new MenuNeeds("Multipayment", covers[0]);
        needsList.add(a);
        a = new MenuNeeds("Ojek dan Taxi", covers[0]);
        needsList.add(a);
        a = new MenuNeeds("Finance", covers[0]);
        needsList.add(a);

        adapterContentMainFeature.notifyDataSetChanged();
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

}
