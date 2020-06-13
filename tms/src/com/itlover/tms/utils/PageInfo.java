package com.itlover.tms.utils;

import java.util.List;

/**
 * 该类显示了分页的信息以及数据信息
 */
public class PageInfo<T> {

    //总数量
    private long totalCount;

    //当前页
    private int pageNum;

    //当前页面的显示数据条数
    private int pageSize;

    //页面总数
    private int pages;

    //封装的数据
    private List<T> objects;

    @Override
    public String toString() {
        return "PageInfo{" +
                "totalCount=" + totalCount +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", pages=" + pages +
                ", objects=" + objects +
                '}';
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getObjects() {
        return objects;
    }

    public void setObjects(List<T> objects) {
        this.objects = objects;
    }


}
