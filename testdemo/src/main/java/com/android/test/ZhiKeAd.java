//package com.android.test;
//
//import android.app.Activity;
//import android.support.annotation.NonNull;
//import android.view.ViewGroup;
//
//import com.kmxs.reader.ad.newad.BaseAd;
//import com.kmxs.reader.ad.newad.entity.AdDataEntity;
//import com.kmxs.reader.app.MainApplication;
//import com.kmxs.reader.network.ApiConnect;
//import com.kmxs.reader.network.DefaultApiConnect;
//
//import java.util.List;
//
//import javax.inject.Inject;
//
//import io.reactivex.Flowable;
//import io.reactivex.disposables.Disposable;
//import io.reactivex.functions.Consumer;
//
//public class ZhiKeAd extends BaseAd {
//
//    @Inject
//    ApiConnect apiConnect;
//
//    ZhiKeStrategy zhiKeStrategy;
//
//    boolean loadSuccess = false;
//
//    /** 获取直客广告数据 */
//    private Flowable<ZhiKeResponseEntity> getZhiKeAdResponse() {
//        DefaultApiConnect defaultApiConnect = MainApplication.mApplicationComponent.defaultApiConnect();
//        return apiConnect.connect(defaultApiConnect.getApiService().getZhiKeAdResponse());
//
//        /*Disposable disposable = defaultApiConnect.getApiService().getZhiKeAdResponse().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<ZhiKeResponseEntity>() {
//                    @Override
//                    public void accept(ZhiKeResponseEntity response) throws Exception {
//                        if (response.data != null) {
//
//                        }
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//
//                    }
//                });
//
//        return null;*/
//    }
//
//
//    /** 广告请求返回的数据 */
//    protected List<?> mAdData;
//
//    public ZhiKeAd(@NonNull Activity activity, @NonNull ViewGroup adContainer, @NonNull AdDataEntity adDataEntity) {
//        super(activity, adContainer, adDataEntity);
//    }
//
//    @Override
//    protected void initAdParameter() {
//
//    }
//
//    @Override
//    protected void loadAdData() {
//
//        if(loadSuccess) {
//            if(zhiKeStrategy != null) {
//                mAdData = zhiKeStrategy.getBestFitData();
//                if (mAdStatusListener != null && !mAdData.isEmpty()) {
//                    loadSuccess = true;
//                    mAdStatusListener.onLoadSuccess(mAdData);
//                }
//            } else {
//                loadSuccess = false;
//                requestAd();
//            }
//        } else {
//            loadSuccess = false;
//            requestAd();
//        }
//
//    }
//
//    @Override
//    protected void destoryAd() {
//
//    }
//
//    public List<?> getAdData() {
//        return mAdData;
//    }
//
//    private void requestAd(){
//        Disposable disposable = getZhiKeAdResponse().subscribe(new Consumer<ZhiKeResponseEntity>() {
//            @Override
//            public void accept(ZhiKeResponseEntity zhiKeResponseEntity) throws Exception {
//
//                if(zhiKeResponseEntity != null && zhiKeResponseEntity.data != null) {
//                    zhiKeStrategy = new ZhiKeStrategy(zhiKeResponseEntity);
//                    mAdData = zhiKeStrategy.getBestFitData();
//                    if (mAdStatusListener != null && !mAdData.isEmpty()) {
//                        loadSuccess = true;
//                        mAdStatusListener.onLoadSuccess(mAdData);
//                    }
//                }else {
//                    mAdData = null;
//                    if (mAdStatusListener != null) {
//                        mAdStatusListener.onLoadError();
//                    }
//                }
//            }
//        }, new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) throws Exception {
//                mAdData = null;
//                if (mAdStatusListener != null) {
//                    mAdStatusListener.onLoadError();
//                }
//            }
//        });
//    }
//}
