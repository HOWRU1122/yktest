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

@RunWith(SpringRunner.class)
@SpringBootTest
public class DouyinIOSTest {

    @Autowired
    private TestResultDao testResultDao;

    @Test
    public void user_info() throws IOException {
        //获取用户基本信息
        String result = "";
        String url = "http://47.114.196.142:5000/api/douyin_ios/user_info?user_id=1297017945466284&sec_user_id=MS4wLjABAAAAZk_KayH7Ze2BOUa0DunPPsGD-A5aI-ZHrEtBfd_zeu9cOmRZN6dGHhYo4mmWBRJl";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code, Statuscode;
        JSONObject data;

        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);

            code = jsonObject.getInteger("code");
            data = jsonObject.getJSONObject("data");
        } catch (Exception e) {
            testResultDao.insertResult("DouyinIOS", 200, new Date(), "测试异常，e:" + e.getMessage(), url, "user_info", result);
            return;
        }
        if (data == null || data.hashCode() == 0) {
            testResultDao.insertResult("DouyinIOS", 300, new Date(), "data返回为空", url, "user_info", result);
        } else if (Statuscode != 200) {
            testResultDao.insertResult("DouyinIOS", Statuscode, new Date(), "http请求错误", url, "user_info", result);
        } else if (code != 0) {
            testResultDao.insertResult("DouyinIOS", code, new Date(), "业务请求错误", url, "user_info", result);
        } else {
            testResultDao.insertResult("DouyinIOS", 200, new Date(), "成功", url, "user_info", result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }


    @Test
    public void user_video() throws IOException {
        //获取用户视频列表
        String result = "";
        String url = "http://47.114.196.142:5000/api/douyin_ios/user_video?user_id=1297017945466284&sec_user_id=MS4wLjABAAAAZk_KayH7Ze2BOUa0DunPPsGD-A5aI-ZHrEtBfd_zeu9cOmRZN6dGHhYo4mmWBRJl&max_cursor=0&count=12";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code, Statuscode;
        JSONObject data;

        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);

            code = jsonObject.getInteger("code");
            data = jsonObject.getJSONObject("data");
        } catch (Exception e) {
            testResultDao.insertResult("DouyinIOS", 200, new Date(), "测试异常，e:" + e.getMessage(), url, "user_video", result);
            return;
        }
        if (data == null || data.hashCode() == 0) {
            testResultDao.insertResult("DouyinIOS", 300, new Date(), "data返回为空", url, "user_video", result);
        } else if (Statuscode != 200) {
            testResultDao.insertResult("DouyinIOS", Statuscode, new Date(), "http请求错误", url, "user_video", result);
        } else if (code != 0) {
            testResultDao.insertResult("DouyinIOS", code, new Date(), "业务请求错误", url, "user_video", result);
        } else {
            testResultDao.insertResult("DouyinIOS", 200, new Date(), "成功", url, "user_video", result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }


    @Test
    public void video_detail() throws IOException {
        //获取视频详情
        String result = "";
        String url = "http://47.114.196.142:5000/api/douyin_ios/video_detail?aweme_id=6789866947015232775";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code, Statuscode;
        JSONObject data;

        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);

            code = jsonObject.getInteger("code");
            data = jsonObject.getJSONObject("data");
        } catch (Exception e) {
            testResultDao.insertResult("DouyinIOS", 200, new Date(), "测试异常，e:" + e.getMessage(), url, "video_detail", result);
            return;
        }
        if (data == null || data.hashCode() == 0) {
            testResultDao.insertResult("DouyinIOS", 300, new Date(), "data返回为空", url, "video_detail", result);
        } else if (Statuscode != 200) {
            testResultDao.insertResult("DouyinIOS", Statuscode, new Date(), "http请求错误", url, "video_detail", result);
        } else if (code != 0) {
            testResultDao.insertResult("DouyinIOS", code, new Date(), "业务请求错误", url, "video_detail", result);
        } else {
            testResultDao.insertResult("DouyinIOS", 200, new Date(), "成功", url, "video_detail", result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }


    @Test
    public void user_goods() throws IOException {
        //用户商品橱窗列表
        String result = "";
        String url = "http://47.114.196.142:5000/api/douyin_ios/user_goods?user_id=1297017945466284&cursor=0&count=20";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code, Statuscode;
        JSONObject data;

        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);

            code = jsonObject.getInteger("code");
            data = jsonObject.getJSONObject("data");
        } catch (Exception e) {
            testResultDao.insertResult("DouyinIOS", 200, new Date(), "测试异常，e:" + e.getMessage(), url, "user_goods", result);
            return;
        }
        if (data == null || data.hashCode() == 0) {
            testResultDao.insertResult("DouyinIOS", 300, new Date(), "data返回为空", url, "user_goods", result);
        } else if (Statuscode != 200) {
            testResultDao.insertResult("DouyinIOS", Statuscode, new Date(), "http请求错误", url, "user_goods", result);
        } else if (code != 0) {
            testResultDao.insertResult("DouyinIOS", code, new Date(), "业务请求错误", url, "user_goods", result);
        } else {
            testResultDao.insertResult("DouyinIOS", 200, new Date(), "成功", url, "user_goods", result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }


    @Test
    public void video_comment() throws IOException {
        //获取视频评论
        String result = "";
        String url = "http://47.114.196.142:5000/api/douyin_ios/video_comment?aweme_id=6834063298263059719&cursor=0&count=20";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code, Statuscode;
        JSONObject data;

        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);

            code = jsonObject.getInteger("code");
            data = jsonObject.getJSONObject("data");
        } catch (Exception e) {
            testResultDao.insertResult("DouyinIOS", 200, new Date(), "测试异常，e:" + e.getMessage(), url, "video_comment", result);
            return;
        }
        if (data == null || data.hashCode() == 0) {
            testResultDao.insertResult("DouyinIOS", 300, new Date(), "data返回为空", url, "video_comment", result);
        } else if (Statuscode != 200) {
            testResultDao.insertResult("DouyinIOS", Statuscode, new Date(), "http请求错误", url, "video_comment", result);
        } else if (code != 0) {
            testResultDao.insertResult("DouyinIOS", code, new Date(), "业务请求错误", url, "video_comment", result);
        } else {
            testResultDao.insertResult("DouyinIOS", 200, new Date(), "成功", url, "video_comment", result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }


    @Test
    public void get_user_following_list() throws IOException {
        //获取用户关注列表
        String result = "";
        String url = "http://47.114.196.142:5000/api/douyin_ios/get_user_following_list?user_id=1754473270347287&max_time=0&count=20";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code, Statuscode;
        JSONObject data;

        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);

            code = jsonObject.getInteger("code");
            data = jsonObject.getJSONObject("data");
        } catch (Exception e) {
            testResultDao.insertResult("DouyinIOS", 200, new Date(), "测试异常，e:" + e.getMessage(), url, "get_user_following_list", result);
            return;
        }
        if (data == null || data.hashCode() == 0) {
            testResultDao.insertResult("DouyinIOS", 300, new Date(), "data返回为空", url, "get_user_following_list", result);
        } else if (Statuscode != 200) {
            testResultDao.insertResult("DouyinIOS", Statuscode, new Date(), "http请求错误", url, "get_user_following_list", result);
        } else if (code != 0) {
            testResultDao.insertResult("DouyinIOS", code, new Date(), "业务请求错误", url, "get_user_following_list", result);
        } else {
            testResultDao.insertResult("DouyinIOS", 200, new Date(), "成功", url, "get_user_following_list", result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }


    @Test
    public void get_webcast_room_info() throws IOException {
        //获取直播房间信息
        String result = "";
        String url = "http://47.114.196.142:5000/api/douyin_ios/get_webcast_room_info?room_id=6731613896211188484";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code, Statuscode;
        JSONObject data;

        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);

            code = jsonObject.getInteger("code");
            data = jsonObject.getJSONObject("data");
        } catch (Exception e) {
            testResultDao.insertResult("DouyinIOS", 200, new Date(), "测试异常，e:" + e.getMessage(), url, "get_webcast_room_info", result);
            return;
        }
        if (data == null || data.hashCode() == 0) {
            testResultDao.insertResult("DouyinIOS", 300, new Date(), "data返回为空", url, "get_webcast_room_info", result);
        } else if (Statuscode != 200) {
            testResultDao.insertResult("DouyinIOS", Statuscode, new Date(), "http请求错误", url, "get_webcast_room_info", result);
        } else if (code != 0) {
            testResultDao.insertResult("DouyinIOS", code, new Date(), "业务请求错误", url, "get_webcast_room_info", result);
        } else {
            testResultDao.insertResult("DouyinIOS", 200, new Date(), "成功", url, "get_webcast_room_info", result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }


    @Test
    public void get_webcast_user_info() throws IOException {
        //获取直播房间信息
        String result = "";
        String url = "http://47.114.196.142:5000/api/douyin_ios/get_webcast_user_info?room_id=6731613896211188484&user_id=108160072764";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code, Statuscode;
        JSONObject data;

        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);

            code = jsonObject.getInteger("code");
            data = jsonObject.getJSONObject("data");
        } catch (Exception e) {
            testResultDao.insertResult("DouyinIOS", 200, new Date(), "测试异常，e:" + e.getMessage(), url, "get_webcast_user_info", result);
            return;
        }
        if (data == null || data.hashCode() == 0) {
            testResultDao.insertResult("DouyinIOS", 300, new Date(), "data返回为空", url, "get_webcast_user_info", result);
        } else if (Statuscode != 200) {
            testResultDao.insertResult("DouyinIOS", Statuscode, new Date(), "http请求错误", url, "get_webcast_user_info", result);
        } else if (code != 0) {
            testResultDao.insertResult("DouyinIOS", code, new Date(), "业务请求错误", url, "get_webcast_user_info", result);
        } else {
            testResultDao.insertResult("DouyinIOS", 200, new Date(), "成功", url, "get_webcast_user_info", result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }


    @Test
    public void get_webcast_ranklist() throws IOException {
        //获取直播本场榜
        String result = "";
        String url = "http://47.114.196.142:5000/api/douyin_ios/get_webcast_ranklist?room_id=6731613896211188484&anchor_id=108160072764";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code, Statuscode;
        JSONObject data;

        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);

            code = jsonObject.getInteger("code");
            data = jsonObject.getJSONObject("data");
        } catch (Exception e) {
            testResultDao.insertResult("DouyinIOS", 200, new Date(), "测试异常，e:" + e.getMessage(), url, "get_webcast_ranklist", result);
            return;
        }
        if (data == null || data.hashCode() == 0) {
            testResultDao.insertResult("DouyinIOS", 300, new Date(), "data返回为空", url, "get_webcast_ranklist", result);
        } else if (Statuscode != 200) {
            testResultDao.insertResult("DouyinIOS", Statuscode, new Date(), "http请求错误", url, "get_webcast_ranklist", result);
        } else if (code != 0) {
            testResultDao.insertResult("DouyinIOS", code, new Date(), "业务请求错误", url, "get_webcast_ranklist", result);
        } else {
            testResultDao.insertResult("DouyinIOS", 200, new Date(), "成功", url, "get_webcast_ranklist", result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }


    @Test
    public void get_live_goods() throws IOException {
        //获取直播间讲解中的商品
        String result = "";
        String url = "http://47.114.196.142:5000/api/douyin_ios/get_live_goods?room_id=6834374938778929934";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code, Statuscode;
        JSONObject data;

        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);

            code = jsonObject.getInteger("code");
            data = jsonObject.getJSONObject("data");
        } catch (Exception e) {
            testResultDao.insertResult("DouyinIOS", 200, new Date(), "测试异常，e:" + e.getMessage(), url, "get_live_goods", result);
            return;
        }
        if (data == null || data.hashCode() == 0) {
            testResultDao.insertResult("DouyinIOS", 300, new Date(), "data返回为空", url, "get_live_goods", result);
        } else if (Statuscode != 200) {
            testResultDao.insertResult("DouyinIOS", Statuscode, new Date(), "http请求错误", url, "get_live_goods", result);
        } else if (code != 0) {
            testResultDao.insertResult("DouyinIOS", code, new Date(), "业务请求错误", url, "get_live_goods", result);
        } else {
            testResultDao.insertResult("DouyinIOS", 200, new Date(), "成功", url, "get_live_goods", result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }


    @Test
    public void get_live_goods_list() throws IOException {
        //获取直播间商品列表
        String result = "";
        String url = "http://47.114.196.142:5000/api/douyin_ios/get_live_goods_list?room_id=6834374938778929934&author_id=101759059715";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code, Statuscode;
        JSONObject data;

        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);

            code = jsonObject.getInteger("code");
            data = jsonObject.getJSONObject("data");
        } catch (Exception e) {
            testResultDao.insertResult("DouyinIOS", 200, new Date(), "测试异常，e:" + e.getMessage(), url, "get_live_goods_list", result);
            return;
        }
        if (data == null || data.hashCode() == 0) {
            testResultDao.insertResult("DouyinIOS", 300, new Date(), "data返回为空", url, "get_live_goods_list", result);
        } else if (Statuscode != 200) {
            testResultDao.insertResult("DouyinIOS", Statuscode, new Date(), "http请求错误", url, "get_live_goods_list", result);
        } else if (code != 0) {
            testResultDao.insertResult("DouyinIOS", code, new Date(), "业务请求错误", url, "get_live_goods_list", result);
        } else {
            testResultDao.insertResult("DouyinIOS", 200, new Date(), "成功", url, "get_live_goods_list", result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }


    @Test
    public void get_ranklist() throws IOException {
        //获取小时榜列表及用户小时榜排名
        String result = "";
        String url = "http://47.114.196.142:5000/api/douyin_ios/get_ranklist?room_id=6825488528693005068&anchor_id=59456152598";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code, Statuscode;
        JSONObject data;

        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);

            code = jsonObject.getInteger("code");
            data = jsonObject.getJSONObject("data");
        } catch (Exception e) {
            testResultDao.insertResult("DouyinIOS", 200, new Date(), "测试异常，e:" + e.getMessage(), url, "get_ranklist", result);
            return;
        }
        if (data == null || data.hashCode() == 0) {
            testResultDao.insertResult("DouyinIOS", 300, new Date(), "data返回为空", url, "get_ranklist", result);
        } else if (Statuscode != 200) {
            testResultDao.insertResult("DouyinIOS", Statuscode, new Date(), "http请求错误", url, "get_ranklist", result);
        } else if (code != 0) {
            testResultDao.insertResult("DouyinIOS", code, new Date(), "业务请求错误", url, "get_ranklist", result);
        } else {
            testResultDao.insertResult("DouyinIOS", 200, new Date(), "成功", url, "get_ranklist", result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }


    @Test
    public void get_shop_promotion() throws IOException {
        //获取抖音商品详情
        String result = "";
        String url = "http://47.114.196.142:5000/api/douyin_ios/get_shop_promotion?product_id=3382302791656702038&promotion_id=3383047053780335895";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code, Statuscode;
        JSONObject data;

        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);

            code = jsonObject.getInteger("code");
            data = jsonObject.getJSONObject("data");
        } catch (Exception e) {
            testResultDao.insertResult("DouyinIOS", 200, new Date(), "测试异常，e:" + e.getMessage(), url, "get_shop_promotion", result);
            return;
        }
        if (data == null || data.hashCode() == 0) {
            testResultDao.insertResult("DouyinIOS", 300, new Date(), "data返回为空", url, "get_shop_promotion", result);
        } else if (Statuscode != 200) {
            testResultDao.insertResult("DouyinIOS", Statuscode, new Date(), "http请求错误", url, "get_shop_promotion", result);
        } else if (code != 0) {
            testResultDao.insertResult("DouyinIOS", code, new Date(), "业务请求错误", url, "get_shop_promotion", result);
        } else {
            testResultDao.insertResult("DouyinIOS", 200, new Date(), "成功", url, "get_shop_promotion", result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }
}