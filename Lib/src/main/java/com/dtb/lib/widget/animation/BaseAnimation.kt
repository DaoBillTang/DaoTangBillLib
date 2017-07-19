package com.dtb.lib.widget.animation
import android.animation.Animator
import android.view.View

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
interface BaseAnimation {

    fun getAnimators(view: View): Array<Animator>

}
