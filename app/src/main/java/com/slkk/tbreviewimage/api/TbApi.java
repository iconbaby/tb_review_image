package com.slkk.tbreviewimage.api;

import com.slkk.tbreviewimage.bean.JsonRootBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by slkk on 2017/11/18.
 */

public interface TbApi {
    @GET("feedRateList.htm")
    Call<ResponseBody> getImageUrlString(@Query("auctionNumId") String auctionNumId,
                                         @Query("userNumId") String userNumId,
                                         @Query("currentPageNum") String currentPageNum,
                                         @Query("pageSize") String pageSize,
                                         @Query("rateType") String rateType,
                                         @Query("orderType") String orderType,
                                         @Query("attribute") String attribute,
                                         @Query("sku") String sku,
                                         @Query("hasSku") String hasSku,
                                         @Query("folded") String folded,
                                         @Query("ua") String ua,
                                         @Query("_ksTS") String ksTs,
                                         @Query("callback") String callback
    );

    @GET("feedRateList.htm")
    Observable<JsonRootBean> getImageUrl(@Query("auctionNumId") String auctionNumId,
                                         @Query("userNumId") String userNumId,
                                         @Query("currentPageNum") String currentPageNum,
                                         @Query("pageSize") String pageSize,
                                         @Query("rateType") String rateType,
                                         @Query("orderType") String orderType,
                                         @Query("attribute") String attribute,
                                         @Query("sku") String sku,
                                         @Query("hasSku") String hasSku,
                                         @Query("folded") String folded,
                                         @Query("ua") String ua,
                                         @Query("_ksTS") String ksTs,
                                         @Query("callback") String callback);


}
