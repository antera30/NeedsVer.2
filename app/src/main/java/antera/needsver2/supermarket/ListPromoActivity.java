package antera.needsver2.supermarket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import antera.needsver2.R;
import antera.needsver2.model.Promo;
import antera.needsver2.utils.AdapterPromo;

public class ListPromoActivity extends AppCompatActivity {


    private AdapterPromo adapterPromo;
    private RecyclerView rv_promo;
    private List<Promo> promoList;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_promo);

        toolbar = (Toolbar) findViewById(R.id.empty_app_bar);
        toolbar.setTitle(R.string.promo);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rv_promo = (RecyclerView) findViewById(R.id.rv_promo);
        promoList = new ArrayList<>();
        setData();


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv_promo.setLayoutManager(layoutManager);
        adapterPromo = new AdapterPromo(this, promoList);
        rv_promo.setAdapter(adapterPromo);

    }

    private void setData() {
        String img_url = "http:needs.co.id ", title = "ini promo luar biasa", description = "lalalla", valid_date = "10 December 2017", price = "Rp 50.0000";
        Promo a = new Promo(img_url, title + "pertama", description, valid_date, price);
        promoList.add(a);
        a = new Promo(img_url, title + "kedua", description, valid_date, price);
        promoList.add(a);
        a = new Promo(img_url, title + "ketiga", description, valid_date, price);
        promoList.add(a);

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
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
