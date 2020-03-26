package com.tester.cases;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tester.dao.TestResultDao;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.tomcat.util.http.fileupload.MultipartStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.ITestResult;

import java.io.IOException;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DouyinLiteTest {
    @Autowired
    private TestResultDao testResultDao;
/*
    @Test
    public void get_feed() throws IOException {
        //热门事件
        String result = "";
        String url = "http://47.97.206.10/api/douyin_lite/get_feed";
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
            testResultDao.insertResult("DouyinLite",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_feed",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("DouyinLite",Statuscode, new Date(), "http请求错误", url,"get_feed",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinLite",code, new Date(), "业务请求错误", url,"get_feed",result);

        }
        else {
            testResultDao.insertResult("DouyinLite",200, new Date(), "成功", url,"get_feed",result);
            System.out.println("成功，" + "请求url：" + url);
        }


    }

    @Test
    public void get_share_video_detail() throws IOException {
        //获取分享视频连接的详情
        String result = "";
        String url = "http://47.97.206.10/api/douyin_lite/get_share_video_detail?url=https://v.douyin.com/tajDmg/";
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
            testResultDao.insertResult("DouyinLite",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_share_video_detail",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("DouyinLite",Statuscode, new Date(), "http请求错误", url,"get_share_video_detail",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinLite",code, new Date(), "业务请求错误", url,"get_share_video_detail",result);

        }
        else {
            testResultDao.insertResult("DouyinLite",200, new Date(), "成功", url,"get_share_video_detail",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }

    @Test
    public void get_nearby_feed() throws IOException {
        //获取该城市的热门信息
        String result = "";
        String url = "http://47.97.206.10/api/douyin_lite/get_nearby_feed?city_id=110000";
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
            testResultDao.insertResult("DouyinLite",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_nearby_feed",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("DouyinLite",Statuscode, new Date(), "http请求错误", url,"get_nearby_feed",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinLite",code, new Date(), "业务请求错误", url,"get_nearby_feed",result);

        }
        else {
            testResultDao.insertResult("DouyinLite",200, new Date(), "成功", url,"get_nearby_feed",result);
            System.out.println("成功，" + "请求url：" + url);
        }


    }

    @Test
    public void get_user_info() throws IOException {
        //获取用户信息
        String result = "";
        String url = "http://47.97.206.10/api/douyin_lite/get_user_info?user_id=102388086611";
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
            testResultDao.insertResult("DouyinLite",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_user_info",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("DouyinLite",Statuscode, new Date(), "http请求错误", url,"get_user_info",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinLite",code, new Date(), "业务请求错误", url,"get_user_info",result);

        }
        else {
            testResultDao.insertResult("DouyinLite",200, new Date(), "成功", url,"get_user_info",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }

    @Test
    public void get_user_post() throws IOException {
        //获取用户post的视频
        String result = "";
        String url = "http://47.97.206.10/api/douyin_lite/get_user_post?user_id=102388086611&max_cursor=0&count=2";
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
            testResultDao.insertResult("DouyinLite",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_user_post",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("DouyinLite",Statuscode, new Date(), "http请求错误", url,"get_user_post",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinLite",code, new Date(), "业务请求错误", url,"get_user_post",result);

        }
        else {
            testResultDao.insertResult("DouyinLite",200, new Date(), "成功", url,"get_user_post",result);
            System.out.println("成功，" + "请求url：" + url);
        }


    }

    @Test
    public void get_user_forward_list() throws IOException {
        //获取用户发布的动态列表
        String result = "";
        String url = "http://47.97.206.10/api/douyin_lite/get_user_forward_list?user_id=102388086611&max_cursor=0&count=2";
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
            testResultDao.insertResult("DouyinLite",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_user_forward_list",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("DouyinLite",Statuscode, new Date(), "http请求错误", url,"get_user_forward_list",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinLite",code, new Date(), "业务请求错误", url,"get_user_forward_list",result);

        }
        else {
            testResultDao.insertResult("DouyinLite",200, new Date(), "成功", url,"get_user_forward_list",result);
            System.out.println("成功，" + "请求url：" + url);
        }


    }
*/
    @Test
    public void get_user_following_list() throws IOException {
        //获取用户关注的列表
        String result = "";
        String url = "http://47.97.206.10/api/douyin_lite/get_user_following_list?user_id=102388086611&max_cursor=0&count=2";
        HttpGet get = new HttpGet(url);
        HttpClient client = new DefaultHttpClient();
        Integer code,Statuscode;
        JSONObject data;
        JSONArray followings;

        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);

            code = jsonObject.getInteger("code");
            data = jsonObject.getJSONObject("data");
            followings = data.getJSONArray("followings");
        } catch (Exception e) {
            testResultDao.insertResult("DouyinLite",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_user_following_list",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("DouyinLite",Statuscode, new Date(), "http请求错误", url,"get_user_following_list",result);

        }
        if (followings == null || followings.size() == 0) {
            testResultDao.insertResult("Douyinv1", 300, new Date(), "data返回为空", url, "user_video", result);

        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinLite",code, new Date(), "业务请求错误", url,"get_user_following_list",result);

        }
        else {
            testResultDao.insertResult("DouyinLite",200, new Date(), "成功", url,"get_user_following_list",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }
/*
    @Test
    public void get_user_follower_list() throws IOException {
        //获取用户粉丝的列表
        String result = "";
        String url = "http://47.97.206.10/api/douyin_lite/get_user_follower_list?user_id=102388086611&max_cursor=0&count=2";
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
            testResultDao.insertResult("DouyinLite",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_user_follower_list",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("DouyinLite",Statuscode, new Date(), "http请求错误", url,"get_user_follower_list",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinLite",code, new Date(), "业务请求错误", url,"get_user_follower_list",result);

        }
        else {
            testResultDao.insertResult("DouyinLite",200, new Date(), "成功", url,"get_user_follower_list",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }

    @Test
    public void get_hot_search_list() throws IOException {
        //获取热搜列表
        String result = "";
        String url = "http://47.97.206.10/api/douyin_lite/get_hot_search_list";
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
            testResultDao.insertResult("DouyinLite",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_hot_search_list",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("DouyinLite",Statuscode, new Date(), "http请求错误", url,"get_hot_search_list",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinLite",code, new Date(), "业务请求错误", url,"get_hot_search_list",result);

        }
        else {
            testResultDao.insertResult("DouyinLite",200, new Date(), "成功", url,"get_hot_search_list",result);
            System.out.println("成功，" + "请求url：" + url);
        }


    }

    @Test
    public void get_hot_video_list() throws IOException {
        //获取热门视频列表
        String result = "";
        String url = "http://47.97.206.10/api/douyin_lite/get_hot_video_list";
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
            testResultDao.insertResult("DouyinLite",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_hot_video_list",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("DouyinLite",Statuscode, new Date(), "http请求错误", url,"get_hot_video_list",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinLite",code, new Date(), "业务请求错误", url,"get_hot_video_list",result);

        }
        else {
            testResultDao.insertResult("DouyinLite",200, new Date(), "成功", url,"get_hot_video_list",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }

    @Test
    public void get_hot_music_list() throws IOException {
        //获取热门音乐列表
        String result = "";
        String url = "http://47.97.206.10/api/douyin_lite/get_hot_music_list";
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
            testResultDao.insertResult("DouyinLite",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_hot_music_list",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("DouyinLite",Statuscode, new Date(), "http请求错误", url,"get_hot_music_list",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinLite",code, new Date(), "业务请求错误", url,"get_hot_music_list",result);

        }
        else {
            testResultDao.insertResult("DouyinLite",200, new Date(), "成功", url,"get_hot_music_list",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }

    @Test
    public void get_hot_positive_energy_list() throws IOException {
        //获取正能量列表
        String result = "";
        String url = "http://47.97.206.10/api/douyin_lite/get_hot_positive_energy_list";
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
            testResultDao.insertResult("DouyinLite",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_hot_positive_energy_list",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("DouyinLite",Statuscode, new Date(), "http请求错误", url,"get_hot_positive_energy_list",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinLite",code, new Date(), "业务请求错误", url,"get_hot_positive_energy_list",result);

        }
        else {
            testResultDao.insertResult("DouyinLite",200, new Date(), "成功", url,"get_hot_positive_energy_list",result);
            System.out.println("成功，" + "请求url：" + url);
        }


    }

    @Test
    public void get_hot_category_list() throws IOException {
        //获取热门分类列表
        String result = "";
        String url = "http://47.97.206.10/api/douyin_lite/get_hot_category_list?cursor=0&count=2";
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
            testResultDao.insertResult("DouyinLite",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_hot_category_list",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("DouyinLite",Statuscode, new Date(), "http请求错误", url,"get_hot_category_list",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinLite",code, new Date(), "业务请求错误", url,"get_hot_category_list",result);

        }
        else {
            testResultDao.insertResult("DouyinLite",200, new Date(), "成功", url,"get_hot_category_list",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }

    @Test
    public void get_general_search_ret() throws IOException {
        //获取综合搜索的结果
        String result = "";
        String url = "http://47.97.206.10/api/douyin_lite/get_general_search_ret?keyword=美食&offset=0&count=2";
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
            testResultDao.insertResult("DouyinLite",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_general_search_ret",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("DouyinLite",Statuscode, new Date(), "http请求错误", url,"get_general_search_ret",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinLite",code, new Date(), "业务请求错误", url,"get_general_search_ret",result);

        }
        else {
            testResultDao.insertResult("DouyinLite",200, new Date(), "成功", url,"get_general_search_ret",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }

    @Test
    public void get_video_search() throws IOException {
        //获取视频搜索的结果
        String result = "";
        String url = "http://47.97.206.10/api/douyin_lite/get_video_search?keyword=养生&offset=0&count=2";
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
            testResultDao.insertResult("DouyinLite",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_video_search",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("DouyinLite",Statuscode, new Date(), "http请求错误", url,"get_video_search",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinLite",code, new Date(), "业务请求错误", url,"get_video_search",result);

        }
        else {
            testResultDao.insertResult("DouyinLite",200, new Date(), "成功", url,"get_video_search",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }

    @Test
    public void get_user_search() throws IOException {
        //获取用户搜索的结果
        String result = "";
        String url = "http://47.97.206.10/api/douyin_lite/get_user_search?keyword=养生&offset=0&count=2";
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
            testResultDao.insertResult("DouyinLite",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_user_search",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("DouyinLite",Statuscode, new Date(), "http请求错误", url,"get_user_search",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinLite",code, new Date(), "业务请求错误", url,"get_user_search",result);

        }
        else {
            testResultDao.insertResult("DouyinLite",200, new Date(), "成功", url,"get_user_search",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }

    @Test
    public void get_video_comment_list() throws IOException {
        //获取评论列表
        String result = "";
        String url = "http://47.97.206.10/api/douyin_lite/get_video_comment_list?aweme_id=6619905376009587972&offset=0&count=2";
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
            testResultDao.insertResult("DouyinLite",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_video_comment_list",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("DouyinLite",Statuscode, new Date(), "http请求错误", url,"get_video_comment_list",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinLite",code, new Date(), "业务请求错误", url,"get_video_comment_list",result);

        }
        else {
            testResultDao.insertResult("DouyinLite",200, new Date(), "成功", url,"get_video_comment_list",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }

    @Test
    public void get_video_detail() throws IOException {
        //获取视频详情
        String result = "";
        String url = "http://47.97.206.10/api/douyin_lite/get_video_detail?aweme_id=6645546646287420686";
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
            testResultDao.insertResult("DouyinLite",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_video_detail",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("DouyinLite",Statuscode, new Date(), "http请求错误", url,"get_video_detail",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinLite",code, new Date(), "业务请求错误", url,"get_video_detail",result);

        }
        else {
            testResultDao.insertResult("DouyinLite",200, new Date(), "成功", url,"get_video_detail",result);
            System.out.println("成功，" + "请求url：" + url);
        }


    }

    @Test
    public void get_music_detail() throws IOException {
        //获取音乐详情
        String result = "";
        String url = "http://47.97.206.10/api/douyin_lite/get_music_detail?music_id=6673679720980269831";
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
            testResultDao.insertResult("DouyinLite",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_music_detail",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("DouyinLite",Statuscode, new Date(), "http请求错误", url,"get_music_detail",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinLite",code, new Date(), "业务请求错误", url,"get_music_detail",result);

        }
        else {
            testResultDao.insertResult("DouyinLite",200, new Date(), "成功", url,"get_music_detail",result);
            System.out.println("成功，" + "请求url：" + url);
        }


    }

    @Test
    public void get_music_videos() throws IOException {
        //获取音乐对应的视频列表
        String result = "";
        String url = "http://47.97.206.10/api/douyin_lite/get_music_videos?music_id=6673679720980269831&cursor=0&count=2";
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
            testResultDao.insertResult("DouyinLite",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_music_videos",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("DouyinLite",Statuscode, new Date(), "http请求错误", url,"get_music_videos",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinLite",code, new Date(), "业务请求错误", url,"get_music_videos",result);

        }
        else {
            testResultDao.insertResult("DouyinLite",200, new Date(), "成功", url,"get_music_videos",result);
            System.out.println("成功，" + "请求url：" + url);
        }


    }


    @Test
    public void get_promotion_list() throws IOException {
        //获取商品橱窗列表
        String result = "";
        String url = "http://47.97.206.10/api/douyin_lite/get_promotion_list?user_id=105621336289&cursor=0&count=2";
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
            testResultDao.insertResult("DouyinLite",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_promotion_list",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("DouyinLite",Statuscode, new Date(), "http请求错误", url,"get_promotion_list",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinLite",code, new Date(), "业务请求错误", url,"get_promotion_list",result);

        }
        else {
            testResultDao.insertResult("DouyinLite",200, new Date(), "成功", url,"get_promotion_list",result);
            System.out.println("成功，" + "请求url：" + url);
        }


    }

    @Test
    public void get_webcast_room_info() throws IOException {
        //获取直播房间信息
        String result = "";
        String url = "http://47.97.206.10/api/douyin_lite/get_webcast_room_info?room_id=6731613896211188484";
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
            testResultDao.insertResult("DouyinLite",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_webcast_room_info",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("DouyinLite",Statuscode, new Date(), "http请求错误", url,"get_webcast_room_info",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinLite",code, new Date(), "业务请求错误", url,"get_webcast_room_info",result);

        }
        else {
            testResultDao.insertResult("DouyinLite",200, new Date(), "成功", url,"get_webcast_room_info",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }

    @Test
    public void get_webcast_user_info() throws IOException {
        //获取直播用户信息
        String result = "";
        String url = "http://47.97.206.10/api/douyin_lite/get_webcast_user_info?room_id=6731613896211188484&user_id=108160072764";
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
            testResultDao.insertResult("DouyinLite",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_webcast_user_info",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("DouyinLite",Statuscode, new Date(), "http请求错误", url,"get_webcast_user_info",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinLite",code, new Date(), "业务请求错误", url,"get_webcast_user_info",result);

        }
        else {
            testResultDao.insertResult("DouyinLite",200, new Date(), "成功", url,"get_webcast_user_info",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }

    @Test
    public void get_webcast_ranklist() throws IOException {
        //获取直播本场榜
        String result = "";
        String url = "http://47.97.206.10/api/douyin_lite/get_webcast_ranklist?room_id=6731613896211188484&anchor_id=108160072764";
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
            testResultDao.insertResult("DouyinLite",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_webcast_ranklist",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("DouyinLite",Statuscode, new Date(), "http请求错误", url,"get_webcast_ranklist",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinLite",code, new Date(), "业务请求错误", url,"get_webcast_ranklist",result);

        }
        else {
            testResultDao.insertResult("DouyinLite",200, new Date(), "成功", url,"get_webcast_ranklist",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    */
}
