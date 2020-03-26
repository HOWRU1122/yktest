package com.tester.cases;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import com.tester.dao.TestResultDao;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.print.DocFlavor;
import java.io.IOException;
import java.util.Date;
@RunWith(SpringRunner.class)
@SpringBootTest
public class Douyinv1Test {

    @Autowired
    private TestResultDao testResultDao;

    @Test
    public void user_info() throws IOException {
        //调用次数
        String result = "";
        String url = "http://47.97.206.10/api/douyin_v1/user_info?sec_user_id=MS4wLjABAAAAc3GesvcbjzGc9Yr7Qf47M1iArpbR16WIk3l-4JnfHvA";
        HttpGet get = new HttpGet(url);
        HttpClient client = new DefaultHttpClient();
        Integer code,Statuscode;
        JSONObject data;
        JSONObject user;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);

            code = jsonObject.getInteger("code");
            data = jsonObject.getJSONObject("data");
            user = data.getJSONObject("user");


        } catch (Exception e) {
            testResultDao.insertResult("Douyinv1",500, new Date(), "测试异常，e:" + e.getMessage(), url, "user_info",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("Douyinv1",Statuscode, new Date(), "http请求错误", url,"user_info",result);

        }
        if (user == null || user.hashCode() == 0){
            testResultDao.insertResult("Douyinv1",300, new Date(), "data返回为空", url, "user_video",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("Douyinv1",code, new Date(), "业务请求错误", url,"user_info",result);

        }
        else {
            testResultDao.insertResult("Douyinv1",200, new Date(), "成功", url,"user_info",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }
    @Test
    public void user_video() throws IOException {
        //获取首页推荐
        String result = "";
        String url = "http://47.97.206.10/api/douyin_v1/user_video?sec_user_id=MS4wLjABAAAAc3GesvcbjzGc9Yr7Qf47M1iArpbR16WIk3l-4JnfHvA&max_cursor=0&count=20";
        HttpGet get = new HttpGet(url);
        HttpClient client = new DefaultHttpClient();
        Integer code, Statuscode;
        JSONObject data;
        JSONArray aweme_list;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);

            code = jsonObject.getInteger("code");
            data = jsonObject.getJSONObject("data");
            aweme_list = data.getJSONArray("aweme_list");

        } catch (Exception e) {
            testResultDao.insertResult("Douyinv1", 500, new Date(), "测试异常，e:" + e.toString(), url, "user_video", result);
            return;
        }
        if (Statuscode != 200) {
            testResultDao.insertResult("Douyinv1", Statuscode, new Date(), "http请求错误", url, "user_video", result);

        }
        if (aweme_list == null || aweme_list.size() == 0) {
            testResultDao.insertResult("Douyinv1", 300, new Date(), "data返回为空", url, "user_video", result);

        }
        else if (code != 0) {
            testResultDao.insertResult("Douyinv1", code, new Date(), "业务请求错误", url, "user_video", result);

        } else {
            testResultDao.insertResult("Douyinv1", 200, new Date(), "成功", url, "user_video", result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }


    @Test
    public void user_goods() throws IOException {
        //获取首页tab页数据
        String result = "";
        String url = "http://47.97.206.10/api/douyin_v1/user_goods?sec_user_id=MS4wLjABAAAAZk_KayH7Ze2BOUa0DunPPsGD-A5aI-ZHrEtBfd_zeu9cOmRZN6dGHhYo4mmWBRJl&user_id=1297017945466284&cursor=0&count=20";
        HttpGet get = new HttpGet(url);
        HttpClient client = new DefaultHttpClient();
        Integer code,Statuscode;
        JSONObject data;
        JSONArray columns;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);

            code = jsonObject.getInteger("code");
            data = jsonObject.getJSONObject("data");
            columns = data.getJSONArray("columns");
        } catch (Exception e) {
            testResultDao.insertResult("Douyinv1",500, new Date(), "测试异常，e:" + e.getMessage(), url, "user_goods",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("Douyinv1",Statuscode, new Date(), "http请求错误", url,"user_goods",result);

        }
        if (columns == null || columns.size() == 0){
            testResultDao.insertResult("Douyinv1",300, new Date(), "data返回为空", url, "user_video",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("Douyinv1",code, new Date(), "业务请求错误", url,"user_goods",result);

        }
        else {
            testResultDao.insertResult("Douyinv1",200, new Date(), "成功", url,"user_goods",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }
    /*
    @Test
    public void video_detail() throws IOException {
        //获取商品详情
        String result = "";
        String url = "http://47.97.206.10/api/douyin_v1/video_detail?aweme_id=6790276545542884615";
        HttpGet get = new HttpGet(url);
        HttpClient client = new DefaultHttpClient();
        Integer code,Statuscode;
        String data = "";
        JSONArray aweme_list;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
        } catch (Exception e) {
            testResultDao.insertResult("Douyinv1",500, new Date(), "测试异常，e:" + e.getMessage(), url, "video_detail",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("Douyinv1",Statuscode, new Date(), "http请求错误", url,"video_detail",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("Douyinv1",code, new Date(), "业务请求错误", url,"video_detail",result);

        }
        else {
            testResultDao.insertResult("Douyinv1",200, new Date(), "成功", url,"video_detail",result);
            System.out.println("成功，" + "请求url：" + url);
        }


    }
    */
    @Test
    public void video_comment() throws IOException {
        //获取商品最近购买列表
        String result = "";
        String url = "http://47.97.206.10/api/douyin_v1/video_comment?aweme_id=6790276545542884615&cursor=0&count=20";
        HttpGet get = new HttpGet(url);
        HttpClient client = new DefaultHttpClient();
        Integer code,Statuscode;
        JSONObject data;
        JSONArray comments;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);

            code = jsonObject.getInteger("code");
            data = jsonObject.getJSONObject("data");
            comments = data.getJSONArray("comments");
        } catch (Exception e) {
            testResultDao.insertResult("Douyinv1",500, new Date(), "测试异常，e:" + e.getMessage(), url, "video_comment",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("Douyinv1",Statuscode, new Date(), "http请求错误", url,"video_comment",result);

        }
        if (comments == null || comments.size() == 0){
            testResultDao.insertResult("Douyinv1",300, new Date(), "data返回为空", url, "user_video",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("Douyinv1",code, new Date(), "业务请求错误", url,"video_comment",result);

        }
        else {
            testResultDao.insertResult("Douyinv1",200, new Date(), "成功", url,"video_comment",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }
}
