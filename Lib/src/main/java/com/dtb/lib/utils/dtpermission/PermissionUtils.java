package com.dtb.lib.utils.dtpermission;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;

/**
 * Project hschefu-android
 * Created by BILL on 2017/4/12.
 * email:tangbaozi@daotangbill.uu.me
 *
 * @author BILL
 * @version 1.0
 */
public class PermissionUtils {

    /**
     * 返回值：
     * 如果app之前请求过该权限,被用户拒绝, 这个方法就会返回true.
     * 如果用户之前拒绝权限的时候勾选了对话框中”Don’t ask again”的选项,那么这个方法会返回false.
     * 如果设备策略禁止应用拥有这条权限, 这个方法也返回false.
     * 弹窗需要解释为何需要该权限，再次请求授权
     *
     * @param context
     * @param permission
     * @return
     */
    public static boolean has(Activity context, String permission) {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
                ContextCompat.checkSelfPermission(context, permission)
                        == PackageManager.PERMISSION_GRANTED;
    }
}