package antera.needsver2.supermarket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;

import antera.needsver2.R;
import antera.needsver2.model.Category;
import antera.needsver2.model.SubCategory;
import antera.needsver2.utils.AdapterRecyclerViewCategory;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Category> categories;
    private AdapterRecyclerViewCategory adapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori);

        toolbar = (Toolbar) findViewById(R.id.empty_app_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(R.string.category);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.rv_categories);
        categories = new ArrayList<>();

        setData();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new AdapterRecyclerViewCategory(this, categories);
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        adapter.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        adapter.onRestoreInstanceState(savedInstanceState);
    }

    private void setData() {
        ArrayList<SubCategory> sembako = new ArrayList<>();
        sembako.add(new SubCategory(1, "satu"));
        sembako.add(new SubCategory(2, "dua"));
        sembako.add(new SubCategory(3, "tiga"));
        sembako.add(new SubCategory(4, "empat"));
        sembako.add(new SubCategory(5, "lima"));

        ArrayList<SubCategory> segar = new ArrayList<>();
        segar.add(new SubCategory(11, "one"));
        segar.add(new SubCategory(22, "two"));
        segar.add(new SubCategory(34, "three"));
        segar.add(new SubCategory(44, "four"));
        segar.add(new SubCategory(55, "five"));

        ArrayList<SubCategory> makanan = new ArrayList<>();
        makanan.add(new SubCategory(111, "ichi"));
        makanan.add(new SubCategory(222, "ni"));
        makanan.add(new SubCategory(333, "san"));

        categories.add(new Category("Sembako", sembako));
        categories.add(new Category("Segar", segar));
        categories.add(new Category("Makanan", makanan));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here
                Intent intent = new Intent(CategoryActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
