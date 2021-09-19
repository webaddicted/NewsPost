package com.example.myapplication.view.splash

import AppConstant
import android.app.Activity
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.databinding.ViewDataBinding
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivitySplashBinding
import com.example.myapplication.view.base.BaseActivity
import com.example.myapplication.view.login.LoginActivity

class SplashActivity : BaseActivity(R.layout.activity_splash) {
    private lateinit var animZoom: Animation
    private lateinit var mBinding: ActivitySplashBinding

    companion object {
        val TAG = SplashActivity::class.qualifiedName
        fun newIntent(activity: Activity) {
            activity.startActivity(Intent(activity, SplashActivity::class.java))
        }

        fun newClearLogin(context: Activity?) {
            val intent = Intent(context, SplashActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            context?.startActivity(intent)
            context?.finish()
        }
    }

    override fun onBindTo(binding: ViewDataBinding) {
        mBinding = binding as ActivitySplashBinding
        init()
        clickListener()
    }

    private fun init() {
        animZoom = AnimationUtils.loadAnimation(this, R.anim.zoom)
        mBinding.imgLogo.startAnimation(animZoom)
        navigateToNext()
    }

    private fun clickListener() {
    }

    private fun navigateToNext() {
        Handler(Looper.getMainLooper()).postDelayed({
            LoginActivity.newClearLogin(this)
        }, AppConstant.SPLASH_DELAY)
    }
}