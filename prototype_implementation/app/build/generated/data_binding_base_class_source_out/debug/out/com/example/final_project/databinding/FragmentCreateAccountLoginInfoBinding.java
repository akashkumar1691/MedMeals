// Generated by view binder compiler. Do not edit!
package com.example.final_project.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public final class FragmentCreateAccountLoginInfoBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView accountTypePage1Background;

  @NonNull
  public final Button buttonBackCreateAccountLogin;

  @NonNull
  public final Button buttonCreateAccountSubmit;

  @NonNull
  public final EditText enterCreatePassword;

  @NonNull
  public final EditText enterCreateUsername;

  @NonNull
  public final TextView enterPass1;

  @NonNull
  public final TextView enterUser1;

  @NonNull
  public final ConstraintLayout frameLayout2;

  @NonNull
  public final ImageView imageMedMeals;

  @NonNull
  public final TextView loginMessage;

  private FragmentCreateAccountLoginInfoBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView accountTypePage1Background, @NonNull Button buttonBackCreateAccountLogin,
      @NonNull Button buttonCreateAccountSubmit, @NonNull EditText enterCreatePassword,
      @NonNull EditText enterCreateUsername, @NonNull TextView enterPass1,
      @NonNull TextView enterUser1, @NonNull ConstraintLayout frameLayout2,
      @NonNull ImageView imageMedMeals, @NonNull TextView loginMessage) {
    this.rootView = rootView;
    this.accountTypePage1Background = accountTypePage1Background;
    this.buttonBackCreateAccountLogin = buttonBackCreateAccountLogin;
    this.buttonCreateAccountSubmit = buttonCreateAccountSubmit;
    this.enterCreatePassword = enterCreatePassword;
    this.enterCreateUsername = enterCreateUsername;
    this.enterPass1 = enterPass1;
    this.enterUser1 = enterUser1;
    this.frameLayout2 = frameLayout2;
    this.imageMedMeals = imageMedMeals;
    this.loginMessage = loginMessage;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentCreateAccountLoginInfoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentCreateAccountLoginInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_create_account_login_info, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentCreateAccountLoginInfoBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.account_type_page1_background;
      TextView accountTypePage1Background = ViewBindings.findChildViewById(rootView, id);
      if (accountTypePage1Background == null) {
        break missingId;
      }

      id = R.id.button_back_create_account_login;
      Button buttonBackCreateAccountLogin = ViewBindings.findChildViewById(rootView, id);
      if (buttonBackCreateAccountLogin == null) {
        break missingId;
      }

      id = R.id.button_create_account_submit;
      Button buttonCreateAccountSubmit = ViewBindings.findChildViewById(rootView, id);
      if (buttonCreateAccountSubmit == null) {
        break missingId;
      }

      id = R.id.enter_create_password;
      EditText enterCreatePassword = ViewBindings.findChildViewById(rootView, id);
      if (enterCreatePassword == null) {
        break missingId;
      }

      id = R.id.enter_create_username;
      EditText enterCreateUsername = ViewBindings.findChildViewById(rootView, id);
      if (enterCreateUsername == null) {
        break missingId;
      }

      id = R.id.enter_pass_1;
      TextView enterPass1 = ViewBindings.findChildViewById(rootView, id);
      if (enterPass1 == null) {
        break missingId;
      }

      id = R.id.enter_user_1;
      TextView enterUser1 = ViewBindings.findChildViewById(rootView, id);
      if (enterUser1 == null) {
        break missingId;
      }

      ConstraintLayout frameLayout2 = (ConstraintLayout) rootView;

      id = R.id.image_med_meals;
      ImageView imageMedMeals = ViewBindings.findChildViewById(rootView, id);
      if (imageMedMeals == null) {
        break missingId;
      }

      id = R.id.login_message;
      TextView loginMessage = ViewBindings.findChildViewById(rootView, id);
      if (loginMessage == null) {
        break missingId;
      }

      return new FragmentCreateAccountLoginInfoBinding((ConstraintLayout) rootView,
          accountTypePage1Background, buttonBackCreateAccountLogin, buttonCreateAccountSubmit,
          enterCreatePassword, enterCreateUsername, enterPass1, enterUser1, frameLayout2,
          imageMedMeals, loginMessage);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}