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
public class TBAPPTest {
    @Autowired
    private TestResultDao testResultDao;
    @Test
    public void call_nums() throws IOException {
        //调用次数
        String result = new String();
        String url = "http://47.114.196.142:5000/api/tb_app/call_nums";
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
            testResultDao.insertResult("TBAPP",500, new Date(), "测试异常，e:" + e.getMessage(), url, "call_nums",result);
            return;
        }
        if (msg.toString().contains("RemoteDisconnected")) {
            testResultDao.insertResult("TBAPP", 400, new Date(), "拒绝访问", url, "call_nums", result);
        }
        else if (msg.toString().contains("Traceback")) {
            testResultDao.insertResult("TBAPP", 400, new Date(), "Traceback，回溯", url, "call_nums", result);
        }
       else if (Statuscode != 200){
            testResultDao.insertResult("TBAPP",Statuscode, new Date(), "http请求错误", url,"call_nums",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("TBAPP",code, new Date(), "业务请求错误", url,"call_nums",result);
        }
        else {
            testResultDao.insertResult("TBAPP",200, new Date(), "成功", url,"call_nums",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void video_list() throws IOException {
        //获取首页频道页视频列表
        String result = new String();
        String url = "http://47.114.196.142:5000/api/tb_app/video_list?channel_id=0&s=0";
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
            testResultDao.insertResult("TBAPP",500, new Date(), "测试异常，e:" + e.getMessage(), url, "video_list",result);
            return;
        }
        if (msg.toString().contains("RemoteDisconnected")) {
            testResultDao.insertResult("TBAPP", 400, new Date(), "拒绝访问", url, "video_list", result);
        }
        else if (msg.toString().contains("Traceback")) {
            testResultDao.insertResult("TBAPP", 400, new Date(), "Traceback，回溯", url, "video_list", result);
        }
       else if (Statuscode != 200){
            testResultDao.insertResult("TBAPP",Statuscode, new Date(), "http请求错误", url,"video_list",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("TBAPP",code, new Date(), "业务请求错误", url,"video_list",result);
        }
        else {
            testResultDao.insertResult("TBAPP",200, new Date(), "成功", url,"video_list",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void broadcaster_info() throws IOException {
        //获取主播信息
        String result = new String();
        String url = "http://47.114.196.142:5000/api/tb_app/broadcaster_info?broadcaster_id=1822619121&start=0";
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
            testResultDao.insertResult("TBAPP",500, new Date(), "测试异常，e:" + e.getMessage(), url, "broadcaster_info",result);
            return;
        }
        if (msg.toString().contains("RemoteDisconnected")) {
            testResultDao.insertResult("TBAPP", 400, new Date(), "拒绝访问", url, "broadcaster_info", result);
        }
        else if (msg.toString().contains("Traceback")) {
            testResultDao.insertResult("TBAPP", 400, new Date(), "Traceback，回溯", url, "broadcaster_info", result);
        }
       else if (Statuscode != 200){
            testResultDao.insertResult("TBAPP",Statuscode, new Date(), "http请求错误", url,"broadcaster_info",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("TBAPP",code, new Date(), "业务请求错误", url,"broadcaster_info",result);
        }
        else {
            testResultDao.insertResult("TBAPP",200, new Date(), "成功", url,"broadcaster_info",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void live_detail() throws IOException {
        //获取直播详情
        String result = new String();
        String url = "http://47.114.196.142:5000/api/tb_app/live_detail?live_id=252617963475";
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
            testResultDao.insertResult("TBAPP",500, new Date(), "测试异常，e:" + e.getMessage(), url, "live_detail",result);
            return;
        }
        if (msg.toString().contains("RemoteDisconnected")) {
            testResultDao.insertResult("TBAPP", 400, new Date(), "拒绝访问", url, "live_detail", result);
        }
        else if (msg.toString().contains("Traceback")) {
            testResultDao.insertResult("TBAPP", 400, new Date(), "Traceback，回溯", url, "live_detail", result);
        }
       else if (Statuscode != 200){
            testResultDao.insertResult("TBAPP",Statuscode, new Date(), "http请求错误", url,"live_detail",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("TBAPP",code, new Date(), "业务请求错误", url,"live_detail",result);
        }
        else {
            testResultDao.insertResult("TBAPP",200, new Date(), "成功", url,"live_detail",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void goods_list() throws IOException {
        //获取直播视频下的商品列表
        String result = new String();
        String url = "http://47.114.196.142:5000/api/tb_app/goods_list?live_id=252617963475&group_num=0";
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
            testResultDao.insertResult("TBAPP",500, new Date(), "测试异常，e:" + e.getMessage(), url, "goods_list",result);
            return;
        }
        if (msg.toString().contains("RemoteDisconnected")) {
            testResultDao.insertResult("TBAPP", 400, new Date(), "拒绝访问", url, "goods_list", result);
        }
        else if (msg.toString().contains("Traceback")) {
            testResultDao.insertResult("TBAPP", 400, new Date(), "Traceback，回溯", url, "goods_list", result);
        }
       else if (Statuscode != 200){
            testResultDao.insertResult("TBAPP",Statuscode, new Date(), "http请求错误", url,"goods_list",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("TBAPP",code, new Date(), "业务请求错误", url,"goods_list",result);
        }
        else {
            testResultDao.insertResult("TBAPP",200, new Date(), "成功", url,"goods_list",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void channel_info() throws IOException {
        //获取频道id信息
        String result = new String();
        String url = "http://47.114.196.142:5000/api/tb_app/channel_info";
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
            testResultDao.insertResult("TBAPP",500, new Date(), "测试异常，e:" + e.getMessage(), url, "channel_info",result);
            return;
        }
        if (msg.toString().contains("RemoteDisconnected")) {
            testResultDao.insertResult("TBAPP", 400, new Date(), "拒绝访问", url, "channel_info", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("TBAPP",Statuscode, new Date(), "http请求错误", url,"channel_info",result);
        }
        else if (msg.toString().contains("Traceback")) {
            testResultDao.insertResult("TBAPP", 400, new Date(), "Traceback，回溯", url, "channel_info", result);
        }
        else if (code != 0) {
            testResultDao.insertResult("TBAPP",code, new Date(), "业务请求错误", url,"channel_info",result);
        }
        else {
            testResultDao.insertResult("TBAPP",200, new Date(), "成功", url,"channel_info",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_shop_items() throws IOException {
        //获取店铺商品列表
        String result = new String();
        String url = "http://47.114.196.142:5000/api/tb_app/get_shop_items?seller_id=seller_id&page=1&size=10";
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
            testResultDao.insertResult("TBAPP",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_shop_items",result);
            return;
        }
        if (msg.toString().contains("RemoteDisconnected")) {
            testResultDao.insertResult("TBAPP", 400, new Date(), "拒绝访问", url, "get_shop_items", result);
        }
        else if (msg.toString().contains("Traceback")) {
            testResultDao.insertResult("TBAPP", 400, new Date(), "Traceback，回溯", url, "get_shop_items", result);
        }
       else if (Statuscode != 200){
            testResultDao.insertResult("TBAPP",Statuscode, new Date(), "http请求错误", url,"get_shop_items",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("TBAPP",code, new Date(), "业务请求错误", url,"get_shop_items",result);
        }
        else {
            testResultDao.insertResult("TBAPP",200, new Date(), "成功", url,"get_shop_items",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }
}
