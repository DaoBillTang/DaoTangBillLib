package com.dtb.lib.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.ScrollView

/**
 * 滑动控制顶部搜索栏透明度
 * Created by wangxy on 2017/3/29.
 */
class TranslateScrollview : ScrollView {
    var onScrollistener: ((startY: Int, endY: Int) -> Unit)? = null

    fun setOnScrollListener(onScrollistener: ((startY: Int, endY: Int) -> Unit)) {
        this.onScrollistener = onScrollistener
    }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onScrollChanged(x: Int, y: Int, oldx: Int, oldy: Int) {
        onScrollistener?.invoke(oldy,y)
        super.onScrollChanged(x, y, oldx, oldy)
    }

}
