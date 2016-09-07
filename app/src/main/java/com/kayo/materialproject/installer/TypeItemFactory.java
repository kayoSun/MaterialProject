package com.kayo.materialproject.installer;

import android.support.annotation.Nullable;

/**
 * Created by Kayo on 2016/8/7.
 */
public class TypeItemFactory {

    @Nullable
    private final String extra;


    private TypeItemFactory(String extra) {
        this.extra = extra;
    }


    public TypeItem buildeContainer(ItemDataContainer container) {
        return new TypeItem(container, extra);
    }

    public static class Builder {
        private String extra;

        public Builder setExtra(String extra) {
            if (extra == null) {
                throw new NullPointerException("extra 不能为空，请检查参数");
            }
            this.extra = extra;
            return this;
        }


        public TypeItemFactory build() {
            return new TypeItemFactory(extra);
        }
    }
}
