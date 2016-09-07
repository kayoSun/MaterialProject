package com.kayo.materialproject.view.cartoontoast;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringSystem;
import com.kayo.materialproject.R;

/**
 * Created by Kayo on 2016/8/10.
 * 自定义 toast类  实现卡通动画效果
 */
public class KartoonToast {
    public static final int LENGTH_SHORT = 0;
    public static final int LENGTH_LONG = 1;

    public static final int SUCCESS = 1;
    public static final int WARNING = 2;
    public static final int ERROR = 3;
    public static final int INFO = 4;
    public static final int DEFAULT = 5;

    static SuccessToastView successToastView;
    static WarningToastView warningToastView;
    static ErrorToastView errorToastView;
    static InfoToastView infoToastView;
    static DefaultToastView defaultToastView;

    public static void makeText(Context context, String msg, int length, int type) {

        Toast toast = new Toast(context);

        switch (type) {
            case 1: {
                View layout = LayoutInflater.from(context).inflate(R.layout.cartoon_success_toast_layout, null, false);
                TextView text = (TextView) layout.findViewById(R.id.toastMessage);
                text.setText(msg);
                successToastView = (SuccessToastView) layout.findViewById(R.id.successView);
                successToastView.startAnim();
                text.setBackgroundResource(R.drawable.kartoon_success_toast);
                text.setTextColor(Color.parseColor("#FFFFFF"));
                toast.setView(layout);
                break;
            }
            case 2: {
                View layout = LayoutInflater.from(context).inflate(R.layout.cartoon_warning_toast_layout, null, false);

                TextView text = (TextView) layout.findViewById(R.id.toastMessage);
                text.setText(msg);

                warningToastView = (WarningToastView) layout.findViewById(R.id.warningView);
                SpringSystem springSystem = SpringSystem.create();
                final Spring spring = springSystem.createSpring();
                spring.setCurrentValue(1.8);
                SpringConfig config = new SpringConfig(40, 5);
                spring.setSpringConfig(config);
                spring.addListener(new SimpleSpringListener() {

                    @Override
                    public void onSpringUpdate(Spring spring) {
                        float value = (float) spring.getCurrentValue();
                        float scale = (float) (0.9f - (value * 0.5f));

                        warningToastView.setScaleX(scale);
                        warningToastView.setScaleY(scale);
                    }
                });
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                        }
                        spring.setEndValue(0.4f);
                    }
                });

                t.start();
                text.setBackgroundResource(R.drawable.kartoon_warning_toast);
                text.setTextColor(Color.parseColor("#FFFFFF"));
                toast.setView(layout);
                break;
            }
            case 3: {
                View layout = LayoutInflater.from(context).inflate(R.layout.cartoon_error_toast_layout, null, false);

                TextView text = (TextView) layout.findViewById(R.id.toastMessage);
                text.setText(msg);
                errorToastView = (ErrorToastView) layout.findViewById(R.id.errorView);
                errorToastView.startAnim();
                text.setBackgroundResource(R.drawable.kartoon_error_toast);
                text.setTextColor(Color.parseColor("#FFFFFF"));
                toast.setView(layout);
                break;
            }
            case 4: {
                View layout = LayoutInflater.from(context).inflate(R.layout.cartoon_info_toast_layout, null, false);

                TextView text = (TextView) layout.findViewById(R.id.toastMessage);
                text.setText(msg);
                infoToastView = (InfoToastView) layout.findViewById(R.id.infoView);
                infoToastView.startAnim();
                text.setBackgroundResource(R.drawable.kartoon_info_toast);
                text.setTextColor(Color.parseColor("#FFFFFF"));
                toast.setView(layout);
                break;
            }
            case 5: {
                View layout = LayoutInflater.from(context).inflate(R.layout.cartoon_default_toast_layout, null, false);

                TextView text = (TextView) layout.findViewById(R.id.toastMessage);
                text.setText(msg);
                defaultToastView = (DefaultToastView) layout.findViewById(R.id.defaultView);
                defaultToastView.startAnim();
                text.setBackgroundResource(R.drawable.kartoon_default_toast);
                text.setTextColor(Color.parseColor("#FFFFFF"));
                toast.setView(layout);
                break;
            }
        }
        toast.setDuration(length);
        toast.show();
    }
}
