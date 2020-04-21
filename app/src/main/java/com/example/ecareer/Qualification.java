package com.example.ecareer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.TextInputLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class Qualification extends Fragment {
//    private Spinner language;
    private AutoCompleteTextView language;

    private View v;
    private TextView job_category,language_category,ide_category;
    private MaterialCardView btn_job_next,btn_language_next,btn_ide_next;

    public Qualification() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_qualification, container, false);

        //UI Declare
        ui_declare();



        ArrayAdapter<String> languageadapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.language_category));

        languageadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        language.setAdapter(languageadapter);
        return v;
    }

    private void ui_declare() {
        language = v.findViewById(R.id.qulification_subcategory_drop);

    }
}
