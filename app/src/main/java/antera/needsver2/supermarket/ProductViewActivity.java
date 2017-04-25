package antera.needsver2.supermarket;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import antera.needsver2.R;
import antera.needsver2.model.Product;
import antera.needsver2.utils.AdapterSingleProductCard;

public class ProductViewActivity extends AppCompatActivity {

    private RecyclerView rv_single_product;
    private AdapterSingleProductCard adapterSingleProductCard;
    private List<Product> products;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_product_view);

        toolbar = (Toolbar) findViewById(R.id.empty_app_bar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rv_single_product = (RecyclerView) findViewById(R.id.product_content_recyclerview);
        products = new ArrayList<>();
        adapterSingleProductCard = new AdapterSingleProductCard(getApplicationContext(), products);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        rv_single_product.setLayoutManager(mLayoutManager);
        rv_single_product.addItemDecoration(new ProductViewActivity.GridSpacingItemDecoration(2, dpToPx(2), true));
        rv_single_product.setItemAnimator(new DefaultItemAnimator());
        rv_single_product.setAdapter(adapterSingleProductCard);
        prepareContent();
    }

    /**
     * Adding few albums for testing
     */
    private void prepareContent() {
        int[] covers = new int[]{
                R.mipmap.ic_launcher
        };

        Product a;
        String url = "https://www.static-src.com/wcsstore/Indraprastha/images/catalog/full/bimoli_bimoli-minyak-goreng--2-l-_full01.jpg";
        a = new Product("bimoli", "2/liter","deskripsi singkat", 150000, 12, url);
        products.add(a);
        a = new Product("filma", "1/liter","deskripsi singkat", 150000, 12, url);
        products.add(a);
        a = new Product("sanco", "3/liter","deskripsi singkat", 150000, 12, url);
        products.add(a);
        a = new Product("bimoli spec", "1/liter","deskripsi singkat", 150000, 12, url);
        products.add(a);
        a = new Product("fortune", "2/liter","deskripsi singkat", 150000, 12, url);
        products.add(a);
        a = new Product("bimoli", "1/liter","deskripsi singkat", 150000, 12, url);
        products.add(a);

        adapterSingleProductCard.notifyDataSetChanged();
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here
//                Intent intent = new Intent(ProductViewActivity.this, CategoryActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
