package antera.needsver2.supermarket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import antera.needsver2.R;

public class DetailPromoActivity extends AppCompatActivity {

    private TextView title, desc, valid, price;
    private ImageView image;

    String tit, des, val, pri, img;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_promo);

        toolbar = (Toolbar) findViewById(R.id.empty_app_bar);
        toolbar.setTitle(R.string.promo);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Intent mIntent = getIntent();
        if (mIntent != null) {
            Bundle extras = mIntent.getExtras();
            tit = extras.getString("TITLE");
            des = extras.getString("DESC");
            val = extras.getString("VALID");
            pri = extras.getString("PRICE");
            img = extras.getString("IMAGE");
        }

        title = (TextView) findViewById(R.id.tv_det_title);
        desc = (TextView) findViewById(R.id.tv_det_desc);
        valid = (TextView) findViewById(R.id.tv_det_valid);
        price = (TextView) findViewById(R.id.tv_det_price);
        image = (ImageView) findViewById(R.id.iv_det_promo_image);

        title.setText(tit);
        desc.setText(des);
        valid.setText(val);
        price.setText(pri);


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
