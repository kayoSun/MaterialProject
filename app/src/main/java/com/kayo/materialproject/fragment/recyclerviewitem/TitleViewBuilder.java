package com.kayo.materialproject.fragment.recyclerviewitem;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kayo.materialproject.R;
import com.kayo.materialproject.installer.ItemViewBuilder;
import com.kayo.materialproject.installer.TypeItem;


/**
 * Created by Kayo on 2016/8/12.
 */

public class TitleViewBuilder extends ItemViewBuilder<TitleDataContainer, TitleViewBuilder.TitleViewHolder> {
    @NonNull
    @Override
    protected TitleViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new TitleViewHolder(inflater.inflate(R.layout.item_title, parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull TitleViewHolder holder, @NonNull TitleDataContainer titleDataContainer, @NonNull TypeItem typeItem) {
        holder.title.setText(titleDataContainer.getTitle());
    }

    public static class TitleViewHolder extends RecyclerView.ViewHolder {

        public TextView title;

        public TitleViewHolder(View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View itemView) {
            title = (TextView) itemView.findViewById(R.id.title);
        }

    }
}
