package com.tester.cases;

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
public class XHSv1Test {

    @Autowired
    private TestResultDao testResultDao;

    @Test
    public void home_feed() throws IOException {
        //首页推荐
        String result = "";
        String url = "http://47.114.196.142:5000/api/xhs_v1/home_feed";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code,Statuscode;
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
            testResultDao.insertResult("XHSv1",500, new Date(), "测试异常，e:" + e.getMessage(), url, "home_feed",result);
            return;
        }
        if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("XHSv1", 400, new Date(), "获取响应失败,重试超过阈值", url, "home_feed", result);
        }
        else if (msg.toString().contains("加密参数错误")) {
            testResultDao.insertResult("XHSv1", 400, new Date(), "加密参数错误,重试", url, "home_feed", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("XHSv1",Statuscode, new Date(), "http请求错误", url,"home_feed",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("XHSv1",code, new Date(), "业务请求错误", url,"home_feed",result);
        }
        else {
            testResultDao.insertResult("XHSv1",200, new Date(), "成功", url,"home_feed",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void user_info() throws IOException {
        //用户信息
        String result = "";
        String url = "http://47.114.196.142:5000/api/xhs_v1/user_info?user_id=5a73c5fa4eacab4c4ccc9778";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code,Statuscode;
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
            testResultDao.insertResult("XHSv1",500, new Date(), "测试异常，e:" + e.toString(), url, "user_info",result);
            return;
        }
        if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("XHSv1", 400, new Date(), "获取响应失败,重试超过阈值", url, "user_info", result);
        }
        else if (msg.toString().contains("加密参数错误")) {
            testResultDao.insertResult("XHSv1", 400, new Date(), "加密参数错误,重试", url, "user_info", result);
        }
       else if (Statuscode != 200){
            testResultDao.insertResult("XHSv1",Statuscode, new Date(), "http请求错误", url,"user_info",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("XHSv1",code, new Date(), "业务请求错误", url,"user_info",result);
        }
        else {
            testResultDao.insertResult("XHSv1",200, new Date(), "成功", url,"user_info",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void user_note() throws IOException {
        //用户笔记
        String result = "";
        String url = "http://47.114.196.142:5000/api/xhs_v1/user_note?user_id=5a73c5fa4eacab4c4ccc9778&page=1&page_size=10";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code,Statuscode;
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
            testResultDao.insertResult("XHSv1",500, new Date(), "测试异常，e:" + e.getMessage(), url, "user_note",result);
            return;
        }
        if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("XHSv1", 400, new Date(), "获取响应失败,重试超过阈值", url, "user_note", result);
        }
        else if (msg.toString().contains("加密参数错误")) {
            testResultDao.insertResult("XHSv1", 400, new Date(), "加密参数错误,重试", url, "user_note", result);
        }
       else if (Statuscode != 200){
            testResultDao.insertResult("XHSv1",Statuscode, new Date(), "http请求错误", url,"user_note",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("XHSv1",code, new Date(), "业务请求错误", url,"user_note",result);
        }
        else {
            testResultDao.insertResult("XHSv1",200, new Date(), "成功", url,"user_note",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }
    @Test
    public void note_detail() throws IOException {
        //笔记详情
        String result = "";
        String url = "http://47.114.196.142:5000/api/xhs_v1/note_detail?note_id=5df5d21d000000000100790c";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code,Statuscode;
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
            testResultDao.insertResult("XHSv1",500, new Date(), "测试异常，e:" + e.getMessage(), url, "note_detail",result);
            return;
        }
        if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("XHSv1", 400, new Date(), "获取响应失败,重试超过阈值", url, "note_detail", result);
        }
        else if (msg.toString().contains("加密参数错误")) {
            testResultDao.insertResult("XHSv1", 400, new Date(), "加密参数错误,重试", url, "note_detail", result);
        }
       else if (Statuscode != 200){
            testResultDao.insertResult("XHSv1",Statuscode, new Date(), "http请求错误", url,"note_detail",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("XHSv1",code, new Date(), "业务请求错误", url,"note_detail",result);
        }
        else {
            testResultDao.insertResult("XHSv1",200, new Date(), "成功", url,"note_detail",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void note_comments() throws IOException {
        //笔记评论
        String result = "";
        String url = "http://47.114.196.142:5000/api/xhs_v1/note_comments?note_id=5df5d21d000000000100790c&num=10&start=5df738e200000000010091d4";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code,Statuscode;
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
            testResultDao.insertResult("XHSv1",500, new Date(), "测试异常，e:" + e.getMessage(), url, "note_comments",result);
            return;
        }
        if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("XHSv1", 400, new Date(), "获取响应失败,重试超过阈值", url, "note_comments", result);
        }
        else if (msg.toString().contains("加密参数错误")) {
            testResultDao.insertResult("XHSv1", 400, new Date(), "加密参数错误,重试", url, "note_comments", result);
        }
       else if (Statuscode != 200){
            testResultDao.insertResult("XHSv1",Statuscode, new Date(), "http请求错误", url,"note_comments",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("XHSv1",code, new Date(), "业务请求错误", url,"note_comments",result);
        }
        else {
            testResultDao.insertResult("XHSv1",200, new Date(), "成功", url,"note_comments",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void user_video() throws IOException {
        //用户视频
        String result = "";
        String url = "http://47.114.196.142:5000/api/xhs_v1/user_video?user_id=5a73c5fa4eacab4c4ccc9778&page=1&page_size=10";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code,Statuscode;
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
            testResultDao.insertResult("XHSv1",500, new Date(), "测试异常，e:" + e.getMessage(), url, "user_video",result);
            return;
        }
        if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("XHSv1", 400, new Date(), "获取响应失败,重试超过阈值", url, "user_video", result);
        }
        else if (msg.toString().contains("加密参数错误")) {
            testResultDao.insertResult("XHSv1", 400, new Date(), "加密参数错误,重试", url, "user_video", result);
        }
       else if (Statuscode != 200){
            testResultDao.insertResult("XHSv1",Statuscode, new Date(), "http请求错误", url,"user_video",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("XHSv1",code, new Date(), "业务请求错误", url,"user_video",result);
        }
        else {
            testResultDao.insertResult("XHSv1",200, new Date(), "成功", url,"user_video",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void video_detail() throws IOException {
        //视频详情
        String result = "";
        String url = "http://47.114.196.142:5000/api/xhs_v1/video_detail?note_id=5dadbbfa0000000001001129";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code,Statuscode;
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
            testResultDao.insertResult("XHSv1",500, new Date(), "测试异常，e:" + e.getMessage(), url, "video_detail",result);
            return;
        }
        if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("XHSv1", 400, new Date(), "获取响应失败,重试超过阈值", url, "video_detail", result);
        }
        else if (msg.toString().contains("加密参数错误")) {
            testResultDao.insertResult("XHSv1", 400, new Date(), "加密参数错误,重试", url, "video_detail", result);
        }
       else if (Statuscode != 200){
            testResultDao.insertResult("XHSv1",Statuscode, new Date(), "http请求错误", url,"video_detail",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("XHSv1",code, new Date(), "业务请求错误", url,"video_detail",result);
        }
        else {
            testResultDao.insertResult("XHSv1",200, new Date(), "成功", url,"video_detail",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void user_focus() throws IOException {
        //用户关注
        String result = "";
        String url = "http://47.114.196.142:5000/api/xhs_v1/user_focus?user_id=5a73c5fa4eacab4c4ccc9778";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code,Statuscode;
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
            testResultDao.insertResult("XHSv1",500, new Date(), "测试异常，e:" + e.getMessage(), url, "user_focus",result);
            return;
        }
        if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("XHSv1", 400, new Date(), "获取响应失败,重试超过阈值", url, "user_focus", result);
        }
        else if (msg.toString().contains("加密参数错误")) {
            testResultDao.insertResult("XHSv1", 400, new Date(), "加密参数错误,重试", url, "user_focus", result);
        }
       else if (Statuscode != 200){
            testResultDao.insertResult("XHSv1",Statuscode, new Date(), "http请求错误", url,"user_focus",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("XHSv1",code, new Date(), "业务请求错误", url,"user_focus",result);
        }
        else {
            testResultDao.insertResult("XHSv1",200, new Date(), "成功", url,"user_focus",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void user_fans() throws IOException {
        //用户粉丝
        String result = "";
        String url = "http://47.114.196.142:5000/api/xhs_v1/user_fans?user_id=5a73c5fa4eacab4c4ccc9778&start=5666f2cc82ec397fccb607a4";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code,Statuscode;
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
            testResultDao.insertResult("XHSv1",500, new Date(), "测试异常，e:" + e.getMessage(), url, "user_fans",result);
            return;
        }
        if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("XHSv1", 400, new Date(), "获取响应失败,重试超过阈值", url, "user_fans", result);
        }
        else if (msg.toString().contains("加密参数错误")) {
            testResultDao.insertResult("XHSv1", 400, new Date(), "加密参数错误,重试", url, "user_fans", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("XHSv1",Statuscode, new Date(), "http请求错误", url,"user_fans",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("XHSv1",code, new Date(), "业务请求错误", url,"user_fans",result);
        }
        else {
            testResultDao.insertResult("XHSv1",200, new Date(), "成功", url,"user_fans",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void user_search() throws IOException {
        //用户关键词搜索
        String result = "";
        String url = "http://47.114.196.142:5000/api/xhs_v1/user/search?keyword=hello&page=1&page_size=20";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code,Statuscode;
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
            testResultDao.insertResult("XHSv1",500, new Date(), "测试异常，e:" + e.getMessage(), url, "user_search",result);
            return;
        }
        if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("XHSv1", 400, new Date(), "获取响应失败,重试超过阈值", url, "user_search", result);
        }
        else if (msg.toString().contains("Sorry, your cid can request up to 200000 times per day")) {
            testResultDao.insertResult("XHSv1", 400, new Date(), "次数用完", url, "user_search", result);
        }
        else if (msg.toString().contains("加密参数错误")) {
            testResultDao.insertResult("XHSv1", 400, new Date(), "加密参数错误,重试", url, "user_search", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("XHSv1",Statuscode, new Date(), "http请求错误", url,"user_search",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("XHSv1",code, new Date(), "业务请求错误", url,"user_search",result);
        }
        else {
            testResultDao.insertResult("XHSv1",200, new Date(), "成功", url,"user_search",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }
}
