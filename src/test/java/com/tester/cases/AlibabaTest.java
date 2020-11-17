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
public class AlibabaTest {

    @Autowired
    private TestResultDao testResultDao;

    @Test
    public void get_cate_info() throws IOException {
        //获取分类列表信息
        String result = "";
        String url = "http://47.114.196.142:5000/api/1688/get_cate_info";
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
            testResultDao.insertResult("Alibaba",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_cate_info",result);
            return;
        }
        if (msg.toString().contains("请求失败")) {
            testResultDao.insertResult("Alibaba", 400, new Date(), "请求失败，重试", url, "get_cate_info", result);
        }

        else if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("Alibaba", 400, new Date(), "获取响应失败,重试超过阈值", url, "get_cate_info", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("Alibaba",Statuscode, new Date(), "http请求错误", url,"get_cate_info",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("Alibaba",code, new Date(), "业务请求错误", url,"get_cate_info",result);
        }
        else {
            testResultDao.insertResult("Alibaba",200, new Date(), "成功", url,"get_cate_info",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_search_list() throws IOException {
        //关键词搜索
        String result = "";
        String url = "http://47.114.196.142:5000/api/1688/get_search_list?keywords=羊绒大衣&beginpage=1&asyncreq=1";
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
            testResultDao.insertResult("Alibaba",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_search_list",result);
            return;
        }
        if (msg.toString().contains("请求失败")) {
            testResultDao.insertResult("Alibaba", 400, new Date(), "请求失败，重试", url, "get_search_list", result);
        }

        else if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("Alibaba", 400, new Date(), "获取响应失败,重试超过阈值", url, "get_search_list", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("Alibaba",Statuscode, new Date(), "http请求错误", url,"get_search_list",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("Alibaba",code, new Date(), "业务请求错误", url,"get_search_list",result);
        }
        else {
            testResultDao.insertResult("Alibaba",200, new Date(), "成功", url,"get_search_list",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }
/*
    @Test
    public void get_product_info() throws IOException {
        // 获取商品信息
        String result = "";
        String url = "http://47.114.196.142:5000/api/1688/get_product_info?eurl=https://detail.1688.com/offer/612058393148.html?spm=a26352.13672862.offerlist.1.42945285pGNaZc&tracelog=p4p&clickid=d643c5c3e9b04adfb7f8952583049023&sessionid=1f5eb626e378a5c2429dfcb55b612970";
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
            testResultDao.insertResult("Alibaba",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_product_info",result);
            return;
        }
        if (msg.toString().contains("请求失败")) {
            testResultDao.insertResult("Alibaba", 400, new Date(), "请求失败，重试", url, "get_product_info", result);
        }

        else if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("Alibaba", 400, new Date(), "获取响应失败,重试超过阈值", url, "get_product_info", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("Alibaba",Statuscode, new Date(), "http请求错误", url,"get_product_info",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("Alibaba",code, new Date(), "业务请求错误", url,"get_product_info",result);
        }
        else {
            testResultDao.insertResult("Alibaba",200, new Date(), "成功", url,"get_product_info",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }
*/
    @Test
    public void get_shop_items() throws IOException {
        // 获取店铺商品列表
        String result = "";
        String url = "http://47.114.196.142:5000/api/1688/get_shop_items?member_id=b2b-2200638252755de6fa&page=1&size=20";
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
            testResultDao.insertResult("Alibaba",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_shop_items",result);
            return;
        }
        if (msg.toString().contains("请求失败")) {
            testResultDao.insertResult("Alibaba", 400, new Date(), "请求失败，重试", url, "get_shop_items", result);
        }

        else if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("Alibaba", 400, new Date(), "获取响应失败,重试超过阈值", url, "get_shop_items", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("Alibaba",Statuscode, new Date(), "http请求错误", url,"get_shop_items",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("Alibaba",code, new Date(), "业务请求错误", url,"get_shop_items",result);
        }
        else {
            testResultDao.insertResult("Alibaba",200, new Date(), "成功", url,"get_shop_items",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_item_info_h5() throws IOException {
        // 获取商品详情(h5)
        String result = "";
        String url = "http://47.114.196.142:5000/api/1688/get_item_info_h5?offer_id=598406781025";
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
            testResultDao.insertResult("Alibaba",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_item_info_h5",result);
            return;
        }
        if (msg.toString().contains("请求失败")) {
            testResultDao.insertResult("Alibaba", 400, new Date(), "请求失败，重试", url, "get_item_info_h5", result);
        }

        else if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("Alibaba", 400, new Date(), "获取响应失败,重试超过阈值", url, "get_item_info_h5", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("Alibaba",Statuscode, new Date(), "http请求错误", url,"get_item_info_h5",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("Alibaba",code, new Date(), "业务请求错误", url,"get_item_info_h5",result);
        }
        else {
            testResultDao.insertResult("Alibaba",200, new Date(), "成功", url,"get_item_info_h5",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_comment_list() throws IOException {
        // 获取商品评论列表
        String result = "";
        String url = "http://47.114.196.142:5000/api/1688/get_comment_list?offer_id=598406781025&user_id=2630700628&page=1";
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
            testResultDao.insertResult("Alibaba",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_comment_list",result);
            return;
        }
        if (msg.toString().contains("请求失败")) {
            testResultDao.insertResult("Alibaba", 400, new Date(), "请求失败，重试", url, "get_comment_list", result);
        }

        else if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("Alibaba", 400, new Date(), "获取响应失败,重试超过阈值", url, "get_comment_list", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("Alibaba",Statuscode, new Date(), "http请求错误", url,"get_comment_list",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("Alibaba",code, new Date(), "业务请求错误", url,"get_comment_list",result);
        }
        else {
            testResultDao.insertResult("Alibaba",200, new Date(), "成功", url,"get_comment_list",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }
}
