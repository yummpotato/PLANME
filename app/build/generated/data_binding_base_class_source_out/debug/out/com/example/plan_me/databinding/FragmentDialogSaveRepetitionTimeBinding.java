// Generated by view binder compiler. Do not edit!
package com.example.plan_me.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.plan_me.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentDialogSaveRepetitionTimeBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final TextView timerDialogCancelRepetitionTimeTv;

  @NonNull
  public final TextView timerDialogRepetitionTimeTv;

  @NonNull
  public final TextView timerDialogSaveRepetitionTimeTv;

  private FragmentDialogSaveRepetitionTimeBinding(@NonNull FrameLayout rootView,
      @NonNull TextView timerDialogCancelRepetitionTimeTv,
      @NonNull TextView timerDialogRepetitionTimeTv,
      @NonNull TextView timerDialogSaveRepetitionTimeTv) {
    this.rootView = rootView;
    this.timerDialogCancelRepetitionTimeTv = timerDialogCancelRepetitionTimeTv;
    this.timerDialogRepetitionTimeTv = timerDialogRepetitionTimeTv;
    this.timerDialogSaveRepetitionTimeTv = timerDialogSaveRepetitionTimeTv;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentDialogSaveRepetitionTimeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentDialogSaveRepetitionTimeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_dialog_save_repetition_time, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentDialogSaveRepetitionTimeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.timer_dialog_cancel_repetition_time_tv;
      TextView timerDialogCancelRepetitionTimeTv = ViewBindings.findChildViewById(rootView, id);
      if (timerDialogCancelRepetitionTimeTv == null) {
        break missingId;
      }

      id = R.id.timer_dialog_repetition_time_tv;
      TextView timerDialogRepetitionTimeTv = ViewBindings.findChildViewById(rootView, id);
      if (timerDialogRepetitionTimeTv == null) {
        break missingId;
      }

      id = R.id.timer_dialog_save_repetition_time_tv;
      TextView timerDialogSaveRepetitionTimeTv = ViewBindings.findChildViewById(rootView, id);
      if (timerDialogSaveRepetitionTimeTv == null) {
        break missingId;
      }

      return new FragmentDialogSaveRepetitionTimeBinding((FrameLayout) rootView,
          timerDialogCancelRepetitionTimeTv, timerDialogRepetitionTimeTv,
          timerDialogSaveRepetitionTimeTv);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}