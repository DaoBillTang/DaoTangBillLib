package com.dtb.lib.widget.smartrefresh.constant;
public enum RefreshState {
    None,
    PullDownToRefresh, PullToUpLoad,
    PullDownCanceled, PullUpCanceled,
    ReleaseToRefresh, ReleaseToLoad,
    Refreshing, Loading,
    RefreshFinish, LoadingFinish,
}