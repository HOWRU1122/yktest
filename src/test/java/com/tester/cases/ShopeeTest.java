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
public class ShopeeTest {

    @Autowired
    private TestResultDao testResultDao;

    @Test
    public void get_cate_info() throws IOException {
        //获取类目信息
        String result = "";
        String url = "http://47.114.196.142:5000/api/shopee/get_cate_info";
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
            testResultDao.insertResult("Shopee",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_cate_info",result);
            return;
        }
        if (msg.toString().contains("请求失败")) {
            testResultDao.insertResult("Shopee", 400, new Date(), "请求失败，重试", url, "get_cate_info", result);
        }

        else if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("Shopee", 400, new Date(), "获取响应失败,重试超过阈值", url, "get_cate_info", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("Shopee",Statuscode, new Date(), "http请求错误", url,"get_cate_info",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("Shopee",code, new Date(), "业务请求错误", url,"get_cate_info",result);
        }
        else {
            testResultDao.insertResult("Shopee",200, new Date(), "成功", url,"get_cate_info",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_cate_item() throws IOException {
        //获取类目商品
        String result = "";
        String url = "http://47.114.196.142:5000/api/shopee/get_cate_item?cate_id=20346&cate_name=car%20lights&limit=10&newest=0";
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
            testResultDao.insertResult("Shopee",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_cate_item",result);
            return;
        }
        if (msg.toString().contains("请求失败")) {
            testResultDao.insertResult("Shopee", 400, new Date(), "请求失败，重试", url, "get_cate_item", result);
        }

        else if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("Shopee", 400, new Date(), "获取响应失败,重试超过阈值", url, "get_cate_item", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("Shopee",Statuscode, new Date(), "http请求错误", url,"get_cate_item",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("Shopee",code, new Date(), "业务请求错误", url,"get_cate_item",result);
        }
        else {
            testResultDao.insertResult("Shopee",200, new Date(), "成功", url,"get_cate_item",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }


    @Test
    public void get_shop_item() throws IOException {
        //获取店铺商品
        String result = "";
        String url = "http://47.114.196.142:5000/api/shopee/get_shop_item?shop_id=107888208&limit=10&newest=0";
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
            testResultDao.insertResult("Shopee",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_shop_item",result);
            return;
        }
        if (msg.toString().contains("请求失败")) {
            testResultDao.insertResult("Shopee", 400, new Date(), "请求失败，重试", url, "get_shop_item", result);
        }

        else if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("Shopee", 400, new Date(), "获取响应失败,重试超过阈值", url, "get_shop_item", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("Shopee",Statuscode, new Date(), "http请求错误", url,"get_shop_item",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("Shopee",code, new Date(), "业务请求错误", url,"get_shop_item",result);
        }
        else {
            testResultDao.insertResult("Shopee",200, new Date(), "成功", url,"get_shop_item",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }


    @Test
    public void get_shop_info() throws IOException {
        //获取店铺信息
        String result = "";
        String url = "http://47.114.196.142:5000/api/shopee/get_shop_info?shop_id=107888208";
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
            testResultDao.insertResult("Shopee",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_shop_info",result);
            return;
        }
        if (msg.toString().contains("请求失败")) {
            testResultDao.insertResult("Shopee", 400, new Date(), "请求失败，重试", url, "get_shop_info", result);
        }

        else if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("Shopee", 400, new Date(), "获取响应失败,重试超过阈值", url, "get_shop_info", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("Shopee",Statuscode, new Date(), "http请求错误", url,"get_shop_info",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("Shopee",code, new Date(), "业务请求错误", url,"get_shop_info",result);
        }
        else {
            testResultDao.insertResult("Shopee",200, new Date(), "成功", url,"get_shop_info",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }


    @Test
    public void get_item_detail() throws IOException {
        //获取商品详情
        String result = "";
        String url = "http://47.114.196.142:5000/api/shopee/get_item_detail?item_id=1736867556&shop_id=107888208";
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
            testResultDao.insertResult("Shopee",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_item_detail",result);
            return;
        }
        if (msg.toString().contains("请求失败")) {
            testResultDao.insertResult("Shopee", 400, new Date(), "请求失败，重试", url, "get_item_detail", result);
        }

        else if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("Shopee", 400, new Date(), "获取响应失败,重试超过阈值", url, "get_item_detail", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("Shopee",Statuscode, new Date(), "http请求错误", url,"get_item_detail",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("Shopee",code, new Date(), "业务请求错误", url,"get_item_detail",result);
        }
        else {
            testResultDao.insertResult("Shopee",200, new Date(), "成功", url,"get_item_detail",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }


    @Test
    public void get_item_comment() throws IOException {
        //获取商品评论
        String result = "";
        String url = "http://47.114.196.142:5000/api/shopee/get_item_comment?item_id=1736867556&shop_id=107888208&limit=10&offset=0";
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
            testResultDao.insertResult("Shopee",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_item_comment",result);
            return;
        }
        if (msg.toString().contains("请求失败")) {
            testResultDao.insertResult("Shopee", 400, new Date(), "请求失败，重试", url, "get_item_comment", result);
        }

        else if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("Shopee", 400, new Date(), "获取响应失败,重试超过阈值", url, "get_item_comment", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("Shopee",Statuscode, new Date(), "http请求错误", url,"get_item_comment",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("Shopee",code, new Date(), "业务请求错误", url,"get_item_comment",result);
        }
        else {
            testResultDao.insertResult("Shopee",200, new Date(), "成功", url,"get_item_comment",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }
}
