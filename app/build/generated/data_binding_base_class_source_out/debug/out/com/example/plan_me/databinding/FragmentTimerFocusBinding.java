// Generated by view binder compiler. Do not edit!
package com.example.plan_me.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.plan_me.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentTimerFocusBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView timerFocus;

  @NonNull
  public final CardView timerFocusCategoryCv;

  @NonNull
  public final LinearLayout timerFocusCategoryLl;

  @NonNull
  public final ImageView timerFocusCircleDefault;

  @NonNull
  public final ConstraintLayout timerFocusCl;

  @NonNull
  public final ImageView timerFocusContourIv;

  @NonNull
  public final ImageView timerFocusMenuBtn;

  @NonNull
  public final ImageView timerFocusPauseBtn;

  @NonNull
  public final ImageView timerFocusPlayBtn;

  @NonNull
  public final CardView timerFocusPlayCv;

  @NonNull
  public final TextView timerFocusResetBtn;

  @NonNull
  public final TextView timerFocusSaveBtn;

  @NonNull
  public final ImageView timerFocusSettingBtn;

  @NonNull
  public final TextView timerFocusStudyEmoticon;

  @NonNull
  public final TextView timerFocusTimeTv;

  private FragmentTimerFocusBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView timerFocus, @NonNull CardView timerFocusCategoryCv,
      @NonNull LinearLayout timerFocusCategoryLl, @NonNull ImageView timerFocusCircleDefault,
      @NonNull ConstraintLayout timerFocusCl, @NonNull ImageView timerFocusContourIv,
      @NonNull ImageView timerFocusMenuBtn, @NonNull ImageView timerFocusPauseBtn,
      @NonNull ImageView timerFocusPlayBtn, @NonNull CardView timerFocusPlayCv,
      @NonNull TextView timerFocusResetBtn, @NonNull TextView timerFocusSaveBtn,
      @NonNull ImageView timerFocusSettingBtn, @NonNull TextView timerFocusStudyEmoticon,
      @NonNull TextView timerFocusTimeTv) {
    this.rootView = rootView;
    this.timerFocus = timerFocus;
    this.timerFocusCategoryCv = timerFocusCategoryCv;
    this.timerFocusCategoryLl = timerFocusCategoryLl;
    this.timerFocusCircleDefault = timerFocusCircleDefault;
    this.timerFocusCl = timerFocusCl;
    this.timerFocusContourIv = timerFocusContourIv;
    this.timerFocusMenuBtn = timerFocusMenuBtn;
    this.timerFocusPauseBtn = timerFocusPauseBtn;
    this.timerFocusPlayBtn = timerFocusPlayBtn;
    this.timerFocusPlayCv = timerFocusPlayCv;
    this.timerFocusResetBtn = timerFocusResetBtn;
    this.timerFocusSaveBtn = timerFocusSaveBtn;
    this.timerFocusSettingBtn = timerFocusSettingBtn;
    this.timerFocusStudyEmoticon = timerFocusStudyEmoticon;
    this.timerFocusTimeTv = timerFocusTimeTv;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentTimerFocusBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentTimerFocusBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_timer_focus, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentTimerFocusBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.timer_focus;
      TextView timerFocus = ViewBindings.findChildViewById(rootView, id);
      if (timerFocus == null) {
        break missingId;
      }

      id = R.id.timer_focus_category_cv;
      CardView timerFocusCategoryCv = ViewBindings.findChildViewById(rootView, id);
      if (timerFocusCategoryCv == null) {
        break missingId;
      }

      id = R.id.timer_focus_category_ll;
      LinearLayout timerFocusCategoryLl = ViewBindings.findChildViewById(rootView, id);
      if (timerFocusCategoryLl == null) {
        break missingId;
      }

      id = R.id.timer_focus_circle_default;
      ImageView timerFocusCircleDefault = ViewBindings.findChildViewById(rootView, id);
      if (timerFocusCircleDefault == null) {
        break missingId;
      }

      id = R.id.timer_focus_cl;
      ConstraintLayout timerFocusCl = ViewBindings.findChildViewById(rootView, id);
      if (timerFocusCl == null) {
        break missingId;
      }

      id = R.id.timer_focus_contour_iv;
      ImageView timerFocusContourIv = ViewBindings.findChildViewById(rootView, id);
      if (timerFocusContourIv == null) {
        break missingId;
      }

      id = R.id.timer_focus_menu_btn;
      ImageView timerFocusMenuBtn = ViewBindings.findChildViewById(rootView, id);
      if (timerFocusMenuBtn == null) {
        break missingId;
      }

      id = R.id.timer_focus_pause_btn;
      ImageView timerFocusPauseBtn = ViewBindings.findChildViewById(rootView, id);
      if (timerFocusPauseBtn == null) {
        break missingId;
      }

      id = R.id.timer_focus_play_btn;
      ImageView timerFocusPlayBtn = ViewBindings.findChildViewById(rootView, id);
      if (timerFocusPlayBtn == null) {
        break missingId;
      }

      id = R.id.timer_focus_play_cv;
      CardView timerFocusPlayCv = ViewBindings.findChildViewById(rootView, id);
      if (timerFocusPlayCv == null) {
        break missingId;
      }

      id = R.id.timer_focus_reset_btn;
      TextView timerFocusResetBtn = ViewBindings.findChildViewById(rootView, id);
      if (timerFocusResetBtn == null) {
        break missingId;
      }

      id = R.id.timer_focus_save_btn;
      TextView timerFocusSaveBtn = ViewBindings.findChildViewById(rootView, id);
      if (timerFocusSaveBtn == null) {
        break missingId;
      }

      id = R.id.timer_focus_setting_btn;
      ImageView timerFocusSettingBtn = ViewBindings.findChildViewById(rootView, id);
      if (timerFocusSettingBtn == null) {
        break missingId;
      }

      id = R.id.timer_focus_study_emoticon;
      TextView timerFocusStudyEmoticon = ViewBindings.findChildViewById(rootView, id);
      if (timerFocusStudyEmoticon == null) {
        break missingId;
      }

      id = R.id.timer_focus_time_tv;
      TextView timerFocusTimeTv = ViewBindings.findChildViewById(rootView, id);
      if (timerFocusTimeTv == null) {
        break missingId;
      }

      return new FragmentTimerFocusBinding((ConstraintLayout) rootView, timerFocus,
          timerFocusCategoryCv, timerFocusCategoryLl, timerFocusCircleDefault, timerFocusCl,
          timerFocusContourIv, timerFocusMenuBtn, timerFocusPauseBtn, timerFocusPlayBtn,
          timerFocusPlayCv, timerFocusResetBtn, timerFocusSaveBtn, timerFocusSettingBtn,
          timerFocusStudyEmoticon, timerFocusTimeTv);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
