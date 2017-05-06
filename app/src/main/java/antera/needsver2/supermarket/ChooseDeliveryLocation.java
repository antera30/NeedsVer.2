package antera.needsver2.supermarket;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import antera.needsver2.R;
import antera.needsver2.model.Kecamatan;
import antera.needsver2.utils.AdapterKecamatan;
import antera.needsver2.utils.DividerItemDecoration;
import antera.needsver2.utils.RecyclerItemClickListener;

public class ChooseDeliveryLocation extends AppCompatActivity {

    Button btn_next;
    private List<Kecamatan> kecamatanList = new ArrayList<>();
    private RecyclerView recyclerView;
    private AdapterKecamatan adapterKecamatan;
    private CoordinatorLayout coordinatorLayout;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_delivery_location);

        toolbar = (Toolbar) findViewById(R.id.empty_app_bar);
        toolbar.setTitle("Pilih Area Pengiriman");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.rv_kecamatan);

        adapterKecamatan = new AdapterKecamatan(kecamatanList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapterKecamatan);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.snackbar_layout);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
//                        Snackbar bar = Snackbar.make(coordinatorLayout, "Belanja Sekarang ? ", Snackbar.LENGTH_LONG)
//                                .setAction("Ya", new View.OnClickListener() {
//                                    @Override
//                                    public void onClick(View v) {
//                                        // Handle user action
//                                        Intent i = new Intent(getApplicationContext(), CategoryActivity.class);
//                                        startActivity(i);
//                                        finish();
//                                    }
//                                });
//                        View snackbarView = bar.getView();
//                        Button button = (Button) snackbarView.findViewById(android.support.design.R.id.snackbar_action);
//                        button.setGravity(Gravity.CENTER);
//                        bar.show();
                        createSnackbar(coordinatorLayout);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                }));

        prepareData();


//        btn_next = (Button) findViewById(R.id.btn_pilih_kecamatan);
//        btn_next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent i = new Intent(getApplicationContext(), CategoryActivity.class);
//                startActivity(i);
//                finish();
//            }
//        });

    }


    public void prepareData() {
        String kec = "Surabaya";
        String kot = "Surabaya";
        String pro = "Jawa Timur";
        int id = 12;
        Kecamatan kecamatan = new Kecamatan(kec, kot, pro, id);
        kecamatanList.add(kecamatan);
        adapterKecamatan.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here
//                Intent intent = new Intent(ProductsViewActivity.this, CategoryActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);
                finish();
                return true;
            case R.id.shopping_cart:
                Toast.makeText(getApplicationContext(), "Add to Cart", Toast.LENGTH_LONG).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }




    public void createSnackbar(CoordinatorLayout coordinatorLayout) {
        Snackbar snackbar = Snackbar.make(coordinatorLayout, "", Snackbar.LENGTH_LONG);
        Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();
        TextView textView = (TextView) layout.findViewById(android.support.design.R.id.snackbar_text);
        textView.setVisibility(View.INVISIBLE);
        View snackView = getLayoutInflater().inflate(R.layout.my_snackbar, null);
        Button btn_lanjutkan = (Button) snackView.findViewById(R.id.btn_belanja_skrng);
        btn_lanjutkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), CategoryActivity.class);
                startActivity(i);
                finish();
            }
        });
        layout.setPadding(0,0,0,0)
        ;
        layout.addView(snackView, 0);
        snackbar.show();
    }

}
