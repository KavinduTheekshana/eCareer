package com.example.ecareer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

public class ResetPassword extends AppCompatActivity {

    private EditText user_password,user_password_confirem;
    private MaterialCardView btn_reset;
    private TextView alert_box,btn_go_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        hideSystemUI();

        //UI Declare
        ui_declare();

        //go login dashboard
        btn_go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String password = user_password.getText().toString().trim();
                String repassword = user_password_confirem.getText().toString().trim();

                if (!password.isEmpty() || !repassword.isEmpty())
                {
                    if (ValidationData.check_password_validate(password,repassword))
                    {
                        //change code
                        startActivity(new Intent(getApplicationContext(),Login.class));
                    }else {
                        alert_box.setText("Password Not Same");
                    }
                }else{
                    alert_box.setText("Fill All Details");
                }
            }
        });
    }

    private void ui_declare() {
        user_password = findViewById(R.id.reset_password_password);
        user_password_confirem = findViewById(R.id.reset_password_re_password);
        btn_reset = findViewById(R.id.reset_password_btn_reset);
        alert_box = findViewById(R.id.reset_password_alert_box);
        btn_go_back = findViewById(R.id.reset_password_btn_goLogin);
    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }
}
