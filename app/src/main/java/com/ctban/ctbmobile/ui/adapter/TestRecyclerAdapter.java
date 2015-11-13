package com.ctban.ctbmobile.ui.adapter;

import android.view.View;
import android.view.ViewGroup;

import com.ctban.ctblib.models.dao.Weather;
import com.ctban.ctbmobile.R;
import com.ctban.ctbmobile.databinding.ItemTestBinding;
import com.ctban.ctbmobile.ui.util.BindingRecyclerViewHold;

/**
 * Created by zhoufeng'an on 2015/11/13.
 */
public class TestRecyclerAdapter extends AbstraRecyclerAdapter<Weather> {

    @Override
    protected View inflateView(ViewGroup parent, int viewType) {
        return View.inflate(parent.getContext(), R.layout.item_test,null);
    }

    @Override
    public void onBindViewHolder(BindingRecyclerViewHold holder, int position) {
        ((ItemTestBinding)holder.getBinding()).setWeather(getItemData(position));
    }
}
