package com.example.final_project;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.final_project.databinding.FragmentDoctorPortalFormPage1Binding;
import com.example.final_project.databinding.FragmentPatientPortalDocNotesBinding;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PatientPortal_DocNotes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PatientPortal_DocNotes extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private DBHandler dbHandler;

    private TextView doc1_username, doc1_diagnosis, doc1_notes, doc2_username, doc2_diagnosis, doc2_notes, no_notes;
    private ConstraintLayout doc2_frame, doc1_frame;

    private FragmentPatientPortalDocNotesBinding binding;

    private ImageButton acct;

    public PatientPortal_DocNotes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PatientPortal_DocNotes.
     */
    // TODO: Rename and change types and number of parameters
    public static PatientPortal_DocNotes newInstance(String param1, String param2) {
        PatientPortal_DocNotes fragment = new PatientPortal_DocNotes();
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

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//
//
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_patient_portal_doc_notes, container, false);
//    }
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentPatientPortalDocNotesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Referencing and Initializing the button
        acct = view.findViewById(R.id.image_account_settings_patportal_doc_notes);

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
                            NavHostFragment.findNavController(PatientPortal_DocNotes.this)
                                    .navigate(R.id.action_patientPortal_DocNotes_to_homeScreen);
                        }

                        return true;
                    }
                });
                // Showing the popup menu
                popupMenu.show();
            }
        });

        String patient_username = ((MainActivity)getContext()).get_patientportal_username();

        dbHandler = new DBHandler((MainActivity)getContext());

        HashMap<String, List<String>> doc_notes_map = dbHandler.getDocNotes(patient_username);

        // get all elements
        doc1_username = view.findViewById(R.id.docName1);
        doc1_diagnosis = view.findViewById(R.id.textView5);
        doc1_notes = view.findViewById(R.id.textView7);

        doc2_username = view.findViewById(R.id.textView9);
        doc2_diagnosis = view.findViewById(R.id.textView10);
        doc2_notes = view.findViewById(R.id.textView12);

        Object[] doc_notes_map_keys = doc_notes_map.keySet().toArray();

//        for (int i = 0; i < doc_notes_map.size(); i++) {
        // fill doc1 content if it exists
        if(doc_notes_map_keys.length!=0) {
            no_notes = (TextView) view.findViewById(R.id.no_notes);
            no_notes.setVisibility(View.GONE);
            List<String> doc_values = doc_notes_map.get(doc_notes_map_keys[0]);
            doc1_username.setText((String) (doc_notes_map_keys[0]));
            doc1_diagnosis.setText(doc_values.subList(0, doc_values.size()-1).toString().replaceAll("(^\\[|\\]$)", ""));
            doc1_notes.setText(doc_values.get(doc_values.size() - 1).toString());
        }
        else {
            doc1_frame = (ConstraintLayout) view.findViewById(R.id.frameLayout6);
            doc1_frame.setVisibility(View.INVISIBLE);
        }

        if (doc_notes_map_keys.length > 1) {
            List<String> doc2_values = doc_notes_map.get(doc_notes_map_keys[1]);
            doc2_username.setText(doc_notes_map_keys[1].toString());
            doc2_diagnosis.setText(doc2_values.subList(0, doc2_values.size()-1).toString().replaceAll("(^\\[|\\]$)", ""));
            doc2_notes.setText(doc2_values.get(doc2_values.size()-1).toString());
        }
        // set doc2 content to be invisible
        else {
            doc2_frame = (ConstraintLayout) view.findViewById(R.id.frameLayout7);
            doc2_frame.setVisibility(View.INVISIBLE);
        }

//        binding.buttonDoctorType.setOnClickListener(view1 -> {
//            NavHostFragment.findNavController(CreateAccount_SelectType.this)
//                    .navigate(R.id.action_createAccount_SelectType_to_doctorPortal_Home);
//            dbHandler.addNewUser(cresated_username, created_password, "Doctor");
//        });
        binding.buttonPatientDocnotespageFoodsToAvoid.setOnClickListener(view1 -> {
            NavHostFragment.findNavController(PatientPortal_DocNotes.this)
                    .navigate(R.id.action_patientPortal_DocNotes_to_patientPortal_FoodsAvoid3);
        });
        binding.buttonPatientDocnotespageMealRecs.setOnClickListener(view1 -> {
            NavHostFragment.findNavController(PatientPortal_DocNotes.this)
                    .navigate(R.id.action_patientPortal_DocNotes_to_patientPortal_Home);
        });

    }
}