package com.example.final_project;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.final_project.databinding.FragmentDoctorPortalFormPage1Binding;
import com.example.final_project.databinding.FragmentDoctorPortalFormPage2Binding;
import com.example.final_project.models.*;

import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DoctorPortal_FormPage2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DoctorPortal_FormPage2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private FragmentDoctorPortalFormPage2Binding binding;
    private String mParam1;
    private String mParam2;
    private String docNotes;

    public DoctorPortal_FormPage2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DoctorPortal_FormPage2.
     */
    // TODO: Rename and change types and number of parameters
    public static DoctorPortal_FormPage2 newInstance(String param1, String param2) {
        DoctorPortal_FormPage2 fragment = new DoctorPortal_FormPage2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentDoctorPortalFormPage2Binding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String patient_user = ((MainActivity)getContext()).get_patient_username();
        TextView user = view.findViewById(R.id.form_one_patient_username_2);
        user.setText(patient_user);

        binding.buttonFormPageTwo.setOnClickListener(view1 -> {
            EditText doc_notes = view.findViewById(R.id.enter_notes);
            docNotes = doc_notes.getText().toString();

            EditText foods_to_avoid = view.findViewById(R.id.enter_foods_to_avoid);
            String foods_avoid_string = foods_to_avoid.getText().toString();

            List<String> items_to_avoid = Arrays.asList(foods_avoid_string.split(","));

            List<String> diagnosis = ((MainActivity)getContext()).get_diagnosis();
            String doc_user = ((MainActivity)getContext()).get_doc_username();

            Form doc_form = new Form(patient_user, doc_user, diagnosis, items_to_avoid, docNotes);
            DBHandler dbHandler = new DBHandler((MainActivity) getContext());
            dbHandler.addFormInfo(doc_form);

           //possibly change db to have 3 tables one for doc, user, foods to avoid
            // one with user, doc, diagnosis
            // one with user, doc, notes

            NavHostFragment.findNavController(DoctorPortal_FormPage2.this)
                    .navigate(R.id.action_doctorPortal_FormPage2_to_doctorPortal_Home);
        });

        binding.buttonBackDoctorPortalFormpage2.setOnClickListener(view1 -> {
            NavHostFragment.findNavController(DoctorPortal_FormPage2.this)
                    .navigate(R.id.action_doctorPortal_FormPage2_to_doctorPortal_FormPage1);
        });
    }
}