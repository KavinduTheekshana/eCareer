package com.example.ecareer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private Button btn_login,btn_signup;
    private TextView btn_forgot,alert_box;
    private EditText user_email,user_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        hideSystemUI();

        //UI Declare
        ui_declare();

        //New user sign up
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Register.class));
            }
        });

        //Password forget
        btn_forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ForgotPassword.class));
            }
        });

        //login Account
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = user_email.getText().toString().trim();
                String password = user_password.getText().toString().trim();

                if (ValidationData.login_validate(email,password))
                {
                    startActivity(new Intent(getApplicationContext(),DashboardActivity.class));
                }else{
                    //Toast.makeText(Login.this,"Please Fill All Details",Toast.LENGTH_SHORT).show();
                    alert_box.setText("Please Fill All Details");
                }
            }
        });
    }

    private void ui_declare() {

        user_email = findViewById(R.id.login_et_username);
        user_password = findViewById(R.id.login_et_password);

        btn_login = findViewById(R.id.login_btn_login);
        btn_signup = findViewById(R.id.login_btn_register);
        btn_forgot = findViewById(R.id.login_tv_ForgotPassword);
        alert_box = findViewById(R.id.login_alert_box);
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
