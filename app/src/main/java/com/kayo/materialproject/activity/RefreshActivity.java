package com.kayo.materialproject.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.kayo.materialproject.R;
import com.kayo.materialproject.adapter.ItemAdapter;
import com.kayo.materialproject.adapter.ItemBean;
import com.kayo.materialproject.base.BaseActivity;
import com.kayo.materialproject.base.SwipeBackLayout;
import com.kayo.materialproject.view.LoadMoreRecyclerView;
import com.kayo.materialproject.view.SuperSwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by zengwendong on 16/7/19.
 */
public class RefreshActivity extends BaseActivity {

    private SuperSwipeRefreshLayout swipeRefreshLayout;
    private LoadMoreRecyclerView loadMoreRecyclerView;
    private LinearLayout ll_header;
    private ImageView iv_image;

    private GridLayoutManager gridLayoutManager;
    private LinearLayoutManager linearLayoutManager;
    private int mScrollY;
    private int mHeaderHeight;
    private int mHeaderTranslation;
    private ItemAdapter itemAdapter;

   // int[] imgIds = new int[]{R.drawable.girl01,R.drawable.girl02,R.drawable.girl03,R.drawable.girl04,R.drawable.girl05};
    int[] imgIds = new int[]{R.drawable.icon_01, R.drawable.icon_02, R.drawable.icon_03, R.drawable.icon_04, R.drawable.icon_05,
           R.drawable.icon_06, R.drawable.icon_07, R.drawable.icon_08, R.drawable.icon_09, R.drawable.icon_10, R.drawable.icon_11,
           R.drawable.icon_12, R.drawable.icon_13};
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh);
        setDragEdge(SwipeBackLayout.DragEdge.LEFT);
        swipeRefreshLayout = (SuperSwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        loadMoreRecyclerView = (LoadMoreRecyclerView) findViewById(R.id.loadMoreRecyclerView);
        ll_header = (LinearLayout) findViewById(R.id.ll_header);
        iv_image = (ImageView) findViewById(R.id.iv_image);
        //头布局
        View headerView = createHeaderView();
        final TextView refresh_tip = (TextView) headerView.findViewById(R.id.tv_refresh_text);
        final ProgressBar progressBar_refresh = (ProgressBar) headerView.findViewById(R.id.progressBar_refresh);
        progressBar_refresh.setVisibility(View.GONE);

        gridLayoutManager = new GridLayoutManager(this, 2);
        linearLayoutManager = new LinearLayoutManager(this);
        loadMoreRecyclerView.setLayoutManager(linearLayoutManager);

        itemAdapter = new ItemAdapter(this);
        loadMoreRecyclerView.setAdapter(itemAdapter);
        List<ItemBean> dataList = getData();
        itemAdapter.setData(dataList);

        initValues();
        loadMoreRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                mScrollY += dy;
               // scrollHeader(mScrollY);
                scrollHeaderWithMove(dy);
            }
        });

        loadMoreRecyclerView.setLoadMoreListener(new LoadMoreRecyclerView.LoadMoreListener() {
            @Override
            public void onLoadMore() {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        List<ItemBean> dataList = new ArrayList<>();
                        for (int i = 0; i < 10; i++) {
                            ItemBean itemBean = new ItemBean();
                            itemBean.title = "条目测试数据一（上拉）---" + i;
                            itemBean.imgId = imgIds[random.nextInt(13)];
                            dataList.add(itemBean);
                        }
                        itemAdapter.addData(dataList);
                        loadMoreRecyclerView.notifyMoreFinish(true);
                    }
                }, 1000);
            }
        });

       // swipeRefreshLayout.setHeaderView(headerView);//添加下拉刷新头部view
//        swipeRefreshLayout.setOnPullRefreshListener(new SuperSwipeRefreshLayout.OnPullRefreshListener() {
//
//            @Override
//            public void onRefresh() {//开始刷新
//                refresh_tip.setText("正在刷新");
//                progressBar_refresh.setVisibility(View.VISIBLE);
//                System.out.println("RefreshActivity --> " + "onPullToRefresh 下拉刷新");
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        swipeRefreshLayout.setRefreshing(false);
//                        List<ItemBean> dataList = getData();
//                        itemAdapter.setData(dataList);
//                    }
//                }, 1000);
//            }
//
//            @Override
//            public void onPullDistance(int distance) {//下拉距离
//                System.out.println("RefreshActivity --> " + "onPullDistance 下拉刷新距离" + distance);
//
//            }
//
//            @Override
//            public void onPullEnable(boolean enable) {//下拉过程中，下拉的距离是否足够出发刷新
//                System.out.println("RefreshActivity --> " + "onPullEnable 下拉刷新距离是否足够 " + enable);
//                refresh_tip.setText(enable?"松开刷新":"下拉刷新");
//
//            }
//        });

    }

    public View createHeaderView(){
        return getLayoutInflater().inflate(R.layout.layout_refresh_header_view,null);
    }

    @NonNull
    private List<ItemBean> getData() {
        List<ItemBean> dataList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            ItemBean itemBean = new ItemBean();
            itemBean.title = "条目测试数据二---" + i;
            itemBean.imgId = imgIds[random.nextInt(6)];
            dataList.add(itemBean);
        }
        return dataList;
    }

    private void scrollHeader(int scrollY) {
        float translationY = Math.max(-scrollY, mHeaderTranslation);
        ll_header.setTranslationY(translationY);
        iv_image.setTranslationY(-translationY / 3);
//        if (translationY == 0){
//            swipeRefreshLayout.isTop(true);
//        }else {
//            swipeRefreshLayout.isTop(false);
//        }
    }

    int fixY = 0 ;
    /**
     * 实现任何位置滑动 更新 头布局位置
     * @param dy
     */
    private void scrollHeaderWithMove(int dy){
        fixY += dy;
        if (fixY > -mHeaderTranslation){
            fixY = -mHeaderTranslation;
        } else if (fixY < 0 ){
            fixY = 0;
        }
        ll_header.setTranslationY(-fixY);
        iv_image.setTranslationY(fixY / 3);

        System.out.println("RefreshActivity --> " + "fixY = "+ fixY);
        System.out.println("RefreshActivity --> " + "dy = "+ dy);
    }

    private void initValues() {
        mHeaderHeight = getResources().getDimensionPixelSize(R.dimen.header_height);
        int tabHeight = getResources().getDimensionPixelSize(R.dimen.tab_height);
        mHeaderTranslation = -mHeaderHeight + tabHeight;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
