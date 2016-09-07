package com.kayo.materialproject.installer;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by Kayo on 2016/8/7.
 * 布局创建器
 * 并作数据绑定
 */
public abstract class ItemViewBuilder<C extends ItemDataContainer, H extends ViewHolder> {

    @NonNull
    protected abstract H onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent);

    protected abstract void onBindViewHolder(@NonNull H holder, @NonNull C c, @NonNull TypeItem typeItem);

    public final void onBindViewHolder(@NonNull H holder, @NonNull TypeItem data) {
        this.onBindViewHolder(holder, (C) data.container, data);
    }
}
