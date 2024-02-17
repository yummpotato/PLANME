package com.example.plan_me.utils.viewModel

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.plan_me.data.remote.dto.timer.TimerSettingRes
import com.example.plan_me.data.remote.service.timer.TimerService
import com.example.plan_me.data.remote.view.timer.GetTimerView

class TimerViewModel(private val sharedPreferences: SharedPreferences): ViewModel(), GetTimerView {
    val focusML = MutableLiveData<String>().apply {
        Log.d("init focus mutable livedata", "focus 라이브 데이터 초기화")
        setValue("10:00:00")
    }

    val breakML = MutableLiveData<String>().apply {
        Log.d("init break mutable livedata", "break 라이브 데이터 초기화")
        setValue("10:00:00")
    }

    val repeatCntML = MutableLiveData<Int>().apply {
        Log.d("init repeatCnt mutable livedata", "repeatCnt 라이브 데이터 초기화")
        setValue(0)
    }

    fun getFocus(): LiveData<String> = focusML
    fun getBreak(): LiveData<String> = breakML
    fun getRepeat(): LiveData<Int> = repeatCntML

    fun getTimer() {
        val access_token = "Bearer " + sharedPreferences.getString("getAccessToken", "")
        val categoryId = sharedPreferences.getInt("category", 0)

        val timerService = TimerService()
        timerService.getTimerView(this@TimerViewModel)
        timerService.getTimer(access_token, categoryId)
    }

    override fun onGetTimerSuccess(response: TimerSettingRes) {
        Log.d("TIMER VIEW 설정", response.result.toString())
        getTimer()
    }

    override fun onGetTimerFailure(isSuccess: Boolean, code: String, message: String) {
        Log.d("TIMER VIEW 설정 실패", message)
    }
}