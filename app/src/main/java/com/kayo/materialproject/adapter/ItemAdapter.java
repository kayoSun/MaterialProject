package com.kayo.materialproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.kayo.materialproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zengwendong on 16/7/19.
 */
public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int TYPE_PLACEHOLDER = 0;
    private final int TYPE_ITEM = 1;
    private final int TYPE_FOOTER = 2;

    private Context context;
    private LayoutInflater layoutInflater;

    private List<ItemBean> dataList;

    public ItemAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.dataList = new ArrayList<>();
    }

    public void setData(List<ItemBean> list) {
        this.dataList.clear();
        this.dataList.addAll(list);
        notifyDataSetChanged();
    }

    public void addData(List<ItemBean> list) {
        this.dataList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == TYPE_PLACEHOLDER) {
            view = layoutInflater.inflate(R.layout.layout_place, parent, false);
            return new PlaceViewHolder(view);
        } else if (viewType == TYPE_ITEM) {
            view = layoutInflater.inflate(R.layout.layout_item, parent, false);
            return new ItemViewHolder(view);
        } else if (viewType == TYPE_FOOTER) {
            view = layoutInflater.inflate(R.layout.layout_load_more, parent, false);
            return new FooterViewHolder(view);
        }

        throw new RuntimeException("Invalid view type " + viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            ItemBean itemBean = getItem(position);
            itemViewHolder.tv_text.setText(itemBean.title);
            if (itemBean.imgId!=0){
                itemViewHolder.iv_icon.setImageResource(itemBean.imgId);
            }

        }
    }

    private ItemBean getItem(int position) {
        try {
            return dataList.get(position - 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_PLACEHOLDER;
        }

        int footerPosition = getItemCount() - 1;
        if (footerPosition == position) {
            return TYPE_FOOTER;
        }

        return TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        int count = dataList == null ? 0 : dataList.size();
        count++;//占位
        count++;//底部

        return count;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_text;
        public ImageView iv_icon;

        public ItemViewHolder(View itemView) {
            super(itemView);
            this.tv_text = (TextView) itemView.findViewById(R.id.tv_text);
            this.iv_icon = (ImageView) itemView.findViewById(R.id.iv_icon);
        }
    }

    class PlaceViewHolder extends RecyclerView.ViewHolder {

        public PlaceViewHolder(View itemView) {
            super(itemView);
        }
    }

    class FooterViewHolder extends RecyclerView.ViewHolder {

        public ProgressBar progressBar;
        public TextView tv_loading_text;

        public FooterViewHolder(View itemView) {
            super(itemView);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar);
            tv_loading_text = (TextView) itemView.findViewById(R.id.tv_loading_text);
        }

    }
}
