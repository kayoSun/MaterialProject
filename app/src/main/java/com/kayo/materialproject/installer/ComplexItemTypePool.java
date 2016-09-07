package com.kayo.materialproject.installer;

import android.support.annotation.NonNull;

import com.kayo.materialproject.constant.AppCanstant;
import com.kayo.materialproject.exception.ItemTypeException;

import java.util.ArrayList;

/**
 * Created by Kayo on 2016/8/7.
 * 用于存储 条目类型的 管理池
 */
public final class ComplexItemTypePool {

    private static ArrayList<Class<? extends ItemDataContainer>> containers;
    private static ArrayList<ItemViewBuilder> builders = new ArrayList<>();
    private static ComplexItemTypePool pool;

    private ComplexItemTypePool() {
    }

    public static ComplexItemTypePool getPool() {
        if (containers == null) {
            synchronized (ComplexItemTypePool.class) {
                if (containers == null) {
                    containers = new ArrayList<>();
                }
            }
        }
        if (builders == null) {
            synchronized (ComplexItemTypePool.class) {
                if (builders == null) {
                    builders = new ArrayList<>();
                }
            }
        }
        if (pool == null) {
            synchronized (ComplexItemTypePool.class) {
                if (pool == null) {
                    pool = new ComplexItemTypePool();
                }
            }
        }
        return pool;
    }

    /**
     * 同步 安装 条目类型
     *
     * @param itemContainer
     * @param builder
     */
    public synchronized void install(@NonNull Class<? extends ItemDataContainer> itemContainer,
                                     @NonNull ItemViewBuilder builder) {
        if (!containers.contains(itemContainer)) {
            containers.add(itemContainer);
            builders.add(builder);
        } else {
            if (AppCanstant.DEVELOP_MODE) {
                throw new ItemTypeException("你已经安装 " + itemContainer.getSimpleName() + " 类型. 请检查.");
            }
        }
    }

    public synchronized void uninstall(@NonNull Class<? extends ItemDataContainer> itemContainer,
                                       @NonNull ItemViewBuilder builder) {
        if (containers.contains(itemContainer)) {
            containers.remove(itemContainer);
            builders.remove(builder);
        } else {
            if (AppCanstant.DEVELOP_MODE) {
                throw new ItemTypeException("你所要卸载的 " + itemContainer.getSimpleName() + " 类型未安装. 检查后请重试");

            }
        }
    }

    /**
     * 卸载 条目类型
     */
    public void uninstallAll() {
        if (containers != null) {
            containers = null;
        }
        if (builders != null) {
            builders = null;
        }
    }


    @NonNull
    public static ArrayList<Class<? extends ItemDataContainer>> getContainers() {
        return containers;
    }

    @NonNull
    public static ArrayList<ItemViewBuilder> getBuilders() {
        return builders;
    }


    @NonNull
    public static ItemViewBuilder getBuilderByIndex(int index) {
        return builders.get(index);
    }
}
