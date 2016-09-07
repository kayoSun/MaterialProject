package com.kayo.materialproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kayo.materialproject.R;

/**
 * Created by Kayo on 2016/8/11.
 */

public class Function2Fragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView view = new TextView(getContext());
        return inflater.inflate(R.layout.fragment_fuc2,container,false);
    }
}
