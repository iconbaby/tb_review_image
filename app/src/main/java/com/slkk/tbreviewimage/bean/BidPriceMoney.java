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
public class BidPriceMoney {

    private int cent;
    private double amount;
    private String currencyCode;
    private int centFactor;
    private String displayUnit;
    private Currency currency;
    public void setCent(int cent) {
         this.cent = cent;
     }
     public int getCent() {
         return cent;
     }

    public void setAmount(double amount) {
         this.amount = amount;
     }
     public double getAmount() {
         return amount;
     }

    public void setCurrencyCode(String currencyCode) {
         this.currencyCode = currencyCode;
     }
     public String getCurrencyCode() {
         return currencyCode;
     }

    public void setCentFactor(int centFactor) {
         this.centFactor = centFactor;
     }
     public int getCentFactor() {
         return centFactor;
     }

    public void setDisplayUnit(String displayUnit) {
         this.displayUnit = displayUnit;
     }
     public String getDisplayUnit() {
         return displayUnit;
     }

    public void setCurrency(Currency currency) {
         this.currency = currency;
     }
     public Currency getCurrency() {
         return currency;
     }

}