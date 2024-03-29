package com.example.plan_me.utils.viewModel

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.plan_me.R
import com.example.plan_me.data.remote.dto.category.AllCategoryRes
import com.example.plan_me.data.remote.dto.category.CategoryList
import com.example.plan_me.data.remote.dto.schedule.AllScheduleRes
import com.example.plan_me.data.remote.dto.schedule.ScheduleList
import com.example.plan_me.data.remote.service.category.CategoryService
import com.example.plan_me.data.remote.service.schedule.ScheduleService
import com.example.plan_me.data.remote.view.category.AllCategoryView
import com.example.plan_me.data.remote.view.schedule.AllScheduleView
import java.time.LocalDate

class CalendarViewModel(private val sharedPreferences: SharedPreferences):ViewModel(),
    AllCategoryView,
    AllScheduleView{
    val _categoryList = MutableLiveData<List<CategoryList>>()
    val _scheduleList = MutableLiveData<List<ScheduleList>>()

    val _isUpdated = MutableLiveData<Boolean>()
    val _currentCategory = MutableLiveData<CategoryList>()

    init {
        getCategoryList()
        _currentCategory.value = CategoryList(-1,"Schedule","\uD83D\uDCC6" ,R.color.light_gray, false, "","" )
    }

    fun sendCategory(categoryList: CategoryList) {
        _currentCategory.value = categoryList
    }

    fun getScheduleAll() {
        val access_token = "Bearer " + sharedPreferences.getString("getAccessToken", "")
        val scheduleService = ScheduleService()
        scheduleService.setAllScheduleView(this)
        scheduleService.getScheduleAllFun(access_token)
    }

    fun getCategoryList() {
        val access_token = "Bearer " + sharedPreferences.getString("getAccessToken", "")
        val setCategoryService = CategoryService()
        setCategoryService.setAllCategoryView(this)
        setCategoryService.getCategoryAllFun(access_token!!)
    }

    fun filteringSchedule(selectDate:LocalDate, groupedSchedules:MutableMap<Int, MutableList<ScheduleList>>) : MutableMap<Int, MutableList<ScheduleList>> {
        // categoryId를 기준으로 ScheduleList를 그룹화하여 Schedule_filter 객체로 만듦
        // 날짜까지 확인
        groupedSchedules.clear()
        for (schedule in _scheduleList.value!!) {
            val categoryId = schedule.category_id
            val startDate = LocalDate.parse(schedule.startDate)
            val endDate = LocalDate.parse(schedule.endDate)

            if (selectDate.isEqual(startDate) || selectDate.isEqual(endDate) ||
                (selectDate.isAfter(startDate) && selectDate.isBefore(endDate))) {
                if (!groupedSchedules.containsKey(categoryId)) {
                    if (_categoryList.value!!.find { it.categoryId == categoryId } != null) {
                        groupedSchedules[categoryId] = mutableListOf()
                    }
                }
                groupedSchedules[categoryId]?.add(schedule)
            }
        }
        Log.d("dfasdf", groupedSchedules.toString())
        return groupedSchedules
    }

    fun filteringCategory(groupedSchedules:MutableMap<Int, MutableList<ScheduleList>>): List<CategoryList> {
        val filteringCategory = mutableListOf<CategoryList>()

        for ((categoryId, _) in groupedSchedules) {
            val category = _categoryList.value!!.find { it.categoryId == categoryId }
            category?.let {
                filteringCategory.add(it)
            }
        }
        Log.d("dfasdf", filteringCategory.toString())
        return filteringCategory
    }

    fun filteringCategoryHidden(groupedSchedules:MutableMap<Int, MutableList<ScheduleList>>): List<CategoryList> {
        val filteringCategory = mutableListOf<CategoryList>()

        for ((categoryId, _) in groupedSchedules) {
            val category = _categoryList.value!!.find { it.categoryId == categoryId && !it.meStoryHidden}
            category?.let {
                filteringCategory.add(it)
            }
        }
        Log.d("dfasdf", filteringCategory.toString())
        return filteringCategory
    }

    override fun onAllCategorySuccess(response: AllCategoryRes) {
        _categoryList.value = response.result.categoryList
        getScheduleAll()
    }

    override fun onAllCategoryFailure(response: AllCategoryRes) {
        TODO("Not yet implemented")
    }

    override fun onAllScheduleSuccess(response: AllScheduleRes) {
        _scheduleList.value = response.result.scheduleList
        if (_currentCategory.value!!.categoryId == -1 && !_categoryList.value!!.isNullOrEmpty()) {
            _currentCategory.value = _categoryList.value!![0]
        }
        _isUpdated.value = true
    }

    override fun onAllScheduleFailure(response: AllScheduleRes) {
        TODO("Not yet implemented")
    }

}