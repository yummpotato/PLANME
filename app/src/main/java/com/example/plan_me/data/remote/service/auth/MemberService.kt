package com.example.plan_me.data.remote.service.auth

import android.util.Log
import com.example.plan_me.data.local.entity.EditProfile
import com.example.plan_me.data.local.entity.Member
import com.example.plan_me.data.remote.dto.auth.AutoLoginRes
import com.example.plan_me.data.remote.dto.auth.ChangeMemberRes
import com.example.plan_me.data.remote.dto.auth.DeleteMemberRes
import com.example.plan_me.data.remote.dto.auth.MemberRes
import com.example.plan_me.data.remote.dto.auth.SignUpRes
import com.example.plan_me.data.remote.retrofit.AuthRetrofitInterface
import com.example.plan_me.data.remote.view.auth.AutoLoginView
import com.example.plan_me.data.remote.view.auth.ChangeProfileView
import com.example.plan_me.data.remote.view.auth.DeleteMemberView
import com.example.plan_me.data.remote.view.auth.LookUpMemberView
import com.example.plan_me.data.remote.view.auth.SignUpView
import com.example.plan_me.utils.getRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MemberService {
    private lateinit var autoLoginView: AutoLoginView
    private lateinit var signUpView: SignUpView
    private lateinit var changeProfileView: ChangeProfileView
    private lateinit var lookUpMemberView: LookUpMemberView
    private lateinit var deleteMemberView: DeleteMemberView

    fun setAutoLoginView(autoLoginView: AutoLoginView) {
        this.autoLoginView = autoLoginView
    }

    fun setSignUpView(signUpView: SignUpView) {
        this.signUpView = signUpView
    }

    fun setChangeProfileView(changeProfileView: ChangeProfileView) {
        this.changeProfileView = changeProfileView
    }

    fun setLookUpMemberView(lookUpMemberView: LookUpMemberView) {
        this.lookUpMemberView = lookUpMemberView
    }

    fun setDeleteMemberView(deleteMemberView: DeleteMemberView) {
        this.deleteMemberView = deleteMemberView
    }

    fun getAutoLogin(accessToken: String) {
        val autoLoginService = getRetrofit().create(AuthRetrofitInterface::class.java)
        autoLoginService.getAutoLogin(accessToken).enqueue(object : Callback<AutoLoginRes> {
            override fun onResponse(call: Call<AutoLoginRes>, response: Response<AutoLoginRes>) {
                if (response.isSuccessful) {
                    val resp: AutoLoginRes? = response.body()
                    if (resp != null) {
                        when (resp.code) {
                            "MEMBER2006" -> autoLoginView.onGetAutoLoginSuccess(resp)
                            else -> autoLoginView.onGetAutoLoginFailure(resp.isSuccess, resp.code, resp.message)
                        }
                    } else {
                        Log.e("AUTO-LOGIN-SUCCESS", "Response body is null")
                    }
                } else {
                    Log.e("AUTO-LOGIN-SUCCESS", "Response not successful: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<AutoLoginRes>, t: Throwable) {
                Log.d("AUTO-LOGIN-FAILURE", t.toString())
            }
        })
    }

    fun setSignUp(accessToken: String, member: Member) {
        val signUpService = getRetrofit().create(AuthRetrofitInterface::class.java)
        signUpService.postSignUp(accessToken, member).enqueue(object : Callback<SignUpRes> {
            override fun onResponse(call: Call<SignUpRes>, response: Response<SignUpRes>) {
                if (response.isSuccessful) {
                    val resp: SignUpRes? = response.body()
                    if (resp != null) {
                        when (resp.code) {
                            "MEMBER2005" -> signUpView.onSetSignUpSuccess(resp)
                            else -> signUpView.onSetSignUpFailure(resp.isSuccess, resp.code, resp.message)
                        }
                    } else {
                        Log.e("SIGNUP-SUCCESS", "Response body is null")
                    }
                } else {
                    Log.e("SIGNUP-SUCCESS", "Response not successful: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<SignUpRes>, t: Throwable) {
                Log.d("SIGNUP-FAILURE", t.toString())
            }
        })
    }

    fun setChangeProfile(accessToken: String, member: EditProfile) {
        val changeProfileService = getRetrofit().create(AuthRetrofitInterface::class.java)
        changeProfileService.patchChangeProfile(accessToken, member).enqueue(object : Callback<ChangeMemberRes> {
            override fun onResponse(call: Call<ChangeMemberRes>, response: Response<ChangeMemberRes>) {
                if (response.isSuccessful) {
                    val resp: ChangeMemberRes = response.body()!!
                    if (resp != null) {
                        when(resp.code) {
                            "MEMBER2003" -> changeProfileView.onSetChangeProfileSuccess(resp)
                            else -> changeProfileView.onSetChangeProfileFailure(resp.isSuccess, resp.code, resp.message)
                        }
                    } else {
                        Log.e("UPDATE-PROFILE-SUCCESS", "Response body is null")
                    }
                } else {
                    Log.e("UPDATE-PROFILE-SUCCESS", "Response not successful: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<ChangeMemberRes>, t: Throwable) {
                Log.d("UPDATE-PROFILE-FAILURE", t.toString())
            }
        })
    }

    fun getLookUpMember(token: String) {
        val lookUpMemberService = getRetrofit().create(AuthRetrofitInterface::class.java)
        lookUpMemberService.getMember(token).enqueue(object : Callback<MemberRes> {
            override fun onResponse(call: Call<MemberRes>, response: Response<MemberRes>) {
                if (response.isSuccessful) {
                    val resp: MemberRes = response.body()!!
                    if (resp != null) {
                        Log.d("LOOK-UP-MEMBER-SUCCESS", resp.result.toString())
                        when(resp.code) {
                            "MEMBER2001" -> lookUpMemberView.onGetMemberSuccess(resp)
                            else -> lookUpMemberView.onGetMemberFailure(resp.isSuccess, resp.code, resp.message)
                        }
                    } else {
                        Log.e("LOOK-UP-MEMBER-SUCCESS", "Response body is null")
                    }
                } else {
                    Log.e("LOOK-UP-MEMBER-SUCCESS", "Response not successful: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<MemberRes>, t: Throwable) {
                Log.d("LOOK-UP-MEMBER-FAILURE", t.toString())
            }
        })
    }

    fun delMember(accessToken: String) {
        val deleteMemberService = getRetrofit().create(AuthRetrofitInterface::class.java)
        deleteMemberService.deleteMember(accessToken).enqueue(object : Callback<DeleteMemberRes> {
            override fun onResponse(call: Call<DeleteMemberRes>, response: Response<DeleteMemberRes>) {
                if (response.isSuccessful) {
                    val resp: DeleteMemberRes = response.body()!!
                    if (resp != null) {
                        when(resp.code) {
                            "MEMBER2004" -> deleteMemberView.onDelMemberSuccess(resp)
                            else -> deleteMemberView.onDelMemberFailure(resp.isSuccess, resp.code, resp.message)
                        }
                    } else {
                        Log.e("DELETE-MEMBER-SUCCESS", "Response body is null")
                    }
                } else {
                    Log.e("DELETE-MEMBER-SUCCESS", "Response not successful: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<DeleteMemberRes>, t: Throwable) {
                Log.d("DELETE-MEMBER-FAILURE", t.toString())
            }
        })
    }
}