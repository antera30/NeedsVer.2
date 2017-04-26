package antera.needsver2.supermarket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import antera.needsver2.R;
import antera.needsver2.model.Checkout_detail;
import antera.needsver2.utils.Adapter_checkout;

/**
 * Created by bima on 25/04/2017.
 */

public class Checkout extends AppCompatActivity {

    private final String nm_barang[] = {
            "Rinso", "Pepsodent", "lifebuoy","batre abc"
    };

    private final String berat[] = {
            "1 kg", "170 gr", "40 gr", "100 gr"
    };

    private final String harga[] = {
            "Rp 34.000,-", "Rp 9.000,-", "Rp 2.500,-","Rp 25.000,-"
    };

    private final String img_url[] = {
            "http://api.learn2crack.com/android/images/donut.png",
            "http://api.learn2crack.com/android/images/eclair.png",
            "http://api.learn2crack.com/android/images/froyo.png",
            "http://api.learn2crack.com/android/images/froyo.png"

    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        initViews();
    }

    private void initViews() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.activity_checkout_detail);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Checkout_detail> checkout_details = checkoutData();
        Adapter_checkout adapter = new Adapter_checkout(getApplicationContext(), checkout_details);
        recyclerView.setAdapter(adapter);

    }

    private ArrayList<Checkout_detail> checkoutData() {
        ArrayList<Checkout_detail> checkout_details = new ArrayList<>();
        for (int i = 0; i < nm_barang.length; i++) {
            Checkout_detail checkoutDetail = new Checkout_detail();
            checkoutDetail.setNm_barang(nm_barang[i]);
            checkoutDetail.setBerat(berat[i]);
            checkoutDetail.setHarga(harga[i]);
            checkoutDetail.setImg_url(img_url[i]);
            checkout_details.add(checkoutDetail);
        }
        return checkout_details;
    }
}

