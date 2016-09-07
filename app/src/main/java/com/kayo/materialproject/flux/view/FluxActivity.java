package com.kayo.materialproject.flux.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.kayo.materialproject.R;
import com.kayo.materialproject.view.cartoontoast.KartoonToast;
import com.kayo.materialproject.flux.action.Action;
import com.kayo.materialproject.flux.action.ActionType;
import com.kayo.materialproject.flux.action.ActionsCreator;
import com.kayo.materialproject.flux.dispatcher.Dispatcher;
import com.kayo.materialproject.flux.control.FluxDataController;
import com.kayo.materialproject.flux.control.IDataController;
import com.kayo.materialproject.flux.control.UpdateEvent;

public class FluxActivity extends BaseFluxActivity {

    private EditText et_text;
    private EditText et_text_send;
    private TextView tips;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flux);
        initView();
    }

    private void initView() {
        et_text = (EditText) findViewById(R.id.et_text);
        et_text_send = (EditText) findViewById(R.id.et_text_send);
        findViewById(R.id.send).setOnClickListener(this);
        findViewById(R.id.request).setOnClickListener(this);
        findViewById(R.id.image).setOnClickListener(this);
        tips = (TextView) findViewById(R.id.tips);
        et_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                ActionsCreator.getCreator(Dispatcher.getDispatcher()).sendAction(new Action(ActionType.ACTION_1, et_text.getText().toString()));

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.send:
                ActionsCreator.getCreator(Dispatcher.getDispatcher()).sendAction(new Action(ActionType.ACTION_1, et_text_send.getText().toString()));
                break;
            case R.id.request:
                findViewById(R.id.progress).setVisibility(View.VISIBLE);
                ActionsCreator.getCreator(Dispatcher.getDispatcher()).sendAction(new Action(ActionType.ACTION_2, null));
                break;
            case R.id.image:
                findViewById(R.id.image).setVisibility(View.GONE);
                break;
            default:
                break;
        }
    }

    @Override
    public void updateUI(UpdateEvent event) {
        switch (event.getOperationType()) {
            case ActionType.ACTION_1:
                tips.setText(event.getData().toString());
                break;
            case ActionType.ACTION_2:
                findViewById(R.id.progress).setVisibility(View.GONE);
                String tips = (String) event.getData();
                System.out.println(tips);
                findViewById(R.id.image).setVisibility(View.VISIBLE);
                if (!TextUtils.isEmpty(tips)){
                    KartoonToast.makeText(this,tips,KartoonToast.LENGTH_LONG,KartoonToast.SUCCESS);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public IDataController initDataController() {
        return new FluxDataController();
    }
}
