package com.kayo.materialproject.fragment.recyclerviewitem;


import com.kayo.materialproject.installer.ItemDataContainer;

/**
 * Created by Kayo on 2016/8/12.
 * 单列条目数据容器
 */

public class SingelItemDataContainer implements ItemDataContainer {
    public String itemTitle;
    public int itemImageId;

    public int getItemImageId() {
        return itemImageId;
    }

    public void setItemImageId(int itemImageId) {
        this.itemImageId = itemImageId;
    }

    public SingelItemDataContainer() {
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }
}
