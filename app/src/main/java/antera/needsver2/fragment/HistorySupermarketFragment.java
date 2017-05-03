package antera.needsver2.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import antera.needsver2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistorySupermarketFragment extends Fragment {


    public HistorySupermarketFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history_supermarket, container, false);
    }

}
