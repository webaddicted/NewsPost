package com.example.myapplication.view.activity

import android.app.Activity
import android.content.Intent
import androidx.databinding.ViewDataBinding
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityAirtelBinding
import com.example.myapplication.view.base.BaseActivity
import com.example.myapplication.view.login.LoginActivity

class AirtelActivity : BaseActivity(R.layout.activity_airtel) {
    private lateinit var mBinding: ActivityAirtelBinding

    companion object {
        val TAG = LoginActivity::class.qualifiedName
        fun newIntent(activity: Activity) {
            activity.startActivity(Intent(activity, AirtelActivity::class.java))
        }

        fun newClearLogin(context: Activity?) {
            val intent = Intent(context, AirtelActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            context?.startActivity(intent)
            context?.finish()
        }
    }

    override fun onBindTo(binding: ViewDataBinding) {
        mBinding = binding as ActivityAirtelBinding
    }

}