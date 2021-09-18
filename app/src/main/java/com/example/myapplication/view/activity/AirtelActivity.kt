package com.example.myapplication.view.activity

import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.databinding.ViewDataBinding
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.global.apiutils.ApiResponse
import com.example.myapplication.model.bean.SearchRespo
import com.example.myapplication.viewmodel.SearchViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityAirtelBinding
import com.example.myapplication.model.bean.SearchReq
import com.example.myapplication.view.adapter.SearchAdapter
import com.example.myapplication.view.base.BaseActivity
import com.example.myapplication.view.base.ScrollListener
import com.example.myapplication.view.login.LoginActivity
import com.google.android.material.snackbar.Snackbar
import kotlin.collections.ArrayList

class AirtelActivity : BaseActivity() {
    private lateinit var mBinding: ActivityAirtelBinding

    companion object {
        val TAG: String = LoginActivity::class.java.simpleName
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


    override fun getLayout(): Int {
        return R.layout.activity_airtel
    }

    override fun initUI(binding: ViewDataBinding) {
        mBinding = binding as ActivityAirtelBinding
    }

    private fun init() {
    }
}