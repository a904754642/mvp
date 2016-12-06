package com.myapplication.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.myapplication.R;

import java.util.List;

/**
 * Created by LiuYF on 2016/12/5.
 */

public class MainActivity extends Activity implements MainV, AdapterView.OnItemClickListener {
    private ListView mListView;
    private MainP p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        mListView = (ListView) findViewById(R.id.list);
        mListView.setOnItemClickListener(this);
        p = new MainPImpl(this);

    }

    @Override
    public void setItems(List<String> msgs) {
        mListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, msgs));
    }

    @Override
    public void showMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        p.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        p.onDestroy();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        p.onItemClick(position);
    }
}
