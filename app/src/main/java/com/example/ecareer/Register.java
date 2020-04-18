package com.example.ecareer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

public class Register extends AppCompatActivity {
    MaterialCardView register_btn_student,register_btn_industry;
    ImageView register_icon_student,register_icon_industry;
    TextView register_txt_student,register_txt_industry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register_btn_student = findViewById(R.id.register_btn_student);
        register_btn_industry = findViewById(R.id.register_btn_industry);
        register_icon_student = findViewById(R.id.register_icon_student);
        register_icon_industry = findViewById(R.id.register_icon_industry);
        register_txt_student = findViewById(R.id.register_txt_student);
        register_txt_industry = findViewById(R.id.register_txt_industry);

        register_btn_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectStudent();
            }
        });

        register_btn_industry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectIndustry();
            }
        });

        //select Student
        SelectStudent();
    }

    private void SelectIndustry() {
        register_btn_industry.setBackgroundColor(Color.parseColor("#5F47AF"));
        register_icon_industry.setColorFilter(Color.parseColor("#ffffff"));
        register_txt_industry.setTextColor(Color.parseColor("#ffffff"));

        register_btn_student.setBackgroundColor(Color.parseColor("#ffffff"));
        register_icon_student.setColorFilter(Color.parseColor("#757576"));
        register_txt_student.setTextColor(Color.parseColor("#757576"));

        Industry industry = new Industry();
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in,R.anim.fade_out).replace(R.id.container,industry).commit();
    }


    private void SelectStudent() {
        register_btn_student.setBackgroundColor(Color.parseColor("#5F47AF"));
        register_icon_student.setColorFilter(Color.parseColor("#ffffff"));
        register_txt_student.setTextColor(Color.parseColor("#ffffff"));

        register_btn_industry.setBackgroundColor(Color.parseColor("#ffffff"));
        register_icon_industry.setColorFilter(Color.parseColor("#757576"));
        register_txt_industry.setTextColor(Color.parseColor("#757576"));

        Student student = new Student();
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in,R.anim.fade_out).replace(R.id.container,student).commit();

    }
}
