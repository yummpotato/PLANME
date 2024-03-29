package com.example.plan_me.ui.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.plan_me.R
import com.example.plan_me.data.local.entity.Category_input
import com.example.plan_me.data.remote.dto.category.AddCategoryRes
import com.example.plan_me.data.remote.service.category.CategoryService
import com.example.plan_me.data.remote.view.category.AddCategoryView
import com.example.plan_me.databinding.FragmentDialogAddCategoryBinding
import java.lang.Integer.max

class DialogAddFragment(context : Context, private val sendSignalToMain: SendSignalToMain): Dialog(context), AddCategoryView {
    private lateinit var binding : FragmentDialogAddCategoryBinding
    private var ignoreCheckChange = false
    private var isFirst = true
    lateinit var categoryInput : Category_input

    interface SendSignalToMain {
        fun sendSuccessSignal(categoryId : Int)
        fun sendCancel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentDialogAddCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        binding.addCategorySaveBtn.setOnClickListener {//연결 완료
            val emoticon = findEmoticon(findCheckItemId(binding.emoticonGroup1, binding.emoticonGroup2))
            val color = findColor(findCheckItemId(binding.colorGroup1, binding.colorGroup2))
            val name = binding.addCategoryNameEt.text.toString()
            if (emoticon == "") {
                binding.addCategoryErrorTv.text = "이모티콘을 선택해주세요"
                binding.addCategoryErrorTv.visibility = View.VISIBLE
            } else if (name == ""){
                binding.addCategoryErrorTv.text = "이름을 입력해주세요"
                binding.addCategoryErrorTv.visibility = View.VISIBLE
            } else if (color == -1) {
                binding.addCategoryErrorTv.text = "색상을 선택해주세요"
                binding.addCategoryErrorTv.visibility = View.VISIBLE
            } else {
                val access_token = "Bearer " + context.getSharedPreferences(
                    "getRes",
                    AppCompatActivity.MODE_PRIVATE
                ).getString("getAccessToken", "")
                Log.d("access token", access_token)
                val setCategoryService = CategoryService()
                setCategoryService.setAddCategoryView(this)
                categoryInput = Category_input(name, emoticon, color)
                setCategoryService.addCategoryFun(access_token!!, categoryInput)
            }
        }

        addPopup(binding.emoticonGroup1, binding.emoticonGroup2)
        addPopup(binding.colorGroup1, binding.colorGroup2)
    }
    private fun findEmoticon(itemId:Int):String {
        val id = if (isFirst) itemId - binding.emoticonGroup1.getChildAt(0).id
                else itemId - binding.emoticonGroup2.getChildAt(0).id  + 5
        return when (id) {
            0 -> "\uD83D\uDCD5"
            1 -> "\uD83D\uDCD7"
            2 -> "\uD83D\uDCD8"
            3 -> "\uD83D\uDCCA"
            4 -> "\uD83D\uDD0D"
            5 -> "\uD83C\uDFAC"
            6 -> "\uD83C\uDFA8"
            7 -> "\uD83C\uDFB5"
            8 -> "⛳"
            -1 -> "⭐"
            else -> "" //예외처리
        }
    }
    private fun findColor(itemId:Int):Int {
        val id = if (isFirst) itemId - binding.colorGroup1.getChildAt(0).id
        else itemId - binding.colorGroup2.getChildAt(0).id  + 5
        Log.d("item id", itemId.toString())
        return when(id) {
            0-> R.color.sky_blue_main
            1-> R.color.sky_blue
            2->R.color.red_orange
            3->R.color.lemon
            4->R.color.neon_green
            5->R.color.green
            6->R.color.red_pink
            7->R.color.purple_pink
            8->R.color.pink
            -1->R.color.blue_gray
            else ->-1  //예외처리
        }
    }
    private fun findCheckItemId(radioGroup1: RadioGroup, radioGroup2: RadioGroup):Int {
        val checkedRadioButtonId1 = radioGroup1.checkedRadioButtonId
        val checkedRadioButtonId2 = radioGroup2.checkedRadioButtonId
        Log.d("select1",checkedRadioButtonId1.toString() )
        Log.d("select2",checkedRadioButtonId2.toString() )
        isFirst =
            checkedRadioButtonId1 > checkedRadioButtonId2

        Log.d("select",isFirst.toString() )
        return max(checkedRadioButtonId1, checkedRadioButtonId2)
    }
    private fun addPopup(radioGroup1: RadioGroup, radioGroup2: RadioGroup) {

        // 라디오 그룹1 체크 상태 변경 리스너
        radioGroup1!!.setOnCheckedChangeListener { group, checkedId ->
            if (!ignoreCheckChange) {
                ignoreCheckChange = true
                // 라디오 그룹2의 체크 여부 확인
                val isCheckedInGroup2 = radioGroup2!!.checkedRadioButtonId != -1
                if (isCheckedInGroup2) {
                    // 라디오 그룹2에 체크된 버튼이 있는 경우
                    radioGroup2!!.clearCheck()
                }
                ignoreCheckChange = false
            }
        }

        // 라디오 그룹2 체크 상태 변경 리스너
        radioGroup2!!.setOnCheckedChangeListener { group, checkedId ->
            if (!ignoreCheckChange) {
                ignoreCheckChange = true
                // 라디오 그룹1의 체크 여부 확인
                val isCheckedInGroup1 = radioGroup1!!.checkedRadioButtonId != -1
                if (isCheckedInGroup1) {
                    // 라디오 그룹1에 체크된 버튼이 있는 경우
                    radioGroup1!!.clearCheck()
                }
                ignoreCheckChange = false
            }
        }
    }

    override fun onAddCategorySuccess(response: AddCategoryRes) {
        Log.d("response", response.toString())
        sendSignalToMain.sendSuccessSignal(response.result.categoryId)
        dismiss()
    }

    override fun onAddCategoryFailure(response: AddCategoryRes) {
        Log.d("response", response.toString())
        sendSignalToMain.sendCancel()
    }
}