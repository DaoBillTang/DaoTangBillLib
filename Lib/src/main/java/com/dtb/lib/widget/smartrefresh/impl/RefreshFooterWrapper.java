package com.dtb.lib.widget.smartrefresh.impl;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.dtb.lib.widget.smartrefresh.api.RefreshFooter;
import com.dtb.lib.widget.smartrefresh.api.RefreshKernel;
import com.dtb.lib.widget.smartrefresh.api.RefreshLayout;
import com.dtb.lib.widget.smartrefresh.constant.RefreshState;
import com.dtb.lib.widget.smartrefresh.constant.SpinnerStyle;


/**
 * 刷新底部包装
 * Created by SCWANG on 2017/5/26.
 */

public class RefreshFooterWrapper implements RefreshFooter {
    private View mWrapperView;
    private SpinnerStyle mSpinnerStyle;

    public RefreshFooterWrapper(View wrapper) {
        this.mWrapperView = wrapper;
    }

    @NonNull
    public View getView() {
        return mWrapperView;
    }

    @Override
    public int onFinish(RefreshLayout layout, boolean success) {
		return 0;
	}

    @Override
    public void setPrimaryColors(int... colors) {

    }

    @Override
    public SpinnerStyle getSpinnerStyle() {
        if (mSpinnerStyle != null) {
            return mSpinnerStyle;
        }
        ViewGroup.LayoutParams params = mWrapperView.getLayoutParams();
        if (params != null) {
            if (params.height == 0) {
                return mSpinnerStyle = SpinnerStyle.Scale;
            }
        }
        return mSpinnerStyle = SpinnerStyle.Translate;
    }

    @Override
    public void onInitialized(RefreshKernel layout, int height, int extendHeight) {

    }

    @Override
    public void onPullingUp(float percent, int offset, int footerHeight, int extendHeight) {

    }

    @Override
    public void onPullReleasing(float percent, int offset, int footerHeight, int extendHeight) {

    }

    @Override
    public void onStartAnimator(RefreshLayout layout, int footerHeight, int extendHeight) {

    }

    @Override
    public void onStateChanged(RefreshLayout refreshLayout, RefreshState oldState, RefreshState newState) {

    }

    @Override
    public boolean setLoadmoreFinished(boolean finished) {
        return false;
    }
}
