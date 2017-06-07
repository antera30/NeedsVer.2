package antera.needsver2.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import antera.needsver2.R;
import antera.needsver2.model.Bangunan;
import antera.needsver2.model.Order;
import antera.needsver2.rest.ApiConfig;
import antera.needsver2.rest.ApiService;
import antera.needsver2.supermarket.DetailOrderActivity;
import antera.needsver2.utils.AdapterOrder;
import antera.needsver2.utils.RecyclerItemClickListener;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistorySupermarketFragment extends Fragment {

    View mView;
    private RecyclerView rv_order;
    private AdapterOrder adapter;
    private List<Order> orderlist;
    private ApiService service;
    public HistorySupermarketFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView =  inflater.inflate(R.layout.fragment_history_supermarket, container, false);

        rv_order = (RecyclerView) mView.findViewById(R.id.rv_supermarket_history);
        orderlist = new ArrayList<>();


        // Retrofit
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        service = new Retrofit.Builder().baseUrl(ApiConfig.API_URL).addConverterFactory(GsonConverterFactory.create())
                .client(client).build()
                .create(ApiService.class);
        Call<Bangunan> call = service.getBangunan();
        call.enqueue(new Callback<Bangunan>() {
            @Override
            public void onResponse(Call<Bangunan> call, Response<Bangunan> response) {
                if (response.isSuccessful()) {
                    Log.i("Supermarket : ", response.body().getBangunan().toString());
                } else {

                }
            }

            @Override
            public void onFailure(Call<Bangunan> call, Throwable t) {

            }
        });


        //add dummy data
        setData();

        adapter = new AdapterOrder(getContext(), orderlist);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rv_order.setLayoutManager(layoutManager);
        rv_order.setAdapter(adapter);

        rv_order.addOnItemTouchListener(new RecyclerItemClickListener(getContext(),
                rv_order, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getContext(), ""+position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), DetailOrderActivity.class);
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));


        return mView;

    }

    private void setData(){
        String kode_pesan = "123";
        String jalur_bayar = "Cash on Delivery", waktu_transaksi = "10-10-10 22:22:10", waktu_kirim = "10-10-10 22:22:10"
                , jm_item = "12", total = "Rp 120.000";
        orderlist.add(new Order(kode_pesan, jalur_bayar, waktu_transaksi, waktu_kirim, jm_item, total));
        orderlist.add(new Order(kode_pesan, jalur_bayar, waktu_transaksi, waktu_kirim, jm_item, total));
        orderlist.add(new Order(kode_pesan, jalur_bayar, waktu_transaksi, waktu_kirim, jm_item, total));
        orderlist.add(new Order(kode_pesan, jalur_bayar, waktu_transaksi, waktu_kirim, jm_item, total));
        orderlist.add(new Order(kode_pesan, jalur_bayar, waktu_transaksi, waktu_kirim, jm_item, total));
    }

}
