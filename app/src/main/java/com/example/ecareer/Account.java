package com.example.ecareer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Account extends Fragment {
    private MaterialCardView account_btn_edit_profile;
    private View v;

    private MaterialCardView btn_logout;
    private TextView student_email,student_nic,student_contact,student_university,student_id;


    public Account() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_account, container, false);

        //UI Declare
        ui_declare();


        //go to edit Profile
        account_btn_edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditProfile editProfile = new EditProfile();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in,R.anim.fade_out);
                fragmentTransaction.replace(R.id.container,editProfile).commit();
            }
        });

        //logout
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Logout
            }
        });

        return v;
    }

    private void ui_declare()
    {
        account_btn_edit_profile = v.findViewById(R.id.account_btn_edit_profile);

        btn_logout = v.findViewById(R.id.account_btn_Logout);
        student_email = v.findViewById(R.id.account_tv_email);
        student_nic = v.findViewById(R.id.account_tv_nic);
        student_contact = v.findViewById(R.id.account_tv_contact);
        student_university = v.findViewById(R.id.account_tv_university);
        student_id = v.findViewById(R.id.account_tv_student_id);
    }
}
