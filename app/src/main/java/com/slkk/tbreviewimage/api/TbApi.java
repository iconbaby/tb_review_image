package com.slkk.tbreviewimage.api;

import com.slkk.tbreviewimage.bean.JsonRootBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by slkk on 2017/11/18.
 */

public interface TbApi {
    @GET("?auctionNumId=38088752805&userNumId=775431765&currentPageNum=1&pageSize=20&rateType=3&orderType=sort_weight&attribute=&sku=&hasSku=false&folded=0&ua=098%23E1hv99vWvRhvU9CkvvvvvjiPPLsytj3vn2zwAjljPmPv1jtUPsLU1jYRPs5wgjYnRLurvpvEvvAk9k6rvCpG3QhvCvvhvvm5vpvhvvmv99yCvhQUZYyvCz7t9ExrV8tYVVz9afmAdcwuYExrQ8g78Boxfa1l5t1zpWsIlnQfV0Q4S47B9CkaU6bnDO2yjLyDZacEKOm65kx%2FljcGzCuOKphv8vvvvvCvpvvvvvmm86CvmPZvvUUdphvWvvvv9krvpv3Fvvmm86CvmVREvpvVmvvC9jXhuphvmvvv98%2FRsuStvphvC9vhvvCvpvGCvvLMMQvvRphvCvvvvvmCvpvW7D%2B6QVLw7Di4Ij5NRphvCvvvvvv%3D&_ksTS=1510993902912_2186&callback=jsonp_tbcrate_reviews_list")
    Observable<JsonRootBean> getImageUrl();

}
