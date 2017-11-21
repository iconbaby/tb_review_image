package com.slkk.tbreviewimage;

import android.graphics.Bitmap;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.slkk.tbreviewimage.api.TbApi;
import com.slkk.tbreviewimage.bean.AppendList;
import com.slkk.tbreviewimage.bean.Comments;
import com.slkk.tbreviewimage.bean.JsonRootBean;
import com.slkk.tbreviewimage.bean.Photos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private String auctionNumId = "38088752805";
    private String userNumId = "775431765";
    private String currentPageNum = "2";
    private String pageSize = "20";
    private String rateType = "3";
    private String orderType = "sort_weight";
    private String attribute = "";
    private String sku = "";
    private String hasSku = "false";
    private String folded = "0";
    private String ua = "098%23E1hv99vWvRhvU9CkvvvvvjiPPLsytj3vn2zwAjljPmPv1jt" +
            "UPsLU1jYRPs5wgjYnRLurvpvEvvAk9k6rvCpG3QhvCvvhvvm5vpvhvvmv99yCvhQUZ" +
            "YyvCz7t9ExrV8tYVVz9afmAdcwuYExrQ8g78Boxfa1l5t1zpWsIlnQfV0Q4S47B9Ck" +
            "aU6bnDO2yjLyDZacEKOm65kx%2FljcGzCuOKphv8vvvvvCvpvvvvvmm86CvmPZvvUU" +
            "dphvWvvvv9krvpv3Fvvmm86CvmVREvpvVmvvC9jXhuphvmvvv98%2FRsuStvphvC9v" +
            "hvvCvpvGCvvLMMQvvRphvCvvvvvmCvpvW7D%2B6QVLw7Di4Ij5NRphvCvvvvvv%3D";
    private String _ksTS = "1510993902912_2186";
    private String callback = "jsonp_tbcrate_reviews_list";

    Gson gson = new GsonBuilder()
            .setLenient()
            .create();
    private static final String TAG = "MainActivity";
    private Converter.Factory jsonConverter = GsonConverterFactory.create(gson);
    private CallAdapter.Factory rxjavaAdapterFactory = RxJava2CallAdapterFactory.create();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        loadData();


        downloadImage();
    }

    private void loadData() {

        Retrofit retrofit = new Retrofit.Builder()
                .client(new OkHttpClient())
                .baseUrl("https://rate.taobao.com/")
                .build();

        TbApi tbApi = retrofit.create(TbApi.class);
        Call<ResponseBody> imageUrlString = tbApi.getImageUrlString(auctionNumId, userNumId,
                currentPageNum, pageSize, rateType, orderType,
                attribute, sku, hasSku, folded, ua, _ksTS, callback);

        imageUrlString.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String string = response.body().string().trim();
                    String substring = string.substring(27, string.length() - 1);
                    Log.i(TAG, "onResponse: " + substring);

                    Gson gson = new Gson();
                    JsonRootBean jsonRootBean = gson.fromJson(substring, JsonRootBean.class);
                    List<Comments> comments = jsonRootBean.getComments();
                    for (Comments comment : comments) {
                        List<AppendList> appendList = comment.getAppendList();
                        for (AppendList append : appendList) {
                            List<Photos> photos = append.getPhotos();
                            for (Photos photo : photos) {
                                String url = photo.getUrl();
                                final String url2 = "http:" + url;
                                final long fileId = photo.getFileId();
                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            Bitmap bitmap = Glide.with(getApplicationContext())
                                                    .asBitmap()
                                                    .load(url2).
                                                            into(400, 400).get();
                                            saveImage(fileId, bitmap);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        } catch (ExecutionException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }).start();

                                Log.i(TAG, "onResponse: " + url);
                            }

                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.toString());
            }
        });


    }

    private void saveImage(long fieldId, Bitmap bitmap) {
        String absolutePath = Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
                .getAbsolutePath();
        Log.i(TAG, "saveImage: " + absolutePath);
        String imgFile = fieldId + ".jpg";
        File file = new File(absolutePath, imgFile);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);

    }

    private void downloadImage() {
        Retrofit retrofit = new Retrofit.Builder()
                .client(new OkHttpClient())
                .baseUrl("https://rate.taobao.com/")
                .addConverterFactory(jsonConverter)
                .addCallAdapterFactory(rxjavaAdapterFactory)
                .build();
        TbApi tbApi = retrofit.create(TbApi.class);
        tbApi.getImageUrl(auctionNumId, userNumId,
                currentPageNum, pageSize, rateType, orderType,
                attribute, sku, hasSku, folded, ua, _ksTS, callback)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(new Consumer<JsonRootBean>() {
                    @Override
                    public void accept(JsonRootBean jsonRootBean) throws Exception {
                        List<Comments> comments = jsonRootBean.getComments();
                        for (Comments comment : comments) {
                            List<AppendList> appendList = comment.getAppendList();
                            for (AppendList append : appendList) {
                                List<Photos> photos = append.getPhotos();
                                for (Photos photo : photos) {
                                    String url = photo.getUrl();
                                    final String url2 = "http:" + url;
                                    final long fileId = photo.getFileId();
                                    Log.i(TAG, "onResponse: " + url);
                                    Bitmap bitmap = Glide.with(getApplicationContext())
                                            .asBitmap()
                                            .load(url2)
                                            .into(400, 400)
                                            .get();
                                    saveImage(fileId, bitmap);

                                }

                            }
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.i(TAG, "accept: exception" + throwable.toString());
                    }
                });
    }
}
