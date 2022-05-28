// Generated by view binder compiler. Do not edit!
package com.example.hbyssystemmanagement.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.hbyssystemmanagement.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityFavouriteBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ListView recyclerFav;

  @NonNull
  public final ConstraintLayout rootLayout;

  private ActivityFavouriteBinding(@NonNull ConstraintLayout rootView,
      @NonNull ListView recyclerFav, @NonNull ConstraintLayout rootLayout) {
    this.rootView = rootView;
    this.recyclerFav = recyclerFav;
    this.rootLayout = rootLayout;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityFavouriteBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityFavouriteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_favourite, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityFavouriteBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.recycler_fav;
      ListView recyclerFav = ViewBindings.findChildViewById(rootView, id);
      if (recyclerFav == null) {
        break missingId;
      }

      ConstraintLayout rootLayout = (ConstraintLayout) rootView;

      return new ActivityFavouriteBinding((ConstraintLayout) rootView, recyclerFav, rootLayout);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}