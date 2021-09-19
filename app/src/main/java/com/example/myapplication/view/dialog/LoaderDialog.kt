package com.example.myapplication.view.dialog

import androidx.databinding.ViewDataBinding
import com.example.myapplication.R
import com.example.myapplication.databinding.DialogLoaderBinding
import com.example.myapplication.global.common.DialogUtil
import com.example.myapplication.view.base.BaseDialog

class LoaderDialog : BaseDialog(R.layout.dialog_loader) {
    private lateinit var mBinding: DialogLoaderBinding

    companion object {
        val TAG = LoaderDialog::class.qualifiedName
        fun dialog(isCancelable: Boolean = true): LoaderDialog {
            val dialog= LoaderDialog()
            dialog.isCancelable =  isCancelable
            return dialog
        }
    }

    override fun onBindTo(binding: ViewDataBinding) {
        mBinding = binding as DialogLoaderBinding
    }

    override fun onResume() {
        super.onResume()
        dialog?.let { DialogUtil.modifyDialogBounds(mActivity, it) }
    }

}
