package com.ctban.ctbmobile.ui.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import com.ctban.ctbmobile.ui.util.BindingRecyclerViewHold;
import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhoufeng'an on 2015/11/13.
 */
public abstract class AbstraRecyclerAdapter<T> extends RecyclerView.Adapter<BindingRecyclerViewHold> {
    private List<T> data;
    private SparseArray<Integer> layoutWithType;
    public AbstraRecyclerAdapter(){
        data = new ArrayList<>();
        layoutWithType = new SparseArray<>();
    }
    @Override
    public BindingRecyclerViewHold onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.bind(inflateView(parent,viewType));
        return new BindingRecyclerViewHold<>(binding.getRoot(),binding);
    }

    protected abstract View inflateView(ViewGroup parent,int viewType);


    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<T> _data){
        Preconditions.checkArgument(null != _data,"列表装载数据对象不存在_datas = null");
        data = _data;
        this.notifyDataSetChanged();
    }

    public void clearData(){
        data.clear();
        this.notifyDataSetChanged();
    }

    public T getItemData(int position){
        Preconditions.checkElementIndex(position, data.size(), "数组越界");
        return data.get(position);
    }
}
