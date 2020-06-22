package com.tester.cases;

import com.alibaba.fastjson.JSONArray;
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
public class DouyinShareTest {

    @Autowired
    private TestResultDao testResultDao;
    @Test
    public void user_info() throws IOException {
        //用户信息
        String result = "";
        String url = "http://47.114.196.142:5000/api/douyin_share/user_info?share_id=104255897823";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code,Statuscode;
        JSONObject data;

        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);

            code = jsonObject.getInteger("code");
            data = jsonObject.getJSONObject("data");
        } catch (Exception e) {
            testResultDao.insertResult("DouyinShare",200, new Date(), "测试异常，e:" + e.getMessage(), url, "user_info",result);
            return;
        }
        if (data == null || data.hashCode() == 0) {
            testResultDao.insertResult("DouyinShare", 300, new Date(), "data返回为空", url, "user_info", result);
        }
       else if (Statuscode != 200){
            testResultDao.insertResult("DouyinShare",Statuscode, new Date(), "http请求错误", url,"user_info",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinShare",code, new Date(), "业务请求错误", url,"user_info",result);
        }
        else {
            testResultDao.insertResult("DouyinShare",200, new Date(), "成功", url,"user_info",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void user_video() throws IOException {
        //用户视频
        String result = "";
        String url = "http://47.114.196.142:5000/api/douyin_share/user_video?share_id=104255897823&max_cursor=0";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code,Statuscode;
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
            testResultDao.insertResult("DouyinShare",200, new Date(), "测试异常，e:" + e.getMessage(), url, "user_video",result);
            return;
        }
        if (aweme_list == null || aweme_list.size() == 0) {
            testResultDao.insertResult("DouyinShare", 300, new Date(), "data返回为空", url, "user_video", result);
        }
       else if (Statuscode != 200){
            testResultDao.insertResult("DouyinShare",Statuscode, new Date(), "http请求错误", url,"user_video",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinShare",code, new Date(), "业务请求错误", url,"user_video",result);
        }
        else {
            testResultDao.insertResult("DouyinShare",200, new Date(), "成功", url,"user_video",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }


    @Test
    public void user_room() throws IOException {
        //获取用户直播间
        String result = "";
        String url = "http://47.114.196.142:5000/api/douyin_share/user_room?room_id=6809426119985466126";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code,Statuscode;
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
            testResultDao.insertResult("DouyinShare",200, new Date(), "测试异常，e:" + e.getMessage(), url, "user_room",result);
            return;
        }
        if (aweme_list == null || aweme_list.size() == 0) {
            testResultDao.insertResult("DouyinShare", 300, new Date(), "data返回为空", url, "user_room", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("DouyinShare",Statuscode, new Date(), "http请求错误", url,"user_room",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinShare",code, new Date(), "业务请求错误", url,"user_room",result);
        }
        else {
            testResultDao.insertResult("DouyinShare",200, new Date(), "成功", url,"user_room",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }


    @Test
    public void hot_recommend() throws IOException {
        // 获取热门推荐
        String result = "";
        String url = "http://47.114.196.142:5000/api/douyin_share/hot_recommend?room_id=6809426119985466126";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code,Statuscode;
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
            testResultDao.insertResult("DouyinShare",200, new Date(), "测试异常，e:" + e.getMessage(), url, "hot_recommend",result);
            return;
        }
        if (aweme_list == null || aweme_list.size() == 0) {
            testResultDao.insertResult("DouyinShare", 300, new Date(), "data返回为空", url, "hot_recommend", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("DouyinShare",Statuscode, new Date(), "http请求错误", url,"hot_recommend",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinShare",code, new Date(), "业务请求错误", url,"hot_recommend",result);
        }
        else {
            testResultDao.insertResult("DouyinShare",200, new Date(), "成功", url,"hot_recommend",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void video_info() throws IOException {
        // 获取视频信息
        String result = "";
        String url = "http://47.114.196.142:5000/api/douyin_share/video_info?aweme_ids=6769786338364427533,6792881560761715968";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code,Statuscode;
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
            testResultDao.insertResult("DouyinShare",200, new Date(), "测试异常，e:" + e.getMessage(), url, "video_info",result);
            return;
        }
        if (aweme_list == null || aweme_list.size() == 0) {
            testResultDao.insertResult("DouyinShare", 300, new Date(), "data返回为空", url, "video_info", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("DouyinShare",Statuscode, new Date(), "http请求错误", url,"video_info",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinShare",code, new Date(), "业务请求错误", url,"video_info",result);
        }
        else {
            testResultDao.insertResult("DouyinShare",200, new Date(), "成功", url,"video_info",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }


    @Test
    public void user_hot_video() throws IOException {
        // 获取视频信息
        String result = "";
        String url = "http://47.114.196.142:5000/api/douyin_share/user_hot_video?aweme_id=6769786338364427533&max_cursor=0";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code,Statuscode;
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
            testResultDao.insertResult("DouyinShare",200, new Date(), "测试异常，e:" + e.getMessage(), url, "user_hot_video",result);
            return;
        }
        if (aweme_list == null || aweme_list.size() == 0) {
            testResultDao.insertResult("DouyinShare", 300, new Date(), "data返回为空", url, "user_hot_video", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("DouyinShare",Statuscode, new Date(), "http请求错误", url,"user_hot_video",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinShare",code, new Date(), "业务请求错误", url,"user_hot_video",result);
        }
        else {
            testResultDao.insertResult("DouyinShare",200, new Date(), "成功", url,"user_hot_video",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }


    @Test
    public void get_shop_info() throws IOException {
        // 获取店铺信息
        String result = "";
        String url = "http://47.114.196.142:5000/api/douyin_share/get_shop_info?shop_id=HoNEDIZ";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code,Statuscode;
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
            testResultDao.insertResult("DouyinShare",200, new Date(), "测试异常，e:" + e.getMessage(), url, "get_shop_info",result);
            return;
        }
        if (aweme_list == null || aweme_list.size() == 0) {
            testResultDao.insertResult("DouyinShare", 300, new Date(), "data返回为空", url, "get_shop_info", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("DouyinShare",Statuscode, new Date(), "http请求错误", url,"get_shop_info",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinShare",code, new Date(), "业务请求错误", url,"get_shop_info",result);
        }
        else {
            testResultDao.insertResult("DouyinShare",200, new Date(), "成功", url,"get_shop_info",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }


    @Test
    public void get_home_item() throws IOException {
        // 获取店铺首页商品
        String result = "";
        String url = "http://47.114.196.142:5000/api/douyin_share/get_home_item?shop_id=HoNEDIZ&page=0&size=10";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code,Statuscode;
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
            testResultDao.insertResult("DouyinShare",200, new Date(), "测试异常，e:" + e.getMessage(), url, "get_home_item",result);
            return;
        }
        if (aweme_list == null || aweme_list.size() == 0) {
            testResultDao.insertResult("DouyinShare", 300, new Date(), "data返回为空", url, "get_home_item", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("DouyinShare",Statuscode, new Date(), "http请求错误", url,"get_home_item",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinShare",code, new Date(), "业务请求错误", url,"get_home_item",result);
        }
        else {
            testResultDao.insertResult("DouyinShare",200, new Date(), "成功", url,"get_home_item",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }


    @Test
    public void get_shop_item() throws IOException {
        // 获取店铺商品
        String result = "";
        String url = "http://47.114.196.142:5000/api/douyin_share/get_home_item?shop_id=HoNEDIZ&page=0&size=10";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code,Statuscode;
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
            testResultDao.insertResult("DouyinShare",200, new Date(), "测试异常，e:" + e.getMessage(), url, "get_shop_item",result);
            return;
        }
        if (aweme_list == null || aweme_list.size() == 0) {
            testResultDao.insertResult("DouyinShare", 300, new Date(), "data返回为空", url, "get_shop_item", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("DouyinShare",Statuscode, new Date(), "http请求错误", url,"get_shop_item",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinShare",code, new Date(), "业务请求错误", url,"get_shop_item",result);
        }
        else {
            testResultDao.insertResult("DouyinShare",200, new Date(), "成功", url,"get_shop_item",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }


    @Test
    public void get_shop_buslist() throws IOException {
        // 获取店铺营业执照
        String result = "";
        String url = "http://47.114.196.142:5000/api/douyin_share/get_shop_buslist?shop_id=HoNEDIZ";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code,Statuscode;
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
            testResultDao.insertResult("DouyinShare",200, new Date(), "测试异常，e:" + e.getMessage(), url, "get_shop_buslist",result);
            return;
        }
        if (aweme_list == null || aweme_list.size() == 0) {
            testResultDao.insertResult("DouyinShare", 300, new Date(), "data返回为空", url, "get_shop_buslist", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("DouyinShare",Statuscode, new Date(), "http请求错误", url,"get_shop_buslist",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinShare",code, new Date(), "业务请求错误", url,"get_shop_buslist",result);
        }
        else {
            testResultDao.insertResult("DouyinShare",200, new Date(), "成功", url,"get_shop_buslist",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }


    @Test
    public void get_shop_rate() throws IOException {
        // 获取店铺营业执照
        String result = "";
        String url = "http://47.114.196.142:5000/api/douyin_share/get_shop_rate?shop_id=HoNEDIZ";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code,Statuscode;
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
            testResultDao.insertResult("DouyinShare",200, new Date(), "测试异常，e:" + e.getMessage(), url, "get_shop_rate",result);
            return;
        }
        if (aweme_list == null || aweme_list.size() == 0) {
            testResultDao.insertResult("DouyinShare", 300, new Date(), "data返回为空", url, "get_shop_rate", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("DouyinShare",Statuscode, new Date(), "http请求错误", url,"get_shop_rate",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinShare",code, new Date(), "业务请求错误", url,"get_shop_rate",result);
        }
        else {
            testResultDao.insertResult("DouyinShare",200, new Date(), "成功", url,"get_shop_rate",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }


    @Test
    public void get_item_detail() throws IOException {
        // 获取商品详情
        String result = "";
        String url = "http://47.114.196.142:5000/api/douyin_share/get_item_detail?item_id=3401450533637201011";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code,Statuscode;
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
            testResultDao.insertResult("DouyinShare",200, new Date(), "测试异常，e:" + e.getMessage(), url, "get_item_detail",result);
            return;
        }
        if (aweme_list == null || aweme_list.size() == 0) {
            testResultDao.insertResult("DouyinShare", 300, new Date(), "data返回为空", url, "get_item_detail", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("DouyinShare",Statuscode, new Date(), "http请求错误", url,"get_item_detail",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinShare",code, new Date(), "业务请求错误", url,"get_item_detail",result);
        }
        else {
            testResultDao.insertResult("DouyinShare",200, new Date(), "成功", url,"get_item_detail",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }


    @Test
    public void get_item_stock() throws IOException {
        // 获取商品详情
        String result = "";
        String url = "http://47.114.196.142:5000/api/douyin_share/get_item_stock?item_id=3401450533637201011";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code,Statuscode;
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
            testResultDao.insertResult("DouyinShare",200, new Date(), "测试异常，e:" + e.getMessage(), url, "get_item_stock",result);
            return;
        }
        if (aweme_list == null || aweme_list.size() == 0) {
            testResultDao.insertResult("DouyinShare", 300, new Date(), "data返回为空", url, "get_item_stock", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("DouyinShare",Statuscode, new Date(), "http请求错误", url,"get_item_stock",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinShare",code, new Date(), "业务请求错误", url,"get_item_stock",result);
        }
        else {
            testResultDao.insertResult("DouyinShare",200, new Date(), "成功", url,"get_item_stock",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }


    @Test
    public void get_item_comment() throws IOException {
        // 获取商品评论
        String result = "";
        String url = "http://47.114.196.142:5000/api/douyin_share/get_item_comment?item_id=3401450533637201011&page=0";
        HttpGet get = new HttpGet(url);
        HttpClient client = HttpClientBuilder.create().build();
        Integer code,Statuscode;
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
            testResultDao.insertResult("DouyinShare",200, new Date(), "测试异常，e:" + e.getMessage(), url, "get_item_comment",result);
            return;
        }
        if (aweme_list == null || aweme_list.size() == 0) {
            testResultDao.insertResult("DouyinShare", 300, new Date(), "data返回为空", url, "get_item_comment", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("DouyinShare",Statuscode, new Date(), "http请求错误", url,"get_item_comment",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinShare",code, new Date(), "业务请求错误", url,"get_item_comment",result);
        }
        else {
            testResultDao.insertResult("DouyinShare",200, new Date(), "成功", url,"get_item_comment",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }
}
