// Generated by view binder compiler. Do not edit!
package com.example.hbyssystemmanagement.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.hbyssystemmanagement.R;
import com.rey.material.widget.ImageView;
import com.rey.material.widget.RelativeLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityViewDirectionsBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button button3;

  @NonNull
  public final Button buttonDirection;

  @NonNull
  public final ImageView photo;

  @NonNull
  public final RatingBar ratingBar2;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final TextView textView5;

  private ActivityViewDirectionsBinding(@NonNull RelativeLayout rootView, @NonNull Button button3,
      @NonNull Button buttonDirection, @NonNull ImageView photo, @NonNull RatingBar ratingBar2,
      @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5) {
    this.rootView = rootView;
    this.button3 = button3;
    this.buttonDirection = buttonDirection;
    this.photo = photo;
    this.ratingBar2 = ratingBar2;
    this.textView3 = textView3;
    this.textView4 = textView4;
    this.textView5 = textView5;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityViewDirectionsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityViewDirectionsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_view_directions, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityViewDirectionsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button3;
      Button button3 = ViewBindings.findChildViewById(rootView, id);
      if (button3 == null) {
        break missingId;
      }

      id = R.id.buttonDirection;
      Button buttonDirection = ViewBindings.findChildViewById(rootView, id);
      if (buttonDirection == null) {
        break missingId;
      }

      id = R.id.photo;
      ImageView photo = ViewBindings.findChildViewById(rootView, id);
      if (photo == null) {
        break missingId;
      }

      id = R.id.ratingBar2;
      RatingBar ratingBar2 = ViewBindings.findChildViewById(rootView, id);
      if (ratingBar2 == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = ViewBindings.findChildViewById(rootView, id);
      if (textView3 == null) {
        break missingId;
      }

      id = R.id.textView4;
      TextView textView4 = ViewBindings.findChildViewById(rootView, id);
      if (textView4 == null) {
        break missingId;
      }

      id = R.id.textView5;
      TextView textView5 = ViewBindings.findChildViewById(rootView, id);
      if (textView5 == null) {
        break missingId;
      }

      return new ActivityViewDirectionsBinding((RelativeLayout) rootView, button3, buttonDirection,
          photo, ratingBar2, textView3, textView4, textView5);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}