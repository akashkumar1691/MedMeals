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
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.final_project.databinding.FragmentPatientPortalDocNotesBinding;
import com.example.final_project.databinding.FragmentPatientPortalFoodsAvoidBinding;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PatientPortal_FoodsAvoid#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PatientPortal_FoodsAvoid extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private DBHandler dbHandler;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ListView listview1;
    private ArrayList<String> foods_to_avoid_texts = new ArrayList<>();
    private ArrayList<String> foods_to_avoid_images = new ArrayList<>();

    private FragmentPatientPortalFoodsAvoidBinding binding;

    private TextView fta_text1, fta_text2, fta_text3, fta_text4, no_fta;
    private ImageView fta_image1, fta_image2, fta_image3, fta_image4;

    ListView l;
    String[] tutorials
            = { "Algorithms", "Data Structures",
            "Languages", "Interview Corner",
            "GATE", "ISRO CS",
            "UGC NET CS", "CS Subjects",
            "Web Technologies" };

    private ImageButton acct;

    public PatientPortal_FoodsAvoid() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PatientPortal_FoodsAvoid.
     */
    // TODO: Rename and change types and number of parameters
    public static PatientPortal_FoodsAvoid newInstance(String param1, String param2) {
        PatientPortal_FoodsAvoid fragment = new PatientPortal_FoodsAvoid();
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
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_patient_portal_foods_avoid, container, false);
//    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentPatientPortalFoodsAvoidBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Referencing and Initializing the button
        acct = view.findViewById(R.id.image_account_settings_patportal_fta);

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
                            NavHostFragment.findNavController(PatientPortal_FoodsAvoid.this)
                                    .navigate(R.id.action_patientPortal_FoodsAvoid_to_homeScreen);
                        }

                        return true;
                    }
                });
                // Showing the popup menu
                popupMenu.show();
            }
        });

        fta_text1 = view.findViewById(R.id.fta_text_1);
        fta_text2 = view.findViewById(R.id.fta_text_2);
        fta_text3 = view.findViewById(R.id.fta_text_3);
        fta_text4 = view.findViewById(R.id.fta_text_4);

        fta_image1 = view.findViewById(R.id.fta_image_1);
        fta_image2 = view.findViewById(R.id.fta_image2);
        fta_image3 = view.findViewById(R.id.fta_image3);
        fta_image4 = view.findViewById(R.id.fta_image_4);
        no_fta = view.findViewById(R.id.no_fta);

        dbHandler = new DBHandler((MainActivity)getContext());

        String patient_username = ((MainActivity)getContext()).get_patientportal_username();
        List<String> fta_list = dbHandler.getFoodstoAvoid_list(patient_username);

        List<TextView> fta_text_ids = new ArrayList<>();
        fta_text_ids.add(fta_text1);
        fta_text_ids.add(fta_text2);
        fta_text_ids.add(fta_text3);
        fta_text_ids.add(fta_text4);

        List<ImageView> fta_image_ids = new ArrayList<>();
        fta_image_ids.add(fta_image1);
        fta_image_ids.add(fta_image2);
        fta_image_ids.add(fta_image3);
        fta_image_ids.add(fta_image4);

        HashMap<String, Integer> stored_images = new HashMap<>();
        stored_images.put("corn", R.drawable.corn);
        stored_images.put("dairy", R.drawable.dairy);
        stored_images.put("eggs", R.drawable.eggs);
        stored_images.put("fats", R.drawable.fats);
        stored_images.put("fish", R.drawable.fish);
        stored_images.put("gelatin", R.drawable.gelatin);
        stored_images.put("gluten", R.drawable.gluten);
        stored_images.put("kiwis", R.drawable.kiwis);
        stored_images.put("peanuts", R.drawable.peanuts);
        stored_images.put("sesame", R.drawable.sesame);
        stored_images.put("sodium", R.drawable.sodium);
        stored_images.put("soy", R.drawable.soy);
        stored_images.put("sugar", R.drawable.sugar);
        stored_images.put("treenuts", R.drawable.treenuts);

        int i;

        if (fta_list.size() > 4) {
            fta_list = fta_list.subList(0, 4);
        }
        if(fta_list.size() > 0){
            no_fta.setVisibility(View.GONE);
        }

        for (i = 0; i < fta_list.size(); i++) {
            String img_name = fta_list.get(i).toLowerCase().replaceAll("\\s+","");

            if (stored_images.containsKey(img_name)) {
                fta_text_ids.get(i).setText((String) (fta_list.get(i)));

                fta_image_ids.get(i).setImageResource(stored_images.get(img_name));
            }
        }

        for (i=i; i < 4; i++) {
            fta_text_ids.get(i).setVisibility(View.INVISIBLE);
            fta_image_ids.get(i).setVisibility(View.INVISIBLE);

        }

        binding.buttonPatientFtapageDocNotes.setOnClickListener(view1 -> {
            NavHostFragment.findNavController(PatientPortal_FoodsAvoid.this)
                    .navigate(R.id.action_patientPortal_FoodsAvoid_to_patientPortal_DocNotes);
        });
        binding.buttonPatientFtapageMealRecs.setOnClickListener(view1 -> {
            NavHostFragment.findNavController(PatientPortal_FoodsAvoid.this)
                    .navigate(R.id.action_patientPortal_FoodsAvoid_to_patientPortal_Home);
        });
    }
}
