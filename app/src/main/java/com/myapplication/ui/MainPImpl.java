package com.myapplication.ui;

import java.util.List;

/**
 * Created by LiuYF on 2016/12/5.
 */

public class MainPImpl implements MainP, MainInteractor.OnFinishedListener {
    private MainV v;
    private MainInteractor interactor;

    public MainPImpl(MainV v) {
        this.v = v;
        interactor = new MainInteractorImpl();
    }

    @Override
    public void onResume() {
        interactor.findItems(this);
    }

    @Override
    public void onItemClick(int position) {
        if (v != null) {
            v.showMsg(msgs.get(position));
        }

    }

    @Override
    public void onDestroy() {
        v = null;
    }

    private List<String> msgs;

    @Override
    public void onFinished(List<String> msgs) {
        if (v != null) {
            v.setItems(msgs);
            this.msgs = msgs;
        }

    }
}
