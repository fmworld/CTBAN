package com.ctban.ctblib.tasks;


import rx.Subscriber;

/**
 * Created by zhoufeng'an on 2015/11/12.
 */
public abstract class RxJavaNetExcuter<T> extends Subscriber<T> {

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    abstract public void excute();
}
