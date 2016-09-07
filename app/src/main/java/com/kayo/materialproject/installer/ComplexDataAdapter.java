package com.kayo.materialproject.installer;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Kayo on 2016/8/7.
 */
public class ComplexDataAdapter extends RecyclerView.Adapter<ViewHolder> {

    private final List<? extends TypeItem> typeItems;
    private LayoutInflater inflater;


    public ComplexDataAdapter(@NonNull List<? extends TypeItem> typeItems) {
        this.typeItems = typeItems;
    }


    @Override public int getItemViewType(int position) {
        //转交 条目类型判断
        ItemDataContainer container = typeItems.get(position).container;
        return ComplexItemTypePool.getContainers().indexOf(container.getClass());
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int indexViewType) {
        //转交 条目持有者创建过程
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        return ComplexItemTypePool.getBuilderByIndex(indexViewType).onCreateViewHolder(inflater, parent);
    }


    @SuppressWarnings("unchecked") @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //转交 数据绑定过程
        int type = getItemViewType(position);
        TypeItem typeItem = typeItems.get(position);
        ComplexItemTypePool.getBuilderByIndex(type).onBindViewHolder(holder, typeItem);
    }


    @Override public int getItemCount() {
        return typeItems.size();
    }
}