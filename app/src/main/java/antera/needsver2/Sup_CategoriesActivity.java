package antera.needsver2;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import antera.needsver2.model.Category;
import antera.needsver2.model.SubCategory;
import antera.needsver2.utils.AdapterRecyclerViewCategory;

public class Sup_CategoriesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Category> categories;
    private AdapterRecyclerViewCategory adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori);

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

}
