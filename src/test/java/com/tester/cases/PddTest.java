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
public class PddTest {

    @Autowired
    private TestResultDao testResultDao;

    @Test
    public void get_pdd_date() throws IOException {
        //获取拼多多某个类目下的某个价格区间的某页数据信息
        String result = "";
        String url = "http://47.114.196.142:5000/api/pdd_spider_api/get_pdd_date?cat_id=-1&range_from=400&range_to=410&page_number=1";
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
            testResultDao.insertResult("Pdd",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_pdd_date",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("Pdd",Statuscode, new Date(), "http请求错误", url,"get_pdd_date",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("Pdd",code, new Date(), "业务请求错误", url,"get_pdd_date",result);

        }
        else {
            testResultDao.insertResult("Pdd",200, new Date(), "成功", url,"get_pdd_date",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }

    @Test
    public void get_cat_id_list() throws IOException {
        //获取catid的列表
        String result = "";
        String url = "http://47.114.196.142:5000/api/pdd_spider_api/get_cat_id_list";
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
            testResultDao.insertResult("Pdd",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_cat_id_list",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("Pdd",Statuscode, new Date(), "http请求错误", url,"get_cat_id_list",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("Pdd",code, new Date(), "业务请求错误", url,"get_cat_id_list",result);

        }
        else {
            testResultDao.insertResult("Pdd",200, new Date(), "成功", url,"get_cat_id_list",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_limited_seckill() throws IOException {
        //限时秒杀
        String result = "";
        String url = "http://47.114.196.142:5000/api/pdd/get_limited_seckill?tab_id=1584100800&page=1&size=20&day_type=2";
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
            testResultDao.insertResult("Pdd",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_limited_seckill",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("Pdd",Statuscode, new Date(), "http请求错误", url,"get_limited_seckill",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("Pdd",code, new Date(), "业务请求错误", url,"get_limited_seckill",result);

        }
        else {
            testResultDao.insertResult("Pdd",200, new Date(), "成功", url,"get_limited_seckill",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }


    @Test
    public void get_hot_goods() throws IOException {
        //热门商品
        String result = "";
        String url = "http://47.114.196.142:5000/api/pdd/get_hot_goods?page=1&size=2";
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
            testResultDao.insertResult("Pdd",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_hot_goods",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("Pdd",Statuscode, new Date(), "http请求错误", url,"get_hot_goods",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("Pdd",code, new Date(), "业务请求错误", url,"get_hot_goods",result);

        }
        else {
            testResultDao.insertResult("Pdd",200, new Date(), "成功", url,"get_hot_goods",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_fenlei_goods() throws IOException {
        //分类商品
        String result = "";
        String url = "http://47.114.196.142:5000/api/pdd/get_fenlei_goods?tab_id=14&count=20&offset=0";
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
            testResultDao.insertResult("Pdd",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_fenlei_goods",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("Pdd",Statuscode, new Date(), "http请求错误", url,"get_fenlei_goods",result);

        }
        if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("Pdd", 400, new Date(), "获取响应失败,重试超过阈值", url, "get_fenlei_goods", result);
        }
        else if (code != 0) {
            testResultDao.insertResult("Pdd",code, new Date(), "业务请求错误", url,"get_fenlei_goods",result);

        }
        else {
            testResultDao.insertResult("Pdd",200, new Date(), "成功", url,"get_fenlei_goods",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_mall_similar_goods() throws IOException {
        //店铺相似商品
        String result = "";
        String url = "http://47.114.196.142:5000/api/pdd/get_mall_similar_goods?goods_id=7366692450";
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
            testResultDao.insertResult("Pdd",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_mall_similar_goods",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("Pdd",Statuscode, new Date(), "http请求错误", url,"get_mall_similar_goods",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("Pdd",code, new Date(), "业务请求错误", url,"get_mall_similar_goods",result);

        }
        else {
            testResultDao.insertResult("Pdd",200, new Date(), "成功", url,"get_mall_similar_goods",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_similar_goods() throws IOException {
        //相似商品
        String result = "";
        String url = "http://47.114.196.142:5000/api/pdd/get_similar_goods?goods_id=7366692450&mall_id=397048742&page=1";
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
            testResultDao.insertResult("Pdd",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_similar_goods",result);
            return;
        }
        if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("Pdd", 400, new Date(), "获取响应失败,重试超过阈值", url, "get_similar_goods", result);
        }
        if (Statuscode != 200){
            testResultDao.insertResult("Pdd",Statuscode, new Date(), "http请求错误", url,"get_similar_goods",result);

        }

        else if (code != 0) {
            testResultDao.insertResult("Pdd",code, new Date(), "业务请求错误", url,"get_similar_goods",result);

        }
        else {
            testResultDao.insertResult("Pdd",200, new Date(), "成功", url,"get_similar_goods",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_goods_detail() throws IOException {
        //商品详情
        String result = "";
        String url = "http://47.114.196.142:5000/api/pdd/get_goods_detail?goods_id=7366692450";
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
            testResultDao.insertResult("Pdd",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_goods_detail",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("Pdd",Statuscode, new Date(), "http请求错误", url,"get_goods_detail",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("Pdd",code, new Date(), "业务请求错误", url,"get_goods_detail",result);

        }
        else {
            testResultDao.insertResult("Pdd",200, new Date(), "成功", url,"get_goods_detail",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_mall_most_goods() throws IOException {
        //商家-大家都在拼
        String result = "";
        String url = "http://47.114.196.142:5000/api/pdd/get_mall_most_goods?mall_id=397048742";
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
            testResultDao.insertResult("Pdd",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_mall_most_goods",result);
            return;
        }
        if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("Pdd", 400, new Date(), "获取响应失败,重试超过阈值", url, "get_mall_most_goods", result);
        }
        if (Statuscode != 200){
            testResultDao.insertResult("Pdd",Statuscode, new Date(), "http请求错误", url,"get_mall_most_goods",result);

        }

        else if (code != 0) {
            testResultDao.insertResult("Pdd",code, new Date(), "业务请求错误", url,"get_mall_most_goods",result);

        }
        else {
            testResultDao.insertResult("Pdd",200, new Date(), "成功", url,"get_mall_most_goods",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_mall_info() throws IOException {
        //商铺信息
        String result = "";
        String url = "http://47.114.196.142:5000/api/pdd/get_mall_info?mall_id=397048742";
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
            testResultDao.insertResult("Pdd",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_mall_info",result);
            return;
        }
        if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("Pdd", 400, new Date(), "获取响应失败,重试超过阈值", url, "get_mall_info", result);
        }
        if (Statuscode != 200){
            testResultDao.insertResult("Pdd",Statuscode, new Date(), "http请求错误", url,"get_mall_info",result);

        }

        else if (code != 0) {
            testResultDao.insertResult("Pdd",code, new Date(), "业务请求错误", url,"get_mall_info",result);

        }
        else {
            testResultDao.insertResult("Pdd",200, new Date(), "成功", url,"get_mall_info",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_clearance_sale_goods() throws IOException {
        //断码清仓
        String result = "";
        String url = "http://47.114.196.142:5000/api/pdd/get_clearance_sale_goods?tab_id=210&page=1&size=20";
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
            testResultDao.insertResult("Pdd",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_clearance_sale_goods",result);
            return;
        }
        if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("Pdd", 400, new Date(), "获取响应失败,重试超过阈值", url, "get_clearance_sale_goods", result);
        }
        if (Statuscode != 200){
            testResultDao.insertResult("Pdd",Statuscode, new Date(), "http请求错误", url,"get_clearance_sale_goods",result);

        }

        else if (code != 0) {
            testResultDao.insertResult("Pdd",code, new Date(), "业务请求错误", url,"get_clearance_sale_goods",result);

        }
        else {
            testResultDao.insertResult("Pdd",200, new Date(), "成功", url,"get_clearance_sale_goods",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_new_clothes_goods() throws IOException {
        //新衣馆
        String result = "";
        String url = "http://47.114.196.142:5000/api/pdd/get_new_clothes_goods?tab_id=6074&page=1&size=20";
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
            testResultDao.insertResult("Pdd",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_new_clothes_goods",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("Pdd",Statuscode, new Date(), "http请求错误", url,"get_new_clothes_goods",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("Pdd",code, new Date(), "业务请求错误", url,"get_new_clothes_goods",result);

        }
        else {
            testResultDao.insertResult("Pdd",200, new Date(), "成功", url,"get_new_clothes_goods",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }
    @Test
    public void get_99_goods() throws IOException {
        //9块9特卖
        String result = "";
        String url = "http://47.114.196.142:5000/api/pdd/get_99_goods?tab_id=18&page=1&size=20";
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
            testResultDao.insertResult("Pdd",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_99_goods",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("Pdd",Statuscode, new Date(), "http请求错误", url,"get_99_goods",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("Pdd",code, new Date(), "业务请求错误", url,"get_99_goods",result);

        }
        else {
            testResultDao.insertResult("Pdd",200, new Date(), "成功", url,"get_99_goods",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_electrical_goods() throws IOException {
        //电器城
        String result = "";
        String url = "http://47.114.196.142:5000/api/pdd/get_electrical_goods?tab_id=0&page=1&size=12";
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
            testResultDao.insertResult("Pdd",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_electrical_goods",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("Pdd",Statuscode, new Date(), "http请求错误", url,"get_electrical_goods",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("Pdd",code, new Date(), "业务请求错误", url,"get_electrical_goods",result);

        }
        else {
            testResultDao.insertResult("Pdd",200, new Date(), "成功", url,"get_electrical_goods",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_love_shopping_goods() throws IOException {
        //爱逛街
        String result = "";
        String url = "http://47.114.196.142:5000/api/pdd/get_love_shopping_goods?tab_id=3255&page=1&size=20";
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
            testResultDao.insertResult("Pdd",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_love_shopping_goods",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("Pdd",Statuscode, new Date(), "http请求错误", url,"get_love_shopping_goods",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("Pdd",code, new Date(), "业务请求错误", url,"get_love_shopping_goods",result);

        }
        else {
            testResultDao.insertResult("Pdd",200, new Date(), "成功", url,"get_love_shopping_goods",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_daily_good_mall() throws IOException {
        //每日好店
        String result = "";
        String url = "http://47.114.196.142:5000/api/pdd/get_daily_good_mall?tab_id=4895&page=1&size=20";
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
            testResultDao.insertResult("Pdd",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_daily_good_mall",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("Pdd",Statuscode, new Date(), "http请求错误", url,"get_daily_good_mall",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("Pdd",code, new Date(), "业务请求错误", url,"get_daily_good_mall",result);

        }
        else {
            testResultDao.insertResult("Pdd",200, new Date(), "成功", url,"get_daily_good_mall",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_subsidy_goods() throws IOException {
        //百亿补贴
        String result = "";
        String url = "http://47.114.196.142:5000/api/pdd/get_subsidy_goods?tab_id=3665&page=1&size=20";
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
            testResultDao.insertResult("Pdd",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_subsidy_goods",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("Pdd",Statuscode, new Date(), "http请求错误", url,"get_subsidy_goods",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("Pdd",code, new Date(), "业务请求错误", url,"get_subsidy_goods",result);

        }
        else {
            testResultDao.insertResult("Pdd",200, new Date(), "成功", url,"get_subsidy_goods",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }
}
