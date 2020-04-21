package com.example.ecareer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Dashboard extends Fragment {

    private View v;
    private TextView user_name,user_email,user_contact,user_state;

    public Dashboard() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_dashboard, container, false);

        //UI Declare
        ui_declare();
        // Inflate the layout for this fragment
        return v;
    }

    private void ui_declare() {
        user_name = v.findViewById(R.id.dashboard_tv_user_name);
        user_email = v.findViewById(R.id.dashboard_tv_user_email);
        user_contact = v.findViewById(R.id.dashboard_tv_user_contact);
        user_state = v.findViewById(R.id.dashboard_tv_user_state);
    }
}
