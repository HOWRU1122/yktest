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
public class TBTest {
    @Autowired
    private TestResultDao testResultDao;
    @Test
    public void get_tb_comment() throws IOException {
        //淘宝评论
        String result = new String();
        String url = "http://47.114.196.142:5000/api/tb/get_tb_comment?item_id=22538999781&page=1&size=20";
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
            testResultDao.insertResult("TB",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_tb_comment",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("TB",Statuscode, new Date(), "http请求错误", url,"get_tb_comment",result);

        }
        if (msg.toString().contains("RemoteDisconnected")) {
            testResultDao.insertResult("TB", 400, new Date(), "拒绝访问", url, "get_tb_comment", result);
        }
        else if (code != 0) {
            testResultDao.insertResult("TB",code, new Date(), "业务请求错误", url,"get_tb_comment",result);

        }
        else {
            testResultDao.insertResult("TB",200, new Date(), "成功", url,"get_tb_comment",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }

    @Test
    public void get_good_goods() throws IOException {
        //获取 "有好货" 商品
        String result = new String();
        String url = "http://47.114.196.142:5000/api/tb/get_good_goods?tab_id=0&page=1&size=20";
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
            testResultDao.insertResult("TB",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_good_goods",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("TB",Statuscode, new Date(), "http请求错误", url,"get_good_goods",result);

        }
        if (msg.toString().contains("RemoteDisconnected")) {
            testResultDao.insertResult("TB", 400, new Date(), "拒绝访问", url, "get_good_goods", result);
        }
        else if (code != 0) {
            testResultDao.insertResult("TB",code, new Date(), "业务请求错误", url,"get_good_goods",result);

        }
        else {
            testResultDao.insertResult("TB",200, new Date(), "成功", url,"get_good_goods",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }

    @Test
    public void get_goods_detail() throws IOException {
        //获取 "有好货" 商品
        String result = new String();
        String url = "http://47.114.196.142:5000/api/tb/get_goods_detail?item_id=226527479393";
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
            testResultDao.insertResult("TB",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_goods_detail",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("TB",Statuscode, new Date(), "http请求错误", url,"get_goods_detail",result);

        }
        if (msg.toString().contains("RemoteDisconnected")) {
            testResultDao.insertResult("TB", 400, new Date(), "拒绝访问", url, "get_goods_detail", result);
        }
        else if (code != 0) {
            testResultDao.insertResult("TB",code, new Date(), "业务请求错误", url,"get_goods_detail",result);

        }
        else {
            testResultDao.insertResult("TB",200, new Date(), "成功", url,"get_goods_detail",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }

    @Test
    public void get_daren_info() throws IOException {
        //获取达人信息
        String result = new String();
        String url = "http://47.114.196.142:5000/api/tb/get_daren_info?user_id=3327431407";
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
            testResultDao.insertResult("TB",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_daren_info",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("TB",Statuscode, new Date(), "http请求错误", url,"get_daren_info",result);

        }
        if (msg.toString().contains("RemoteDisconnected")) {
            testResultDao.insertResult("TB", 400, new Date(), "拒绝访问", url, "get_daren_info", result);
        }
        else if (code != 0) {
            testResultDao.insertResult("TB",code, new Date(), "业务请求错误", url,"get_daren_info",result);

        }
        else {
            testResultDao.insertResult("TB",200, new Date(), "成功", url,"get_goods_detail",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }

    @Test
    public void get_daren_feed() throws IOException {
        //获取达人内容
        String result = new String();
        String url = "http://47.114.196.142:5000/api/tb/get_daren_feed?user_id=3327431407&page=1&tab=10000";
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
            testResultDao.insertResult("TB",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_daren_feed",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("TB",Statuscode, new Date(), "http请求错误", url,"get_daren_feed",result);

        }
        if (msg.toString().contains("RemoteDisconnected")) {
            testResultDao.insertResult("TB", 400, new Date(), "拒绝访问", url, "get_daren_feed", result);
        }
        else if (code != 0) {
            testResultDao.insertResult("TB",code, new Date(), "业务请求错误", url,"get_daren_feed",result);

        }
        else {
            testResultDao.insertResult("TB",200, new Date(), "成功", url,"get_daren_feed",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }

    @Test
    public void get_questions() throws IOException {
        //获取用户问题列表
        String result = new String();
        String url = "http://47.114.196.142:5000/api/tb/get_questions?item_id=586018840145&page=1&size=10";
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
            testResultDao.insertResult("TB",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_questions",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("TB",Statuscode, new Date(), "http请求错误", url,"get_questions",result);

        }
        if (msg.toString().contains("RemoteDisconnected")) {
            testResultDao.insertResult("TB", 400, new Date(), "拒绝访问", url, "get_questions", result);
        }
        else if (code != 0) {
            testResultDao.insertResult("TB",code, new Date(), "业务请求错误", url,"get_questions",result);

        }
        else {
            testResultDao.insertResult("TB",200, new Date(), "成功", url,"get_questions",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }

    @Test
    public void get_ask_tag() throws IOException {
        //获取问答标签
        String result = new String();
        String url = "http://47.114.196.142:5000/api/tb/get_ask_tag?item_id=586018840145";
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
            testResultDao.insertResult("TB",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_ask_tag",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("TB",Statuscode, new Date(), "http请求错误", url,"get_ask_tag",result);

        }
        if (msg.toString().contains("RemoteDisconnected")) {
            testResultDao.insertResult("TB", 400, new Date(), "拒绝访问", url, "get_ask_tag", result);
        }
        else if (code != 0) {
            testResultDao.insertResult("TB",code, new Date(), "业务请求错误", url,"get_ask_tag",result);

        }
        else {
            testResultDao.insertResult("TB",200, new Date(), "成功", url,"get_ask_tag",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }
}
