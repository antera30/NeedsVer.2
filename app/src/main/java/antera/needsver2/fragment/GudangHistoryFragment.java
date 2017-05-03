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
import antera.needsver2.model.Order;
import antera.needsver2.utils.AdapterOrderGudang;

/**
 * A simple {@link Fragment} subclass.
 */
public class GudangHistoryFragment extends Fragment {
    View mView;
    private RecyclerView rv_history;
    private AdapterOrderGudang adapterhistorygudang;
    private List<Order> orderhistorylist;

    public GudangHistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_gudang_history, container, false);
        rv_history = (RecyclerView) mView.findViewById(R.id.rv_gudang_history);
        orderhistorylist = new ArrayList<>();

        //add dummy data
        setData();

        adapterhistorygudang = new AdapterOrderGudang(getContext(), orderhistorylist);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rv_history.setLayoutManager(layoutManager);
        rv_history.setAdapter(adapterhistorygudang);
        return mView;
    }

    private void setData(){
        String kode_pesan = "123";
        String jalur_bayar = "Cash on Delivery", waktu_transaksi = "10-10-10 22:22:10", waktu_kirim = "10-10-10 22:22:10"
                , jm_item = "12", total = "Rp 120.000";
        orderhistorylist.add(new Order(kode_pesan, jalur_bayar, waktu_transaksi, waktu_kirim, jm_item, total));
        orderhistorylist.add(new Order(kode_pesan, jalur_bayar, waktu_transaksi, waktu_kirim, jm_item, total));
        orderhistorylist.add(new Order(kode_pesan, jalur_bayar, waktu_transaksi, waktu_kirim, jm_item, total));
        orderhistorylist.add(new Order(kode_pesan, jalur_bayar, waktu_transaksi, waktu_kirim, jm_item, total));
        orderhistorylist.add(new Order(kode_pesan, jalur_bayar, waktu_transaksi, waktu_kirim, jm_item, total));
    }

}
