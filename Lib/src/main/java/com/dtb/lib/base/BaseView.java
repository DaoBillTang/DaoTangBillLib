package com.dtb.lib.base;

public interface BaseView<T> {
    void setPresenter(T presenter);

    boolean isActive();
}
