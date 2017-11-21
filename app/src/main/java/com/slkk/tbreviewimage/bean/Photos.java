/**
 * Copyright 2017 bejson.com
 */
package com.slkk.tbreviewimage.bean;

/**
 * Auto-generated: 2017-11-18 16:0:24
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Photos {

    private long fileId;
    private long receiveId;
    private String thumbnail;
    private int status;
    private String url;

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public long getFileId() {
        return fileId;
    }

    public void setReceiveId(long receiveId) {
        this.receiveId = receiveId;
    }

    public long getReceiveId() {
        return receiveId;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}