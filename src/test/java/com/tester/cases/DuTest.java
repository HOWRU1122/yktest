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
public class DuTest {

    @Autowired
    private TestResultDao testResultDao;

    @Test
    public void call_nums() throws IOException {
        //调用次数
        String result = "";
        String url = "http://47.114.196.142:5000/api/du/call_nums";
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
            testResultDao.insertResult("Du",500, new Date(), "测试异常，e:" + e.getMessage(), url, "call_nums",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("Du",Statuscode, new Date(), "http请求错误", url,"call_nums",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("Du",code, new Date(), "业务请求错误", url,"call_nums",result);
        }
        else {
            testResultDao.insertResult("Du",200, new Date(), "成功", url,"call_nums",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void ice_shopping() throws IOException {
        //获取首页推荐
        String result = "";
        String url = "http://47.114.196.142:5000/api/du/ice_shopping";
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
            testResultDao.insertResult("Du",500, new Date(), "测试异常，e:" + e.getMessage(), url, "ice_shopping",result);
            return;
        }
        if (msg.toString().contains("Sorry, your cid can request up to 3000 times per day")) {
            testResultDao.insertResult("Du", 400, new Date(), "次数用完", url, "ice_shopping", result);
        }
       else if (Statuscode != 200){
            testResultDao.insertResult("Du",Statuscode, new Date(), "http请求错误", url,"ice_shopping",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("Du",code, new Date(), "业务请求错误", url,"ice_shopping",result);
        }
        else {
            testResultDao.insertResult("Du",200, new Date(), "成功", url,"ice_shopping",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void ice_shopping_tab() throws IOException {
        //获取首页tab页数据
        String result = "";
        String url = "http://47.114.196.142:5000/api/du/ice_shopping_tab?tab_id=13";
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
            testResultDao.insertResult("Du",500, new Date(), "测试异常，e:" + e.getMessage(), url, "ice_shopping_tab",result);
            return;
        }
        if (msg.toString().contains("Sorry, your cid can request up to 3000 times per day")) {
            testResultDao.insertResult("Du", 400, new Date(), "次数用完", url, "ice_shopping_tab", result);
        }
       else if (Statuscode != 200){
            testResultDao.insertResult("Du",Statuscode, new Date(), "http请求错误", url,"ice_shopping_tab",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("Du",code, new Date(), "业务请求错误", url,"ice_shopping_tab",result);
        }
        else {
            testResultDao.insertResult("Du",200, new Date(), "成功", url,"ice_shopping_tab",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void item_detail() throws IOException {
        //获取商品详情
        String result = "";
        String url = "http://47.114.196.142:5000/api/du/item/detail?item_id=57388";
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
            testResultDao.insertResult("Du",500, new Date(), "测试异常，e:" + e.getMessage(), url, "item_detail",result);
            return;
        }
        if (msg.toString().contains("Sorry, your cid can request up to 3000 times per day")) {
            testResultDao.insertResult("Du", 400, new Date(), "次数用完", url, "item_detail", result);
        }
       else if (Statuscode != 200){
            testResultDao.insertResult("Du",Statuscode, new Date(), "http请求错误", url,"item_detail",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("Du",code, new Date(), "业务请求错误", url,"item_detail",result);
        }
        else {
            testResultDao.insertResult("Du",200, new Date(), "成功", url,"item_detail",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void sold_list() throws IOException {
        //获取商品最近购买列表
        String result = "";
        String url = "http://47.114.196.142:5000/api/du/item/sold_list?item_id=57388";
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
            testResultDao.insertResult("Du",500, new Date(), "测试异常，e:" + e.getMessage(), url, "sold_list",result);
            return;
        }
        if (msg.toString().contains("Sorry, your cid can request up to 3000 times per day")) {
            testResultDao.insertResult("Du", 400, new Date(), "次数用完", url, "sold_list", result);
        }
       else if (Statuscode != 200){
            testResultDao.insertResult("Du",Statuscode, new Date(), "http请求错误", url,"sold_list",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("Du",code, new Date(), "业务请求错误", url,"sold_list",result);
        }
        else {
            testResultDao.insertResult("Du",200, new Date(), "成功", url,"sold_list",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }
}
