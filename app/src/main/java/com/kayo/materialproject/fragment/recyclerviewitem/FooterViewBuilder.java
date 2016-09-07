package com.kayo.materialproject.fragment.recyclerviewitem;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kayo.materialproject.R;
import com.kayo.materialproject.installer.ItemViewBuilder;
import com.kayo.materialproject.installer.TypeItem;


/**
 * Created by Kayo on 2016/8/12.
 */

public class FooterViewBuilder extends ItemViewBuilder<FooterDataContainer,FooterViewBuilder.FooterViewHolder> {
    @NonNull
    @Override
    protected FooterViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new FooterViewHolder(inflater.inflate(R.layout.item_footer,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull FooterViewHolder holder, @NonNull FooterDataContainer footerDataContainer, @NonNull TypeItem typeItem) {

    }

    public static class FooterViewHolder extends RecyclerView.ViewHolder{

        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }
}
