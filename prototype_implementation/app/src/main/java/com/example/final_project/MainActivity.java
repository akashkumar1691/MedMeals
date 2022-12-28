package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.final_project.databinding.ActivityMainBinding;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

//    private Button create_account_submit_button;
    private String enter_create_username, enter_create_password, patient_username, doctor_username, patientportal_username;
    private List<String> diagnosis;

//    private DBHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.deleteDatabase("med_meals_db");
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        enter_create_password = "";
        enter_create_username = "";
        patient_username = "";
        doctor_username = "";
        patientportal_username = "";
        diagnosis = new ArrayList<>();
        // intialize all variables
//        create_account_submit_button = findViewById(R.id.button_create_account_submit);
//        enter_create_username = findViewById(R.id.enter_create_username);
//        enter_create_password = findViewById(R.id.enter_create_password);

//        dbHandler = new DBHandler(MainActivity.this);

        // below line is to add on click listener for our create account submit button
//        create_account_submit_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                // below line is to get data from all edit text fields.
//                String username = enter_create_username.getText().toString();
//                String password = enter_create_password.getText().toString();
//
//                // validating if the text fields are empty or not.
//                if (username.isEmpty() && password.isEmpty()) {
//                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//                // on below line we are calling a method to add new
//                // course to sqlite data and pass all our values to it.
//                dbHandler.addNewUser(username, password);
//
//                // after adding the data we are displaying a toast message.
//                Toast.makeText(MainActivity.this, "Course has been added.", Toast.LENGTH_SHORT).show();
//                courseNameEdt.setText("");
//                courseDurationEdt.setText("");
//                courseTracksEdt.setText("");
//                courseDescriptionEdt.setText("");
//            }
//        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    // store user's username and password when they create account
    public void set_create_username(String entered_username){
        this.enter_create_username=entered_username;
    }
    public void set_doctor_username(String entered_username){
        this.doctor_username=entered_username;
    }
    public void set_create_password(String entered_password){
        this.enter_create_password=entered_password;
    }
    public void set_diagnosis(List<String> diagnosis){
        this.diagnosis=diagnosis;
    }
    public void set_patient_username(String username){
        this.patient_username=username;
    }

    public void set_patientportal_username(String username){
        this.patientportal_username=username;
    }

    // get user's username and password they entered on first page of creating account
    public String get_create_username() { return this.enter_create_username;}
    public String get_doc_username() { return this.doctor_username;}
    public String get_create_password() { return this.enter_create_password;}
    public String get_patient_username() { return this.patient_username;}
    public String get_patientportal_username() { return this.patientportal_username; }
    public List<String> get_diagnosis() { return this.diagnosis;}
}