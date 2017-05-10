package antera.needsver2.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import antera.needsver2.R;

/**
 * Created by vincentpaing on 6/7/16.
 */
public class OverlapFragment extends Fragment {

    int resourceId;
    int position;
    static final String ARG_RES_ID = "ARG_RES_ID", ARG_POS = "ARG_POS";

    public static OverlapFragment newInstance(int resourceId, int position) {
        OverlapFragment overlapFragment = new OverlapFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_RES_ID, resourceId);
        bundle.putInt(ARG_POS, position);
        overlapFragment.setArguments(bundle);
        Log.i("onCreate", "Overlap Fragment");
        return overlapFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        resourceId = getArguments().getInt(ARG_RES_ID);
        position = getArguments().getInt(ARG_POS);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_overlap_cover, container, false);
        ImageView coverImageView = (ImageView) rootView.findViewById(R.id.image_cover);
        coverImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "" + position, Toast.LENGTH_SHORT).show();
            }
        });
        coverImageView.setImageDrawable(ContextCompat.getDrawable(getContext(), resourceId));
        return rootView;
    }
}
