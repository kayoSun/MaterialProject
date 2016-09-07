package com.kayo.materialproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.kayo.materialproject.R;
import com.kayo.materialproject.view.cartoontoast.KartoonToast;

/**
 * Created by Kayo on 2016/7/27.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView username;
    private TextView password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        initView();
    }

    private void initView() {
        username = (TextView) findViewById(R.id.username);
        password = (TextView) findViewById(R.id.passpord);
        findViewById(R.id.cancel).setOnClickListener(this);
        findViewById(R.id.confirm).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, SlidingActivity.class);
        switch (view.getId()) {
            case R.id.cancel:
                startActivity(intent);
                finish();
                break;
            case R.id.confirm:
                String name = username.getText().toString();
                String pwd = password.getText().toString();
                if (TextUtils.isEmpty(name)) {
                    KartoonToast.makeText(this, "Username 不能为空", KartoonToast.LENGTH_LONG, KartoonToast.WARNING);
                    return;
                }
                if (TextUtils.isEmpty(pwd)) {
                    KartoonToast.makeText(this, "Password 不能为空", KartoonToast.LENGTH_LONG, KartoonToast.WARNING);

                    return;
                }
                if (TextUtils.equals(name, "abc") && TextUtils.equals(pwd, "123")) {
                    KartoonToast.makeText(this, "登陆成功~", KartoonToast.LENGTH_LONG, KartoonToast.SUCCESS);
                    startActivity(intent);
                    finish();
                } else {
                    KartoonToast.makeText(this, "Username 或 Password 不正确", KartoonToast.LENGTH_LONG, KartoonToast.WARNING);
                }
                break;
        }

    }
}
