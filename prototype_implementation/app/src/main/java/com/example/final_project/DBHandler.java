package com.example.final_project;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.final_project.models.Form;
import com.example.final_project.models.User;
//import com.example.final_project.models.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "med_meals_db";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String table_name_acct_info = "account_info_table";
    private static final String col_username = "username"; // primary key
    private static final String col_password = "password";
    private static final String col_acct_type = "account_type";

    // below variable is for our table name.
    private static final String table_name_patient_recs = "patient_doctor_recs";
    private static final String diagnosis_table = "doc_diagnosis";
    private static final String foods_to_avoid_table = "foods_to_avoid";
    private static final String doc_notes = "doctor_notes";
    private static final String col_id_primary_key = "id";
    private static final String col_patient_username = "patient_username";
    private static final String col_doctor_username = "doctor_username";
    private static final String col_diagnosis = "diagnosis";
    private static final String col_food = "food_to_avoid";
    private static final String col_notes = "notes";

    private static final String table_name_meals = "Meals";
    private static final String col_id_meals = "id";
    private static final String col_meals = "meals";
    private static final String col_diagnosis_meals = "diagnosis";

    private HashMap<String, String> food_image_mapping;


    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        food_image_mapping = new HashMap<>();
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query_account_table = "CREATE TABLE " + table_name_acct_info + " ("
                + col_username + " TEXT PRIMARY KEY,"
                + col_password + " TEXT,"
                + col_acct_type + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query_account_table);


        String query_diagnosis_table = "CREATE TABLE " + diagnosis_table + " ("
                + col_id_primary_key + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + col_patient_username + " TEXT,"
                + col_doctor_username + " TEXT,"
                + col_diagnosis + " TEXT)";
        db.execSQL(query_diagnosis_table);

        String query_fta_table = "CREATE TABLE " + foods_to_avoid_table + " ("
                + col_id_primary_key + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + col_patient_username + " TEXT,"
                + col_doctor_username + " TEXT,"
                + col_food + " TEXT)";
        db.execSQL(query_fta_table);

        String query_notes_table = "CREATE TABLE " + doc_notes + " ("
                + col_id_primary_key + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + col_patient_username + " TEXT,"
                + col_doctor_username + " TEXT,"
                + col_notes + " TEXT)";
        db.execSQL(query_notes_table);

        // at last we are calling a exec sql
        // method to execute above sql query


        String query_meals = "CREATE TABLE " + table_name_meals + " ("
                + col_id_meals + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + col_diagnosis + " TEXT, "
                + col_meals + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query_meals);

    }



    public void addNewUser(String username, String password, String account_type) {
        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(col_username, username);
        values.put(col_password, password);
        values.put(col_acct_type, account_type);

        // after adding all values we are passing
        // content values to our table.
        db.insert(table_name_acct_info, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    public void addPatientRec(String patient_username, String doctor_username, String diagnosis, String food_recs, String doc_notes) {
        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();


        // on below line we are passing all values
        // along with its key and value pair.
        values.put(col_patient_username, patient_username);
        values.put(col_doctor_username, doctor_username);
        values.put(col_diagnosis, diagnosis);
        values.put(col_food, food_recs);
        values.put(col_notes, doc_notes);

        // after adding all values we are passing
        // content values to our table.
        db.insert(table_name_patient_recs, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    public void addFormInfo(Form doc_form) {
        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.

        for(String diag: doc_form.get_diagnosis()){
            ContentValues values = new ContentValues();

            // on below line we are passing all values
            // along with its key and value pair.
            values.put(col_patient_username, doc_form.get_patient_username());
            values.put(col_doctor_username, doc_form.get_doc_username());
            values.put(col_diagnosis, diag);
            db.insert(diagnosis_table, null, values);
        }

        for(String food: doc_form.get_foods_to_avoid()){

            ContentValues values = new ContentValues();

            values.put(col_patient_username, doc_form.get_patient_username());
            values.put(col_doctor_username, doc_form.get_doc_username());
            values.put(col_food, food);
            db.insert(foods_to_avoid_table, null, values);

        }

        ContentValues values = new ContentValues();

        values.put(col_patient_username, doc_form.get_patient_username());
        values.put(col_doctor_username, doc_form.get_doc_username());
        values.put(col_notes, doc_form.get_doc_notes());
        db.insert(doc_notes, null, values);


        // at last we are closing our
        // database after adding database.
        db.close();
    }

    public User getUser(String username) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM " + table_name_acct_info + " WHERE " + col_username + " LIKE \"" + username + "\"", null);

        // user exists
        if (c.moveToFirst()) {
            @SuppressLint("Range") String password = c.getString(c.getColumnIndex(col_password));
            @SuppressLint("Range") String acct_type = c.getString(c.getColumnIndex(col_acct_type));

            User u = new User(username, password, acct_type);
        return u;
    }
        // no matching user found
        return null;
//        Log.i("Cursor Object", DatabaseUtils.dumpCursorToString(c));
    }

    public List<String> getFoodstoAvoid_list(String pat_username) {
        SQLiteDatabase db = this.getReadableDatabase();

        // all rows matching patient
        Cursor c = db.rawQuery("SELECT * FROM " + foods_to_avoid_table + " WHERE " + col_patient_username + " LIKE \"" + pat_username + "\"", null);

        Set<String> foods_to_avoid_list = new HashSet<>();
        while (c.moveToNext()) {
            @SuppressLint("Range") String food_to_avoid = c.getString(c.getColumnIndex(col_food));
            foods_to_avoid_list.add(food_to_avoid);
        }

        List<String> fta_list = new ArrayList<>(foods_to_avoid_list);
        return fta_list;
    }

    public List<String> getDiagnosis(String pat_username) {
        SQLiteDatabase db = this.getReadableDatabase();

        // all rows matching patient
        Cursor c = db.rawQuery("SELECT * FROM " + diagnosis_table + " WHERE " + col_patient_username + " LIKE \"" + pat_username + "\"", null);

        Set<String> diagnosis_set = new HashSet<>();
        while (c.moveToNext()) {
            @SuppressLint("Range") String diagnosis = c.getString(c.getColumnIndex(col_diagnosis));
            diagnosis_set.add(diagnosis);
        }

        List<String> diagnosis_list = new ArrayList<>(diagnosis_set);
        return diagnosis_list;
    }

    public HashMap<String, List<String>> getDocNotes(String pat_username) {
        SQLiteDatabase db = this.getReadableDatabase();

        // all rows matching patient
        Cursor c = db.rawQuery("SELECT * FROM " + diagnosis_table + " WHERE " + col_patient_username + " LIKE \"" + pat_username + "\"", null);

        HashMap<String, List<String>> doc_notes = new HashMap<>();


        while (c.moveToNext()) {

            @SuppressLint("Range") String doc_username = c.getString(c.getColumnIndex(col_doctor_username));
            @SuppressLint("Range") String doc_diagnosis = c.getString(c.getColumnIndex(col_diagnosis));

            if (doc_notes.containsKey(doc_username)) {
                doc_notes.get(doc_username).add(doc_diagnosis);
            }
            else {
                List<String> doc_list_diagnosis = new ArrayList<>();
                doc_list_diagnosis.add(doc_diagnosis);
                doc_notes.put(doc_username, doc_list_diagnosis);
            }
        }
        Cursor c2 = db.rawQuery("SELECT * FROM " + "doctor_notes" + " WHERE " + col_patient_username + " LIKE \"" + pat_username + "\"", null);
        while (c2.moveToNext()) {
            @SuppressLint("Range") String doc_username = c2.getString(c2.getColumnIndex(col_doctor_username));
            @SuppressLint("Range") String doc_notes_column = c2.getString(c2.getColumnIndex(col_notes));
            if (doc_notes.containsKey(doc_username)) {
                doc_notes.get(doc_username).add(doc_notes_column);
            }
        }
        return doc_notes;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + table_name_acct_info);
        db.execSQL("DROP TABLE IF EXISTS " + table_name_patient_recs);
        onCreate(db);
    }
}
