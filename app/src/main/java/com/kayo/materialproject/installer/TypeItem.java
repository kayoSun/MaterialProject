package com.kayo.materialproject.installer;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Kayo on 2016/8/7.
 */
public class TypeItem {

    public ItemDataContainer container;
    public String extra;

    public TypeItem() {
    }

    public TypeItem(@NonNull ItemDataContainer container, String extra) {
        this.extra = extra;
        this.container = container;
    }

    @Override
    public String toString() {
        return "TypeItem {" +
                "container=" + container +
                ", extra='" + extra + '\'' +
                '}';
    }
}
