package com.tester.cases;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tester.dao.TestResultDao;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KuaiShouV1Test {

    @Autowired
    private TestResultDao testResultDao;

    @Test
    public void hot_feed() throws IOException {
        //获取热点推荐
        String result = "";
        String url = "http://47.114.196.142:5000/api/ks_v1/hot_feed?page=1&page_size=10";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code, Statuscode;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
        } catch (Exception e) {
            testResultDao.insertResult("KuaiShouV1", 500, new Date(), "测试异常，e:" + e.getMessage(), url, "hot_feed", result);
            return;
        }
        if (Statuscode != 200) {
            testResultDao.insertResult("KuaiShouV1", Statuscode, new Date(), "http请求错误", url, "hot_feed", result);
        } else if (code != 0) {
            testResultDao.insertResult("KuaiShouV1", code, new Date(), "业务请求错误", url, "hot_feed", result);
        } else {
            testResultDao.insertResult("KuaiShouV1", 200, new Date(), "成功", url, "hot_feed", result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void nearby_feed() throws IOException {
        //获取同城推荐
        String result = "";
        String url = "http://47.114.196.142:5000/api/ks_v1/nearby_feed?page=1&page_size=20&lon=113.712143&lat=34.593717";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code, Statuscode;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
        } catch (Exception e) {
            testResultDao.insertResult("KuaiShouV1", 500, new Date(), "测试异常，e:" + e.getMessage(), url, "nearby_feed", result);
            return;
        }
        if (Statuscode != 200) {
            testResultDao.insertResult("KuaiShouV1", Statuscode, new Date(), "http请求错误", url, "nearby_feed", result);
        }
        else if (code != 0) {
            testResultDao.insertResult("KuaiShouV1", code, new Date(), "业务请求错误", url, "nearby_feed", result);
        }
        else {
            testResultDao.insertResult("KuaiShouV1", 200, new Date(), "成功", url, "nearby_feed", result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void user_info() throws IOException {
        //获取用户信息(被检测频率较高)
        String result = "";
        String url = "http://47.114.196.142:5000/api/ks_v1/user_info?user_id=1391625066";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code, Statuscode;
        Object msg;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
            msg = jsonObject.get("msg");
            System.out.println(msg);
        } catch (Exception e) {
            testResultDao.insertResult("KuaiShouV1", 500, new Date(), "测试异常，e:" + e.getMessage(), url, "user_info", result);
            return;
        }
        if (Statuscode != 200) {
            testResultDao.insertResult("KuaiShouV1", Statuscode, new Date(), "http请求错误", url, "user_info", result);
        }
        else if (msg.toString().contains("代理IP已过期,本次请求失败")) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "代理IP已过期,本次请求失败", url, "user_info", result);
        }
        else if (msg.toString().contains("Redis内可用设备池为空")) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "Redis内可用设备池为空", url, "user_info", result);
        }
        else if (msg.toString().contains("重试超过阈值")) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "重试超过阈值", url, "user_info", result);
        }
        else if (code != 0) {
            testResultDao.insertResult("KuaiShouV1", code, new Date(), "业务请求错误", url, "user_info", result);
        }
        else {
            testResultDao.insertResult("KuaiShouV1", 200, new Date(), "成功", url, "user_info", result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void user_video() throws IOException {
        //获取用户视频列表(返回的不是目标用户的视频)
        String result = "";
        String url = "http://47.114.196.142:5000/api/ks_v1/user_video?user_id=1391625066&page_size=10";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code, Statuscode;
        Object msg;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
            msg = jsonObject.get("msg");
            System.out.println(msg);
        } catch (Exception e) {
            testResultDao.insertResult("KuaiShouV1", 500, new Date(), "测试异常，e:" + e.getMessage(), url, "user_video", result);
            return;
        }
        if (msg.toString().contains("请求失败,返回数据为脏数据")) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "请求失败,返回数据为脏数据", url, "user_video", result);
        }
        else if (msg.toString().contains("代理IP已过期,本次请求失败")) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "代理IP已过期,本次请求失败", url, "user_video", result);
        }
        else if (msg.toString().contains("Redis内可用设备池为空")) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "Redis内可用设备池为空", url, "user_video", result);
        }
        else if (msg.toString().contains("重试超过阈值")) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "重试超过阈值", url, "user_video", result);
        }
        else if (Statuscode != 200) {
            testResultDao.insertResult("KuaiShouV1", Statuscode, new Date(), "http请求错误", url, "user_video", result);
        }
        else if (code != 0) {
            testResultDao.insertResult("KuaiShouV1", code, new Date(), "业务请求错误", url, "user_video", result);
        }
        else {
            testResultDao.insertResult("KuaiShouV1", 200, new Date(), "成功", url, "user_video", result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void video_comment() throws IOException {
        //获取视频评论列表
        String result = "";
        String url = "http://47.114.196.142:5000/api/ks_v1/video_comment?user_id=191674858&photo_id=5248945383907780546&page_size=10";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code, Statuscode;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
        } catch (Exception e) {
            testResultDao.insertResult("KuaiShouV1", 500, new Date(), "测试异常，e:" + e.getMessage(), url, "video_comment", result);
            return;
        }
        if (Statuscode != 200) {
            testResultDao.insertResult("KuaiShouV1", Statuscode, new Date(), "http请求错误", url, "video_comment", result);
        } else if (code != 0) {
            testResultDao.insertResult("KuaiShouV1", code, new Date(), "业务请求错误", url, "video_comment", result);
        } else {
            testResultDao.insertResult("KuaiShouV1", 200, new Date(), "成功", url, "video_comment", result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void video_detail() throws IOException {
        //获取视频信息
        String result = "";
        String url = "http://47.114.196.142:5000/api/ks_v1/video_detail?photo_id=5248945383907780546";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code, Statuscode;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
        } catch (Exception e) {
            testResultDao.insertResult("KuaiShouV1", 500, new Date(), "测试异常，e:" + e.getMessage(), url, "video_detail", result);
            return;
        }
        if (Statuscode != 200) {
            testResultDao.insertResult("KuaiShouV1", Statuscode, new Date(), "http请求错误", url, "video_detail", result);
        }
        else if (code != 0) {
            testResultDao.insertResult("KuaiShouV1", code, new Date(), "业务请求错误", url, "video_detail", result);
        }
        else {
            testResultDao.insertResult("KuaiShouV1", 200, new Date(), "成功", url, "video_detail", result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void share_video() throws IOException {
        //获取分享视频链接信息
        String result = "";
        String url = "http://47.114.196.142:5000/api/ks_v1/share_video?share_url=http://kphbeijing.m.chenzhongtech.com/s/Qsh970xL";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code, Statuscode;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
        } catch (Exception e) {
            testResultDao.insertResult("KuaiShouV1", 500, new Date(), "测试异常，e:" + e.getMessage(), url, "share_video", result);
            return;
        }
        if (Statuscode != 200) {
            testResultDao.insertResult("KuaiShouV1", Statuscode, new Date(), "http请求错误", url, "share_video", result);
        }
        else if (code != 0) {
            testResultDao.insertResult("KuaiShouV1", code, new Date(), "业务请求错误", url, "share_video", result);
        }
        else {
            testResultDao.insertResult("KuaiShouV1", 200, new Date(), "成功", url, "share_video", result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void product_list() throws IOException {
        //获取小店商品
        String result = "";
        String url = "http://47.114.196.142:5000/api/ks_v1/product_list?user_id=976786976&page=1";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code, Statuscode;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
        } catch (Exception e) {
            testResultDao.insertResult("KuaiShouV1", 500, new Date(), "测试异常，e:" + e.getMessage(), url, "product_list", result);
            return;
        }
        if (Statuscode != 200) {
            testResultDao.insertResult("KuaiShouV1", Statuscode, new Date(), "http请求错误", url, "product_list", result);
        }
        else if (code != 0) {
            testResultDao.insertResult("KuaiShouV1", code, new Date(), "业务请求错误", url, "product_list", result);
        }
        else {
            testResultDao.insertResult("KuaiShouV1", 200, new Date(), "成功", url, "product_list", result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_live_info() throws IOException {
        //获取直播简介
        String result = "";
        String url = "http://47.114.196.142:5000/api/ks_v1/get_live_info?user_id=1143032926";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code, Statuscode;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
        } catch (Exception e) {
            testResultDao.insertResult("KuaiShouV1", 500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_live_info", result);
            return;
        }
        if (Statuscode != 200) {
            testResultDao.insertResult("KuaiShouV1", Statuscode, new Date(), "http请求错误", url, "get_live_info", result);
        }
        else if (code != 0) {
            testResultDao.insertResult("KuaiShouV1", code, new Date(), "业务请求错误", url, "get_live_info", result);
        }
        else {
            testResultDao.insertResult("KuaiShouV1", 200, new Date(), "成功", url, "get_live_info", result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    /*
        @Test
        public void get_live_goods() throws IOException {
            //获取直播小黄车商品 (需要登陆)
            //获取liveStreamId
            String zhiboresult = "";
            String zhibourl = "http://47.114.196.142:5000/api/ks_v1/get_live_square_refresh";
            HttpGet zhiboget = new HttpGet(zhibourl);
            HttpClient zhiboclient = HttpClientBuilder.create().build();
            Integer zhibocode,zhiboStatuscode;
            JSONObject zhibodata1;
            JSONObject zhibodata2;
            JSONArray zhibofeeds = new JSONArray();
            String liveStreamId = "";
            try{
                HttpResponse zhiboresponse = zhiboclient.execute(zhiboget);
                zhiboresult = EntityUtils.toString(zhiboresponse.getEntity(), "utf-8");
                zhiboStatuscode = zhiboresponse.getStatusLine().getStatusCode();
                JSONObject jsonObject = JSONObject.parseObject(zhiboresult);

                zhibocode = jsonObject.getInteger("code");
                zhibodata1 = jsonObject.getJSONObject("data");
                zhibodata2 = zhibodata1.getJSONObject("data");
                zhibofeeds = zhibodata2.getJSONArray("feeds");


                Map<String, JSONObject> feedMap = zhibofeeds.stream().map(obj -> {
                    if (obj instanceof JSONObject) {
                        return (JSONObject) obj;
                    } else {
                        return JSONObject.parseObject(obj.toString());
                    }
                }).collect(Collectors.toMap(feed -> feed.getString("liveStreamId"), feed -> feed));
                JSONObject feedObj = feedMap.get(1);
                liveStreamId = feedMap.keySet().iterator().next();

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            String result = "";
            String url = "http://47.114.196.142:5000/api/ks_v1/get_live_goods?live_stream_id=" + liveStreamId;
            HttpGet get = new HttpGet(url);
            HttpClient client = HttpClientBuilder.create().build();
            Integer code,Statuscode;
            try {
                HttpResponse response = client.execute(get);
                result = EntityUtils.toString(response.getEntity(), "utf-8");
                Statuscode = response.getStatusLine().getStatusCode();
                JSONObject jsonObject = JSONObject.parseObject(result);
                code = jsonObject.getInteger("code");
            } catch (Exception e) {
                testResultDao.insertResult("KuaiShouV1",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_live_goods",result);
                return;
            }
            if (Statuscode != 200){
                testResultDao.insertResult("KuaiShouV1",Statuscode, new Date(), "http请求错误", url,"get_live_goods",result);

            }
            else if (code != 0) {
                testResultDao.insertResult("KuaiShouV1",code, new Date(), "业务请求错误", url,"get_live_goods",result);
            }
            else if (liveStreamId == null) {
                testResultDao.insertResult("KuaiShouV1",-200, new Date(), "liveStreamId未取到", url,"get_live_users",result);

            }
            else {
                testResultDao.insertResult("KuaiShouV1",200, new Date(), "成功", url,"get_live_goods",result);
                System.out.println("成功，" + "请求url：" + url);
            }

        }
        */
    @Test
    public void get_live_users() throws IOException {
        //获取前30名直播观看用户
        /*获取liveStreamId
         */
        String zhiboresult = "";
        String zhibourl = "http://47.114.196.142:5000/api/ks_v1/get_live_square_refresh";
        HttpGet zhiboget = new HttpGet(zhibourl);
        HttpClient zhiboclient = HttpClientBuilder.create().build();
        Integer zhibocode, zhiboStatuscode;
        JSONObject zhibodata1;
        JSONObject zhibodata2;
        JSONArray zhibofeeds = new JSONArray();
        String liveStreamId = "";
        try {
            HttpResponse zhiboresponse = zhiboclient.execute(zhiboget);
            zhiboresult = EntityUtils.toString(zhiboresponse.getEntity(), "utf-8");
            zhiboStatuscode = zhiboresponse.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(zhiboresult);

            zhibocode = jsonObject.getInteger("code");
            zhibodata1 = jsonObject.getJSONObject("data");
            zhibodata2 = zhibodata1.getJSONObject("data");
            zhibofeeds = zhibodata2.getJSONArray("feeds");

            Map<String, JSONObject> feedMap = zhibofeeds.stream().map(obj -> {
                if (obj instanceof JSONObject) {
                    return (JSONObject) obj;
                } else {
                    return JSONObject.parseObject(obj.toString());
                }
            }).collect(Collectors.toMap(feed -> feed.getString("liveStreamId"), feed -> feed));
            JSONObject feedObj = feedMap.get(1);
            liveStreamId = feedMap.keySet().iterator().next();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String result = "";
        String url = "http://47.114.196.142:5000/api/ks_v1/get_live_users?live_stream_id=" + liveStreamId;
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code, Statuscode;
        Object msg;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
            msg = jsonObject.get("msg");

        } catch (Exception e) {
            testResultDao.insertResult("KuaiShouV1", 500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_live_users", result);
            return;
        }
        if (msg.toString().contains("参数异常")) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "参数异常", url, "get_live_top_users", result);
        }
        else if (msg.toString().contains("代理IP已过期,本次请求失败")) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "代理IP已过期,本次请求失败", url, "get_live_top_users", result);
        }
        else if (msg.toString().contains("签名验证失败")) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "签名验证失败", url, "get_live_top_users", result);
        }
        else if (msg.toString().contains("重试超过阈值")) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "重试超过阈值", url, "get_live_top_users", result);
        }
        else if (liveStreamId == null) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "liveStreamId未取到", url, "get_live_users", result);
        }
        else if (Statuscode != 200) {
            testResultDao.insertResult("KuaiShouV1", Statuscode, new Date(), "http请求错误", url, "get_live_users", result);
        }
        else if (code != 0) {
            testResultDao.insertResult("KuaiShouV1", code, new Date(), "业务请求错误", url, "get_live_users", result);
        }
        else {
            testResultDao.insertResult("KuaiShouV1", 200, new Date(), "成功", url, "get_live_users", result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_live_top_users() throws IOException {
        //获取前100名直播观看用户
        /*获取liveStreamId
         */
        String zhiboresult = "";
        String zhibourl = "http://47.114.196.142:5000/api/ks_v1/get_live_square_refresh";
        HttpGet zhiboget = new HttpGet(zhibourl);
        HttpClient zhiboclient = HttpClientBuilder.create().build();
        Integer zhibocode, zhiboStatuscode;
        JSONObject zhibodata1;
        JSONObject zhibodata2;
        JSONArray zhibofeeds = new JSONArray();
        String liveStreamId = "";
        try {
            HttpResponse zhiboresponse = zhiboclient.execute(zhiboget);
            zhiboresult = EntityUtils.toString(zhiboresponse.getEntity(), "utf-8");
            zhiboStatuscode = zhiboresponse.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(zhiboresult);

            zhibocode = jsonObject.getInteger("code");
            zhibodata1 = jsonObject.getJSONObject("data");
            zhibodata2 = zhibodata1.getJSONObject("data");
            zhibofeeds = zhibodata2.getJSONArray("feeds");

            Map<String, JSONObject> feedMap = zhibofeeds.stream().map(obj -> {
                if (obj instanceof JSONObject) {
                    return (JSONObject) obj;
                } else {
                    return JSONObject.parseObject(obj.toString());
                }
            }).collect(Collectors.toMap(feed -> feed.getString("liveStreamId"), feed -> feed));
            JSONObject feedObj = feedMap.get(1);
            liveStreamId = feedMap.keySet().iterator().next();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        String result = "";
        String url = "http://47.114.196.142:5000/api/ks_v1/get_live_district_rank?live_stream_id=" + liveStreamId;
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code, Statuscode;
        Object msg;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
            msg = jsonObject.get("msg");

        } catch (Exception e) {
            testResultDao.insertResult("KuaiShouV1", 500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_live_top_users", result);
            return;
        }
        if (msg.toString().contains("参数异常")) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "参数异常", url, "get_live_top_users", result);
        }
        else if (msg.toString().contains("代理IP已过期,本次请求失败")) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "代理IP已过期,本次请求失败", url, "get_live_top_users", result);
        }
        else if (msg.toString().contains("签名验证失败")) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "签名验证失败", url, "get_live_top_users", result);
        }
        else if (msg.toString().contains("重试超过阈值")) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "重试超过阈值", url, "get_live_top_users", result);
        }
        else if (liveStreamId == null) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "liveStreamId未取到", url, "get_live_top_users", result);
        }
        else if (Statuscode != 200) {
            testResultDao.insertResult("KuaiShouV1", Statuscode, new Date(), "http请求错误", url, "get_live_top_users", result);
        }
        else if (code != 0) {
            testResultDao.insertResult("KuaiShouV1", code, new Date(), "业务请求错误", url, "get_live_top_users", result);
        }
        else {
            testResultDao.insertResult("KuaiShouV1", 200, new Date(), "成功", url, "get_live_top_users", result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_live_square_refresh() throws IOException {
        //获取直播广场刷新列表
        String result = "";
        String url = "http://47.114.196.142:5000/api/ks_v1/get_live_square_refresh";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code, Statuscode;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
        } catch (Exception e) {
            testResultDao.insertResult("KuaiShouV1", 500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_live_square_refresh", result);
            return;
        }
        if (Statuscode != 200) {
            testResultDao.insertResult("KuaiShouV1", Statuscode, new Date(), "http请求错误", url, "get_live_square_refresh", result);
        }
        else if (code != 0) {
            testResultDao.insertResult("KuaiShouV1", code, new Date(), "业务请求错误", url, "get_live_square_refresh", result);
        }
        else {
            testResultDao.insertResult("KuaiShouV1", 200, new Date(), "成功", url, "get_live_square_refresh", result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_live_square_list() throws IOException {
        //获取直播广场分页列表
        String result = "";
        String url = "http://47.114.196.142:5000/api/ks_v1/get_live_square_list?pcursor=8";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code, Statuscode;
        Object msg;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
            msg = jsonObject.get("msg");

        } catch (Exception e) {
            testResultDao.insertResult("KuaiShouV1", 500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_live_square_list", result);
            return;
        }
        if (msg.toString().contains("参数异常")) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "参数异常", url, "get_live_square_list", result);
        }
        else if (msg.toString().contains("代理IP已过期,本次请求失败")) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "代理IP已过期,本次请求失败", url, "get_live_square_list", result);
        }
        else if (msg.toString().contains("签名验证失败")) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "签名验证失败", url, "get_live_square_list", result);
        }
        else if (msg.toString().contains("重试超过阈值")) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "重试超过阈值", url, "get_live_square_list", result);
        }
        else if (Statuscode != 200) {
            testResultDao.insertResult("KuaiShouV1", Statuscode, new Date(), "http请求错误", url, "get_live_square_list", result);
        }
        else if (code != 0) {
            testResultDao.insertResult("KuaiShouV1", code, new Date(), "业务请求错误", url, "get_live_square_list", result);
        }
        else {
            testResultDao.insertResult("KuaiShouV1", 200, new Date(), "成功", url, "get_live_square_list", result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_live_district_rank() throws IOException {
        //获取直播地区排名
        /*获取liveStreamId
         */
        String zhiboresult = "";
        String zhibourl = "http://47.114.196.142:5000/api/ks_v1/get_live_square_refresh";
        HttpGet zhiboget = new HttpGet(zhibourl);
        HttpClient zhiboclient = HttpClientBuilder.create().build();
        Integer zhibocode, zhiboStatuscode;
        JSONObject zhibodata1;
        JSONObject zhibodata2;
        JSONArray zhibofeeds = new JSONArray();
        String liveStreamId = "";
        try {
            HttpResponse zhiboresponse = zhiboclient.execute(zhiboget);
            zhiboresult = EntityUtils.toString(zhiboresponse.getEntity(), "utf-8");
            zhiboStatuscode = zhiboresponse.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(zhiboresult);

            zhibocode = jsonObject.getInteger("code");
            zhibodata1 = jsonObject.getJSONObject("data");
            zhibodata2 = zhibodata1.getJSONObject("data");
            zhibofeeds = zhibodata2.getJSONArray("feeds");

            Map<String, JSONObject> feedMap = zhibofeeds.stream().map(obj -> {
                if (obj instanceof JSONObject) {
                    return (JSONObject) obj;
                } else {
                    return JSONObject.parseObject(obj.toString());
                }
            }).collect(Collectors.toMap(feed -> feed.getString("liveStreamId"), feed -> feed));
            JSONObject feedObj = feedMap.get(1);
            liveStreamId = feedMap.keySet().iterator().next();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String result = "";
        String url = "http://47.114.196.142:5000/api/ks_v1/get_live_district_rank?live_stream_id=" + liveStreamId;
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code, Statuscode;
        Object msg;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            ;
            code = jsonObject.getInteger("code");
            msg = jsonObject.get("msg");
        } catch (Exception e) {
            testResultDao.insertResult("KuaiShouV1", 500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_live_district_rank", result);
            return;
        }
        if (msg.toString().contains("参数异常")) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "参数异常", url, "get_live_district_rank", result);
        }
        else if (msg.toString().contains("代理IP已过期,本次请求失败")) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "代理IP已过期,本次请求失败", url, "get_live_district_rank", result);
        }
        else if (msg.toString().contains("签名验证失败")) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "签名验证失败", url, "get_live_district_rank", result);
        }
        else if (msg.toString().contains("重试超过阈值")) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "重试超过阈值", url, "get_live_district_rank", result);
        }
        else if (liveStreamId == null) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "liveStreamId未取到", url, "get_live_district_rank", result);
        }
        else if (Statuscode != 200) {
            testResultDao.insertResult("KuaiShouV1", Statuscode, new Date(), "http请求错误", url, "get_live_district_rank", result);
        }
        else if (code != 0) {
            testResultDao.insertResult("KuaiShouV1", code, new Date(), "业务请求错误", url, "get_live_district_rank", result);
        }
        else {
            testResultDao.insertResult("KuaiShouV1", 200, new Date(), "成功", url, "get_live_district_rank", result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_user_card_info() throws IOException {
        //获取用户名片信息
        String result = "";
        String url = "http://47.114.196.142:5000/api/ks_v1/get_user_card_info?principal_id=Tina__2020";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code, Statuscode;
        Object msg;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
            msg = jsonObject.get("msg");

        } catch (Exception e) {
            testResultDao.insertResult("KuaiShouV1", 500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_user_card_info", result);
            return;
        }
        if (msg.toString().contains("参数异常")) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "参数异常", url, "get_user_card_info", result);
        }
        else if (msg.toString().contains("代理IP已过期,本次请求失败")) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "代理IP已过期,本次请求失败", url, "get_user_card_info", result);
        }
        else if (msg.toString().contains("签名验证失败")) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "签名验证失败", url, "get_user_card_info", result);
        }
        else if (msg.toString().contains("重试超过阈值")) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "重试超过阈值", url, "get_user_card_info", result);
        }
        else if (Statuscode != 200) {
            testResultDao.insertResult("KuaiShouV1", Statuscode, new Date(), "http请求错误", url, "get_user_card_info", result);
        }
        else if (code != 0) {
            testResultDao.insertResult("KuaiShouV1", code, new Date(), "业务请求错误", url, "get_user_card_info", result);
        }
        else {
            testResultDao.insertResult("KuaiShouV1", 200, new Date(), "成功", url, "get_live_square_list", result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_comm_list() throws IOException {
        //获取视频评论
        String result = "";
        String url = "http://47.114.196.142:5000/api/ks_v1/get_comm_list?photo_id=5191524499654918752&page=1&page_size=20";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code, Statuscode;
        Object msg;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
            msg = jsonObject.get("msg");

        } catch (Exception e) {
            testResultDao.insertResult("KuaiShouV1", 500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_comm_list", result);
            return;
        }
        if (msg.toString().contains("参数异常")) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "参数异常", url, "get_comm_list", result);
        }
        else if (msg.toString().contains("Need captcha")) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "需要验证码", url, "get_comm_list", result);
        }
        else if (msg.toString().contains("代理IP已过期,本次请求失败")) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "代理IP已过期,本次请求失败", url, "get_comm_list", result);
        }
        else if (msg.toString().contains("签名验证失败")) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "签名验证失败", url, "get_comm_list", result);
        }
        else if (msg.toString().contains("重试超过阈值")) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "重试超过阈值", url, "get_comm_list", result);
        }
        else if (Statuscode != 200) {
            testResultDao.insertResult("KuaiShouV1", Statuscode, new Date(), "http请求错误", url, "get_comm_list", result);
        }
        else if (code != 0) {
            testResultDao.insertResult("KuaiShouV1", code, new Date(), "业务请求错误", url, "get_comm_list", result);
        }
        else {
            testResultDao.insertResult("KuaiShouV1", 200, new Date(), "成功", url, "get_comm_list", result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_live_detail() throws IOException {
        // 获取用户直播信息
        String result = "";
        String url = "http://47.114.196.142:5000/api/ks_v1/get_live_detail?principal_id=jiutianhu";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code, Statuscode;
        Object msg;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
            msg = jsonObject.get("msg");

        } catch (Exception e) {
            testResultDao.insertResult("KuaiShouV1", 500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_live_detail", result);
            return;
        }
        if (msg.toString().contains("参数异常")) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "参数异常", url, "get_live_detail", result);
        }
        else if (msg.toString().contains("代理IP已过期,本次请求失败")) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "代理IP已过期,本次请求失败", url, "get_live_detail", result);
        }
        else if (msg.toString().contains("签名验证失败")) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "签名验证失败", url, "get_live_detail", result);
        }
        else if (msg.toString().contains("重试超过阈值")) {
            testResultDao.insertResult("KuaiShouV1", 400, new Date(), "重试超过阈值", url, "get_live_detail", result);
        }
        else if (Statuscode != 200) {
            testResultDao.insertResult("KuaiShouV1", Statuscode, new Date(), "http请求错误", url, "get_live_detail", result);
        }
        else if (code != 0) {
            testResultDao.insertResult("KuaiShouV1", code, new Date(), "业务请求错误", url, "get_live_detail", result);
        }
        else {
            testResultDao.insertResult("KuaiShouV1", 200, new Date(), "成功", url, "get_live_detail", result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }
}