package com.example.final_project;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import com.example.final_project.databinding.FragmentDoctorPortalHomeBinding;
import com.example.final_project.databinding.FragmentHomeScreenBinding;
import com.example.final_project.databinding.FragmentLoginScreenBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DoctorPortal_Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DoctorPortal_Home extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentDoctorPortalHomeBinding binding;
    private EditText patient_username;
    private String p_user;

    private ImageButton acct;

    public DoctorPortal_Home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DoctorPortal_Home.
     */
    // TODO: Rename and change types and number of parameters
    public static DoctorPortal_Home newInstance(String param1, String param2) {
        DoctorPortal_Home fragment = new DoctorPortal_Home();
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

        binding = FragmentDoctorPortalHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Referencing and Initializing the button
        acct = view.findViewById(R.id.image_account_settings);

        // Setting onClick behavior to the button
        acct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Initializing the popup menu and giving the reference as current context
                PopupMenu popupMenu = new PopupMenu(((MainActivity)getContext()), acct);

                // Inflating popup menu from popup_menu.xml file
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        // Toast message on menu item clicked
//                        Toast.makeText(((MainActivity)getContext()), "You Clicked " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        Log.i("Debug", "INSIDE FUNCTION");

                        if (menuItem.getItemId() == R.id.logout) {
                            NavHostFragment.findNavController(DoctorPortal_Home.this)
                                    .navigate(R.id.action_doctorPortal_Home_to_homeScreen);
                        }

                        return true;
                    }
                });
                // Showing the popup menu
                popupMenu.show();
            }
        });

        binding.docButtonSubmit.setOnClickListener(view1 -> {
            patient_username = view.findViewById(R.id.p_username);
            p_user = patient_username.getText().toString();

            ((MainActivity)getContext()).set_patient_username(p_user);
            NavHostFragment.findNavController(DoctorPortal_Home.this)
                    .navigate(R.id.action_doctorPortal_Home_to_doctorPortal_FormPage12);
        });


    }


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_doctor_portal_home, container, false);
//    }
}