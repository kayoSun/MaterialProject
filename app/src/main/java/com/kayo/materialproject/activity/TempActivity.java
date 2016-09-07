package com.kayo.materialproject.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.kayo.materialproject.R;
import com.kayo.materialproject.fragment.recyclerviewitem.FooterDataContainer;
import com.kayo.materialproject.fragment.recyclerviewitem.PlaceDataContainer;
import com.kayo.materialproject.fragment.recyclerviewitem.SingelItemDataContainer;
import com.kayo.materialproject.fragment.recyclerviewitem.TitleDataContainer;
import com.kayo.materialproject.installer.ComplexDataAdapter;
import com.kayo.materialproject.installer.TypeItem;
import com.kayo.materialproject.installer.TypeItemFactory;

import java.util.ArrayList;
import java.util.List;

public class TempActivity extends AppCompatActivity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);
        text = (TextView) findViewById(R.id.text);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        setRecyclerViewData(recyclerView);
        setViewData();
    }

    private void setViewData() {
        text.measure(0,0);
        int measuredWidth = text.getMeasuredWidth();
        int measuredHeight = text.getMeasuredHeight();
        int i = View.MeasureSpec.makeMeasureSpec(measuredWidth, View.MeasureSpec.EXACTLY);
        int y = View.MeasureSpec.makeMeasureSpec(measuredHeight, View.MeasureSpec.AT_MOST);
        String ci= "何年月地。有白凤飞来，与秋游戏。碎屑黄金馥馥，暗熏沉水。如来粟界开全未，直着得、许多清气。饱谙风露，自应韵色，独高人世。更不羡、犀帷富贵。羡鹫峰前度，秀分云外。弹压西风，谁数锦英华丽。幽芳素抱岩栖志，笑当时、满门桃李。等闲乞取，长生妙诀，广寒宫里。";
        TextView textView = new TextView(this);
        textView.setText(ci);
        textView.setTextSize(14);
        textView.measure(i,y);
        System.out.println("测量的高度为 = "+textView.getMeasuredHeight());

    }

    private void setRecyclerViewData(RecyclerView recycler_view) {
//        TypeItemFactory build = new TypeItemFactory.Builder().build();
//        SingelItemDataContainer singelItemDataContainer;
//        TypeItem placeItem = build.buildeContainer(new PlaceDataContainer());
//        TypeItem footerItem = build.buildeContainer(new FooterDataContainer());
//
//        List<TypeItem> typeItems = new ArrayList<>(80);
//        typeItems.add(placeItem);
//        typeItems.add(build.buildeContainer(new TitleDataContainer("标题栏  分类一")));
//        for (int i = 0; i < 15; i++) {
//            TypeItem singleItem = build.buildeContainer(singelItemDataContainer = new SingelItemDataContainer() );
//            singelItemDataContainer.setItemTitle("条目种类一标题 ==> "+i);
//            typeItems.add(singleItem);
//        }
//        typeItems.add(build.buildeContainer(new TitleDataContainer("标题栏  分类二")));
//        for (int i = 0; i < 15; i++) {
//            TypeItem singleItem = build.buildeContainer(singelItemDataContainer = new SingelItemDataContainer() );
//            singelItemDataContainer.setItemTitle("条目种类二标题 ==> "+(i));
//            typeItems.add(singleItem);
//        }
//        typeItems.add(footerItem);
//        recycler_view.setLayoutManager(new LinearLayoutManager(this));
//        recycler_view.setAdapter(new ComplexDataAdapter(typeItems));
    }
}
