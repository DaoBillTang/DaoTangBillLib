package com.dtb.lib.ext

import android.app.Activity
import android.content.Context
import android.support.annotation.UiThread
import android.support.v4.app.Fragment
import android.view.Gravity
import android.widget.Toast

/**
 * project com.hyhs.hschefu.business.base
 * Created by Bill on 2017/7/18.
 * emal: tangbakzi@daotangbill.uu.me
 * @author: Bill
 * @version: 1.0
 * @description:Toast的工具 的整理修改，改善了连续多次弹出相同内容的情况
 */
var lastMsg: String? = null

@UiThread
fun Context.TToast(message: String, gravity: Int = Gravity.CENTER) {
    if (message != lastMsg) {
        lastMsg = message
        val mToast = Toast(this)
        mToast.setText(message + "")
        mToast.duration = Toast.LENGTH_SHORT
        mToast.setGravity(gravity, 0, 0)
        mToast.show()
    }
}

@UiThread
fun Activity.TToast(message: String, gravity: Int = Gravity.CENTER) {
    if (message != lastMsg) {
        lastMsg = message
        val mToast = Toast(this)
        mToast.setText(message + "")
        mToast.duration = Toast.LENGTH_SHORT
        mToast.setGravity(gravity, 0, 0)
        mToast.show()
    }
}

@UiThread
fun Fragment.TToast(message: String, gravity: Int = Gravity.CENTER) {
    if (message != lastMsg) {
        lastMsg = message
        val mToast = Toast(this.activity)
        mToast.setText(message + "")
        mToast.duration = Toast.LENGTH_SHORT
        mToast.setGravity(gravity, 0, 0)
        mToast.show()
    }
}

@UiThread
fun Context.TToast(str: Int, gravity: Int = Gravity.CENTER) {
    val mToast = Toast(this)
    mToast.setText(str)
    mToast.duration = Toast.LENGTH_SHORT
    mToast.setGravity(gravity, 0, 0)
    mToast.show()
}

@UiThread
fun Activity.TToast(str: Int, gravity: Int = Gravity.CENTER) {
    val mToast = Toast(this)
    mToast.setText(str)
    mToast.duration = Toast.LENGTH_SHORT
    mToast.setGravity(gravity, 0, 0)
    mToast.show()
}

@UiThread
fun Fragment.TToast(str: Int, gravity: Int = Gravity.CENTER) {
    val mToast = Toast(this.activity)
    mToast.setText(str)
    mToast.duration = Toast.LENGTH_SHORT
    mToast.setGravity(gravity, 0, 0)
    mToast.show()
}