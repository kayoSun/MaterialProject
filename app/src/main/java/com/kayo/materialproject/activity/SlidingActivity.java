package com.kayo.materialproject.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.kayo.materialproject.R;
import com.kayo.materialproject.flux.view.FluxActivity;
import com.kayo.materialproject.fragment.Function1Fragment;
import com.kayo.materialproject.fragment.Function2Fragment;
import com.kayo.materialproject.view.cartoontoast.KartoonToast;
import com.kayo.materialproject.view.portslidingmenu.PortSlidingMenu;
import com.kayo.materialproject.view.portslidingmenu.listener.onSwipeProgressListener;
import com.kayo.materialproject.view.portslidingmenu.util.SizeUtil;

public class SlidingActivity extends AppCompatActivity implements View.OnClickListener {

    private int mStyleCode = 11111; //风格代码
    private int mScaleProgress = 0; //起始缩放程度
    private int mAlphaProgress = 0; //起始透明程度
    private int mAngleProgress = 0; //起始3D旋转角度

    private int mTransCode = 1; //移动动画代码 1-3
    private int mScaleCode = 1; //缩放动画代码 1-2
    private int mAlphaCode = 1; //透明度动画代码 1-2
    private int mRotateCode = 4; //旋转动画代码 1-6

    PortSlidingMenu port_sliding_menu;
    TextView login_activity;
    TextView refresh_activity;
    TextView flux_activity;
    TextView splash_activity;
    ImageButton show_port_menu;
    FrameLayout fragment_container;
    TextView title;
    private Function1Fragment function1Fragment;
    private Function2Fragment function2Fragment;

    private Fragment currFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_sliding_activity);
        port_sliding_menu = (PortSlidingMenu) findViewById(R.id.port_sliding_menu);
        login_activity = (TextView) findViewById(R.id.login_activity);
        refresh_activity = (TextView) findViewById(R.id.refresh_activity);
        flux_activity = (TextView) findViewById(R.id.flux_activity);
        splash_activity = (TextView) findViewById(R.id.splash_activity);
        fragment_container = (FrameLayout) findViewById(R.id.fragment_container);
        title = (TextView) findViewById(R.id.title);
        show_port_menu = (ImageButton) findViewById(R.id.show_port_menu);
        show_port_menu.setOnClickListener(this);
        login_activity.setOnClickListener(this);
        refresh_activity.setOnClickListener(this);
        flux_activity.setOnClickListener(this);
        splash_activity.setOnClickListener(this);
        findViewById(R.id.func1).setOnClickListener(this);
        findViewById(R.id.func2).setOnClickListener(this);
        findViewById(R.id.temp_activity).setOnClickListener(this);
        port_sliding_menu.setOnMenuShowingListener(new onSwipeProgressListener() {
            @Override
            public void onProgressChange(float progress) {
                System.out.println("onSwipeProgressListener   progress = "+progress);
                //1打开  0关闭
                if (progress == 0){
                    show_port_menu.setImageResource(R.drawable.ic_menu_back);
               //     KartoonToast.makeText(SlidingActivity.this, "关闭 侧边栏", KartoonToast.LENGTH_SHORT, KartoonToast.INFO);
                }else if (progress == 1){
                    show_port_menu.setImageResource(R.drawable.ic_menu_forward);
                //    KartoonToast.makeText(SlidingActivity.this, "展开 侧边栏", KartoonToast.LENGTH_SHORT, KartoonToast.INFO);
                }
            }
        });

        port_sliding_menu.setMenuOffset((int) SizeUtil.Dp2Px(this, 100));
     FragmentManager   fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        function1Fragment = new Function1Fragment();
        function2Fragment = new Function2Fragment();
        ft.add(R.id.fragment_container, function2Fragment);
        ft.add(R.id.fragment_container, function1Fragment);
        title.setText("FUNC_1标题");
        ft.commit();
        currFragment = function1Fragment;
        changeStyleCode();
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.login_activity:
                KartoonToast.makeText(this, "login_activity 启动", KartoonToast.LENGTH_SHORT, KartoonToast.INFO);
                port_sliding_menu.hideMenu();
                intent.setClass(this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.refresh_activity:
                KartoonToast.makeText(this, "refresh_activity 启动", KartoonToast.LENGTH_SHORT, KartoonToast.INFO);
                port_sliding_menu.hideMenu();
                intent.setClass(this, RefreshActivity.class);
                startActivity(intent);
                break;
            case R.id.flux_activity:
                KartoonToast.makeText(this, "flux_activity 启动", KartoonToast.LENGTH_SHORT, KartoonToast.INFO);
                port_sliding_menu.hideMenu();
                intent.setClass(this, FluxActivity.class);
                startActivity(intent);
                break;
            case R.id.splash_activity:
                KartoonToast.makeText(this, "splash_activity 启动", KartoonToast.LENGTH_SHORT, KartoonToast.INFO);
                port_sliding_menu.hideMenu();
                intent.setClass(this, SplashActivity.class);
                startActivity(intent);
                break;
            case R.id.show_port_menu:
                if (port_sliding_menu.isMenuShowing()) {
                    port_sliding_menu.hideMenu();
                } else {
                    port_sliding_menu.showMenu();
                }
                break;
            case R.id.func1:
                showOrHide(function1Fragment);
                title.setText("FUNC_1标题");

                break;
            case R.id.func2:
                showOrHide(function2Fragment);
                title.setText("FUNC_2标题");

                break;
            case R.id.temp_activity:
                KartoonToast.makeText(this, "temp_activity 启动", KartoonToast.LENGTH_SHORT, KartoonToast.INFO);
                port_sliding_menu.hideMenu();
                intent.setClass(this, TempActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void showOrHide(Fragment toFragment){
        port_sliding_menu.hideMenu();
        FragmentManager  fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        if (!toFragment.isAdded()) {
            ft.hide(currFragment).add(R.id.fragment_container, toFragment).commit();
        } else {
            ft.hide(currFragment).show(toFragment).commit();
        }
        currFragment = toFragment;
    }

    //更新侧滑风格代码
    public void changeStyleCode() {
        mStyleCode =
                mTransCode * 1000 +
                mScaleCode * 100 +
                mAlphaCode * 10 +
                mRotateCode;
        port_sliding_menu.setStyleCode(mStyleCode);
    }

}
