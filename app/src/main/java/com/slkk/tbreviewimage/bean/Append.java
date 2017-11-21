/**
  * Copyright 2017 bejson.com 
  */
package com.slkk.tbreviewimage.bean;
import java.util.List;

/**
 * Auto-generated: 2017-11-18 16:0:24
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Append {

    private List<Photos> photos;
    private String content;
    private List<Video> videos;
    private String vicious;
    private Reply reply;
    private boolean show;
    private int dayAfterConfirm;
    private long appendId;
    public void setPhotos(List<Photos> photos) {
         this.photos = photos;
     }
     public List<Photos> getPhotos() {
         return photos;
     }

    public void setContent(String content) {
         this.content = content;
     }
     public String getContent() {
         return content;
     }

    public void setVideos(List<Video> videos) {
         this.videos = videos;
     }
     public List<Video> getVideos() {
         return videos;
     }

    public void setVicious(String vicious) {
         this.vicious = vicious;
     }
     public String getVicious() {
         return vicious;
     }

    public void setReply(Reply reply) {
         this.reply = reply;
     }
     public Reply getReply() {
         return reply;
     }

    public void setShow(boolean show) {
         this.show = show;
     }
     public boolean getShow() {
         return show;
     }

    public void setDayAfterConfirm(int dayAfterConfirm) {
         this.dayAfterConfirm = dayAfterConfirm;
     }
     public int getDayAfterConfirm() {
         return dayAfterConfirm;
     }

    public void setAppendId(long appendId) {
         this.appendId = appendId;
     }
     public long getAppendId() {
         return appendId;
     }

}