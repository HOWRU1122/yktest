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
public class JingDongV2Test {

    @Autowired
    private TestResultDao testResultDao;


    @Test
    public void get_homepage() throws IOException {
        //获取首页数据
        String result = "";
        String url = "http://47.114.196.142:5000/api/jd_v2/get_homepage";
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
            testResultDao.insertResult("JingDongV2",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_homepage",result);
            return;
        }
        if (msg.toString().contains("timed out")) {
            testResultDao.insertResult("JingDongV2", 400, new Date(), "timed out", url, "get_homepage", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("JingDongV2",Statuscode, new Date(), "http请求错误", url,"get_homepage",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("JingDongV2",code, new Date(), "业务请求错误", url,"get_homepage",result);
        }
        else {
            testResultDao.insertResult("JingDongV2",200, new Date(), "成功", url,"get_homepage",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }


    @Test
    public void get_goods_detail() throws IOException {
        //获取商品详情
        String result = "";
        String url = "http://47.114.196.142:5000/api/jd_v2/get_goods_detail?sku_id=41803015029&lng=113.714872&lat=34.760459";
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
            testResultDao.insertResult("JingDongV2",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_goods_detail",result);
            return;
        }
        if (msg.toString().contains("timed out")) {
            testResultDao.insertResult("JingDongV2", 400, new Date(), "timed out", url, "get_goods_detail", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("JingDongV2",Statuscode, new Date(), "http请求错误", url,"get_goods_detail",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("JingDongV2",code, new Date(), "业务请求错误", url,"get_goods_detail",result);
        }
        else {
            testResultDao.insertResult("JingDongV2",200, new Date(), "成功", url,"get_goods_detail",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }


    @Test
    public void get_comment_list() throws IOException {
        //获取商品评论
        String result = "";
        String url = "http://47.114.196.142:5000/api/jd_v2/get_comment_list?sku_id=41803015029&offset=1";
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
            testResultDao.insertResult("JingDongV2",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_comment_list",result);
            return;
        }
        if (msg.toString().contains("timed out")) {
            testResultDao.insertResult("JingDongV2", 400, new Date(), "timed out", url, "get_comment_list", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("JingDongV2",Statuscode, new Date(), "http请求错误", url,"get_comment_list",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("JingDongV2",code, new Date(), "业务请求错误", url,"get_comment_list",result);
        }
        else {
            testResultDao.insertResult("JingDongV2",200, new Date(), "成功", url,"get_comment_list",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }


    @Test
    public void discovery_live_list() throws IOException {
        //获取直播推荐列表
        String result = "";
        String url = "http://47.114.196.142:5000/api/jd_v2/discovery_live_list?page=1";
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
            testResultDao.insertResult("JingDongV2",500, new Date(), "测试异常，e:" + e.getMessage(), url, "discovery_live_list",result);
            return;
        }
        if (msg.toString().contains("timed out")) {
            testResultDao.insertResult("JingDongV2", 400, new Date(), "timed out", url, "discovery_live_list", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("JingDongV2",Statuscode, new Date(), "http请求错误", url,"discovery_live_list",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("JingDongV2",code, new Date(), "业务请求错误", url,"discovery_live_list",result);
        }
        else {
            testResultDao.insertResult("JingDongV2",200, new Date(), "成功", url,"discovery_live_list",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }


    @Test
    public void get_live_detail() throws IOException {
        //获取直播详情
        String result = "";
        String url = "http://47.114.196.142:5000/api/jd_v2/get_live_detail?live_id=1112269";
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
            testResultDao.insertResult("JingDongV2",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_live_detail",result);
            return;
        }
        if (msg.toString().contains("timed out")) {
            testResultDao.insertResult("JingDongV2", 400, new Date(), "timed out", url, "get_live_detail", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("JingDongV2",Statuscode, new Date(), "http请求错误", url,"get_live_detail",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("JingDongV2",code, new Date(), "业务请求错误", url,"get_live_detail",result);
        }
        else {
            testResultDao.insertResult("JingDongV2",200, new Date(), "成功", url,"get_live_detail",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }


    @Test
    public void get_live_card_detail() throws IOException {
        //获取直播商品列表
        String result = "";
        String url = "http://47.114.196.142:5000/api/jd_v2/get_live_card_detail?live_id=1112269";
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
            testResultDao.insertResult("JingDongV2",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_live_card_detail",result);
            return;
        }
        if (msg.toString().contains("timed out")) {
            testResultDao.insertResult("JingDongV2", 400, new Date(), "timed out", url, "get_live_card_detail", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("JingDongV2",Statuscode, new Date(), "http请求错误", url,"get_live_card_detail",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("JingDongV2",code, new Date(), "业务请求错误", url,"get_live_card_detail",result);
        }
        else {
            testResultDao.insertResult("JingDongV2",200, new Date(), "成功", url,"get_live_card_detail",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }


    @Test
    public void get_live_author_info() throws IOException {
        //获取主播信息
        String result = "";
        String url = "http://47.114.196.142:5000/api/jd_v2/get_live_author_info?author_id=591810&live_id=1112269";
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
            testResultDao.insertResult("JingDongV2",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_live_author_info",result);
            return;
        }
        if (msg.toString().contains("timed out")) {
            testResultDao.insertResult("JingDongV2", 400, new Date(), "timed out", url, "get_live_author_info", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("JingDongV2",Statuscode, new Date(), "http请求错误", url,"get_live_author_info",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("JingDongV2",code, new Date(), "业务请求错误", url,"get_live_author_info",result);
        }
        else {
            testResultDao.insertResult("JingDongV2",200, new Date(), "成功", url,"get_live_author_info",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }


    @Test
    public void get_keyword_search() throws IOException {
        //获取关键词搜索
        String result = "";
        String url = "http://47.114.196.142:5000/api/jd_v2/get_keyword_search?keyword=华为手机&page=1&lng=113.714872&lat=34.760459";
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
            testResultDao.insertResult("JingDongV2",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_keyword_search",result);
            return;
        }
        if (msg.toString().contains("timed out")) {
            testResultDao.insertResult("JingDongV2", 400, new Date(), "timed out", url, "get_keyword_search", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("JingDongV2",Statuscode, new Date(), "http请求错误", url,"get_keyword_search",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("JingDongV2",code, new Date(), "业务请求错误", url,"get_keyword_search",result);
        }
        else {
            testResultDao.insertResult("JingDongV2",200, new Date(), "成功", url,"get_keyword_search",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }
}
