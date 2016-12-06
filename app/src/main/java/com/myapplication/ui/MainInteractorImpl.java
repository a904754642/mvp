package com.myapplication.ui;

import java.util.Arrays;
import java.util.List;

/**
 * Created by LiuYF on 2016/12/5.
 */

public class MainInteractorImpl implements MainInteractor {
    @Override
    public void findItems(OnFinishedListener listener) {
        listener.onFinished(createList());
    }

    private List<String> createList() {
        return Arrays.asList("11", "22", "33");
    }
}
