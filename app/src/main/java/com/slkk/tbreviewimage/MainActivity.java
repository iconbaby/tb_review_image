package com.slkk.tbreviewimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.slkk.tbreviewimage.api.TbApi;
import com.slkk.tbreviewimage.bean.Comments;
import com.slkk.tbreviewimage.bean.JsonRootBean;

import java.util.List;

import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Gson gson = new GsonBuilder()
            .setLenient()
            .create();
    private static final String TAG = "MainActivity";
    private Converter.Factory jsonConverter = GsonConverterFactory.create(gson);
    private CallAdapter.Factory rxjavaAdapterFactory = RxJava2CallAdapterFactory.create();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        downloadImage();
    }

    private void downloadImage() {
        Retrofit retrofit = new Retrofit.Builder()
                .client(new OkHttpClient())
                .baseUrl("https://rate.taobao.com/feedRateList.htm/")
//                .addConverterFactory(jsonConverter)
                .addCallAdapterFactory(rxjavaAdapterFactory)
                .build();
        TbApi tbApi = retrofit.create(TbApi.class);
        tbApi.getImageUrl()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(new Consumer<JsonRootBean>() {
                    @Override
                    public void accept(JsonRootBean jsonRootBean) throws Exception {
                        List<Comments> comments = jsonRootBean.getComments();
                        String promotionType = comments.get(0).getPromotionType();
                        Log.i(TAG, "accept: success"+promotionType);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.i(TAG, "accept: exception"+throwable.toString());
                    }
                });
    }
}
