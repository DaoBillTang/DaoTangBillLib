package com.dtb.lib.base

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.os.Bundle

/**
 * project com.hyhs.hschefu.business.base
 * Created by Bill on 2017/7/17.
 * emal: tangbakzi@daotangbill.uu.me
 * @author: Bill
 * @version: 1.0
 * @description:
 */
@SuppressLint("Registered")
open class BaseApp : Application() {

    var life: LifeListener? = null

    companion object {
        @JvmStatic
        var actList: MutableList<Activity> = mutableListOf()
    }

    override fun onCreate() {
        super.onCreate()
        life = LifeListener()
        registerActivityLifecycleCallbacks(life)
    }

    override fun onTerminate() {
        super.onTerminate()
        unregisterActivityLifecycleCallbacks(life)
    }


    fun exit() {
        actList.forEach {
            it.finish()
        }
    }


    class LifeListener : ActivityLifecycleCallbacks {
        override fun onActivityPaused(activity: Activity?) {
        }

        override fun onActivityResumed(activity: Activity?) {
        }

        override fun onActivityStarted(activity: Activity?) {
        }

        override fun onActivityDestroyed(activity: Activity?) {
            if (activity != null) {
                actList.remove(activity)
            }
        }

        override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
        }

        override fun onActivityStopped(activity: Activity?) {
        }

        override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
            if (activity != null) {
                actList.add(activity)
            }
        }
    }
}