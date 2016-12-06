package com.myapplication.ui;

import java.util.List;

/**
 * Created by LiuYF on 2016/12/5.
 */

public interface MainInteractor {
    interface OnFinishedListener{
        void onFinished(List<String> msgs);
    }
    void findItems(OnFinishedListener listener);
}
