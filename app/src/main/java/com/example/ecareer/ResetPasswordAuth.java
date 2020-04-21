package com.example.ecareer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResetPasswordAuth extends Fragment {

    private View v;
    private EditText user_password,user_password_confirem;
    private MaterialCardView btn_reset;
    private TextView alert_box;

    public ResetPasswordAuth() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_reset_password_auth, container, false);

        //UI Declare
        ui_declare();

        //change password
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
                    }else {
                        alert_box.setText("Password Not Same");
                    }
                }else{
                    alert_box.setText("Fill All Details");
                }

            }
        });



        // Inflate the layout for this fragment
        return v;
    }

    private void ui_declare() {
        user_password = v.findViewById(R.id.reset_auth_et_password);
        user_password_confirem = v.findViewById(R.id.reset_auth_et_re_password);
        btn_reset = v.findViewById(R.id.reset_auth_btn_submit);
        alert_box = v.findViewById(R.id.reset_auth_alert_box);
    }

}
