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
public class MeiTuanTest {
    @Autowired
    private TestResultDao testResultDao;
    @Test
    public void call_nums() throws IOException {
        //调用次数
        String result = new String();
        String url = "http://47.97.206.10/api/meituan_v2/call_nums";
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
            testResultDao.insertResult("MeiTuanV2",500, new Date(), "测试异常，e:" + e.getMessage(), url, "call_nums",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("MeiTuanV2",Statuscode, new Date(), "http请求错误", url,"call_nums",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("MeiTuanV2",code, new Date(), "业务请求错误", url,"call_nums",result);

        }
        else {
            testResultDao.insertResult("MeiTuanV2",200, new Date(), "成功", url,"call_nums",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }

    @Test
    public void homepage_shops() throws IOException {
        //获取附近商家
        String result = new String();
        String url = "http://47.97.206.10/api/meituan_v2/homepage_shops?lon=120010802&lat=30287490&index=0";
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
            testResultDao.insertResult("MeiTuanV2",500, new Date(), "测试异常，e:" + e.getMessage(), url, "homepage_shops",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("MeiTuanV2",Statuscode, new Date(), "http请求错误", url,"homepage_shops",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("MeiTuanV2",code, new Date(), "业务请求错误", url,"homepage_shops",result);

        }
        else {
            testResultDao.insertResult("MeiTuanV2",200, new Date(), "成功", url,"homepage_shops",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }

    @Test
    public void shop_foods() throws IOException {
        //获取附近商家
        String result = new String();
        String url = "http://47.97.206.10/api/meituan_v2/shop_foods?wmpoiid=1005607664858484&index=0";
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
            testResultDao.insertResult("MeiTuanV2",500, new Date(), "测试异常，e:" + e.getMessage(), url, "shop_foods",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("MeiTuanV2",Statuscode, new Date(), "http请求错误", url,"shop_foods",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("MeiTuanV2",code, new Date(), "业务请求错误", url,"shop_foods",result);

        }
        else {
            testResultDao.insertResult("MeiTuanV2",200, new Date(), "成功", url,"shop_foods",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }

    @Test
    public void shop_comments() throws IOException {
        //获取商家评论
        String result = new String();
        String url = "http://47.97.206.10/api/meituan_v2/shop_comments?wmpoiid=856228702304026&offset=0";
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
            testResultDao.insertResult("MeiTuanV2",500, new Date(), "测试异常，e:" + e.getMessage(), url, "shop_comments",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("MeiTuanV2",Statuscode, new Date(), "http请求错误", url,"shop_comments",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("MeiTuanV2",code, new Date(), "业务请求错误", url,"shop_comments",result);

        }
        else {
            testResultDao.insertResult("MeiTuanV2",200, new Date(), "成功", url,"shop_comments",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }
}
