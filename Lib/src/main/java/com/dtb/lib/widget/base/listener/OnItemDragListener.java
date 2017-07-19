package com.dtb.lib.widget.base.listener;
import android.support.v7.widget.RecyclerView;

/**
 * project ${PACKAGE_NAME}
 * Created by Bill on 2016/6/20.
 * emal: tangbakzi@daotangbill.uu.me
 * @author: Bill
 * @version: 1.0
 * @description:
 */
public interface OnItemDragListener {
    void onItemDragStart(RecyclerView.ViewHolder viewHolder, int pos);
    void onItemDragMoving(RecyclerView.ViewHolder source, int from, RecyclerView.ViewHolder target, int to);
    void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int pos);

}
