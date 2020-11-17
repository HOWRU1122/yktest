package com.tester.cases;

import com.alibaba.fastjson.JSONObject;
import com.tester.dao.TestResultDao;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
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
public class KaoLaTest {

    @Autowired
    private TestResultDao testResultDao;

    @Test
    public void leaf_cate() throws IOException {
        //获取考拉类目id
        String result = "";
        String url = "http://47.114.196.142:5000/api/kaola/leaf_cate";
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
            testResultDao.insertResult("KaoLa",500, new Date(), "测试异常，e:" + e.getMessage(), url, "leaf_cate",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("KaoLa",Statuscode, new Date(), "http请求错误", url,"leaf_cate",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("KaoLa",code, new Date(), "业务请求错误", url,"leaf_cate",result);
        }
        else {
            testResultDao.insertResult("KaoLa",200, new Date(), "成功", url,"leaf_cate",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void item_list() throws IOException {
        //根据类目获取商品
        String result = "";
        String url = "http://47.114.196.142:5000/api/kaola/item_list?cid=547&page_no=1&page_size=5";
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
            testResultDao.insertResult("KaoLa",500, new Date(), "测试异常，e:" + e.getMessage(), url, "item_list",result);
            return;
        }
        if (msg.toString().contains("提取页面数据失败")) {
            testResultDao.insertResult("KaoLa", 400, new Date(), "提取页面数据失败", url, "item_list", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("KaoLa",Statuscode, new Date(), "http请求错误", url,"item_list",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("KaoLa",code, new Date(), "业务请求错误", url,"item_list",result);
        }
        else {
            testResultDao.insertResult("KaoLa",200, new Date(), "成功", url,"item_list",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }
    @Test
    public void item_detail() throws IOException {
        //获取单个商品详情
        String result = "";
        String url = "http://47.114.196.142:5000/api/kaola/item_detail?item_id=1991396";
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
            testResultDao.insertResult("KaoLa",500, new Date(), "测试异常，e:" + e.getMessage(), url, "item_detail",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("KaoLa",Statuscode, new Date(), "http请求错误", url,"item_detail",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("KaoLa",code, new Date(), "业务请求错误", url,"item_detail",result);
        }
        else {
            testResultDao.insertResult("KaoLa",200, new Date(), "成功", url,"item_detail",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void shop_info() throws IOException {
        //获取店铺信息
        String result = "";
        String url = "http://47.114.196.142:5000/api/kaola/shop_info?shop_id=23072595";
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
            testResultDao.insertResult("KaoLa",500, new Date(), "测试异常，e:" + e.getMessage(), url, "shop_info",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("KaoLa",Statuscode, new Date(), "http请求错误", url,"shop_info",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("KaoLa",code, new Date(), "业务请求错误", url,"shop_info",result);
        }
        else {
            testResultDao.insertResult("KaoLa",200, new Date(), "成功", url,"shop_info",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void shop_item() throws IOException {
        //获取店铺商品
        String result = "";
        String url = "http://47.114.196.142:5000/api/kaola/shop_item?shop_id=104975581&page=1&page_size=5";
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
            testResultDao.insertResult("KaoLa",500, new Date(), "测试异常，e:" + e.getMessage(), url, "shop_item",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("KaoLa",Statuscode, new Date(), "http请求错误", url,"shop_item",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("KaoLa",code, new Date(), "业务请求错误", url,"shop_item",result);
        }
        else {
            testResultDao.insertResult("KaoLa",200, new Date(), "成功", url,"shop_item",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }
}
