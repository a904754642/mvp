package com.myapplication.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.myapplication.R;
import com.myapplication.login.LoginP;
import com.myapplication.login.LoginPImpl;
import com.myapplication.login.LoginV;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginV {
    private EditText nameEt, pwdEt;
    private Context context;
    private LoginP p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        nameEt = (EditText) findViewById(R.id.name);
        pwdEt = (EditText) findViewById(R.id.pwd);
        findViewById(R.id.login).setOnClickListener(this);
        p = new LoginPImpl(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        p.onDestory();
    }

    @Override
    public void onClick(View v) {
        p.checkLogin(nameEt.getText().toString(), pwdEt.getText().toString());
    }

    @Override
    public void setNameError() {
        nameEt.setError("name is empty");
    }

    @Override
    public void setPwdError() {
        pwdEt.setError("pwd is empty");
    }

    @Override
    public void successToHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
