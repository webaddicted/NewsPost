package com.example.myapplication.view.base

import FileUtils
import android.Manifest
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.global.apiutils.ApiResponse
import com.example.myapplication.global.common.*
import com.example.myapplication.view.dialog.LoaderDialog
import com.webaddicted.kotlinproject.global.sharedpref.PreferenceMgr
import org.koin.android.ext.android.inject

/**
 * Author : Deepak Sharma(Webaddicted)
 * Email : techtamper@gmail.com
 * Profile : https://github.com/webaddicted
 */
abstract class BaseFragment(private val layoutId: Int) : Fragment(), View.OnClickListener,
        PermissionHelper.Companion.PermissionListener {
    private lateinit var mBinding: ViewDataBinding
    private var loaderDialog: LoaderDialog? = null
    protected val mActivity by lazy { requireActivity() }
    protected val preferenceMgr: PreferenceMgr by inject()
    protected abstract fun onBindTo(binding: ViewDataBinding)

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return mBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        onBindTo(mBinding)
        super.onViewCreated(view, savedInstanceState)
        if (loaderDialog == null) {
            loaderDialog = LoaderDialog.dialog(false)
        }
    }

    protected fun showApiLoader() {
        if (loaderDialog != null) {
            val fragment = parentFragmentManager.findFragmentByTag(LoaderDialog.TAG)
            if (fragment != null) parentFragmentManager.beginTransaction().remove(fragment).commit()
            loaderDialog?.show(parentFragmentManager, LoaderDialog.TAG)
        }
    }

    protected fun hideApiLoader() {
        if (loaderDialog != null && loaderDialog?.isVisible!!) loaderDialog?.dismiss()
    }

    protected fun <T> apiResponseHandler(view: View, response: ApiResponse<T>) {
        when (response.status) {
            ApiResponse.Status.LOADING -> {
                showApiLoader()
            }
            ApiResponse.Status.ERROR -> {
                hideApiLoader()
                if (response.errorMessage != null && response.errorMessage?.length!! > 0)
                    ValidationHelper.showSnackBar(view, response.errorMessage!!)
                else activity?.showToast(getString(R.string.something_went_wrong))
            }
            else -> {
                showApiLoader()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        GlobalUtility.hideKeyboard(mActivity)
    }

    protected fun navigateFragment(
            layoutContainer: Int,
            fragment: Fragment,
            isEnableBackStack: Boolean
    ) {
            (mActivity as BaseActivity).navigateFragment(
                    layoutContainer,
                    fragment,
                    isEnableBackStack
            )
    }

    protected fun navigateAddFragment(
            layoutContainer: Int,
            fragment: Fragment,
            isEnableBackStack: Boolean
    ) {
            (mActivity as BaseActivity).navigateAddFragment(
                    layoutContainer,
                    fragment,
                    isEnableBackStack
            )
    }

    protected fun navigateChildFragment(
            layoutContainer: Int,
            fragment: Fragment,
            isEnableBackStack: Boolean
    ) {
        val fragmentManager = childFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(layoutContainer, fragment)
        if (isEnableBackStack)
            fragmentTransaction.addToBackStack(fragment.javaClass.simpleName)
        fragmentTransaction.commitAllowingStateLoss()
    }

    override fun onClick(v: View) {
        GlobalUtility.hideKeyboard(mActivity)
        GlobalUtility.avoidDoubleClicks(v)
        GlobalUtility.btnClickAnimation(v)
    }

    fun checkStoragePermission() {
        val multiplePermission = ArrayList<String>()
        multiplePermission.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        multiplePermission.add(Manifest.permission.READ_EXTERNAL_STORAGE)
        multiplePermission.add(Manifest.permission.CAMERA)
        if (PermissionHelper.checkMultiplePermission(mActivity, multiplePermission)) {
            FileUtils.createApplicationFolder(mActivity)
            onPermissionGranted(multiplePermission)
        } else
            PermissionHelper.requestMultiplePermission(mActivity, multiplePermission, this)
    }

    override fun onPermissionGranted(mCustomPermission: List<String>) {
        FileUtils.createApplicationFolder(mActivity)
    }


    override fun onPermissionDenied(mCustomPermission: List<String>) {
    }


    fun getPlaceHolder(imageLoaderPos: Int): String {
        val imageLoader = resources.getStringArray(R.array.image_loader)
        return imageLoader[imageLoaderPos]
    }

    protected fun addBlankSpace(bottomSpace: LinearLayout) {
        KeyboardEventListener(mActivity as AppCompatActivity) { isKeyboardOpen: Boolean, softkeybordHeight: Int ->
            if (isKeyboardOpen)
                bottomSpace.layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        softkeybordHeight
                )
            else bottomSpace.layoutParams =
                    LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0)
        }
    }

}
