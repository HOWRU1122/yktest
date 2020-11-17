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
public class JingDongTest {

    @Autowired
    private TestResultDao testResultDao;
    @Test
    public void crawlPageShopProducts() throws IOException {
        //店铺内的商品列表
        String result = "";
        String url = "http://47.114.196.142:5000/api/jd/crawlPageShopProducts?shop_id=1000000925&page=0&page_size=3";
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
            testResultDao.insertResult("JingDong",500, new Date(), "测试异常，e:" + e.getMessage(), url, "crawlPageShopProducts",result);
            return;
        }
        if (msg.toString().contains("timed out")) {
            testResultDao.insertResult("JingDong", 400, new Date(), "timed out", url, "crawlPageShopProducts", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("JingDong",Statuscode, new Date(), "http请求错误", url,"crawlPageShopProducts",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("JingDong",code, new Date(), "业务请求错误", url,"crawlPageShopProducts",result);
        }
        else {
            testResultDao.insertResult("JingDong",200, new Date(), "成功", url,"crawlPageShopProducts",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void crawlPageByBrandName() throws IOException {
        //获取品牌商品列表
        String result = "";
        String url = "http://47.114.196.142:5000/api/jd/crawlPageByBrandName?brandName=三星";
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
            testResultDao.insertResult("JingDong",500, new Date(), "测试异常，e:" + e.getMessage(), url, "crawlPageByBrandName",result);
            return;
        }
        if (msg.toString().contains("timed out")) {
            testResultDao.insertResult("JingDong", 400, new Date(), "timed out", url, "crawlPageByBrandName", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("JingDong",Statuscode, new Date(), "http请求错误", url,"crawlPageByBrandName",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("JingDong",code, new Date(), "业务请求错误", url,"crawlPageByBrandName",result);
        }
        else {
            testResultDao.insertResult("JingDong",200, new Date(), "成功", url,"crawlPageByBrandName",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void crawlSkuComment() throws IOException {
        //获取某个商品的评论列表
        String result = "";
        String url = "http://47.114.196.142:5000/api/jd/crawlSkuComment?product_id=100000538392";
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
            testResultDao.insertResult("JingDong",500, new Date(), "测试异常，e:" + e.getMessage(), url, "crawlSkuComment",result);
            return;
        }
        if (msg.toString().contains("timed out")) {
            testResultDao.insertResult("JingDong", 400, new Date(), "timed out", url, "crawlSkuComment", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("JingDong",Statuscode, new Date(), "http请求错误", url,"crawlSkuComment",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("JingDong",code, new Date(), "业务请求错误", url,"crawlSkuComment",result);
        }
        else {
            testResultDao.insertResult("JingDong",200, new Date(), "成功", url,"crawlSkuComment",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void crawlSkuCommentAndCount() throws IOException {
        //获取某个商品的评论列表和总数
        String result = "";
        String url = "http://47.114.196.142:5000/api/jd/crawlSkuCommentAndCount?product_id=100000538392&page=0";
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
            testResultDao.insertResult("JingDong",500, new Date(), "测试异常，e:" + e.getMessage(), url, "crawlSkuCommentAndCount",result);
            return;
        }
        if (msg.toString().contains("timed out")) {
            testResultDao.insertResult("JingDong", 400, new Date(), "timed out", url, "crawlSkuCommentAndCount", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("JingDong",Statuscode, new Date(), "http请求错误", url,"crawlSkuCommentAndCount",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("JingDong",code, new Date(), "业务请求错误", url,"crawlSkuCommentAndCount",result);
        }
        else {
            testResultDao.insertResult("JingDong",200, new Date(), "成功", url,"crawlSkuCommentAndCount",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void crawlShopDetails() throws IOException {
        //获取店铺详情
        String result = "";
        String url = "http://47.114.196.142:5000/api/jd/crawlShopDetails?shop_list=[1000000925]";
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
            testResultDao.insertResult("JingDong",500, new Date(), "测试异常，e:" + e.getMessage(), url, "crawlShopDetails",result);
            return;
        }
        if (msg.toString().contains("timed out")) {
            testResultDao.insertResult("JingDong", 400, new Date(), "timed out", url, "crawlShopDetails", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("JingDong",Statuscode, new Date(), "http请求错误", url,"crawlShopDetails",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("JingDong",code, new Date(), "业务请求错误", url,"crawlShopDetails",result);
        }
        else {
            testResultDao.insertResult("JingDong",200, new Date(), "成功", url,"crawlShopDetails",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void crawlShopVenderId() throws IOException {
        //获取店铺简要概况
        String result = "";
        String url = "http://47.114.196.142:5000/api/jd/crawlShopVenderId?shop_id=1000000925";
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
            testResultDao.insertResult("JingDong",500, new Date(), "测试异常，e:" + e.getMessage(), url, "crawlShopVenderId",result);
            return;
        }
        if (msg.toString().contains("timed out")) {
            testResultDao.insertResult("JingDong", 400, new Date(), "timed out", url, "crawlShopVenderId", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("JingDong",Statuscode, new Date(), "http请求错误", url,"crawlShopVenderId",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("JingDong",code, new Date(), "业务请求错误", url,"crawlShopVenderId",result);
        }
        else {
            testResultDao.insertResult("JingDong",200, new Date(), "成功", url,"crawlShopVenderId",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void crawlSkuPrices() throws IOException {
        //获取产品的sku列表
        String result = "";
        String url = "http://47.114.196.142:5000/api/jd/crawlSkuPrices?product_list=[100000538392]";
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
            testResultDao.insertResult("JingDong",500, new Date(), "测试异常，e:" + e.getMessage(), url, "crawlSkuPrices",result);
            return;
        }
        if (msg.toString().contains("timed out")) {
            testResultDao.insertResult("JingDong", 400, new Date(), "timed out", url, "crawlSkuPrices", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("JingDong",Statuscode, new Date(), "http请求错误", url,"crawlSkuPrices",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("JingDong",code, new Date(), "业务请求错误", url,"crawlSkuPrices",result);
        }
        else {
            testResultDao.insertResult("JingDong",200, new Date(), "成功", url,"crawlSkuPrices",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void crawlCommentsCounts() throws IOException {
        //获取评论的详情
        String result = "";
        String url = "http://47.114.196.142:5000/api/jd/crawlCommentsCounts?product_list=[100000538392]";
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
            testResultDao.insertResult("JingDong",500, new Date(), "测试异常，e:" + e.getMessage(), url, "crawlCommentsCounts",result);
            return;
        }
        if (msg.toString().contains("timed out")) {
            testResultDao.insertResult("JingDong", 400, new Date(), "timed out", url, "crawlCommentsCounts", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("JingDong",Statuscode, new Date(), "http请求错误", url,"crawlCommentsCounts",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("JingDong",code, new Date(), "业务请求错误", url,"crawlCommentsCounts",result);
        }
        else {
            testResultDao.insertResult("JingDong",200, new Date(), "成功", url,"crawlCommentsCounts",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }
}
