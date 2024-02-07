package com.example.plan_me.ui.setting

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.plan_me.ui.main.MainActivity
import com.example.plan_me.R
import com.example.plan_me.databinding.ActivityConsumerCenterBinding
import com.example.plan_me.ui.timer.TimerFocusActivity

class ConsumerCenterActivity: AppCompatActivity() {
    private lateinit var binding: ActivityConsumerCenterBinding
    private var isFabOpen = false
    private var fab_open: Animation? = null
    private var fab_close: Animation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConsumerCenterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        overridePendingTransition(R.anim.screen_start, R.anim.screen_none)

        fab_open = AnimationUtils.loadAnimation(this, R.anim.fab_open)
        fab_close = AnimationUtils.loadAnimation(this, R.anim.fab_close)
        clickListener()

        binding.consumerCenterBackBtn.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.screen_none, R.anim.screen_exit)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        overridePendingTransition(R.anim.screen_none, R.anim.screen_exit)
    }

    private fun clickListener() {
        binding.settingFabSettingBtn.setOnClickListener {
            Log.d("fab","fab")
            toggleFab()
        }
        binding.settingFabMestoryBtn.setOnClickListener {
        }
        binding.settingFabTimerBtn.setOnClickListener {
            switchActivity(TimerFocusActivity())
        }
        binding.settingFabPlannerBtn.setOnClickListener {
            switchActivity(MainActivity())
        }
    }
    private fun switchActivity(activity: Activity) {
        val intent = Intent(this, activity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.screen_none, R.anim.screen_exit)
    }

    private fun toggleFab() {
        isFabOpen = if (isFabOpen) {
            binding.settingFabMestoryBtn.startAnimation(fab_close)
            binding.settingFabTimerBtn.startAnimation(fab_close)
            binding.settingFabPlannerBtn.startAnimation(fab_close)
            false
        } else {
            binding.settingFabMestoryBtn.startAnimation(fab_open)
            binding.settingFabTimerBtn.startAnimation(fab_open)
            binding.settingFabPlannerBtn.startAnimation(fab_open)

            binding.settingFabMestoryBtn.visibility = View.VISIBLE
            binding.settingFabTimerBtn.visibility = View.VISIBLE
            binding.settingFabPlannerBtn.visibility = View.VISIBLE

            binding.settingFabMestoryBtn.setClickable(true)
            binding.settingFabTimerBtn.setClickable(true)
            binding.settingFabPlannerBtn.setClickable(true)
            true
        }
    }
}