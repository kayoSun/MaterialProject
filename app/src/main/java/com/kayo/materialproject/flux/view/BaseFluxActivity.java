package com.kayo.materialproject.flux.view;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kayo.materialproject.flux.control.IDataController;
import com.kayo.materialproject.flux.dispatcher.Dispatcher;
import com.kayo.materialproject.flux.control.UpdateEvent;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public abstract class BaseFluxActivity extends AppCompatActivity  implements View.OnClickListener{

    private IDataController controller;
    @Override
    public void onClick(View view) {

    }

    @Override
    public void onStart() {
        super.onStart();
        if (controller == null){
            controller = initDataController();
        }
        Dispatcher.getDispatcher().register(this, controller);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Dispatcher.getDispatcher().unRegister(this, controller);
        if (controller != null) {
            controller = null;
        }
    }

    /**
     * 将返回的 动作数据 在主线程中进行
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(UpdateEvent event){
        updateUI(event);
    }

    /**
     * 返回的数据 与 发送数据时的同线程中进行
     */
    @Subscribe
    public void onEvent(UpdateEvent event){

    }

    /**
     * 更新UI 数据  具体子类实现
     * @param event 携带 动作数据对象
     */
    public abstract void updateUI(UpdateEvent event);

    /**
     * 初始化 数据控制中心
     * @return  返回控制中心对象
     */
    public abstract IDataController initDataController();
}
