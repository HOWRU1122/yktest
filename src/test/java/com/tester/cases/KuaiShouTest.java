package com.tester.cases;

import com.alibaba.fastjson.JSONObject;
import com.tester.dao.TestResultDao;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
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
public class KuaiShouTest {

    @Autowired
    private TestResultDao testResultDao;
    @Test
    public void call_nums() throws IOException {
        //调用次数
        String result = "";
        String url = "http://47.97.206.10/api/ks_v2/call_nums";
        HttpGet get = new HttpGet(url);
        HttpClient client = new DefaultHttpClient();
        Integer code,Statuscode;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
        } catch (Exception e) {
            testResultDao.insertResult("KuaiShou",200, new Date(), "测试异常，e:" + e.getMessage(), url, "call_nums",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("KuaiShou",Statuscode, new Date(), "http请求错误", url,"call_nums",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("KuaiShou",code, new Date(), "业务请求错误", url,"call_nums",result);

        }
        else {
            testResultDao.insertResult("KuaiShou",200, new Date(), "成功", url,"call_nums",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }

    @Test
    public void hot_feed() throws IOException {
        //获取热点推荐
        String result = "";
        String url = "http://47.97.206.10/api/ks_v2/hot_feed?page=1&page_size=10";
        HttpGet get = new HttpGet(url);
        HttpClient client = new DefaultHttpClient();
        Integer code,Statuscode;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
        } catch (Exception e) {
            testResultDao.insertResult("KuaiShou",500, new Date(), "测试异常，e:" + e.getMessage(), url, "hot_feed",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("KuaiShou",Statuscode, new Date(), "http请求错误", url,"hot_feed",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("KuaiShou",code, new Date(), "业务请求错误", url,"hot_feed",result);

        }
        else {
            testResultDao.insertResult("KuaiShou",200, new Date(), "成功", url,"hot_feed",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }
    @Test
    public void nearby_feed() throws IOException {
        //获取同城推荐
        String result = "";
        String url = "http://47.97.206.10/api/ks_v2/nearby_feed?page=1&page_size=20&lon=113.712143&lat=34.593717";
        HttpGet get = new HttpGet(url);
        HttpClient client = new DefaultHttpClient();
        Integer code,Statuscode;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
        } catch (Exception e) {
            testResultDao.insertResult("KuaiShou",500, new Date(), "测试异常，e:" + e.getMessage(), url, "nearby_feed",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("KuaiShou",Statuscode, new Date(), "http请求错误", url,"nearby_feed",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("KuaiShou",code, new Date(), "业务请求错误", url,"nearby_feed",result);

        }
        else {
            testResultDao.insertResult("KuaiShou",200, new Date(), "成功", url,"nearby_feed",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }
    @Test
    public void user_info() throws IOException {
        //获取用户信息(被检测频率较高)
        String result = "";
        String url = "http://47.97.206.10/api/ks_v2/user_info?user_id=1391625066";
        HttpGet get = new HttpGet(url);
        HttpClient client = new DefaultHttpClient();
        Integer code,Statuscode;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
        } catch (Exception e) {
            testResultDao.insertResult("KuaiShou",500, new Date(), "测试异常，e:" + e.getMessage(), url, "user_info",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("KuaiShou",Statuscode, new Date(), "http请求错误", url,"user_info",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("KuaiShou",code, new Date(), "业务请求错误", url,"user_info",result);

        }
        else {
            testResultDao.insertResult("KuaiShou",200, new Date(), "成功", url,"user_info",result);
            System.out.println("成功，" + "请求url：" + url);
        }


    }
    @Test
    public void user_video() throws IOException {
        //获取用户视频列表(返回的不是目标用户的视频)
        String result = "";
        String url = "http://47.97.206.10/api/ks_v2/user_video?user_id=1391625066&page_size=10";
        HttpGet get = new HttpGet(url);
        HttpClient client = new DefaultHttpClient();
        Integer code,Statuscode;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
        } catch (Exception e) {
            testResultDao.insertResult("KuaiShou",500, new Date(), "测试异常，e:" + e.getMessage(), url, "user_video",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("KuaiShou",Statuscode, new Date(), "http请求错误", url,"user_video",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("KuaiShou",code, new Date(), "业务请求错误", url,"user_video",result);

        }
        else {
            testResultDao.insertResult("KuaiShou",200, new Date(), "成功", url,"user_video",result);
            System.out.println("成功，" + "请求url：" + url);
        }


    }
    @Test
    public void video_comment() throws IOException {
        //获取视频评论列表
        String result = "";
        String url = "http://47.97.206.10/api/ks_v2/video_comment?user_id=191674858&photo_id=5248945383907780546&page_size=10";
        HttpGet get = new HttpGet(url);
        HttpClient client = new DefaultHttpClient();
        Integer code,Statuscode;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
        } catch (Exception e) {
            testResultDao.insertResult("KuaiShou",500, new Date(), "测试异常，e:" + e.getMessage(), url, "video_comment",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("KuaiShou",Statuscode, new Date(), "http请求错误", url,"video_comment",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("KuaiShou",code, new Date(), "业务请求错误", url,"video_comment",result);

        }
        else {
            testResultDao.insertResult("KuaiShou",200, new Date(), "成功", url,"video_comment",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }
    @Test
    public void video_detail() throws IOException {
        //获取视频信息
        String result = "";
        String url = "http://47.97.206.10/api/ks_v2/video_detail?photo_id=5248945383907780546";
        HttpGet get = new HttpGet(url);
        HttpClient client = new DefaultHttpClient();
        Integer code,Statuscode;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
        } catch (Exception e) {
            testResultDao.insertResult("KuaiShou",500, new Date(), "测试异常，e:" + e.getMessage(), url, "video_detail",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("KuaiShou",Statuscode, new Date(), "http请求错误", url,"video_detail",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("KuaiShou",code, new Date(), "业务请求错误", url,"video_detail",result);

        }
        else {
            testResultDao.insertResult("KuaiShou",200, new Date(), "成功", url,"video_detail",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }
    @Test
    public void share_video() throws IOException {
        //获取分享视频链接信息
        String result = "";
        String url = "http://47.97.206.10/api/ks_v2/share_video?share_url=http://kphbeijing.m.chenzhongtech.com/s/Qsh970xL";
        HttpGet get = new HttpGet(url);
        HttpClient client = new DefaultHttpClient();
        Integer code,Statuscode;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
        } catch (Exception e) {
            testResultDao.insertResult("KuaiShou",500, new Date(), "测试异常，e:" + e.getMessage(), url, "share_video",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("KuaiShou",Statuscode, new Date(), "http请求错误", url,"share_video",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("KuaiShou",code, new Date(), "业务请求错误", url,"share_video",result);

        }
        else {
            testResultDao.insertResult("KuaiShou",200, new Date(), "成功", url,"share_video",result);
            System.out.println("成功，" + "请求url：" + url);
        }


    }
    @Test
    public void product_list() throws IOException {
        //获取小店商品
        String result = "";
        String url = "http://47.97.206.10/api/ks_v2/product_list?user_id=976786976&page=1";
        HttpGet get = new HttpGet(url);
        HttpClient client = new DefaultHttpClient();
        Integer code,Statuscode;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
        } catch (Exception e) {
            testResultDao.insertResult("KuaiShou",500, new Date(), "测试异常，e:" + e.getMessage(), url, "product_list",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("KuaiShou",Statuscode, new Date(), "http请求错误", url,"product_list",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("KuaiShou",code, new Date(), "业务请求错误", url,"product_list",result);

        }
        else {
            testResultDao.insertResult("KuaiShou",200, new Date(), "成功", url,"product_list",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }

    @Test
    public void get_live_info() throws IOException {
        //获取直播简介
        String result = "";
        String url = "http://47.97.206.10/api/ks_v2/get_live_info?user_id=417310422";
        HttpGet get = new HttpGet(url);
        HttpClient client = new DefaultHttpClient();
        Integer code,Statuscode;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
        } catch (Exception e) {
            testResultDao.insertResult("KuaiShou",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_live_info",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("KuaiShou",Statuscode, new Date(), "http请求错误", url,"get_live_info",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("KuaiShou",code, new Date(), "业务请求错误", url,"get_live_info",result);

        }
        else {
            testResultDao.insertResult("KuaiShou",200, new Date(), "成功", url,"get_live_info",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }

    @Test
    public void get_live_goods() throws IOException {
        //获取直播小黄车商品 (需要登陆)
        String result = "";
        String url = "http://47.97.206.10/api/ks_v2/get_live_goods?live_stream_id=sLB199KXJDQ";
        HttpGet get = new HttpGet(url);
        HttpClient client = new DefaultHttpClient();
        Integer code,Statuscode;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
        } catch (Exception e) {
            testResultDao.insertResult("KuaiShou",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_live_goods",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("KuaiShou",Statuscode, new Date(), "http请求错误", url,"get_live_goods",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("KuaiShou",code, new Date(), "业务请求错误", url,"get_live_goods",result);

        }
        else {
            testResultDao.insertResult("KuaiShou",200, new Date(), "成功", url,"get_live_goods",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }

    @Test
    public void get_live_users() throws IOException {
        //获取前30名直播观看用户
        String result = "";
        String url = "http://47.97.206.10/api/ks_v2/get_live_users?live_stream_id=3J5JzzC75Bw";
        HttpGet get = new HttpGet(url);
        HttpClient client = new DefaultHttpClient();
        Integer code,Statuscode;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
        } catch (Exception e) {
            testResultDao.insertResult("KuaiShou",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_live_users",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("KuaiShou",Statuscode, new Date(), "http请求错误", url,"get_live_users",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("KuaiShou",code, new Date(), "业务请求错误", url,"get_live_users",result);

        }
        else {
            testResultDao.insertResult("KuaiShou",200, new Date(), "成功", url,"get_live_users",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }

    @Test
    public void get_live_top_users() throws IOException {
        //获取前100名直播观看用户
        String result = "";
        String url = "http://47.97.206.10/api/ks_v2/get_live_top_users?live_stream_id=3J5JzzC75Bw";
        HttpGet get = new HttpGet(url);
        HttpClient client = new DefaultHttpClient();
        Integer code,Statuscode;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
        } catch (Exception e) {
            testResultDao.insertResult("KuaiShou",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_live_top_users",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("KuaiShou",Statuscode, new Date(), "http请求错误", url,"get_live_top_users",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("KuaiShou",code, new Date(), "业务请求错误", url,"get_live_top_users",result);

        }
        else {
            testResultDao.insertResult("KuaiShou",200, new Date(), "成功", url,"get_live_top_users",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }

    @Test
    public void get_live_square_refresh() throws IOException {
        //获取直播广场刷新列表
        String result = "";
        String url = "http://47.97.206.10/api/ks_v2/get_live_square_refresh";
        HttpGet get = new HttpGet(url);
        HttpClient client = new DefaultHttpClient();
        Integer code,Statuscode;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
        } catch (Exception e) {
            testResultDao.insertResult("KuaiShou",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_live_square_refresh",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("KuaiShou",Statuscode, new Date(), "http请求错误", url,"get_live_square_refresh",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("KuaiShou",code, new Date(), "业务请求错误", url,"get_live_square_refresh",result);

        }
        else {
            testResultDao.insertResult("KuaiShou",200, new Date(), "成功", url,"get_live_square_refresh",result);
            System.out.println("成功，" + "请求url：" + url);
        }
        System.out.println(result);

    }

    @Test
    public void get_live_square_list() throws IOException {
        //获取直播广场分页列表
        String result = "";
        String url = "http://47.97.206.10/api/ks_v2/get_live_square_list?pcursor=8";
        HttpGet get = new HttpGet(url);
        HttpClient client = new DefaultHttpClient();
        Integer code,Statuscode;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
        } catch (Exception e) {
            testResultDao.insertResult("KuaiShou",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_live_square_list",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("KuaiShou",Statuscode, new Date(), "http请求错误", url,"get_live_square_list",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("KuaiShou",code, new Date(), "业务请求错误", url,"get_live_square_list",result);

        }
        else {
            testResultDao.insertResult("KuaiShou",200, new Date(), "成功", url,"get_live_square_list",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }

    @Test
    public void get_live_district_rank() throws IOException {
        //获取直播地区排名
        String result = "";
        String url = "http://47.97.206.10/api/ks_v2/get_live_district_rank?live_stream_id=sLB199KXJDQ";
        HttpGet get = new HttpGet(url);
        HttpClient client = new DefaultHttpClient();
        Integer code,Statuscode;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
        } catch (Exception e) {
            testResultDao.insertResult("KuaiShou",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_live_district_rank",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("KuaiShou",Statuscode, new Date(), "http请求错误", url,"get_live_district_rank",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("KuaiShou",code, new Date(), "业务请求错误", url,"get_live_district_rank",result);

        }
        else {
            testResultDao.insertResult("KuaiShou",200, new Date(), "成功", url,"get_live_district_rank",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }
}
