package com.tester.cases;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.util.JSON;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.IOException;

public class DuTest {

    @Test(groups = "du")
    public void call_nums() throws IOException {
        //调用次数
        String result;
        String url = "http://47.97.206.10/api/du/call_nums";
        HttpGet get = new HttpGet(url);
        HttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        int StatusCode = response.getStatusLine().getStatusCode();
        JSONObject jsonObject = JSONObject.parseObject(result);
        Integer code = jsonObject.getInteger("code");
        if(code == -200){
            System.out.println(result);
            throw new RuntimeException(result+"\n"+"请求url："+url);
        }
        if (code == -1){
            System.out.println(result);
            throw new RuntimeException(result+"\n"+"请求url："+url);
        }
        if (StatusCode != 200){
            System.out.println(result);
            throw new RuntimeException("失败，"+"请求url："+url);
        }
        else{
            System.out.println("成功，"+"请求url："+url);

        }

    }
    @Test(groups = "du")
    public void ice_shopping() throws IOException {
        //获取首页推荐
        String result;
        String url = "http://47.97.206.10/api/du/ice_shopping";
        HttpGet get = new HttpGet(url);
        HttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        int StatusCode = response.getStatusLine().getStatusCode();
        JSONObject jsonObject = JSONObject.parseObject(result);
        Integer code = jsonObject.getInteger("code");
        if(code == -200){
            System.out.println(result);
            throw new RuntimeException(result+"\n"+"请求url："+url);
        }
        if (code == -1){
            System.out.println(result);
            throw new RuntimeException(result+"\n"+"请求url："+url);
        }
        if (StatusCode != 200){
            System.out.println(result);
            throw new RuntimeException("失败，"+"请求url："+url);
        }
        else{
            System.out.println("成功，"+"请求url："+url);
        }
    }
    @Test(groups = "du")
    public void ice_shopping_tab() throws IOException {
        //获取首页tab页数据
        String result;
        String url = "http://47.97.206.10/api/du/ice_shopping_tab?tab_id=13";
        HttpGet get = new HttpGet(url);
        HttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        int StatusCode = response.getStatusLine().getStatusCode();
        JSONObject jsonObject = JSONObject.parseObject(result);
        Integer code = jsonObject.getInteger("code");
        if(code == -200){
            System.out.println(result);
            throw new RuntimeException(result+"\n"+"请求url："+url);
        }
        if (code == -1){
            System.out.println(result);
            throw new RuntimeException(result+"\n"+"请求url："+url);
        }
        if (StatusCode != 200){
            System.out.println(result);
            throw new RuntimeException("失败，"+"请求url："+url);
        }
        else{
            System.out.println("成功，"+"请求url："+url);

        }

    }
    @Test(groups = "du")
    public void item_detail() throws IOException {
        //获取商品详情
        String result;
        String url = "http://47.97.206.10/api/du/item/detail?item_id=57388";
        HttpGet get = new HttpGet(url);
        HttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        int StatusCode = response.getStatusLine().getStatusCode();
        JSONObject jsonObject = JSONObject.parseObject(result);
        Integer code = jsonObject.getInteger("code");
        if(code == -200){
            System.out.println(result);
            throw new RuntimeException(result+"\n"+"请求url："+url);
        }
        if (code == -1){
            System.out.println(result);
            throw new RuntimeException(result+"\n"+"请求url："+url);
        }
        if (StatusCode != 200){
            System.out.println(result);
            throw new RuntimeException("失败，"+"请求url："+url);
        }
        else{
            System.out.println("成功，"+"请求url："+url);

        }

    }
    @Test(groups = "du")
    public void sold_list() throws IOException {
        //获取商品最近购买列表
        String result;
        String url = "http://47.97.206.10/api/du/item/sold_list?item_id=57388";
        HttpGet get = new HttpGet(url);
        HttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        int StatusCode = response.getStatusLine().getStatusCode();
        JSONObject jsonObject = JSONObject.parseObject(result);
        Integer code = jsonObject.getInteger("code");
        if(code == -200){
            System.out.println(result);
            throw new RuntimeException(result+"\n"+"请求url："+url);
        }
        if (code == -1){
            System.out.println(result);
            throw new RuntimeException(result+"\n"+"请求url："+url);
        }
        if (StatusCode != 200){
            System.out.println(result);
            throw new RuntimeException("失败，"+"请求url："+url);
        }
        else{
            System.out.println("成功，"+"请求url："+url);

        }

    }
}
