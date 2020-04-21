package com.example.ecareer;

import android.content.Intent;
import android.os.Bundle;

import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Industry extends Fragment {

    private View v;
    private EditText user_email,user_nic,user_contact,user_company,user_password,user_repassword;
    private TextView btn_goback,alert_box;
    private Button btn_submit;

    public Industry() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_industry, container, false);

        //UI Declare
        ui_declare();

        //Go to login screen
        btn_goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),Login.class));
            }
        });

        //Submit Data
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = user_email.getText().toString().trim();
                String nic = user_nic.getText().toString().trim();
                String contact = user_contact.getText().toString().trim();
                String company = user_company.getText().toString().trim();
                String password = user_password.getText().toString().trim();
                String repassword = user_repassword.getText().toString().trim();

                if (ValidationData.industry_validate(email,nic,contact,company,password,repassword))
                {
                    if (ValidationData.check_password_validate(password,repassword))
                    {
                        if (ValidationData.isValidmail(email))
                        {
                            if (ValidationData.iscontact(contact))
                            {
                                if (ValidationData.isValidNic(nic))
                                {
                                    //submit code
                                }else{
                                    alert_box.setText("Your NIC isn't Valid");
                                }
                            }else{
                                alert_box.setText("Your Contact isn't Valid");
                            }
                        }else {
                            alert_box.setText("Your Email isn't Valid");
                        }
                    }else {
                        alert_box.setText("Your Password isn't Same");
                    }
                }else {
                    alert_box.setText("Please Fill All Details");
                }
            }
        });

        // Inflate the layout for this fragment
        return v;
    }

    private void ui_declare() {
        user_email = v.findViewById(R.id.industry_et_email);
        user_nic = v.findViewById(R.id.industry_et_nic);
        user_contact = v.findViewById(R.id.industry_et_phone);
        user_company = v.findViewById(R.id.industry_et_company);
        user_password = v.findViewById(R.id.industry_et_password);
        user_repassword = v.findViewById(R.id.industry_et_re_password);

        btn_goback = v.findViewById(R.id.industry_tv_goback);
        alert_box = v.findViewById(R.id.industry_alert_box);
        btn_submit = v.findViewById(R.id.industry_btn_submit);
    }
}
