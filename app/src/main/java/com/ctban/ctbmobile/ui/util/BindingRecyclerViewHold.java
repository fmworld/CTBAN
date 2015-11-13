package com.ctban.ctbmobile.ui.util;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by zhoufeng'an on 2015/11/13.
 */
public class BindingRecyclerViewHold<T extends ViewDataBinding> extends RecyclerView.ViewHolder {
    private T myBinding;
    public BindingRecyclerViewHold(View itemView, T  binding) {
        super(itemView);
        myBinding = binding;
    }

    public T getBinding() {
        return myBinding;
    }
}
