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
public class ShareInfo {

    private boolean share;
    private String userNumIdBase64;
    private int reply;
    private int pic;
    private String lastReplyTime;
    public void setShare(boolean share) {
         this.share = share;
     }
     public boolean getShare() {
         return share;
     }

    public void setUserNumIdBase64(String userNumIdBase64) {
         this.userNumIdBase64 = userNumIdBase64;
     }
     public String getUserNumIdBase64() {
         return userNumIdBase64;
     }

    public void setReply(int reply) {
         this.reply = reply;
     }
     public int getReply() {
         return reply;
     }

    public void setPic(int pic) {
         this.pic = pic;
     }
     public int getPic() {
         return pic;
     }

    public void setLastReplyTime(String lastReplyTime) {
         this.lastReplyTime = lastReplyTime;
     }
     public String getLastReplyTime() {
         return lastReplyTime;
     }

}