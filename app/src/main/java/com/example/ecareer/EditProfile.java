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
public class EditProfile extends Fragment {
    private View v;
    private MaterialButton edit_profile_update_password,edite_profile_btn_update_details;
    private EditText student_email,student_nic,student_contact,student_univercity,student_id;
    private TextView alert_box;

    public EditProfile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_edit_profile, container, false);

        //UI Declare
        ui_declare();

        //go password edite
        edit_profile_update_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CurrentPassword currentPassword = new CurrentPassword();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in,R.anim.fade_out);
                fragmentTransaction.replace(R.id.container,currentPassword).commit();
            }
        });

        edite_profile_btn_update_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = student_email.getText().toString().trim();
                String nic =student_nic.getText().toString().trim();
                String contact = student_contact.getText().toString().trim();
                String university = student_univercity.getText().toString().trim();
                String id = student_id.getText().toString().trim();

                if (ValidationData.student_update_validate(email,nic,contact,university,id))
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
                    alert_box.setText("Please Fill All Details");
                }
            }
        });



        return v;
    }

    private void ui_declare()
    {
        edit_profile_update_password = v.findViewById(R.id.edit_profile_btn_update_password);
        edite_profile_btn_update_details = v.findViewById(R.id.edit_profile_btn_update);

        student_email = v.findViewById(R.id.edit_profile_et_email);
        student_nic = v.findViewById(R.id.edit_profile_et_nic);
        student_contact = v.findViewById(R.id.edit_profile_et_contact);
        student_univercity = v.findViewById(R.id.edit_profile_et_university);
        student_id = v.findViewById(R.id.edit_profile_et_id);

        alert_box = v.findViewById(R.id.edite_profile_alert_box);

    }
}
