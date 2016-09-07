package com.kayo.materialproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kayo.materialproject.R;
import com.kayo.materialproject.fragment.recyclerviewitem.FooterDataContainer;
import com.kayo.materialproject.fragment.recyclerviewitem.FooterViewBuilder;
import com.kayo.materialproject.fragment.recyclerviewitem.PlaceDataContainer;
import com.kayo.materialproject.fragment.recyclerviewitem.PlaceViewBuilder;
import com.kayo.materialproject.fragment.recyclerviewitem.SingelItemDataContainer;
import com.kayo.materialproject.fragment.recyclerviewitem.SingleItemViewBuilder;
import com.kayo.materialproject.fragment.recyclerviewitem.TitleDataContainer;
import com.kayo.materialproject.fragment.recyclerviewitem.TitleViewBuilder;
import com.kayo.materialproject.installer.ComplexDataAdapter;
import com.kayo.materialproject.installer.ComplexItemTypePool;
import com.kayo.materialproject.installer.TypeItem;
import com.kayo.materialproject.installer.TypeItemFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Kayo on 2016/8/11.
 */

public class Function1Fragment extends BaseFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ComplexItemTypePool.getPool().install(TitleDataContainer.class,new TitleViewBuilder());
        ComplexItemTypePool.getPool().install(PlaceDataContainer.class,new PlaceViewBuilder());
        ComplexItemTypePool.getPool().install(FooterDataContainer.class,new FooterViewBuilder());
        ComplexItemTypePool.getPool().install(SingelItemDataContainer.class,new SingleItemViewBuilder());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_fuc1, container, false);
        RecyclerView recycler_view = (RecyclerView) rootview.findViewById(R.id.recycler_view);
        setRecyclerViewData(recycler_view);
        return rootview;
    }

    private void setRecyclerViewData(RecyclerView recycler_view) {
        TypeItemFactory build = new TypeItemFactory.Builder().build();
        SingelItemDataContainer singelItemDataContainer;
        TypeItem placeItem = build.buildeContainer(new PlaceDataContainer());
        TypeItem footerItem = build.buildeContainer(new FooterDataContainer());

        List<TypeItem> typeItems = new ArrayList<>();
        typeItems.add(placeItem);
        typeItems.add(build.buildeContainer(new TitleDataContainer("标题栏  分类一")));
        for (int i = 0; i < 15; i++) {
            TypeItem singleItem = build.buildeContainer(singelItemDataContainer = new SingelItemDataContainer() );
            singelItemDataContainer.setItemTitle("条目种类一标题 ==> "+i);
            typeItems.add(singleItem);
        }
        typeItems.add(build.buildeContainer(new TitleDataContainer("标题栏  分类二")));
        for (int i = 0; i < 15; i++) {
            TypeItem singleItem = build.buildeContainer(singelItemDataContainer = new SingelItemDataContainer() );
            singelItemDataContainer.setItemTitle("条目种类二标题 ==> "+(i));
            singelItemDataContainer.setItemImageId(R.drawable.icon_07);
            typeItems.add(singleItem);
        }
        typeItems.add(footerItem);
        recycler_view.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler_view.setAdapter(new ComplexDataAdapter(typeItems));

    }
}
