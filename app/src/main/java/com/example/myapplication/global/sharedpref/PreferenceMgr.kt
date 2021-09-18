package com.webaddicted.kotlinproject.global.sharedpref

import com.example.myapplication.global.constant.PreferenceConstant
import com.example.myapplication.model.bean.PreferenceBean


/**
 * Author : Deepak Sharma(Webaddicted)
 * Email : techtamper@gmail.com
 * Profile : https://github.com/webaddicted
 */
class PreferenceMgr constructor(var preferenceUtils: PreferenceUtils) {
    /**
     * set user session info
     */
    fun setUserInfo(preferenceBean: PreferenceBean) {
        preferenceUtils.setPreference(PreferenceConstant.PREF_USER_NAME, preferenceBean.name)
        preferenceUtils.setPreference(PreferenceConstant.PREF_USER_AGE, preferenceBean.age)
        preferenceUtils.setPreference(PreferenceConstant.PREF_USER_GENDER, preferenceBean.gender)
        preferenceUtils.setPreference(PreferenceConstant.PREF_USER_WEIGHT, preferenceBean.weight)
        preferenceUtils.setPreference(
            PreferenceConstant.PREF_USER_IS_MARRIED,
            preferenceBean.isMarried
        )
    }

    /**
     * get user session info
     */
    fun getUserInfo(): PreferenceBean {
        val preferenceBean = PreferenceBean()
        preferenceBean.name = preferenceUtils.getPreference(PreferenceConstant.PREF_USER_NAME, "")!!
        preferenceBean.gender =
            preferenceUtils.getPreference(PreferenceConstant.PREF_USER_GENDER, "")!!
        preferenceBean.age = preferenceUtils.getPreference(PreferenceConstant.PREF_USER_AGE, 0)!!
        preferenceBean.weight =
            preferenceUtils.getPreference(PreferenceConstant.PREF_USER_WEIGHT, 0L)!!
        preferenceBean.isMarried =
            preferenceUtils.getPreference(PreferenceConstant.PREF_USER_IS_MARRIED, false)!!
        return preferenceBean
    }


    fun removeKey(removeKey: String) {
        preferenceUtils.removeKey(removeKey)
    }

    fun clearPref() {
        preferenceUtils.clearAllPreferences()
 }
}