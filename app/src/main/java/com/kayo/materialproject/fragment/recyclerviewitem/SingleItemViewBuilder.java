package com.kayo.materialproject.fragment.recyclerviewitem;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kayo.materialproject.R;
import com.kayo.materialproject.installer.ItemViewBuilder;
import com.kayo.materialproject.installer.TypeItem;


/**
 * Created by Kayo on 2016/8/12.
 */

public class SingleItemViewBuilder extends ItemViewBuilder< SingelItemDataContainer, SingleItemViewBuilder.SingleItemViewHolder > {
    @NonNull
    @Override
    protected SingleItemViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new SingleItemViewHolder(inflater.inflate(R.layout.item_single,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull SingleItemViewHolder holder, @NonNull SingelItemDataContainer container, @NonNull TypeItem typeItem) {

        holder.item_title.setText(container.getItemTitle());
        if (container.getItemImageId() !=0){
            holder.item_image.setImageResource(container.getItemImageId());
        }
    }

    public static class SingleItemViewHolder extends RecyclerView.ViewHolder{

        private ImageView item_image;
        private TextView item_title;

        public SingleItemViewHolder(View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View itemView) {
            item_image = (ImageView) itemView.findViewById(R.id.item_image);
            item_title = (TextView) itemView.findViewById(R.id.item_title);
        }
    }
}
