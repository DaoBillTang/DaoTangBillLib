package com.dtb.lib.widget.smartrefresh.impl;

import android.view.MotionEvent;
import android.view.View;

import com.dtb.lib.widget.smartrefresh.api.RefreshScrollBoundary;

import static com.dtb.lib.widget.smartrefresh.util.ScrollBoundaryUtil.canScrollDown;
import static com.dtb.lib.widget.smartrefresh.util.ScrollBoundaryUtil.canScrollUp;


/**
 * 滚动边界
 * Created by SCWANG on 2017/7/8.
 */

public class RefreshScrollBoundaryAdapter implements RefreshScrollBoundary {

    //<editor-fold desc="Internal">
    MotionEvent mActionEvent;
    RefreshScrollBoundary boundary;

    void setRefreshScrollBoundary(RefreshScrollBoundary boundary) {
        this.boundary = boundary;
    }

    void setActionEvent(MotionEvent event) {
        mActionEvent = event;
    }
    //</editor-fold>

    //<editor-fold desc="RefreshScrollBoundary">
    @Override
    public boolean canPullDown(View content) {
        if (boundary != null) {
            return boundary.canPullDown(content);
        }
        return canScrollUp(content, mActionEvent);
    }

    @Override
    public boolean canPullUp(View content) {
        if (boundary != null) {
            return boundary.canPullUp(content);
        }
        return canScrollDown(content, mActionEvent);
    }
    //</editor-fold>
}