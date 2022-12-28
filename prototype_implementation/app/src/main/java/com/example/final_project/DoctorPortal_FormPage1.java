package com.example.final_project;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.final_project.databinding.FragmentDoctorPortalFormPage1Binding;
import com.example.final_project.databinding.FragmentDoctorPortalHomeBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DoctorPortal_FormPage1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DoctorPortal_FormPage1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private FragmentDoctorPortalFormPage1Binding binding;

    private String mParam1;
    private String mParam2;

    public DoctorPortal_FormPage1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DoctorPortal_FormPage1.
     */
    // TODO: Rename and change types and number of parameters
    public static DoctorPortal_FormPage1 newInstance(String param1, String param2) {
        DoctorPortal_FormPage1 fragment = new DoctorPortal_FormPage1();
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

        binding = FragmentDoctorPortalFormPage1Binding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String patient_user = ((MainActivity)getContext()).get_patient_username();
        TextView user = view.findViewById(R.id.form_one_patient_username);
        user.setText(patient_user);

//        binding.buttonCreateAccount.setOnClickListener(view1 -> {
//            NavHostFragment.findNavController(DoctorPortal_Home.this)
//                    .navigate(R.id.action_homeScreen_to_createAccount_AccountInfo);
//        });
        binding.buttonFormPageOne.setOnClickListener(view1 -> {

            List<String> diagnosis = new ArrayList<>();

            if(((CheckBox) view.findViewById(R.id.diagnosis_check_allergies)).isChecked()){
                diagnosis.add("Allergies");
            }
            if(((CheckBox) view.findViewById(R.id.diagnosis_check_crohns)).isChecked()){
                diagnosis.add("Crohn's");
            }
            if(((CheckBox) view.findViewById(R.id.diagnosis_check_diabetes)).isChecked()){
                diagnosis.add("Diabetes");
            }
            if(((CheckBox) view.findViewById(R.id.diagnosis_check_highBP)).isChecked()){
                diagnosis.add("High Blood Pressure");
            }
            if(((CheckBox) view.findViewById(R.id.diagnosis_check_other)).isChecked()){
                EditText t = view.findViewById(R.id.diagnosis_edit_other);
                diagnosis.add(t.getText().toString());
            }
            ((MainActivity)getContext()).set_diagnosis(diagnosis);

            NavHostFragment.findNavController(DoctorPortal_FormPage1.this)
                    .navigate(R.id.action_doctorPortal_FormPage1_to_doctorPortal_FormPage2);
        });

        binding.buttonBackDoctorPortalFormpage1.setOnClickListener(view1 -> {
            NavHostFragment.findNavController(DoctorPortal_FormPage1.this)
                    .navigate(R.id.action_doctorPortal_FormPage1_to_doctorPortal_Home);
        });
    }
}