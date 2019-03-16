package com.android.testretrofit;

import java.util.Map;

import io.reactivex.Flowable;
import okhttp3.RequestBody;
import retrofit2.Call;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface DefaultServerApi {

    String BASE_URL = "http://101.1.1/api/";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .build();
    //http://101.1.1/api/

    //http://101.1.1/api/openapi.do
    @GET("openapi.do")                     //采用Get方法发送网络请求
    Call<ResponseBody> get();              //返回类型为Call<*>，*是接收数据的类
    //直接获得Responsebody中的内容


    /**
     * url 中带有参数
     * @param newid
     * @return
     */
    //http://101.1.1/api/new/1
    @GET("new/{newid}")
    Call<ResponseBody> path(@Path("newid") String newid);

    //http://101.1.1/api/new/1/ad
    @GET("new/{newid}/{type}")
    Call<ResponseBody> path1(@Path("newid") String newid, @Path("type") String type);

    /**
     * url后面带有参数, 多个参数后面多个query
     */
    //http://101.1.1/api/new/te?newid=1
    @GET("new/te")
    Call<ResponseBody> query(@Query("newid") String newid);


    /**
     * 一连串的参数就使用querymap
     * @param map
     * @return
     */
    //http://101.1.1/api/new/te?newid=1&type=o&pos=0
    @GET("new/te")
    Call<ResponseBody> queryMap(@QueryMap Map<String, String> map);


    //http://101.1.1/api/new/1
    @POST("new/{newid}")
    Call<ResponseBody> post(@Path("newid") String newid, @Field("field") String field);

    //http://101.1.1/api/new/1?id=1
    @POST("new/{newid}")
    Call<ResponseBody> post1(@Path("newid") String newid, @Query("id") String id, @Field("field") String field);

    //http://101.1.1/api/new/1
    @POST("new/{newid}")
    Call<RequestBody> post2(@Path("newid") String newid, @Body DefaultServerApi api);

}
