package antera.needsver2.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import antera.needsver2.R;
import antera.needsver2.model.Kurir_Order;
import antera.needsver2.utils.AdapterOrderKurir;

/**
 * A simple {@link Fragment} subclass.
 */
public class KurirOrderFragment extends Fragment {


    View mView;
    private RecyclerView rv_order;
    private AdapterOrderKurir adapterOrderKurir;
    private List<Kurir_Order> orderlist;


    public KurirOrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_kurir_order, container, false);
        rv_order = (RecyclerView) mView.findViewById(R.id.rv_kurir_order);
        orderlist = new ArrayList<>();

        //add dummy data
        setData();

        adapterOrderKurir= new AdapterOrderKurir(getContext(), orderlist);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rv_order.setLayoutManager(layoutManager);
        rv_order.setAdapter(adapterOrderKurir);
        return mView;
    }

    private void setData(){
        String kode_pesan = "123";
        String jalur_bayar = "Cash on Delivery", lokasi = "ruko panji makmur", waktu_kirim = "10-10-10 22:22:10"
                , jm_item = "12", total = "Rp 120.000";
        orderlist.add(new Kurir_Order(kode_pesan, jalur_bayar, lokasi, waktu_kirim, jm_item, total));
        orderlist.add(new Kurir_Order(kode_pesan, jalur_bayar, lokasi, waktu_kirim, jm_item, total));
        orderlist.add(new Kurir_Order(kode_pesan, jalur_bayar, lokasi, waktu_kirim, jm_item, total));
        orderlist.add(new Kurir_Order(kode_pesan, jalur_bayar, lokasi, waktu_kirim, jm_item, total));
        orderlist.add(new Kurir_Order(kode_pesan, jalur_bayar, lokasi, waktu_kirim, jm_item, total));
    }


}
