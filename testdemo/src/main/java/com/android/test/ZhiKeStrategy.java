package com.android.test;

import android.text.TextUtils;

import com.android.modulcommons.utils.DVLogUtils;
import com.android.testdagger.AppApplication;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ZhiKeStrategy {

    public static Gson gson = new GsonBuilder().serializeNulls().enableComplexMapKeySerialization().create();
    
    ZhiKeResponseEntity zhiKeResponseEntity;

    List<ApiFeedAd> localList = new ArrayList<>();
    /** 获取数据游标的位置 */
    int dataPos = 0;

    /** 保存的服务端返回的满足次数条件的所有数据 */
    List<ApiFeedAd> networkList = new ArrayList<>();

    // 0.
    public ZhiKeStrategy(ZhiKeResponseEntity zhiKeResponseEntity) {
        this.zhiKeResponseEntity = zhiKeResponseEntity;


        if(zhiKeResponseEntity != null && zhiKeResponseEntity.data != null
                && zhiKeResponseEntity.data.list != null && zhiKeResponseEntity.data.list.size() > 0){

            initList(zhiKeResponseEntity.data.list);
        }

    }

    // 1. 首先要排除显示次数满了的
    public void initList(List<ApiFeedAd> tempList){
        if(tempList == null || tempList.size() == 0) {
            return;
        }
        localList.clear();
        networkList.clear();
        dataPos = 0;
        for(ApiFeedAd feedAd : tempList) {

            if(!isFeedAdCountMax(feedAd)){
                localList.add(feedAd);
                networkList.add(feedAd);
            }
        }
    }

    /**
     * 返回请求的满足条件的数据
     * @return
     */
    public List<ApiFeedAd> getBestFitData(){
        List<ApiFeedAd> list = new ArrayList<>();

        if(localList == null || localList.size() == 0) {
            return list;
        }

        ApiFeedAd feedAd = localList.get(dataPos);
        if(dataPos == 0 && isFeedAdInLimit(feedAd)) {
            return list;
        }
        if(!isFeedAdCountMax(feedAd) && !isFeedAdInLimit(feedAd)) {
            countDataPos();
            list.add(feedAd);
        } else {
            countDataPos();
            if(dataPos == 0) {
                return list;
            }
            return getBestFitData();
        }
        return list;
    }

    private void countDataPos(){
        dataPos ++;
        DVLogUtils.et("dataPos =  " + dataPos);
        if(dataPos >= localList.size()) {
            dataPos = 0;
        }
    }


    /**
     * 获取直客广告下载时保存的包名信息
     * @return
     */
    public static ZhiKeSpInfos.ZhiKeInstallPkg getZhiKeInstallPkg() {
        ZhiKeSpInfos.ZhiKeInstallPkg zhiKeInstallPkg = null;

        String spstring = AppApplication.getString(Constants.SHARE_PREFER.KEY_AD_ZHIKE_PACKAGENAME, "");
        try {
            zhiKeInstallPkg = gson.fromJson(spstring, ZhiKeSpInfos.ZhiKeInstallPkg.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        if(zhiKeInstallPkg == null) {
            zhiKeInstallPkg = new ZhiKeSpInfos.ZhiKeInstallPkg();
            zhiKeInstallPkg.setPackages(new ArrayList<String>());
        }

        return zhiKeInstallPkg;
    }

    /**
     * 添加一个包名
     * @param packageName
     */
    public static void saveZhiKeInstallPkg(String packageName){
        if(TextUtils.isEmpty(packageName)) {
            return;
        }
        ZhiKeSpInfos.ZhiKeInstallPkg zhiKeInstallPkg = getZhiKeInstallPkg();
        zhiKeInstallPkg.getPackages().add(packageName);
        saveZhiKeInstallPkg(zhiKeInstallPkg);
    }

    /**
     * 删除一个包名
     * @param packageName
     */
    public static void removeZhiKeInstallPkg(String packageName){
        if(TextUtils.isEmpty(packageName)) {
            return;
        }
        ZhiKeSpInfos.ZhiKeInstallPkg zhiKeInstallPkg = getZhiKeInstallPkg();
        List<String> list = zhiKeInstallPkg.getPackages();
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
            String temp = iterator.next();
            if(packageName.equals(temp)){
                iterator.remove();
            }
        }
        zhiKeInstallPkg.setPackages(list);

        saveZhiKeInstallPkg(zhiKeInstallPkg);
    }

    /**
     * 保存信息
     * @param zhiKeInstallPkg
     */
    public static void saveZhiKeInstallPkg(ZhiKeSpInfos.ZhiKeInstallPkg zhiKeInstallPkg){

        if (null == zhiKeInstallPkg) {
            return;
        }

        // 保存数据
        String screenAdJson = null;
        try {
            screenAdJson = gson.toJson(zhiKeInstallPkg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null == screenAdJson) {
            screenAdJson = "";
        }
        AppApplication.saveString(Constants.SHARE_PREFER.KEY_AD_ZHIKE_PACKAGENAME, screenAdJson);
    }

    /**
     * 判断一个包名是否存在
     * @param packageName
     */
    public static boolean hasZhiKeInstallPkg(String packageName){
        if(TextUtils.isEmpty(packageName)) {
            return false;
        }
        ZhiKeSpInfos.ZhiKeInstallPkg zhiKeInstallPkg = getZhiKeInstallPkg();
        List<String> list = zhiKeInstallPkg.getPackages();
        if(list.contains(packageName)) {
            return true;
        }
        return false;
    }

    /**
     * 获取直客广告显示次数等信息
     * @return
     */
    public static ZhiKeSpInfos.ZhikeSpAdInfoList getZhikeSpAdInfoList() {
        ZhiKeSpInfos.ZhikeSpAdInfoList spAdInfo = null;

        String zhikeInstallPkg = AppApplication.getString(Constants.SHARE_PREFER.KEY_AD_ZHIKE_FEED_AD_INFO, "");
        DVLogUtils.dt(zhikeInstallPkg);
        try {
            spAdInfo = gson.fromJson(zhikeInstallPkg, ZhiKeSpInfos.ZhikeSpAdInfoList.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }

        if(spAdInfo != null) {
            String tempTime = spAdInfo.getSaveTimeValue();
            if(isExpired(tempTime)) {
                // 数据过期，则删除之前的数据
                AppApplication.saveString(Constants.SHARE_PREFER.KEY_AD_ZHIKE_FEED_AD_INFO, "");
                return null;
            }
        }

        return spAdInfo;
    }


    /**
     * 保存单个广告信息
     * 比如展示次数，展示时间变化
     * @param apiFeedAd
     */
    public static void saveZhikeFeedAdInfo(ApiFeedAd apiFeedAd){

        if (null == apiFeedAd) {
            return;
        }
        ZhiKeSpInfos.ZhikeSpAdInfoList zhikeSpAdInfoList = getZhikeSpAdInfoList();
        if(zhikeSpAdInfoList == null) {
            zhikeSpAdInfoList = new ZhiKeSpInfos.ZhikeSpAdInfoList();
            zhikeSpAdInfoList.setSaveTimeValue(startOfToday() + ":" + endOfToday());
            zhikeSpAdInfoList.setZhikeFeedAdInfos(new ArrayList<ZhiKeSpInfos.ZhikeFeedAdInfo>());
        }
        ZhiKeSpInfos.ZhikeFeedAdInfo tempFeedAdInfo = null;
        for(ZhiKeSpInfos.ZhikeFeedAdInfo feedAdInfo : zhikeSpAdInfoList.getZhikeFeedAdInfos()) {
            if(feedAdInfo.getAdv_id().equals(apiFeedAd.getAdv_id())) {
                tempFeedAdInfo = feedAdInfo;
                tempFeedAdInfo.setInterval_time(System.currentTimeMillis());
                tempFeedAdInfo.setShow_frequency(tempFeedAdInfo.getShow_frequency() + 1);
                break;
            }
        }
        if(tempFeedAdInfo == null){
            tempFeedAdInfo = new ZhiKeSpInfos.ZhikeFeedAdInfo();
            tempFeedAdInfo.setAdv_id(apiFeedAd.getAdv_id());
            tempFeedAdInfo.setShow_frequency(1);
            tempFeedAdInfo.setInterval_time(System.currentTimeMillis());
            zhikeSpAdInfoList.getZhikeFeedAdInfos().add(tempFeedAdInfo);
        }

        saveZhikeSpAdInfoList(zhikeSpAdInfoList);

    }

    /**
     * 保存单个广告信息
     * 比如展示次数，展示时间变化
     * @deprecated
     * @param zhiKeInstallPkg
     */
    private static void saveZhikeFeedAdInfo(ZhiKeSpInfos.ZhikeFeedAdInfo zhiKeInstallPkg){

        if (null == zhiKeInstallPkg) {
            return;
        }
        ZhiKeSpInfos.ZhikeSpAdInfoList zhikeSpAdInfoList = getZhikeSpAdInfoList();
        if(zhikeSpAdInfoList == null) {
            zhikeSpAdInfoList = new ZhiKeSpInfos.ZhikeSpAdInfoList();
            zhikeSpAdInfoList.setSaveTimeValue(startOfToday() + ":" + endOfToday());
            zhikeSpAdInfoList.setZhikeFeedAdInfos(new ArrayList<ZhiKeSpInfos.ZhikeFeedAdInfo>());
        }
        zhikeSpAdInfoList.getZhikeFeedAdInfos().add(zhiKeInstallPkg);

        saveZhikeSpAdInfoList(zhikeSpAdInfoList);
    }


    /**
     * 保存所有广告信息
     * @param zhiKeInstallPkg
     */
    public static void saveZhikeSpAdInfoList(ZhiKeSpInfos.ZhikeSpAdInfoList zhiKeInstallPkg){

        if (null == zhiKeInstallPkg) {
            return;
        }

        // 保存数据
        String screenAdJson = null;
        try {
            screenAdJson = gson.toJson(zhiKeInstallPkg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null == screenAdJson) {
            screenAdJson = "";
        }
        AppApplication.saveString(Constants.SHARE_PREFER.KEY_AD_ZHIKE_FEED_AD_INFO, screenAdJson);
    }

    /**
     * 广告是否达到了最大显示次数
     * @param feedAd
     * @return
     */
    public static boolean isFeedAdCountMax(ApiFeedAd feedAd) {
        ZhiKeSpInfos.ZhikeSpAdInfoList zhikeSpAdInfoList = getZhikeSpAdInfoList();
        if(zhikeSpAdInfoList == null || zhikeSpAdInfoList.getZhikeFeedAdInfos() == null
                || zhikeSpAdInfoList.getZhikeFeedAdInfos().size() == 0) {
            return false;
        }

        for(ZhiKeSpInfos.ZhikeFeedAdInfo zhikeFeedAdInfo : zhikeSpAdInfoList.getZhikeFeedAdInfos()) {

            if(feedAd.getAdv_id().equals(zhikeFeedAdInfo.getAdv_id())) {
                //保存在本地的展示次数 》 配置的次数
                if(zhikeFeedAdInfo.getShow_frequency() >= feedAd.getShow_frequency()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 广告是否在限定的时间间隔内
     * true 说明 还在规定的限制时间内，比如：设置的时间是5分钟，true代表到目前还没有超过5分钟
     * @param feedAd
     * @return
     */
    public static boolean isFeedAdInLimit(ApiFeedAd feedAd) {
        ZhiKeSpInfos.ZhikeSpAdInfoList zhikeSpAdInfoList = getZhikeSpAdInfoList();
        if(zhikeSpAdInfoList == null || zhikeSpAdInfoList.getZhikeFeedAdInfos() == null
                || zhikeSpAdInfoList.getZhikeFeedAdInfos().size() == 0) {
            return false;
        }

        for(ZhiKeSpInfos.ZhikeFeedAdInfo zhikeFeedAdInfo : zhikeSpAdInfoList.getZhikeFeedAdInfos()) {

            if(feedAd.getAdv_id().equals(zhikeFeedAdInfo.getAdv_id())) {
                long currentTime = System.currentTimeMillis();
                //保存在本地的时间 跟当前时间时间差 进行对比
                if((currentTime - zhikeFeedAdInfo.getInterval_time()) < feedAd.getInterval_time() * 1000 * 60) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *  跟当前的时间进行对比，判断时间是不是过期
     *      strs[0] 代表当天起始时间戳
     *      strs[1] 代表当天结束时间戳
     * @param
     */
    private static boolean isExpired(String todayShowTimes) {

        if (TextUtils.isEmpty(todayShowTimes)) {
            return false;
        }

        long currentTime = System.currentTimeMillis() / 1000;
        long startTime = 0;
        long endTime = 0;

        String[] strs = new String[2];

        String[] tmpArrs2 = todayShowTimes.split(":");
        if (null != tmpArrs2 && 2 == tmpArrs2.length) {
            strs[0] = tmpArrs2[0]; // 获取当天起始时间戳
            strs[1] = tmpArrs2[1]; // 获取当天结束时间戳
        }

        try {
            startTime = Long.valueOf(strs[0]);
            endTime = Long.valueOf(strs[1]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        if (currentTime >= startTime && currentTime <= endTime) {
            // 当天的数据,时间是在有效期内
            return false;
        } else {
            // 数据过期，
            return true;
        }
    }


    public static long startOfToday() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        Date date = calendar.getTime();
        return date.getTime() / 1000L;
    }

    public static long endOfToday() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, 999);
        Date date = calendar.getTime();
        return date.getTime() / 1000L;
    }

}
