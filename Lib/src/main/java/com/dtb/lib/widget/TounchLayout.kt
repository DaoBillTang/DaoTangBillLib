package com.dtb.lib.widget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.LinearLayout

/**
 * Project hschefu-android
 * Created by BILL on 2017/5/24.
 * email:tangbaozi@daotangbill.uu.me

 * @author BILL
 * *
 * @version 1.0
 */

class TounchLayout : LinearLayout {

    private var canTouch = true

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        if (canTouch) {
            return super.onInterceptTouchEvent(ev)
        } else {
            return true
        }
    }


    fun changeTouch(boolean: Boolean) {
        this.canTouch = boolean
    }


}
