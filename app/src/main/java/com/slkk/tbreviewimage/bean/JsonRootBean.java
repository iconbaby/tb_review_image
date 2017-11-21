/**
 * Copyright 2017 bejson.com
 */
package com.slkk.tbreviewimage.bean;

import java.util.List;

/**
 * Auto-generated: 2017-11-21 13:37:23
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class JsonRootBean {

    private int total;
    private int watershed;
    private int maxPage;
    private String search;
    private int currentPageNum;
    private List<Comments> comments;
    private boolean qnaDisabled;

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal() {
        return total;
    }

    public void setWatershed(int watershed) {
        this.watershed = watershed;
    }

    public int getWatershed() {
        return watershed;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }

    public int getMaxPage() {
        return maxPage;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getSearch() {
        return search;
    }

    public void setCurrentPageNum(int currentPageNum) {
        this.currentPageNum = currentPageNum;
    }

    public int getCurrentPageNum() {
        return currentPageNum;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setQnaDisabled(boolean qnaDisabled) {
        this.qnaDisabled = qnaDisabled;
    }

    public boolean getQnaDisabled() {
        return qnaDisabled;
    }

}