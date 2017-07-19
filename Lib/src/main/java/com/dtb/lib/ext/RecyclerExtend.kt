package com.dtb.lib.ext

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView


/**
 * project com.hyhs.hschefu.staff.base
 * Created by Bill on 2017/6/27.
 * emal: tangbakzi@daotangbill.uu.me
 * @author: Bill
 * @version: 1.0
 * @description:
 */

/**
 *LinearLayoutManager 使用的moveToPosition
 */
fun RecyclerView.moveToPosition(n: Int) {
    //先从RecyclerView的LayoutManager中获取第一项和最后一项的Position
    val mLinearLayoutManager = this.layoutManager
    if (mLinearLayoutManager is LinearLayoutManager) {
        val firstItem = mLinearLayoutManager.findFirstVisibleItemPosition()
        val lastItem = mLinearLayoutManager.findLastVisibleItemPosition()
        //然后区分情况
        if (n <= firstItem) {
            //当要置顶的项在当前显示的第一个项的前面时
            this.scrollToPosition(n)
        } else if (n <= lastItem) {
            //当要置顶的项已经在屏幕上显示时
            val top = this.getChildAt(n - firstItem).top
            this.scrollBy(0, top)
        } else {
            //当要置顶的项在当前显示的最后一项的后面时
            this.scrollToPosition(n)
            //这里这个变量是用在RecyclerView滚动监听里面的
        }
    }
}