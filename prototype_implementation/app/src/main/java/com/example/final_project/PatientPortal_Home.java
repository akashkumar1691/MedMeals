package com.example.final_project;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.final_project.databinding.FragmentPatientPortalHomeBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PatientPortal_Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PatientPortal_Home extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private DBHandler dbHandler;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentPatientPortalHomeBinding binding;

    private TextView meals_text1, meals_text2, meals_text3, no_notes;
    private ImageView meals_image1, meals_image2, meals_image3;

    private ImageButton acct;

    public PatientPortal_Home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PatientPortal_Home.
     */
    // TODO: Rename and change types and number of parameters
    public static PatientPortal_Home newInstance(String param1, String param2) {
        PatientPortal_Home fragment = new PatientPortal_Home();
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
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_patient_portal_home, container, false);
//    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentPatientPortalHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Referencing and Initializing the button
        acct = view.findViewById(R.id.image_account_settings_patportal_home);

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
                            NavHostFragment.findNavController(PatientPortal_Home.this)
                                    .navigate(R.id.action_patientPortal_Home_to_homeScreen);
                        }

                        return true;
                    }
                });
                // Showing the popup menu
                popupMenu.show();
            }
        });

        meals_text1 = view.findViewById(R.id.meals_text1);
        meals_text2 = view.findViewById(R.id.meals_text2);
        meals_text3 = view.findViewById(R.id.meals_text3);

        meals_image1 = view.findViewById(R.id.meals_image_1);
        meals_image2 = view.findViewById(R.id.meals_image_2);
        meals_image3 = view.findViewById(R.id.meals_image_3);
        no_notes = view.findViewById(R.id.no_notes_1);

        dbHandler = new DBHandler((MainActivity)getContext());

        String patient_username = ((MainActivity)getContext()).get_patientportal_username();
        List<String> diagnosis_list = dbHandler.getDiagnosis(patient_username);

        List<TextView> meals_text_ids = new ArrayList<>();
        meals_text_ids.add(meals_text1);
        meals_text_ids.add(meals_text2);
        meals_text_ids.add(meals_text3);

        List<ImageView> meals_image_ids = new ArrayList<>();
        meals_image_ids.add(meals_image1);
        meals_image_ids.add(meals_image2);
        meals_image_ids.add(meals_image3);

        HashMap<Integer, String> stored_meals_names = new HashMap<>();
        stored_meals_names.put(R.drawable.bakedblueberryoatmeal, "Baked Oatmeal");
        stored_meals_names.put(R.drawable.quinoaveggierice, "Quinoa Salad");
        stored_meals_names.put(R.drawable.grilledtofu, "Grilled Tofu");

        stored_meals_names.put(R.drawable.beetsalad, "Roasted Beet Salad");
        stored_meals_names.put(R.drawable.stuffedsweetpotatoes, "Baked Sweet Potatoes");
        stored_meals_names.put(R.drawable.chickpeasalad, "Chickpea Salad");

        stored_meals_names.put(R.drawable.bananablueberrykalesmoothie, "Blueberry Smoothie");
        stored_meals_names.put(R.drawable.veggiefrittata, "Vegetable Frittata");
        stored_meals_names.put(R.drawable.creamyveggiesoup, "Creamy Veggie Soup");

        stored_meals_names.put(R.drawable.lentilsoup, "Green Lentil Soup");
        stored_meals_names.put(R.drawable.oatmealraisincookies, "Oatmeal Raisin Cookies");
        stored_meals_names.put(R.drawable.tomatozoodles, "Zoodles");

        HashMap<String, List<Integer>> stored_meals_map = new HashMap<>();
        stored_meals_map.put("diabetes", Arrays.asList(R.drawable.bakedblueberryoatmeal, R.drawable.quinoaveggierice, R.drawable.grilledtofu));
        stored_meals_map.put("highbloodpressure", Arrays.asList(R.drawable.beetsalad, R.drawable.stuffedsweetpotatoes, R.drawable.chickpeasalad));
        stored_meals_map.put("crohn's", Arrays.asList(R.drawable.bananablueberrykalesmoothie, R.drawable.veggiefrittata, R.drawable.creamyveggiesoup));
        stored_meals_map.put("pregnancy", Arrays.asList(R.drawable.lentilsoup, R.drawable.oatmealraisincookies, R.drawable.tomatozoodles));

        int i;

        if (diagnosis_list.size() >= 1) {
            no_notes.setVisibility(View.GONE);
            String diag_name = diagnosis_list.get(0).toLowerCase().replaceAll("\\s+","");

            List<Integer> diag_meals = stored_meals_map.get(diag_name);

            for (i = 0; i < 3; i++) {
                int image_id = diag_meals.get(i).intValue();

                meals_text_ids.get(i).setText((String) (stored_meals_names.get(image_id)));
                meals_image_ids.get(i).setImageResource(image_id);
            }
        }
        else{
            meals_text1.setVisibility(View.INVISIBLE);
            meals_text2.setVisibility(View.INVISIBLE);
            meals_text3.setVisibility(View.INVISIBLE);
            meals_image1.setVisibility(View.INVISIBLE);
            meals_image2.setVisibility(View.INVISIBLE);
            meals_image3.setVisibility(View.INVISIBLE);
        }

//        for (i=i; i < 4; i++) {
//            meals_text_ids.get(i).setVisibility(View.INVISIBLE);
//            meals_image_ids.get(i).setVisibility(View.INVISIBLE);
//
//        }


        binding.buttonPatientHomeDocNotes.setOnClickListener(view1 -> {
            NavHostFragment.findNavController(PatientPortal_Home.this)
                    .navigate(R.id. action_patientPortal_Home_to_patientPortal_DocNotes);
        });
        binding.buttonPatientHomeFta.setOnClickListener(view1 -> {
            NavHostFragment.findNavController(PatientPortal_Home.this)
                    .navigate(R.id.action_patientPortal_Home_to_patientPortal_FoodsAvoid2);
        });
    }

}