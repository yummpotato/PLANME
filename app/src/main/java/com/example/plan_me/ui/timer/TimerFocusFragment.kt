package com.example.plan_me.ui.timer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.plan_me.databinding.FragmentTimerFocusSettingBinding

class TimerFocusFragment : Fragment(){
    private lateinit var binding: FragmentTimerFocusSettingBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentTimerFocusSettingBinding.inflate(layoutInflater)
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}