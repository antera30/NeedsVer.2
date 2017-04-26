package antera.needsver2;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.ArrayList;
import java.util.Calendar;

import antera.needsver2.model.Alamat;
import antera.needsver2.utils.Alamat_adapter;
import antera.needsver2.model.SubAlamat;

/**
 * Created by bima on 18/04/2017.
 */

public class AlamatActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private RecyclerView recyclerView;
    private ArrayList<Alamat> alamates;
    private Alamat_adapter adapter;
    private Toolbar toolbar;
    private TextView tanggal, jam;
    private Button bt_tanggal, bt_jam;

    private Button save;
    private ImageView tambah;
    Point p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alamat_pengiriman);

        toolbar = (Toolbar) findViewById(R.id.empty_app_bar);
        setSupportActionBar(toolbar);


        tanggal = (TextView) findViewById(R.id.textTanggal);
        jam = (TextView) findViewById(R.id.textJam);
        bt_jam = (Button) findViewById(R.id.Jam);
        bt_tanggal = (Button) findViewById(R.id.Date);

        bt_tanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//            updateDate();
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        AlamatActivity.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.show(getFragmentManager(), "Datepickerdialog");
            }
        });

        bt_jam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//            updateTime();
                Calendar now = Calendar.getInstance();
                TimePickerDialog timepickerdialog = TimePickerDialog.newInstance(AlamatActivity.this,
                        now.get(Calendar.HOUR_OF_DAY),
                        now.get(Calendar.MINUTE), true);

                timepickerdialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        Toast.makeText(AlamatActivity.this, "Cancel choosing time", Toast.LENGTH_SHORT).show();
                    }
                });
                timepickerdialog.show(getFragmentManager(), "Timepickerdialog"); //show time picker dialog
            }

        });


        getSupportActionBar().setTitle(R.string.alamat);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.rv_categories);
        alamates = new ArrayList<>();

        setData();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new Alamat_adapter(this, alamates);
        recyclerView.setAdapter(adapter);


        tambah = (ImageView) findViewById(R.id.tambah_alamat);
        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Open popup window
                if (p != null)
                    tambahAlamat(AlamatActivity.this, p);
            }
        });

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
        ArrayList<SubAlamat> sembako = new ArrayList<>();
        sembako.add(new SubAlamat(1, "satu"));
        sembako.add(new SubAlamat(2, "dua"));
        sembako.add(new SubAlamat(3, "tiga"));
        sembako.add(new SubAlamat(4, "empat"));
        sembako.add(new SubAlamat(5, "lima"));



        alamates.add(new Alamat("Sembako", sembako));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
//            case android.R.id.home:
//                // todo: goto back activity from here
//                Intent intent = new Intent(AlamatActivity.this, MainActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);
//                finish();
//                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        int[] location = new int[2];
        tambah = (ImageView) findViewById(R.id.tambah_alamat);
        tambah.getLocationOnScreen(location);

        p = new Point();
        p.x = location[0];
        p.y = location[1];
    }

    private void tambahAlamat(final Activity context, Point p){

        LinearLayout viewGroup = (LinearLayout) context.findViewById(R.id.popup);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = layoutInflater.inflate(R.layout.activity_isi_alamat, viewGroup);

        // Creating the PopupWindow
        final PopupWindow popup = new PopupWindow(context);
        popup.setContentView(layout);
        popup.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        popup.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popup.setFocusable(true);

        // Some offset to align the popup a bit to the right, and a bit down, relative to button's position.
        int OFFSET_X = 50;
        int OFFSET_Y = 50;

        // Clear the default translucent background
        popup.setBackgroundDrawable(new BitmapDrawable());

        // Displaying the popup at the specified location, + offsets.
        popup.showAtLocation(layout, Gravity.CENTER, p.x + OFFSET_X, p.y + OFFSET_Y);

        // Getting a reference to Close button, and close the popup when clicked.
        save = (Button) layout.findViewById(R.id.saves);
        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                popup.dismiss();
            }
        });
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = "Tanggal kirim" + dayOfMonth + "/" + (++monthOfYear) + "/" + year;
        tanggal.setText(date);
    }

    @Override
    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
        String hourString = hourOfDay < 10 ? "0" + hourOfDay : "" + hourOfDay;
        String minuteString = minute < 10 ? "0" + minute : "" + minute;
        String secondString = second < 10 ? "0" + second : "" + second;
        String time = "Jam kirim" + hourString + "h" + minuteString + "m" + secondString + "s";
        jam.setText(time);
    }
}
