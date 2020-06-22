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
public class TBVTest {

    @Autowired
    private TestResultDao testResultDao;

    @Test
    public void get_user_list() throws IOException {
        //获取 主播/机构 列表
        String result = "";
        String url = "http://47.114.196.142:5000/api/tbv/get_user_list?cate_type=701&page=1&fans_count=100万以上";
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
            testResultDao.insertResult("TBV",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_user_list",result);
            return;
        }
        if (msg.toString().contains("请求失败")) {
            testResultDao.insertResult("TBV", 400, new Date(), "请求失败，重试", url, "get_user_list", result);
        }

        else if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("TBV", 400, new Date(), "获取响应失败,重试超过阈值", url, "get_user_list", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("TBV",Statuscode, new Date(), "http请求错误", url,"get_user_list",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("TBV",code, new Date(), "业务请求错误", url,"get_user_list",result);
        }
        else {
            testResultDao.insertResult("TBV",200, new Date(), "成功", url,"get_user_list",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_user_info() throws IOException {
        //获取 主播/机构 信息
        String result = "";
        String url = "http://47.114.196.142:5000/api/tbv/get_user_info?user_id=69226163";
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
            testResultDao.insertResult("TBV",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_user_info",result);
            return;
        }
        if (msg.toString().contains("请求失败")) {
            testResultDao.insertResult("TBV", 400, new Date(), "请求失败，重试", url, "get_user_info", result);
        }

        else if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("TBV", 400, new Date(), "获取响应失败,重试超过阈值", url, "get_user_info", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("TBV",Statuscode, new Date(), "http请求错误", url,"get_user_info",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("TBV",code, new Date(), "业务请求错误", url,"get_user_info",result);
        }
        else {
            testResultDao.insertResult("TBV",200, new Date(), "成功", url,"get_user_info",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_fans_portrait() throws IOException {
        // 获取 主播/机构 粉丝分析数据
        String result = "";
        String url = "http://47.114.196.142:5000/api/tbv/get_fans_portrait?user_id=69226163";
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
            testResultDao.insertResult("TBV",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_fans_portrait",result);
            return;
        }
        if (msg.toString().contains("请求失败")) {
            testResultDao.insertResult("TBV", 400, new Date(), "请求失败，重试", url, "get_fans_portrait", result);
        }

        else if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("TBV", 400, new Date(), "获取响应失败,重试超过阈值", url, "get_fans_portrait", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("TBV",Statuscode, new Date(), "http请求错误", url,"get_fans_portrait",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("TBV",code, new Date(), "业务请求错误", url,"get_fans_portrait",result);
        }
        else {
            testResultDao.insertResult("TBV",200, new Date(), "成功", url,"get_fans_portrait",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }


    @Test
    public void get_hot_live() throws IOException {
        // 获取主播的热门直播
        String result = "";
        String url = "http://47.114.196.142:5000/api/tbv/get_hot_live?user_id=69226163";
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
            testResultDao.insertResult("TBV",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_hot_live",result);
            return;
        }
        if (msg.toString().contains("请求失败")) {
            testResultDao.insertResult("TBV", 400, new Date(), "请求失败，重试", url, "get_hot_live", result);
        }

        else if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("TBV", 400, new Date(), "获取响应失败,重试超过阈值", url, "get_hot_live", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("TBV",Statuscode, new Date(), "http请求错误", url,"get_hot_live",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("TBV",code, new Date(), "业务请求错误", url,"get_hot_live",result);
        }
        else {
            testResultDao.insertResult("TBV",200, new Date(), "成功", url,"get_hot_live",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_user_server() throws IOException {
        // 获取 主播/机构 服务
        String result = "";
        String url = "http://47.114.196.142:5000/api/tbv/get_user_server?user_id=69226163&page=1&size=10";
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
            testResultDao.insertResult("TBV",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_user_server",result);
            return;
        }
        if (msg.toString().contains("请求失败")) {
            testResultDao.insertResult("TBV", 400, new Date(), "请求失败，重试", url, "get_user_server", result);
        }

        else if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("TBV", 400, new Date(), "获取响应失败,重试超过阈值", url, "get_user_server", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("TBV",Statuscode, new Date(), "http请求错误", url,"get_user_server",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("TBV",code, new Date(), "业务请求错误", url,"get_user_server",result);
        }
        else {
            testResultDao.insertResult("TBV",200, new Date(), "成功", url,"get_user_server",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_user_comment() throws IOException {
        // 获取 主播/机构 评价
        String result = "";
        String url = "http://47.114.196.142:5000/api/tbv/get_user_comment?user_id=69226163&page=1&size=6";
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
            testResultDao.insertResult("TBV",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_user_comment",result);
            return;
        }
        if (msg.toString().contains("请求失败")) {
            testResultDao.insertResult("TBV", 400, new Date(), "请求失败，重试", url, "get_user_comment", result);
        }

        else if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("TBV", 400, new Date(), "获取响应失败,重试超过阈值", url, "get_user_comment", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("TBV",Statuscode, new Date(), "http请求错误", url,"get_user_comment",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("TBV",code, new Date(), "业务请求错误", url,"get_user_comment",result);
        }
        else {
            testResultDao.insertResult("TBV",200, new Date(), "成功", url,"get_user_comment",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }


    @Test
    public void get_history_data() throws IOException {
        //获取主播历史数据
        String result = "";
        String url = "http://47.114.196.142:5000/api/tbv/get_history_data?user_id=69226163&cycle=7";
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
            testResultDao.insertResult("TBV",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_history_data",result);
            return;
        }
        if (msg.toString().contains("请求失败")) {
            testResultDao.insertResult("TBV", 400, new Date(), "请求失败，重试", url, "get_history_data", result);
        }

        else if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("TBV", 400, new Date(), "获取响应失败,重试超过阈值", url, "get_history_data", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("TBV",Statuscode, new Date(), "http请求错误", url,"get_history_data",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("TBV",code, new Date(), "业务请求错误", url,"get_history_data",result);
        }
        else {
            testResultDao.insertResult("TBV",200, new Date(), "成功", url,"get_history_data",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }
}
