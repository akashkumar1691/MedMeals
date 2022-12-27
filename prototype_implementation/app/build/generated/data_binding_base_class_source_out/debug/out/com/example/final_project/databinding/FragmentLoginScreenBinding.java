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

public final class FragmentLoginScreenBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView accountTypePage1Background;

  @NonNull
  public final Button buttonBackLogin;

  @NonNull
  public final Button buttonLoginSubmit;

  @NonNull
  public final TextView enterPass;

  @NonNull
  public final TextView enterUser;

  @NonNull
  public final ImageView imageMedMeals;

  @NonNull
  public final TextView loginMessage;

  @NonNull
  public final EditText loginPassword;

  @NonNull
  public final EditText loginUsername;

  private FragmentLoginScreenBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView accountTypePage1Background, @NonNull Button buttonBackLogin,
      @NonNull Button buttonLoginSubmit, @NonNull TextView enterPass, @NonNull TextView enterUser,
      @NonNull ImageView imageMedMeals, @NonNull TextView loginMessage,
      @NonNull EditText loginPassword, @NonNull EditText loginUsername) {
    this.rootView = rootView;
    this.accountTypePage1Background = accountTypePage1Background;
    this.buttonBackLogin = buttonBackLogin;
    this.buttonLoginSubmit = buttonLoginSubmit;
    this.enterPass = enterPass;
    this.enterUser = enterUser;
    this.imageMedMeals = imageMedMeals;
    this.loginMessage = loginMessage;
    this.loginPassword = loginPassword;
    this.loginUsername = loginUsername;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentLoginScreenBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentLoginScreenBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_login_screen, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentLoginScreenBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.account_type_page1_background;
      TextView accountTypePage1Background = ViewBindings.findChildViewById(rootView, id);
      if (accountTypePage1Background == null) {
        break missingId;
      }

      id = R.id.button_back_login;
      Button buttonBackLogin = ViewBindings.findChildViewById(rootView, id);
      if (buttonBackLogin == null) {
        break missingId;
      }

      id = R.id.button_login_submit;
      Button buttonLoginSubmit = ViewBindings.findChildViewById(rootView, id);
      if (buttonLoginSubmit == null) {
        break missingId;
      }

      id = R.id.enter_pass;
      TextView enterPass = ViewBindings.findChildViewById(rootView, id);
      if (enterPass == null) {
        break missingId;
      }

      id = R.id.enter_user;
      TextView enterUser = ViewBindings.findChildViewById(rootView, id);
      if (enterUser == null) {
        break missingId;
      }

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

      id = R.id.login_password;
      EditText loginPassword = ViewBindings.findChildViewById(rootView, id);
      if (loginPassword == null) {
        break missingId;
      }

      id = R.id.login_username;
      EditText loginUsername = ViewBindings.findChildViewById(rootView, id);
      if (loginUsername == null) {
        break missingId;
      }

      return new FragmentLoginScreenBinding((ConstraintLayout) rootView, accountTypePage1Background,
          buttonBackLogin, buttonLoginSubmit, enterPass, enterUser, imageMedMeals, loginMessage,
          loginPassword, loginUsername);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}