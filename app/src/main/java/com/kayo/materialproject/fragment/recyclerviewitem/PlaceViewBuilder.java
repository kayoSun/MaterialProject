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

public class PlaceViewBuilder extends ItemViewBuilder<PlaceDataContainer,PlaceViewBuilder.PlaceViewHolder> {

    @NonNull
    @Override
    protected PlaceViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new PlaceViewHolder(inflater.inflate(R.layout.item_place,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull PlaceViewHolder holder, @NonNull PlaceDataContainer placeDataContainer, @NonNull TypeItem typeItem) {

    }

    public static class PlaceViewHolder extends RecyclerView.ViewHolder{

        public PlaceViewHolder(View itemView) {
            super(itemView);
        }
    }
}
