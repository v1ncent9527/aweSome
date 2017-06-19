package com.v1ncent.awesome.common.pojo;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by v1ncent on 2017/6/9.
 */

public class CommonAdapterVO implements MultiItemEntity {
    private String title;
    private String content;
    public static final int TEXT = 1;
    public static final int IMG = 2;
    public static final int IMG_TEXT = 3;
    public static final int TEXT_SPAN_SIZE = 3;
    public static final int IMG_SPAN_SIZE = 1;
    public static final int IMG_TEXT_SPAN_SIZE = 4;
    public static final int IMG_TEXT_SPAN_SIZE_MIN = 2;
    private int itemType;
    private int spanSize;

    public CommonAdapterVO(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public CommonAdapterVO(int itemType, int spanSize, String content) {
        this.itemType = itemType;
        this.content = content;
        this.spanSize = spanSize;
    }

    public CommonAdapterVO(int itemType, int spanSize) {
        this.itemType = itemType;
        this.spanSize = spanSize;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
