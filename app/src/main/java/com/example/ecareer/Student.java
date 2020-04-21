package com.example.ecareer;

import android.content.Intent;
import android.os.Bundle;

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
public class Student extends Fragment {

    private View v;
    private EditText student_email,student_nic,student_contact,student_univercity,student_id,student_password,student_repassword;
    private TextView btn_goback,alert_box;
    private Button btn_submit;

    public Student() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_student, container, false);

        //UI Declare
        ui_declare();

        //Go to login screen
        btn_goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),Login.class));
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = student_email.getText().toString().trim();
                String nic =student_nic.getText().toString().trim();
                String contact = student_contact.getText().toString().trim();
                String university = student_univercity.getText().toString().trim();
                String id = student_id.getText().toString().trim();
                String password = student_password.getText().toString().trim();
                String repassword = student_repassword.getText().toString().trim();

                if (ValidationData.student_validate(email,nic,contact,university,id,password,repassword))
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
        student_email = v.findViewById(R.id.student_et_email);
        student_nic = v.findViewById(R.id.student_et_nic);
        student_contact = v.findViewById(R.id.student_et_contact);
        student_univercity = v.findViewById(R.id.student_et_university);
        student_id = v.findViewById(R.id.student_et_id);
        student_password = v.findViewById(R.id.student_et_password);
        student_repassword = v.findViewById(R.id.student_et_password_re);

        btn_goback = v.findViewById(R.id.student_tv_goback);
        alert_box = v.findViewById(R.id.student_alert_box);
        btn_submit = v.findViewById(R.id.student_btn_submit);
    }
}
