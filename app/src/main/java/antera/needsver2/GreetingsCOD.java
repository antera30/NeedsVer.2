package antera.needsver2;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

public class GreetingsCOD extends AppCompatActivity {

    RecyclerView rv_detailtrans, rv_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings_cod);

        rv_detailtrans = (RecyclerView) findViewById(R.id.rv_detail);
        rv_status = (RecyclerView) findViewById(R.id.rv_status_trans);

    }
}
