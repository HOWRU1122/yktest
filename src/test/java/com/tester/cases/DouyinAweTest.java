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
public class DouyinAweTest {

    @Autowired
    private TestResultDao testResultDao;
    @Test
    public void get_user_info() throws IOException {
        //获取抖音用户信息
        String result = new String();
        String url = "http://47.114.196.142:5000/api/douyin_awe/get_user_info?sec_uid=MS4wLjABAAAAvcLIWOv1lqH4NrB1CM-rcPGIEmaI8z8_51rYmz00Apo";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code,Statuscode;
        Object msg;
        JSONObject data;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
            msg = jsonObject.get("msg");
            data = jsonObject.getJSONObject("data");
            System.out.println(msg);
            System.out.println(data);
        } catch (Exception e) {
            testResultDao.insertResult("DouyinAwe",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_user_info",result);
            return;
        }
        if (msg.toString().contains("失败，采集失败")) {
            testResultDao.insertResult("DouyinAwe", 400, new Date(), "失败，采集失败", url, "get_user_info", result);
        }
        else if (data == null){
            testResultDao.insertResult("DouyinAwe", 400, new Date(), "数据为空", url, "get_user_info", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("DouyinAwe",Statuscode, new Date(), "http请求错误", url,"get_user_info",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinAwe",code, new Date(), "业务请求错误", url,"get_user_info",result);
        }
        else {
            testResultDao.insertResult("DouyinAwe",200, new Date(), "成功", url,"get_user_info",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_promotion_list() throws IOException {
        //获得抖音商品信息
        String result = new String();
        String url = "http://47.114.196.142:5000/api/douyin_awe/get_promotion_list?user_id=100057983844&sec_uid=MS4wLjABAAAAnUDewltNkKWz6gNx0MZ-qZOHDB58ksYV6dG-W_EcD1k&cursor=0";
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
            testResultDao.insertResult("DouyinAwe",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_promotion_list",result);
            return;
        }
        if (msg.toString().contains("失败，采集失败")) {
            testResultDao.insertResult("DouyinAwe", 400, new Date(), "失败，采集失败", url, "get_promotion_list", result);
        }
       else if (Statuscode != 200){
            testResultDao.insertResult("DouyinAwe",Statuscode, new Date(), "http请求错误", url,"get_promotion_list",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinAwe",code, new Date(), "业务请求错误", url,"get_promotion_list",result);
        }
        else {
            testResultDao.insertResult("DouyinAwe",200, new Date(), "成功", url,"get_promotion_list",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_aweme_list() throws IOException {
        //获得用户的抖音作品
        String result = new String();
        String url = "http://47.114.196.142:5000/api/douyin_awe/get_aweme_list?sec_uid=MS4wLjABAAAAvcLIWOv1lqH4NrB1CM-rcPGIEmaI8z8_51rYmz00Apo&cursor=0";
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
            testResultDao.insertResult("DouyinAwe",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_aweme_list",result);
            return;
        }
        if (msg.toString().contains("失败，采集失败")) {
            testResultDao.insertResult("DouyinAwe", 400, new Date(), "失败，采集失败", url, "get_aweme_list", result);
        }
       else if (Statuscode != 200){
            testResultDao.insertResult("DouyinAwe",Statuscode, new Date(), "http请求错误", url,"get_aweme_list",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinAwe",code, new Date(), "业务请求错误", url,"get_aweme_list",result);
        }
        else {
            testResultDao.insertResult("DouyinAwe",200, new Date(), "成功", url,"get_aweme_list",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_aweme_comment() throws IOException {
        //获特定抖音作品下面的评论
        String result = new String();
        String url = "http://47.114.196.142:5000/api/douyin_awe/get_aweme_comment?aweme_id=6772104868627827982&cursor=0";
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
            testResultDao.insertResult("DouyinAwe",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_aweme_comment",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("DouyinAwe",Statuscode, new Date(), "http请求错误", url,"get_aweme_comment",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinAwe",code, new Date(), "业务请求错误", url,"get_aweme_comment",result);
        }
        else {
            testResultDao.insertResult("DouyinAwe",200, new Date(), "成功", url,"get_aweme_comment",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_aweme_info() throws IOException {
        //获取视频简介
        String result = new String();
        String url = "http://47.114.196.142:5000/api/douyin_awe/get_aweme_info?aweme_id=6729436911498267908";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code,Statuscode;
        Object msg;
        JSONObject data;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
            msg = jsonObject.get("msg");
            data = jsonObject.getJSONObject("data");
            System.out.println(msg);
            System.out.println(data);
        } catch (Exception e) {
            testResultDao.insertResult("DouyinAwe",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_aweme_info",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("DouyinAwe",Statuscode, new Date(), "http请求错误", url,"get_aweme_info",result);
        }
        else if (data == null){
            testResultDao.insertResult("DouyinAwe", 400, new Date(), "数据为空", url, "get_aweme_info", result);
        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinAwe",code, new Date(), "业务请求错误", url,"get_aweme_info",result);
        }
        else {
            testResultDao.insertResult("DouyinAwe",200, new Date(), "成功", url,"get_aweme_info",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void user_info() throws IOException {
        //用户信息
        String result = new String();
        String url = "http://47.114.196.142:5000/api/douyin_share/user_info?share_id=104255897823";
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
            testResultDao.insertResult("DouyinAwe",500, new Date(), "测试异常，e:" + e.getMessage(), url, "user_info",result);
            return;
        }
        if (msg.toString().contains("失败，采集失败")) {
            testResultDao.insertResult("DouyinAwe", 400, new Date(), "失败，采集失败", url, "user_info", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("DouyinAwe",Statuscode, new Date(), "http请求错误", url,"user_info",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinAwe",code, new Date(), "业务请求错误", url,"user_info",result);
        }
        else {
            testResultDao.insertResult("DouyinAwe",200, new Date(), "成功", url,"user_info",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void user_video() throws IOException {
        //用户视频
        String result = new String();
        String url = "http://47.114.196.142:5000/api/douyin_share/user_video?share_id=104255897823&max_cursor=0";
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
            testResultDao.insertResult("DouyinAwe",500, new Date(), "测试异常，e:" + e.getMessage(), url, "user_video",result);
            return;
        }
        if (msg.toString().contains("失败，采集失败")) {
            testResultDao.insertResult("DouyinAwe", 400, new Date(), "失败，采集失败", url, "user_video", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("DouyinAwe",Statuscode, new Date(), "http请求错误", url,"user_video",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinAwe",code, new Date(), "业务请求错误", url,"user_video",result);
        }
        else {
            testResultDao.insertResult("DouyinAwe",200, new Date(), "成功", url,"user_video",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void user_room() throws IOException {
        //获取用户直播间
        String result = new String();
        String url = "http://47.114.196.142:5000/api/douyin_share/user_room?room_id=6809426119985466126";
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
            testResultDao.insertResult("DouyinAwe",500, new Date(), "测试异常，e:" + e.getMessage(), url, "user_room",result);
            return;
        }
        if (msg.toString().contains("失败，采集失败")) {
            testResultDao.insertResult("DouyinAwe", 400, new Date(), "失败，采集失败", url, "user_room", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("DouyinAwe",Statuscode, new Date(), "http请求错误", url,"user_room",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinAwe",code, new Date(), "业务请求错误", url,"user_room",result);
        }
        else {
            testResultDao.insertResult("DouyinAwe",200, new Date(), "成功", url,"user_room",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void hot_recommend() throws IOException {
        //获取热门推荐
        String result = new String();
        String url = "http://47.114.196.142:5000/api/douyin_share/hot_recommend?room_id=6809426119985466126";
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
            testResultDao.insertResult("DouyinAwe",500, new Date(), "测试异常，e:" + e.getMessage(), url, "hot_recommend",result);
            return;
        }
        if (msg.toString().contains("失败，采集失败")) {
            testResultDao.insertResult("DouyinAwe", 400, new Date(), "失败，采集失败", url, "hot_recommend", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("DouyinAwe",Statuscode, new Date(), "http请求错误", url,"hot_recommend",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinAwe",code, new Date(), "业务请求错误", url,"hot_recommend",result);
        }
        else {
            testResultDao.insertResult("DouyinAwe",200, new Date(), "成功", url,"hot_recommend",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void video_info() throws IOException {
        //获取视频信息
        String result = new String();
        String url = "http://47.114.196.142:5000/api/douyin_share/video_info?aweme_ids=6769786338364427533,6792881560761715968";
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
            testResultDao.insertResult("DouyinAwe",500, new Date(), "测试异常，e:" + e.getMessage(), url, "video_info",result);
            return;
        }
        if (msg.toString().contains("失败，采集失败")) {
            testResultDao.insertResult("DouyinAwe", 400, new Date(), "失败，采集失败", url, "video_info", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("DouyinAwe",Statuscode, new Date(), "http请求错误", url,"video_info",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinAwe",code, new Date(), "业务请求错误", url,"video_info",result);
        }
        else {
            testResultDao.insertResult("DouyinAwe",200, new Date(), "成功", url,"video_info",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void user_hot_video() throws IOException {
        //获取用户热门视频
        String result = new String();
        String url = "http://47.114.196.142:5000/api/douyin_share/user_hot_video?aweme_id=6769786338364427533&max_cursor=0";
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
            testResultDao.insertResult("DouyinAwe",500, new Date(), "测试异常，e:" + e.getMessage(), url, "user_hot_video",result);
            return;
        }
        if (msg.toString().contains("失败，采集失败")) {
            testResultDao.insertResult("DouyinAwe", 400, new Date(), "失败，采集失败", url, "user_hot_video", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("DouyinAwe",Statuscode, new Date(), "http请求错误", url,"user_hot_video",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinAwe",code, new Date(), "业务请求错误", url,"user_hot_video",result);
        }
        else {
            testResultDao.insertResult("DouyinAwe",200, new Date(), "成功", url,"user_hot_video",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }
}
