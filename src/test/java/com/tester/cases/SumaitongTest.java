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
public class SumaitongTest {

    @Autowired
    private TestResultDao testResultDao;

   /*
    @Test
    public void get_cate_info() throws IOException {
        //获取分类列表信息
        String result = "";
        String url = "http://47.114.196.142:5000/api/aliexpress/get_cate_info";
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
            testResultDao.insertResult("Sumaitong",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_cate_info",result);
            return;
        }
        if (msg.toString().contains("请求失败")) {
            testResultDao.insertResult("Alibaba", 400, new Date(), "请求失败，重试", url, "get_cate_info", result);
        }

        else if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("Sumaitong", 400, new Date(), "获取响应失败,重试超过阈值", url, "get_cate_info", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("Sumaitong",Statuscode, new Date(), "http请求错误", url,"get_cate_info",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("Sumaitong",code, new Date(), "业务请求错误", url,"get_cate_info",result);
        }
        else {
            testResultDao.insertResult("Sumaitong",200, new Date(), "成功", url,"get_cate_info",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }
*/
    @Test
    public void get_item_list() throws IOException {
        //根据类目id获取商品列表
        String result = "";
        String url = "http://47.114.196.142:5000/api/aliexpress/get_item_list?category_id=205776616&start=0";
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
            testResultDao.insertResult("Sumaitong",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_item_list",result);
            return;
        }
        if (msg.toString().contains("请求失败")) {
            testResultDao.insertResult("Sumaitong", 400, new Date(), "请求失败，重试", url, "get_item_list", result);
        }

        else if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("Sumaitong", 400, new Date(), "获取响应失败,重试超过阈值", url, "get_item_list", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("Sumaitong",Statuscode, new Date(), "http请求错误", url,"get_item_list",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("Sumaitong",code, new Date(), "业务请求错误", url,"get_item_list",result);
        }
        else {
            testResultDao.insertResult("Sumaitong",200, new Date(), "成功", url,"get_item_list",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_item_detial_h5() throws IOException {
        //获取商品详情
        String result = "";
        String url = "http://47.114.196.142:5000/api/aliexpress/get_item_detial_h5?product_id=32944753184";
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
            testResultDao.insertResult("Sumaitong",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_item_detial_h5",result);
            return;
        }
        if (msg.toString().contains("请求失败")) {
            testResultDao.insertResult("Sumaitong", 400, new Date(), "请求失败，重试", url, "get_item_detial_h5", result);
        }

        else if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("Sumaitong", 400, new Date(), "获取响应失败,重试超过阈值", url, "get_item_detial_h5", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("Sumaitong",Statuscode, new Date(), "http请求错误", url,"get_item_detial_h5",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("Sumaitong",code, new Date(), "业务请求错误", url,"get_item_detial_h5",result);
        }
        else {
            testResultDao.insertResult("Sumaitong",200, new Date(), "成功", url,"get_item_detial_h5",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_item_detial_pc() throws IOException {
        //获取商品详情
        String result = "";
        String url = "http://47.114.196.142:5000/api/aliexpress/get_item_detial_pc?product_id=32944753184";
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
            testResultDao.insertResult("Sumaitong",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_item_detial_pc",result);
            return;
        }
        if (msg.toString().contains("请求失败")) {
            testResultDao.insertResult("Sumaitong", 400, new Date(), "请求失败，重试", url, "get_item_detial_pc", result);
        }

        else if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("Sumaitong", 400, new Date(), "获取响应失败,重试超过阈值", url, "get_item_detial_pc", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("Sumaitong",Statuscode, new Date(), "http请求错误", url,"get_item_detial_pc",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("Sumaitong",code, new Date(), "业务请求错误", url,"get_item_detial_pc",result);
        }
        else {
            testResultDao.insertResult("Sumaitong",200, new Date(), "成功", url,"get_item_detial_pc",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_shop_info_h5() throws IOException {
        //获取店铺信息
        String result = "";
        String url = "http://47.114.196.142:5000/api/aliexpress/get_shop_info_h5?seller_id=234676259";
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
            testResultDao.insertResult("Sumaitong",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_shop_info_h5",result);
            return;
        }
        if (msg.toString().contains("请求失败")) {
            testResultDao.insertResult("Sumaitong", 400, new Date(), "请求失败，重试", url, "get_shop_info_h5", result);
        }

        else if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("Sumaitong", 400, new Date(), "获取响应失败,重试超过阈值", url, "get_shop_info_h5", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("Sumaitong",Statuscode, new Date(), "http请求错误", url,"get_shop_info_h5",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("Sumaitong",code, new Date(), "业务请求错误", url,"get_shop_info_h5",result);
        }
        else {
            testResultDao.insertResult("Sumaitong",200, new Date(), "成功", url,"get_shop_info_h5",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_shop_info_pc() throws IOException {
        //获取店铺信息
        String result = "";
        String url = "http://47.114.196.142:5000/api/aliexpress/get_shop_info_pc?seller_id=234676259";
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
            testResultDao.insertResult("Sumaitong",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_shop_info_pc",result);
            return;
        }
        if (msg.toString().contains("请求失败")) {
            testResultDao.insertResult("Sumaitong", 400, new Date(), "请求失败，重试", url, "get_shop_info_pc", result);
        }

        else if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("Sumaitong", 400, new Date(), "获取响应失败,重试超过阈值", url, "get_shop_info_pc", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("Sumaitong",Statuscode, new Date(), "http请求错误", url,"get_shop_info_pc",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("Sumaitong",code, new Date(), "业务请求错误", url,"get_shop_info_pc",result);
        }
        else {
            testResultDao.insertResult("Sumaitong",200, new Date(), "成功", url,"get_shop_info_pc",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }
    @Test
    public void get_shop_item() throws IOException {
        //获取店铺商品
        String result = "";
        String url = "http://47.114.196.142:5000/api/aliexpress/get_shop_item?seller_id=234676259&page=1&size=20";
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
            testResultDao.insertResult("Sumaitong",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_shop_item",result);
            return;
        }
        if (msg.toString().contains("请求失败")) {
            testResultDao.insertResult("Sumaitong", 400, new Date(), "请求失败，重试", url, "get_shop_item", result);
        }

        else if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("Sumaitong", 400, new Date(), "获取响应失败,重试超过阈值", url, "get_shop_item", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("Sumaitong",Statuscode, new Date(), "http请求错误", url,"get_shop_item",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("Sumaitong",code, new Date(), "业务请求错误", url,"get_shop_item",result);
        }
        else {
            testResultDao.insertResult("Sumaitong",200, new Date(), "成功", url,"get_shop_item",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_seller_info() throws IOException {
        //获取卖家信息
        String result = "";
        String url = "http://47.114.196.142:5000/api/aliexpress/get_seller_info?seller_id=234676259";
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
            testResultDao.insertResult("Sumaitong",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_seller_info",result);
            return;
        }
        if (msg.toString().contains("请求失败")) {
            testResultDao.insertResult("Sumaitong", 400, new Date(), "请求失败，重试", url, "get_seller_info", result);
        }

        else if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("Sumaitong", 400, new Date(), "获取响应失败,重试超过阈值", url, "get_seller_info", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("Sumaitong",Statuscode, new Date(), "http请求错误", url,"get_seller_info",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("Sumaitong",code, new Date(), "业务请求错误", url,"get_seller_info",result);
        }
        else {
            testResultDao.insertResult("Sumaitong",200, new Date(), "成功", url,"get_seller_info",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_shop_feedback() throws IOException {
        //获取店铺反馈评论
        String result = "";
        String url = "http://47.114.196.142:5000/api/aliexpress/get_shop_feedback?seller_id=234676259&page=1&size=20";
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
            testResultDao.insertResult("Sumaitong",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_shop_feedback",result);
            return;
        }
        if (msg.toString().contains("请求失败")) {
            testResultDao.insertResult("Sumaitong", 400, new Date(), "请求失败，重试", url, "get_shop_feedback", result);
        }

        else if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("Sumaitong", 400, new Date(), "获取响应失败,重试超过阈值", url, "get_shop_feedback", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("Sumaitong",Statuscode, new Date(), "http请求错误", url,"get_shop_feedback",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("Sumaitong",code, new Date(), "业务请求错误", url,"get_shop_feedback",result);
        }
        else {
            testResultDao.insertResult("Sumaitong",200, new Date(), "成功", url,"get_shop_feedback",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }

    @Test
    public void get_item_feedback() throws IOException {
        //获取商品反馈评论
        String result = "";
        String url = "http://47.114.196.142:5000/api/aliexpress/get_item_feedback?product_id=32968943234&page=1";
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
            testResultDao.insertResult("Sumaitong",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_item_feedback",result);
            return;
        }
        if (msg.toString().contains("请求失败")) {
            testResultDao.insertResult("Sumaitong", 400, new Date(), "请求失败，重试", url, "get_item_feedback", result);
        }

        else if (msg.toString().contains("获取响应失败,重试超过阈值")) {
            testResultDao.insertResult("Sumaitong", 400, new Date(), "获取响应失败,重试超过阈值", url, "get_item_feedback", result);
        }
        else if (Statuscode != 200){
            testResultDao.insertResult("Sumaitong",Statuscode, new Date(), "http请求错误", url,"get_item_feedback",result);
        }
        else if (code != 0) {
            testResultDao.insertResult("Sumaitong",code, new Date(), "业务请求错误", url,"get_item_feedback",result);
        }
        else {
            testResultDao.insertResult("Sumaitong",200, new Date(), "成功", url,"get_item_feedback",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }
}
