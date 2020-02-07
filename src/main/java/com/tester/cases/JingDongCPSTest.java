package com.tester.cases;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class JingDongCPSTest {
    @Test(groups = "jingdongcps")
    public void items() throws IOException {
        //获取京东联盟商品列表
        String result;
        String url = "http://47.97.206.10/api/jd_cps/items?page_no=1&page_size=60";
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

    @Test(groups = "jingdongcps")
    public void shops() throws IOException {
        //获取京东联盟店铺列表
        String result;
        String url = "http://47.97.206.10/api/jd_cps/shops?page_no=1&page_size=20";
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
    @Test(groups = "jingdongcps")
    public void shop_info() throws IOException {
        //获取京东CPS店铺信息
        String result;
        String url = "http://47.97.206.10/api/jd_cps/shop_info?shop_id=996822";
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
    @Test(groups = "jingdongcps")
    public void shop_item() throws IOException {
        //获取京东CPS店铺商品
        String result;
        String url = "http://47.97.206.10/api/jd_cps/shop_item?shop_id=996822&page_no=1&page_size=20";
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
