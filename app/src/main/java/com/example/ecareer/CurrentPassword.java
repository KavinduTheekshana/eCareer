package com.example.ecareer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class CurrentPassword extends Fragment {
    private MaterialButton current_password_btn_submit;
    private EditText current_password;
    private TextView alert_box;

    public CurrentPassword() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_current_password, container, false);

        //UI Declare
        current_password_btn_submit = v.findViewById(R.id.current_password_btn_submit);
        current_password = v.findViewById(R.id.current_et_password);
        alert_box = v.findViewById(R.id.current_alert_box);

        current_password_btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String password = current_password.getText().toString().trim();

                if (!password.isEmpty())
                {
                    ResetPasswordAuth resetPasswordAuth = new ResetPasswordAuth();
                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in,R.anim.fade_out);
                    fragmentTransaction.replace(R.id.container,resetPasswordAuth).commit();
                }else {
                    alert_box.setText("Please Fill All Details");
                }
            }
        });
        return v;
    }
}
