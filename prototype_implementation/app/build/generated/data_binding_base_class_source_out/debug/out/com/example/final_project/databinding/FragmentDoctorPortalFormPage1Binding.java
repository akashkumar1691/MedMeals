// Generated by view binder compiler. Do not edit!
package com.example.final_project.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.final_project.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentDoctorPortalFormPage1Binding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button buttonBackDoctorPortalFormpage1;

  @NonNull
  public final Button buttonFormPageOne;

  @NonNull
  public final CheckBox diagnosisCheckAllergies;

  @NonNull
  public final CheckBox diagnosisCheckCrohns;

  @NonNull
  public final CheckBox diagnosisCheckDiabetes;

  @NonNull
  public final CheckBox diagnosisCheckHighBP;

  @NonNull
  public final CheckBox diagnosisCheckOther;

  @NonNull
  public final EditText diagnosisEditOther;

  @NonNull
  public final TextView diagnosisText;

  @NonNull
  public final TextView docPortalHeading;

  @NonNull
  public final TextView formOnePatientUsername;

  @NonNull
  public final ConstraintLayout frameLayout10;

  @NonNull
  public final ImageView imageMedMeals;

  @NonNull
  public final TextView textFormPage1;

  private FragmentDoctorPortalFormPage1Binding(@NonNull ConstraintLayout rootView,
      @NonNull Button buttonBackDoctorPortalFormpage1, @NonNull Button buttonFormPageOne,
      @NonNull CheckBox diagnosisCheckAllergies, @NonNull CheckBox diagnosisCheckCrohns,
      @NonNull CheckBox diagnosisCheckDiabetes, @NonNull CheckBox diagnosisCheckHighBP,
      @NonNull CheckBox diagnosisCheckOther, @NonNull EditText diagnosisEditOther,
      @NonNull TextView diagnosisText, @NonNull TextView docPortalHeading,
      @NonNull TextView formOnePatientUsername, @NonNull ConstraintLayout frameLayout10,
      @NonNull ImageView imageMedMeals, @NonNull TextView textFormPage1) {
    this.rootView = rootView;
    this.buttonBackDoctorPortalFormpage1 = buttonBackDoctorPortalFormpage1;
    this.buttonFormPageOne = buttonFormPageOne;
    this.diagnosisCheckAllergies = diagnosisCheckAllergies;
    this.diagnosisCheckCrohns = diagnosisCheckCrohns;
    this.diagnosisCheckDiabetes = diagnosisCheckDiabetes;
    this.diagnosisCheckHighBP = diagnosisCheckHighBP;
    this.diagnosisCheckOther = diagnosisCheckOther;
    this.diagnosisEditOther = diagnosisEditOther;
    this.diagnosisText = diagnosisText;
    this.docPortalHeading = docPortalHeading;
    this.formOnePatientUsername = formOnePatientUsername;
    this.frameLayout10 = frameLayout10;
    this.imageMedMeals = imageMedMeals;
    this.textFormPage1 = textFormPage1;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentDoctorPortalFormPage1Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentDoctorPortalFormPage1Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_doctor_portal_form_page1, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentDoctorPortalFormPage1Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button_back_doctor_portal_formpage1;
      Button buttonBackDoctorPortalFormpage1 = ViewBindings.findChildViewById(rootView, id);
      if (buttonBackDoctorPortalFormpage1 == null) {
        break missingId;
      }

      id = R.id.button_form_page_one;
      Button buttonFormPageOne = ViewBindings.findChildViewById(rootView, id);
      if (buttonFormPageOne == null) {
        break missingId;
      }

      id = R.id.diagnosis_check_allergies;
      CheckBox diagnosisCheckAllergies = ViewBindings.findChildViewById(rootView, id);
      if (diagnosisCheckAllergies == null) {
        break missingId;
      }

      id = R.id.diagnosis_check_crohns;
      CheckBox diagnosisCheckCrohns = ViewBindings.findChildViewById(rootView, id);
      if (diagnosisCheckCrohns == null) {
        break missingId;
      }

      id = R.id.diagnosis_check_diabetes;
      CheckBox diagnosisCheckDiabetes = ViewBindings.findChildViewById(rootView, id);
      if (diagnosisCheckDiabetes == null) {
        break missingId;
      }

      id = R.id.diagnosis_check_highBP;
      CheckBox diagnosisCheckHighBP = ViewBindings.findChildViewById(rootView, id);
      if (diagnosisCheckHighBP == null) {
        break missingId;
      }

      id = R.id.diagnosis_check_other;
      CheckBox diagnosisCheckOther = ViewBindings.findChildViewById(rootView, id);
      if (diagnosisCheckOther == null) {
        break missingId;
      }

      id = R.id.diagnosis_edit_other;
      EditText diagnosisEditOther = ViewBindings.findChildViewById(rootView, id);
      if (diagnosisEditOther == null) {
        break missingId;
      }

      id = R.id.diagnosis_text;
      TextView diagnosisText = ViewBindings.findChildViewById(rootView, id);
      if (diagnosisText == null) {
        break missingId;
      }

      id = R.id.doc_portal_heading;
      TextView docPortalHeading = ViewBindings.findChildViewById(rootView, id);
      if (docPortalHeading == null) {
        break missingId;
      }

      id = R.id.form_one_patient_username;
      TextView formOnePatientUsername = ViewBindings.findChildViewById(rootView, id);
      if (formOnePatientUsername == null) {
        break missingId;
      }

      id = R.id.frameLayout10;
      ConstraintLayout frameLayout10 = ViewBindings.findChildViewById(rootView, id);
      if (frameLayout10 == null) {
        break missingId;
      }

      id = R.id.image_med_meals;
      ImageView imageMedMeals = ViewBindings.findChildViewById(rootView, id);
      if (imageMedMeals == null) {
        break missingId;
      }

      id = R.id.text_form_page_1;
      TextView textFormPage1 = ViewBindings.findChildViewById(rootView, id);
      if (textFormPage1 == null) {
        break missingId;
      }

      return new FragmentDoctorPortalFormPage1Binding((ConstraintLayout) rootView,
          buttonBackDoctorPortalFormpage1, buttonFormPageOne, diagnosisCheckAllergies,
          diagnosisCheckCrohns, diagnosisCheckDiabetes, diagnosisCheckHighBP, diagnosisCheckOther,
          diagnosisEditOther, diagnosisText, docPortalHeading, formOnePatientUsername,
          frameLayout10, imageMedMeals, textFormPage1);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
