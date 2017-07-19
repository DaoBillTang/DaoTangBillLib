package com.dtb.lib.base

import android.app.ProgressDialog
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import com.daotangbill.lib.R
import com.dtb.lib.utils.statusbar.StatusBarHelper
import org.jetbrains.anko.AnkoLogger


/**
 * Created by Bill on 2016/9/18 11:31.
 * emal:1750352866@qq.com
 */
abstract class BaseActivity : AppCompatActivity(), AnkoLogger {
    private var proDialg: ProgressDialog? = null
    private var dlg: AlertDialog? = null
    protected var mStatusBarHelper: StatusBarHelper? = null
    protected val handler: Handler = Handler()
    var loadingState: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResource())
        onTintStatusBar()
    }


    protected abstract fun getLayoutResource(): Int

    protected fun onTintStatusBar() {
        if (mStatusBarHelper == null) {
            mStatusBarHelper = StatusBarHelper(this, StatusBarHelper.LEVEL_19_TRANSLUCENT,
                    StatusBarHelper.LEVEL_21_VIEW)
        }
        mStatusBarHelper!!.setColor(resources.getColor(R.color.colorPrimaryDark))
    }

    override fun onStart() {
        super.onStart()
//        AppManager.instance.addTopAct(this)
        // setSendLogStrategy已经@deprecated，建议使用新的start接口
// 如果没有页面和自定义事件统计埋点，此代码一定要设置，否则无法完成统计
// 进程第一次执行此代码，会导致发送上次缓存的统计数据；若无上次缓存数据，则发送空启动日志
// 由于多进程等可能造成Application多次执行，建议此代码不要埋点在Application中，否则可能造成启动次数偏高
// 建议此代码埋点在统计路径触发的第一个页面中，若可能存在多个则建议都埋点
//        StatService.start(this)
    }

    /**
     * 显示[.proDialg],附带文字
     */
    fun showProgressDialog(message: String? = "正在处理中请稍后……") {
        if (proDialg == null) {
            proDialg = ProgressDialog(this)
        }
        proDialg!!.setMessage(message)
        proDialg!!.show()
    }

    fun hideLoading() {
        if (dlg != null) {
            dlg?.dismiss()
            dlg?.cancel()
            dlg = null
        }
    }


    /**
     * 隐藏 progress dialog
     */
    fun proDialogDismiss() {
        if (proDialg != null) proDialg!!.dismiss()
        proDialg = null
    }

    override fun onPause() {
        super.onPause()
        //清理痕迹
        proDialg = null
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}

