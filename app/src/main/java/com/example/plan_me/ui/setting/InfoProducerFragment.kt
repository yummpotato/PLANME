package com.example.plan_me.ui.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.plan_me.R
import com.example.plan_me.databinding.ActivityProducerBinding

class InfoProducerFragment: Fragment() {
    private lateinit var binding: ActivityProducerBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = ActivityProducerBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.producerBackBtn.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.fadein, R.anim.fadeout)
                .replace(R.id.main_frm, InfoSettingFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}