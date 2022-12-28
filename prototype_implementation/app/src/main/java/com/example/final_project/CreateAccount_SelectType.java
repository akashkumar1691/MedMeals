package com.example.final_project;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.final_project.databinding.FragmentCreateAccountSelectTypeBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreateAccount_SelectType#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreateAccount_SelectType extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentCreateAccountSelectTypeBinding binding;

    private DBHandler dbHandler;

    public CreateAccount_SelectType() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CreateAccount_SelectType.
     */
    // TODO: Rename and change types and number of parameters
    public static CreateAccount_SelectType newInstance(String param1, String param2) {
        CreateAccount_SelectType fragment = new CreateAccount_SelectType();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentCreateAccountSelectTypeBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String created_username = ((MainActivity)getContext()).get_create_username();
        String created_password = ((MainActivity)getContext()).get_create_password();

        dbHandler = new DBHandler((MainActivity)getContext());

        binding.buttonDoctorType.setOnClickListener(view1 -> {
            NavHostFragment.findNavController(CreateAccount_SelectType.this)
                    .navigate(R.id.action_createAccount_SelectType_to_doctorPortal_Home);
            ((MainActivity)getContext()).set_doctor_username(created_username);
            dbHandler.addNewUser(created_username, created_password, "Doctor");
        });
        binding.buttonPatientType.setOnClickListener(view1 -> {
            NavHostFragment.findNavController(CreateAccount_SelectType.this)
                    .navigate(R.id.action_createAccount_SelectType_to_patientPortal_Home);
            ((MainActivity)getContext()).set_patientportal_username(created_username);
            dbHandler.addNewUser(created_username, created_password, "Patient");
        });

        binding.buttonBackCreateAccountSelect.setOnClickListener(view1 -> {
            NavHostFragment.findNavController(CreateAccount_SelectType.this)
                    .navigate(R.id.action_createAccount_SelectType_to_createAccount_AccountInfo);
        });
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_create_account_select_type, container, false);
//    }
}