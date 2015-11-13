package com.ctban.ctbmobile.ui.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.ctban.ctblib.models.dao.Weather;
import com.ctban.ctbmobile.R;
import com.ctban.ctbmobile.databinding.ItemTestBinding;
import com.ctban.ctbmobile.ui.util.BindingRecyclerViewHold;

/**
 * Created by zhoufeng'an on 2015/11/13.
 */
public class TestRecyclerAdapter extends RecyclerView.Adapter<BindingRecyclerViewHold> {
    private Weather weather;
    public TestRecyclerAdapter(){
        weather = new Weather();
        weather.setCity("态度");
        weather.setTemp("100%");
    }
    @Override
    public BindingRecyclerViewHold onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemTestBinding binding = DataBindingUtil.bind(View.inflate(parent.getContext(), R.layout.item_test, null));
        return new BindingRecyclerViewHold<>(binding.getRoot(),binding);
    }

    @Override
    public void onBindViewHolder(BindingRecyclerViewHold holder, int position) {
        ((ItemTestBinding)holder.getBinding()).setWeather(weather);
//        holder.getBinding().setWeather(weather);
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
