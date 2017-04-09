package antera.needsver2;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class ForgotPasswordActivity extends AppCompatActivity {

    Toolbar toolbar;
    CoordinatorLayout coordinatorLayout;
    Button btn_send_code, btn_verify_code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.forgot_password);

        toolbar = (Toolbar) findViewById(R.id.empty_app_bar);
        toolbar.setTitle("Forgot Password");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        btn_send_code = (Button) findViewById(R.id.btn_send_code);
        btn_send_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Code Has Been Sent", Snackbar.LENGTH_SHORT);

                snackbar.show();
            }
        });

        btn_verify_code = (Button) findViewById(R.id.btn_verify_code);
        btn_verify_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Enter Verification Code", Snackbar.LENGTH_SHORT);

                snackbar.show();
            }
        });
    }
}
