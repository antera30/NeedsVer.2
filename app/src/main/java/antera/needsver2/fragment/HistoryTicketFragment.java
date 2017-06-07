package antera.needsver2.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import antera.needsver2.R;
import antera.needsver2.model.Bangunan;
import antera.needsver2.rest.ApiConfig;
import antera.needsver2.rest.ApiService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class HistoryTicketFragment extends Fragment {
    private ApiService service;

    public HistoryTicketFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
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
                    Log.i("Tiket : ", response.body().getBangunan().toString());
                } else {

                }
            }

            @Override
            public void onFailure(Call<Bangunan> call, Throwable t) {

            }
        });

        return inflater.inflate(R.layout.fragment_history_ticket, container, false);
    }
}
