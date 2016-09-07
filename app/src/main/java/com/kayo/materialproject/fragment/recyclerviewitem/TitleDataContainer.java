package com.kayo.materialproject.fragment.recyclerviewitem;

import com.kayo.materialproject.installer.ItemDataContainer;

/**
 * Created by Kayo on 2016/8/12.
 */

public class TitleDataContainer implements ItemDataContainer {
    public String title;

    public TitleDataContainer(){
    }

    public TitleDataContainer(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
