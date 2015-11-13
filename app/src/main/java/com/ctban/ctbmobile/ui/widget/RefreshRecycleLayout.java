package com.ctban.ctbmobile.ui.widget;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.cjj.MaterialRefreshLayout;

/**
 * Created by zhoufeng'an on 2015/11/13.
 */
public class RefreshRecycleLayout extends MaterialRefreshLayout{
    RecyclerView recyclerView;
    public RefreshRecycleLayout(Context context) {
        super(context);
        recyclerView = new RecyclerView(context);
        initView();
    }

    public RefreshRecycleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        recyclerView = new RecyclerView(context, attrs);

        initView();
    }

    private void initView(){
        LinearLayoutManager manager = new LinearLayoutManager(this.getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);

        this.addView(recyclerView);
    }

    public void setLayoutManager(RecyclerView.LayoutManager manager){
        recyclerView.setLayoutManager(manager);
    }

    public void setAdapter(RecyclerView.Adapter adapter){
        recyclerView.setAdapter(adapter);
    }
}
