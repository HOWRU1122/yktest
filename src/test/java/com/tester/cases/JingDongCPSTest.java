package com.tester.cases;

import com.alibaba.fastjson.JSONObject;
import com.tester.dao.TestResultDao;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
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
public class JingDongCPSTest {

    @Autowired
    private TestResultDao testResultDao;
    @Test
    public void items() throws IOException {
        //获取京东联盟商品列表
        String result = "";
        String url = "http://47.97.206.10/api/jd_cps/items?page_no=1&page_size=5";
        HttpGet get = new HttpGet(url);
        HttpClient client = new DefaultHttpClient();
        Integer code,Statuscode;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
        } catch (Exception e) {
            testResultDao.insertResult("JingDongCPS",500, new Date(), "测试异常，e:" + e.getMessage(), url, "items",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("JingDongCPS",Statuscode, new Date(), "http请求错误", url,"items",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("JingDongCPS",code, new Date(), "业务请求错误", url,"items",result);

        }
        else {
            testResultDao.insertResult("JingDongCPS",200, new Date(), "成功", url,"items",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }

    @Test
    public void shops() throws IOException {
        //获取京东联盟店铺列表
        String result = "";
        String url = "http://47.97.206.10/api/jd_cps/shops?page_no=1&page_size=5";
        HttpGet get = new HttpGet(url);
        HttpClient client = new DefaultHttpClient();
        Integer code,Statuscode;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
        } catch (Exception e) {
            testResultDao.insertResult("JingDongCPS",500, new Date(), "测试异常，e:" + e.getMessage(), url, "shops",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("JingDongCPS",Statuscode, new Date(), "http请求错误", url,"shops",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("JingDongCPS",code, new Date(), "业务请求错误", url,"shops",result);

        }
        else {
            testResultDao.insertResult("JingDongCPS",200, new Date(), "成功", url,"shops",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }
    @Test
    public void shop_info() throws IOException {
        //获取京东CPS店铺信息
        String result = "";
        String url = "http://47.97.206.10/api/jd_cps/shop_info?shop_id=996822";
        HttpGet get = new HttpGet(url);
        HttpClient client = new DefaultHttpClient();
        Integer code,Statuscode;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
        } catch (Exception e) {
            testResultDao.insertResult("JingDongCPS",500, new Date(), "测试异常，e:" + e.getMessage(), url, "shop_info",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("JingDongCPS",Statuscode, new Date(), "http请求错误", url,"shop_info",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("JingDongCPS",code, new Date(), "业务请求错误", url,"shop_info",result);

        }
        else {
            testResultDao.insertResult("JingDongCPS",200, new Date(), "成功", url,"shop_info",result);
            System.out.println("成功，" + "请求url：" + url);
        }
    }
    @Test
    public void shop_item() throws IOException {
        //获取京东CPS店铺商品
        String result = "";
        String url = "http://47.97.206.10/api/jd_cps/shop_item?shop_id=996822&page_no=1&page_size=5";
        HttpGet get = new HttpGet(url);
        HttpClient client = new DefaultHttpClient();
        Integer code,Statuscode;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
        } catch (Exception e) {
            testResultDao.insertResult("JingDongCPS",500, new Date(), "测试异常，e:" + e.getMessage(), url, "shop_item",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("JingDongCPS",Statuscode, new Date(), "http请求错误", url,"shop_item",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("JingDongCPS",code, new Date(), "业务请求错误", url,"shop_item",result);

        }
        else {
            testResultDao.insertResult("JingDongCPS",200, new Date(), "成功", url,"shop_item",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }
}
